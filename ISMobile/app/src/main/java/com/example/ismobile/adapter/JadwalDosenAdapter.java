package com.example.ismobile.adapter;
import com.example.ismobile.model.Bimbingan;
import com.example.ismobile.model.JadwalDosen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ismobile.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class JadwalDosenAdapter extends RecyclerView.Adapter<JadwalDosenAdapter.MyViewHolder>{

    Context context;
    ArrayList<JadwalDosen> jadwaldosenArrayList;
    JadwalDosenAdapter.ItemUndanganClickListener undanganClickListener;

    public JadwalDosenAdapter(Context context, ArrayList<JadwalDosen> jadwaldosenArrayList){
        this.context = context;
        this.jadwaldosenArrayList = jadwaldosenArrayList;

    }

    public JadwalDosenAdapter(ArrayList<JadwalDosen> jadwaldosenArrayList, ItemUndanganClickListener undanganClickListener) {
        this.jadwaldosenArrayList = jadwaldosenArrayList;
        this.undanganClickListener = undanganClickListener;
    }

    public void setJadwaldosenArrayList(ArrayList<JadwalDosen> jadwaldosenArrayList) {
        this.jadwaldosenArrayList = jadwaldosenArrayList;
    }

    public void setListener(ItemUndanganClickListener undanganClickListener) {
        this.undanganClickListener = undanganClickListener;
    }

    @NonNull
    @Override
    public JadwalDosenAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_jadwaldosen,parent,false);

        return new JadwalDosenAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalDosenAdapter.MyViewHolder holder, int position) {

        JadwalDosen jadwalDosen = jadwaldosenArrayList.get(position);
        holder.jadwaldosen_nama.setText(jadwalDosen.nama);
        holder.jadwaldosen_nim.setText(jadwalDosen.nim);
        holder.jadwaldosen_skripsi.setText(jadwalDosen.skripsi);
        holder.jadwaldosen_waktu.setText(jadwalDosen.waktu);
        holder.jadwaldosen_kategori.setText(jadwalDosen.kategori);
        holder.jadwaldosen_jam.setText(jadwalDosen.jam);
        holder.jadwaldosen_tempat.setText(jadwalDosen.tempat);
    }

    @Override
    public int getItemCount() {
        return jadwaldosenArrayList.size();
    }
    public interface  ItemUndanganClickListener{
        void onItemUndanganClick(JadwalDosen jadwaldosen);

    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ShapeableImageView jadwaldosen_ava;
        TextView jadwaldosen_nama;
        TextView jadwaldosen_nim;
        TextView jadwaldosen_skripsi;
        TextView jadwaldosen_waktu;
        TextView jadwaldosen_kategori;
        TextView jadwaldosen_jam;
        TextView jadwaldosen_tempat;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            jadwaldosen_kategori = itemView.findViewById(R.id.jadwaldosen_kategori);
            jadwaldosen_nama = itemView.findViewById(R.id.jadwaldosen_nama);
            jadwaldosen_nim = itemView.findViewById(R.id.jadwaldosen_nim);
            jadwaldosen_waktu = itemView.findViewById(R.id.jadwaldosen_waktu);
            jadwaldosen_skripsi = itemView.findViewById(R.id.jadwaldosen_skripsi);
            jadwaldosen_jam = itemView.findViewById(R.id.jadwaldosen_jam);
            jadwaldosen_tempat = itemView.findViewById(R.id.jadwaldosen_tempat);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            JadwalDosen jadwaldosen = jadwaldosenArrayList.get(getAdapterPosition());
            undanganClickListener.onItemUndanganClick(jadwaldosen);
        }
    }
}