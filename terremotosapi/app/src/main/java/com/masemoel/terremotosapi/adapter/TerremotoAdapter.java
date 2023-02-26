package com.masemoel.terremotosapi.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masemoel.terremotosapi.MainActivity;
import com.masemoel.terremotosapi.MapsActivity;
import com.masemoel.terremotosapi.R;
import com.masemoel.terremotosapi.model.Terremoto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TerremotoAdapter extends RecyclerView.Adapter<TerremotoAdapter.TerremotoAdapterHolder> {
    private List<Terremoto> terremotos;

    public TerremotoAdapter(List<Terremoto> terremotos) {
        this.terremotos = terremotos;
    }

    @NonNull
    @Override
    public TerremotoAdapter.TerremotoAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_terremoto, parent, false);
        return new TerremotoAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotoAdapter.TerremotoAdapterHolder holder, int position) {
        Terremoto terremoto = terremotos.get(position);
        holder.tvtitle.setText(terremoto.getPropiedades().getTitle());
        holder.tvid.setText(terremoto.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        holder.tvtime.setText(sdf.format(new Date(terremoto.getPropiedades().getTime())));
        if (terremoto.getPropiedades().getTsunami() == 0) {
            holder.tvtsunami.setText("no");
        } else {
            holder.tvtsunami.setText("sí");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("longitud", terremoto.getGeometria().getCoordenadas().get(0));
                intent.putExtra("latitud", terremoto.getGeometria().getCoordenadas().get(1));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public void setData (List<Terremoto> terremotos) {
        this.terremotos = terremotos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return terremotos.size();
    }

    public class TerremotoAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvtitle, tvid, tvtime, tvtsunami;

        public TerremotoAdapterHolder(View itemView) {
            super(itemView);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvid = itemView.findViewById(R.id.tvid);
            tvtime = itemView.findViewById(R.id.tvtime);
            tvtsunami = itemView.findViewById(R.id.tvtsunami);
        }
    }
}