package dynamicfxview;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import dynamicfxview.view.DynamicFXContainerView;
import dynamicfxview.viewmodel.DynamicFXContainerViewModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.AZURE;
import static javafx.scene.paint.Color.BLUEVIOLET;

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

        ViewTuple<DynamicFXContainerView, DynamicFXContainerViewModel> viewTuple = FluentViewLoader.fxmlView(
                DynamicFXContainerView.class).load();

        DynamicFXContainerView fxContainerView = viewTuple.getCodeBehind();

        for (int i = 0; i < 5; i++) {
            fxContainerView.addView(createTestRectangle());
        }

        Parent root = viewTuple.getView();
        stage.setScene(new Scene(root, 1200, 900));
        stage.show();
    }

    private Rectangle createTestRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        rectangle.setFill(new Color(0.3,0,0,1));
        return rectangle;
    }

}