package dynamicfxview.view;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import dynamicfxview.viewmodel.DynamicFXComponentViewModel;
import dynamicfxview.viewmodel.DynamicFXContainerViewModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arcos on 29.01.2017.
 */
public class DynamicFXContainerView implements FxmlView<DynamicFXContainerViewModel>, Initializable {

    @FXML
    private FlowPane flowLayout;
    @FXML
    private GridPane configGrid;
    @FXML
    private ToggleGroup layoutSelection;
    @FXML
    private ScrollPane flowScrollPane;
    @FXML
    private ScrollPane listScrollPane;
    @FXML
    private VBox containerVbox;
    @FXML
    private VBox listLayout;
    @FXML
    private RadioButton listRadioButton;
    @FXML
    private RadioButton flowRadioButton;

    @InjectViewModel
    DynamicFXContainerViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        flowLayout.prefWidthProperty().bind(flowScrollPane.widthProperty().subtract(13));
        listLayout.prefWidthProperty().bind(listScrollPane.widthProperty().subtract(13));
//        flowLayout.prefHeightProperty().bind(scrollPane.heightProperty());

        listScrollPane.managedProperty().bind(listRadioButton.selectedProperty());
        listLayout.managedProperty().bind(listRadioButton.selectedProperty());

//        listRadioButton.selectedProperty().addListener(
        createVisibleBySelectionChangeListener(listRadioButton.selectedProperty(), listScrollPane);
        createVisibleBySelectionChangeListener(flowRadioButton.selectedProperty(), flowScrollPane);

        viewModel.dynamicFXComponentViewModelListProperty().addListener(
                (ListChangeListener<DynamicFXComponentViewModel>) c -> {
                    while (c.next()) {
                        if (c.wasAdded()) {
                            c.getAddedSubList().forEach(this::initComponent);
                        } else if (c.wasRemoved()) {
                            c.getRemoved().forEach(this::removeComponent);
                        }
                    }
                });
    }

    private void createVisibleBySelectionChangeListener(BooleanProperty booleanProperty, Node view) {
        booleanProperty.addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue) {
                        containerVbox.getChildren().add(view);
                    } else {
                        containerVbox.getChildren().remove(view);
                    }
                });
    }

    public DynamicFXContainerViewModel getViewModel() {
        return viewModel;
    }

    private void removeComponent(DynamicFXComponentViewModel fxComponentModel) {

    }

    private void initComponent(DynamicFXComponentViewModel fxComponentViewModel) {

        ViewTuple<DynamicFXListComponent, DynamicFXComponentViewModel> componentListViewTuple = FluentViewLoader
                .fxmlView(DynamicFXListComponent.class).viewModel(fxComponentViewModel).load();

        Parent listViewComponent = componentListViewTuple.getView();
        listLayout.getChildren().add(listViewComponent);

        containerVbox.getChildren().remove(listScrollPane);

        ViewTuple<DynamicFXFlowComponent, DynamicFXComponentViewModel> componentFlowViewTuple = FluentViewLoader
                .fxmlView(DynamicFXFlowComponent.class).viewModel(fxComponentViewModel).load();

        Parent flowViewComponent = componentFlowViewTuple.getView();
        flowLayout.getChildren().add(flowViewComponent);
    }

}
