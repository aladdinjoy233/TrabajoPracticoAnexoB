package com.example.trabajopracticoanexob.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajopracticoanexob.models.Actividad;

public class DescripcionViewModel extends ViewModel {

    private MutableLiveData<Actividad> actividad = new MutableLiveData<>();

    public LiveData<Actividad> getActivity() {
        return actividad;
    }

    public void procesarDatos(Bundle bundle) {
        if (bundle != null) {
            actividad.setValue((Actividad) bundle.getSerializable("actividad"));
        }
    }
}
