package com.example.trabajopracticoanexob.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajopracticoanexob.R;
import com.example.trabajopracticoanexob.databinding.ItemActividadBinding;
import com.example.trabajopracticoanexob.models.Actividad;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private List<Actividad> actividades;
    private LayoutInflater inflater;

    public ActivityAdapter(List<Actividad> actividades, LayoutInflater inflater) {
        this.actividades = actividades;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemActividadBinding binding = ItemActividadBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ViewHolder holder, int position) {
        holder.binding.tvNombre.setText(actividades.get(position).getNombre());
        holder.binding.tvFecha.setText(actividades.get(position).getFecha());
        holder.binding.tvHora.setText(actividades.get(position).getHora());
    }

    @Override
    public int getItemCount() { return actividades.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemActividadBinding binding;

        public ViewHolder(@NonNull ItemActividadBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("actividad", actividades.get(getAdapterPosition()));
                Navigation.findNavController(v).navigate(R.id.descripcionFragment, bundle);
            });
        }
    }
}
