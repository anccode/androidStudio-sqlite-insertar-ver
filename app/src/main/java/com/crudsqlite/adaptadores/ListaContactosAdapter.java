package com.crudsqlite.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crudsqlite.R;
import com.crudsqlite.entidades.Contactos;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContacyoViewHolder> {
    ArrayList<Contactos> listaContactos;

    public ListaContactosAdapter(ArrayList<Contactos> listaContactos){
        this.listaContactos = listaContactos;
    }

    @NonNull
    @Override
    public ContacyoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto,
                null, false);
        return new ContacyoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContacyoViewHolder holder, int position) {
        holder.viewNombre.setText(listaContactos.get(position).getNombre());
        holder.viewTelefono.setText(listaContactos.get(position).getTelefono());
        holder.viewCorreo.setText(listaContactos.get(position).getCorreo());
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContacyoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo;

        public ContacyoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

        }
    }
}
