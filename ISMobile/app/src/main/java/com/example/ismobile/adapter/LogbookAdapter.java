package com.example.ismobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ismobile.R;
import com.example.ismobile.model.Logbook;

import java.util.ArrayList;

public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.MyViewHolder> {

    ArrayList<Logbook> listLogbook = new ArrayList<>();

    public LogbookAdapter(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_logbook, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookAdapter.MyViewHolder holder, int position) {
        Logbook logbook = listLogbook.get(position);
        holder.tgl.setText(logbook.getTgl());
        holder.ket.setText(logbook.getKet());


    }

    @Override
    public int getItemCount() {

        return listLogbook.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tgl, ket;
        public ImageButton detail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tgl = itemView.findViewById(R.id.logbook_tgl);
            ket = itemView.findViewById(R.id.logbook_ket);
            detail = itemView.findViewById(R.id.logbook_btn_detail);

        }
    }
}