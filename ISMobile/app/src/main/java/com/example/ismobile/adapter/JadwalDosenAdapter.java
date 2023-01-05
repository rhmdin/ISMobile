package com.example.ismobile.adapter;
import com.example.ismobile.fragment.JadwalDosenFragment;
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
import com.example.ismobile.modelapi.SeminarsItem;
import com.example.ismobile.modelapi.Student;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class JadwalDosenAdapter extends RecyclerView.Adapter<JadwalDosenAdapter.MyViewHolder>{

    ArrayList<Student> listStudent;
    ItemUndanganClickListener undanganClickListener;
    private View itemView;

    public JadwalDosenAdapter(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
        notifyDataSetChanged();
    }

    public JadwalDosenAdapter(ArrayList<Student> listStudent, ItemUndanganClickListener bimbinganClickListener) {
        this.listStudent = listStudent;
        this.undanganClickListener= undanganClickListener;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
        notifyDataSetChanged();
    }

    public void setUndanganClickListener(ItemUndanganClickListener undanganClickListener) {
        this.undanganClickListener = undanganClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jadwaldosen, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.tv_nama.setText(student.getName());
        holder.tv_nim.setText(student.getNim());
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public void setListener(ItemUndanganClickListener itemUndanganClickListener) {
        this.undanganClickListener = undanganClickListener;
    }


    public interface ItemUndanganClickListener{
        void onItemUndanganClick(Student student);

        void onItemUndanganClick(SeminarsItem seminarsItem);

        void onItemBimbinganClick(SeminarsItem seminarsItem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_nim,tv_ket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.jadwaldosen_nama);
            tv_nim = itemView.findViewById(R.id.jadwaldosen_nim);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = listStudent.get(getAdapterPosition());
                    undanganClickListener.onItemUndanganClick(student);
                }
            });
        }
    }
}