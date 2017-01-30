package dynamicfxview.view;

import de.saxsys.mvvmfx.FxmlView;
import dynamicfxview.viewmodel.DynamicFXContainerViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private ScrollPane scrollPane;
    @FXML
    private VBox containerVbox;

    public void addView(Node view) {
        if (!flowLayout.getChildren().contains(view)) {
            flowLayout.getChildren().add(view);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flowLayout.prefWidthProperty().bind(scrollPane.widthProperty().subtract(13));
//        flowLayout.prefHeightProperty().bind(scrollPane.heightProperty());
    }
}
