package dynamicfxview.view;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import dynamicfxview.viewmodel.DynamicFXComponentViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DynamicFXListComponent implements FxmlView<DynamicFXComponentViewModel>, Initializable {

    @FXML
    private Label versionLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label nameLabel;

    @InjectViewModel
    DynamicFXComponentViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameLabel.textProperty().bind(viewModel.nameProperty());
        genreLabel.textProperty().bind(viewModel.genreProperty());
        versionLabel.textProperty().bind(viewModel.versionProperty());
    }

}