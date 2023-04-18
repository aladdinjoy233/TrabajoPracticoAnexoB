package com.example.trabajopracticoanexob;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationActivityViewModel extends ViewModel {

    private MutableLiveData<Boolean> mutableDialogoSalida;

    public MutableLiveData<Boolean> getMutableDialogoSalida() {
        if (mutableDialogoSalida == null) {
            mutableDialogoSalida = new MutableLiveData<>();
        }
        return mutableDialogoSalida;
    }

    public void dialogoSalida() { mutableDialogoSalida.setValue(true); }

}
