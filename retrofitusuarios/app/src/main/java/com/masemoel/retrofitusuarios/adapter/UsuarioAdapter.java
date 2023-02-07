package com.masemoel.retrofitusuarios.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masemoel.retrofitusuarios.R;
import com.masemoel.retrofitusuarios.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioAdapterHolder> {
    private List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioAdapter.UsuarioAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_usuario, parent, false);
        return new UsuarioAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioAdapterHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.tvid.setText(String.valueOf(usuario.getId()));
        holder.tvemail.setText(usuario.getEmail());
        holder.tvfirstname.setText(usuario.getFirstName());
        holder.tvlastname.setText(usuario.getLastName());
        holder.tvavatar.setText(usuario.getAvatar());
    }

    public void setData (List<Usuario> usuarios) {
        this.usuarios = usuarios;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class UsuarioAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvid, tvemail, tvfirstname, tvlastname, tvavatar;

        public UsuarioAdapterHolder(View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tvid);
            tvemail = itemView.findViewById(R.id.tvemail);
            tvfirstname = itemView.findViewById(R.id.tvfirstname);
            tvlastname = itemView.findViewById(R.id.tvlastname);
            tvavatar = itemView.findViewById(R.id.tvavatar);
        }
    }
}