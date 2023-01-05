package com.example.ismobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import com.example.ismobile.R;
import com.example.ismobile.model.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;


public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.MyViewHolder> {

    Context context;
    ArrayList<Logbook> listLogbook;
    ItemLogbookClickListener logbookClickListener;

    public LogbookAdapter(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListener(ItemLogbookClickListener logbookClickListener) {
        this.logbookClickListener = logbookClickListener;
    }

    public LogbookAdapter(ArrayList<Logbook> listLogbook, ItemLogbookClickListener logbookClickListener) {
        this.listLogbook = listLogbook;
        this.logbookClickListener = logbookClickListener;
    }
    public void setListLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_logbook, parent, false);
        return new MyViewHolder(v);
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

    public interface  ItemLogbookClickListener{
        void onItemLogbookClick(Logbook logbook);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tgl, ket;
        ImageButton detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tgl = itemView.findViewById(R.id.logbook_tgl);
            ket = itemView.findViewById(R.id.logbook_ket);
            detail = itemView.findViewById(R.id.logbook_btn_detail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Logbook logbook = listLogbook.get(getAdapterPosition());
            logbookClickListener.onItemLogbookClick(logbook);
        }
    }
}