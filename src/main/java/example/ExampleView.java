package example;

import de.saxsys.mvvmfx.FxmlView;
import dynamicfxview.view.DynamicFXContainerView;
import dynamicfxview.viewmodel.DynamicFXComponentViewModel;
import dynamicfxview.viewmodel.DynamicFXContainerViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Arrays;

/**
 * Created by arcos on 30.01.2017.
 */
public class ExampleView implements FxmlView<ExampleViewModel> {

    @FXML
    private VBox containerVbox;

    @FXML
    private DynamicFXContainerView dynamicFXViewController;

    @FXML
    void selectPath(ActionEvent event) {

        File directory = new File("C:\\Users\\steven.lehmann\\Pictures\\covers");

        if (directory != null && directory.isDirectory() && directory.exists()) {

            System.out.println(directory.getAbsolutePath());

            Arrays.asList(directory.listFiles()).stream()
                    .filter(file -> file.isFile())
                    .forEach(file -> {

                        DynamicFXComponentViewModel dynamicFXComponentViewModel = new DynamicFXComponentViewModel();
                        dynamicFXComponentViewModel.setImage(file);
                        dynamicFXComponentViewModel.setName(file.getName());

                        DynamicFXContainerViewModel dynamicFXContainerViewModel = dynamicFXViewController
                                .getViewModel();

                        dynamicFXContainerViewModel.dynamicFXComponentViewModelListProperty().add(
                                dynamicFXComponentViewModel);

                    });
        }
    }

}
