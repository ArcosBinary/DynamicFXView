package dynamicfxview.viewmodel;

import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by arcos on 29.01.2017.
 */
public class DynamicFXContainerViewModel implements ViewModel {

    private ObservableList<DynamicFXComponentViewModel> dynamicFXComponentViewModelList = FXCollections.observableArrayList();

    public ObservableList<DynamicFXComponentViewModel> dynamicFXComponentViewModelListProperty() {
        return dynamicFXComponentViewModelList;
    }

}
