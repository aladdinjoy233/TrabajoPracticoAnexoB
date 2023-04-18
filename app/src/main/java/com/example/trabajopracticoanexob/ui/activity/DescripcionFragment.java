package com.example.trabajopracticoanexob.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.trabajopracticoanexob.databinding.FragmentActivityBinding;
import com.example.trabajopracticoanexob.databinding.FragmentDescripcionBinding;
import com.example.trabajopracticoanexob.models.Actividad;

public class DescripcionFragment extends Fragment {
    FragmentDescripcionBinding binding;
    DescripcionViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ActivityViewModel activityViewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        binding = FragmentDescripcionBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(DescripcionViewModel.class);

        Bundle bundle = getArguments();
        if (bundle != null) {
            viewModel.procesarDatos(bundle);
        }

        viewModel.getActivity().observe(getViewLifecycleOwner(), actividad -> {
            binding.tvNombreDesc.setText(actividad.getNombre());
            binding.tvFechaDesc.setText(actividad.getFecha());
            binding.tvHoraDesc.setText(actividad.getHora());
            binding.tvLugarDesc.setText("Ubicaion: " + actividad.getLugar());
            binding.tvDescripcionDesc.setText(actividad.getDescripcion());
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
