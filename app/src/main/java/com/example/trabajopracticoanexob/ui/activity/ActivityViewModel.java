package com.example.trabajopracticoanexob.ui.activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajopracticoanexob.models.Actividad;

import java.util.ArrayList;

public class ActivityViewModel extends ViewModel {

    private ArrayList<Actividad> listaDeActividades;
    private MutableLiveData<ArrayList<Actividad>> listaDeActividadesLiveData;

    public ActivityViewModel() { generarActividades(); }

    public MutableLiveData<ArrayList<Actividad>> getListaDeActividadesLiveData() {
        if (listaDeActividadesLiveData == null) {
            listaDeActividadesLiveData = new MutableLiveData<>();
            listaDeActividadesLiveData.setValue(listaDeActividades);
        }
        return listaDeActividadesLiveData;
    }

    public void generarActividades() {
        listaDeActividades = new ArrayList<>();
        listaDeActividades.add(new Actividad("Compra de alimentos para la semana", "Hacer una lista de compras de alimentos y productos de limpieza para la semana", "19/04/2023", "10:00 am", "Supermercado local"));
        listaDeActividades.add(new Actividad("Tarea de matemáticas", "Resolver las ecuaciones asignadas en la tarea de matemáticas", "20/04/2023", "2:00 pm", "Biblioteca universitaria"));
        listaDeActividades.add(new Actividad("Reunión semanal del equipo de trabajo", "Discutir el progreso del proyecto y asignar tareas para la próxima semana", "22/04/2023", "9:00 am", "Sala de reuniones de la oficina"));
        listaDeActividades.add(new Actividad("Cita con el médico", "Revisión médica anual", "25/04/2023", "3:00 pm", "Consultorio del médico"));
        listaDeActividades.add(new Actividad("Clase de yoga", "Asistir a la clase de yoga semanal", "26/04/2023", "6:00 pm", "Estudio de yoga local"));
    }
}