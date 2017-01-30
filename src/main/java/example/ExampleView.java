package example;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewTuple;
import dynamicfxview.view.DynamicFXComponent;
import dynamicfxview.view.DynamicFXContainerView;
import dynamicfxview.viewmodel.DynamicFXComponentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.Arrays;

/**
 * Created by steven.lehmann on 30.01.2017.
 */
public class ExampleView implements FxmlView<ExampleViewModel> {

    @FXML
    private VBox containerVbox;
    @FXML
    private VBox dynamicFXView;
    @FXML
    private DynamicFXContainerView dynamicFXViewController;

    @FXML
    void selectPath(ActionEvent event) {
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        File directory = directoryChooser.showDialog(containerVbox.getScene().getWindow());

        File directory = new File("C:\\Users\\steven.lehmann\\Pictures\\covers");

        if (directory != null && directory.isDirectory() && directory.exists()) {

            System.out.println(directory.getAbsolutePath());

            Arrays.asList(directory.listFiles()).stream()
                    .filter(file -> file.isFile())
                    .forEach(file -> {

                        ViewTuple<DynamicFXComponent, DynamicFXComponentModel> componentViewTuple = FluentViewLoader
                                .fxmlView(
                                        DynamicFXComponent.class).load();

                        Parent view = componentViewTuple.getView();
                        DynamicFXComponentModel viewModel = componentViewTuple.getViewModel();
                        viewModel.setImage(file);
                        viewModel.setName(file.getName());

                        dynamicFXViewController.addView(view);

                    });
        }
    }

}
