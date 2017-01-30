package dynamicfxview.viewmodel;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.io.File;

/**
 * Created by steven.lehmann on 30.01.2017.
 */
public class DynamicFXComponentModel implements ViewModel {

    private StringProperty nameProperty = new SimpleStringProperty();
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public ObjectProperty<Image> imageProperty() {
        return imageProperty;
    }

    public void setImage(File file) {
        Image image = new Image("file:" + file.getPath());
        imageProperty.setValue(image);
        nameProperty.set(file.getName());
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

}
