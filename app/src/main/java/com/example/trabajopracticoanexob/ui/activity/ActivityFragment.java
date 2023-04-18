package com.example.trabajopracticoanexob.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.trabajopracticoanexob.databinding.FragmentActivityBinding;

public class ActivityFragment extends Fragment {

    private FragmentActivityBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ActivityViewModel activityViewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        binding = FragmentActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        activityViewModel.getListaDeActividadesLiveData().observe(getViewLifecycleOwner(), listaDeActividades -> {
            GridLayoutManager grilla = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
            binding.rvListaActividades.setLayoutManager(grilla);
            ActivityAdapter adapter = new ActivityAdapter(listaDeActividades, getLayoutInflater());
            binding.rvListaActividades.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}