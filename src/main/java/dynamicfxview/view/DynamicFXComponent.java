package dynamicfxview.view;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import dynamicfxview.viewmodel.DynamicFXComponentModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by steven.lehmann on 30.01.2017.
 */
public class DynamicFXComponent implements FxmlView<DynamicFXComponentModel>, Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private VBox containerVbox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label versionLabel;
    @FXML
    private Label genreLabel;

    @InjectViewModel
    DynamicFXComponentModel viewModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView.imageProperty().bind(viewModel.imageProperty());
        nameLabel.textProperty().bind(viewModel.nameProperty());

        fillWithDummyData();
    }

    private void fillWithDummyData() {
        versionLabel.setText("1.0.4");
        genreLabel.setText("horror");
    }
}
