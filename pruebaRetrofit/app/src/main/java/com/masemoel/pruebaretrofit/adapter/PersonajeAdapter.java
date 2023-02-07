package com.masemoel.pruebaretrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masemoel.pruebaretrofit.R;
import com.masemoel.pruebaretrofit.model.Personaje;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeAdapterHolder> {
    private List<Personaje> personajes;

    public PersonajeAdapter(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeAdapter.PersonajeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personaje, parent, false);
        return new PersonajeAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapter.PersonajeAdapterHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.tvname.setText(personaje.getName());
        holder.tvheight.setText(personaje.getHeight());
        holder.tveyecolor.setText(personaje.getEyeColor());
        holder.tvbirth.setText(personaje.getBirthYear());
    }

    public void setData (List<Personaje> personajes) {
        this.personajes = personajes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public class PersonajeAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvname, tvheight, tveyecolor, tvbirth;

        public PersonajeAdapterHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvheight = itemView.findViewById(R.id.tvheight);
            tveyecolor = itemView.findViewById(R.id.tveyecolor);
            tvbirth = itemView.findViewById(R.id.tvbirth);
        }
    }
}