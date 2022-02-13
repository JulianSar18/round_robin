package com.roundrobin.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    Context context;

    List<TableModel> table_list;

    public TableAdapter(Context context, List<TableModel> table_list){
        this.context = context;
        this.table_list = table_list;
    }
    @NonNull
    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        if (table_list != null && table_list.size() > 0){
            TableModel model = table_list.get(position);
            holder.name_tv.setText(String.valueOf(model.getNombre()));
            holder.peso_tv.setText(String.valueOf(model.getPesoCPU()));
            holder.estado_tv.setText(String.valueOf(model.getEstado()));
            holder.prioridad_tv.setText(String.valueOf(model.getEstado()));
        }
    }

    @Override
    public int getItemCount() {
        return table_list.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView name_tv, peso_tv, estado_tv, prioridad_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_tv = itemView.findViewById(R.id.name_tv);
            peso_tv = itemView.findViewById(R.id.peso_tv);
            estado_tv = itemView.findViewById(R.id.estado_tv);
            prioridad_tv = itemView.findViewById(R.id.prioridad_tv);
        }
    }
}
