package dynamicfxview.view;

import de.saxsys.mvvmfx.FxmlView;
import dynamicfxview.viewmodel.DynamicFXContainerViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Created by arcos on 29.01.2017.
 */
public class DynamicFXContainerView implements FxmlView<DynamicFXContainerViewModel> {

    @FXML
    private VBox containerVbox;

    @FXML
    private GridPane configGrid;

    @FXML
    private ToggleGroup layoutSelection;

    @FXML
    private FlowPane flowLayout;

    public void addView(Node view) {
        if (!flowLayout.getChildren().contains(view)) {
            flowLayout.getChildren().add(view);
        }
    }

}
