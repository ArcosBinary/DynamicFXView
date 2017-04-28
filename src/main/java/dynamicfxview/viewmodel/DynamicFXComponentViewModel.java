package dynamicfxview.viewmodel;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.io.File;

/**
 * Created by arcos on 30.01.2017.
 */
public class DynamicFXComponentViewModel implements ViewModel {

    private StringProperty nameProperty = new SimpleStringProperty();
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();
    private StringProperty versionProperty = new SimpleStringProperty();
    private StringProperty genreProperty = new SimpleStringProperty();

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public StringProperty versionProperty() {
        return versionProperty;
    }

    public StringProperty genreProperty() {
        return genreProperty;
    }

    public ObjectProperty<Image> imageProperty() {
        return imageProperty;
    }

    public void setImage(File file) {
        Image image = new Image("file:" + file.getPath());
        imageProperty.setValue(image);
        nameProperty.set(file.getName());

        fillWithDummyData();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    private void fillWithDummyData() {
        versionProperty.set("1.0.4");
        genreProperty.set("horror");
    }

}
