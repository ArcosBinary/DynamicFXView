package example;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by arcos on 29.01.2017.
 */
public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Dynamic FX View");

        ViewTuple<ExampleView, ExampleViewModel> viewTuple = FluentViewLoader.fxmlView(
                ExampleView.class).load();

        Parent root = viewTuple.getView();
        Scene scene = new Scene(root, 1200, 900);
        stage.setScene(scene);
        stage.show();
    }

}