package com.example.ismobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ismobile.R;

import com.example.ismobile.activity.BimbinganActivity;
import com.example.ismobile.modelapi.ListBimbingan;
import com.example.ismobile.modelapi.Student;
import com.example.ismobile.modelapi.Theses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class BimbinganAdapter extends RecyclerView.Adapter<BimbinganAdapter.MyViewHolder> {

    ArrayList<Student> listStudent;
    ItemBimbinganClickListener bimbinganClickListener;

    public BimbinganAdapter(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
        notifyDataSetChanged();
    }

    public BimbinganAdapter(ArrayList<Student> listStudent, ItemBimbinganClickListener bimbinganClickListener) {
        this.listStudent = listStudent;
        this.bimbinganClickListener = bimbinganClickListener;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
        notifyDataSetChanged();
    }

    public void setBimbinganClickListener(ItemBimbinganClickListener bimbinganClickListener) {
        this.bimbinganClickListener = bimbinganClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bimbingan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.tv_nama.setText(student.getName());
        holder.tv_nim.setText(student.getNim());
        holder.tv_ket.setText(student.getSejak());
        holder.iv_bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bimbinganClickListener.onItemBimbinganClick(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public void setListener(ItemBimbinganClickListener itemBimbinganClickListener) {
        this.bimbinganClickListener = bimbinganClickListener;
    }


    public interface ItemBimbinganClickListener{
        void onItemBimbinganClick(Student student);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_nim,tv_ket;
        ImageView iv_bimbingan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.bimbingan_nama);
            tv_nim = itemView.findViewById(R.id.bimbingan_nim);
            tv_ket = itemView.findViewById(R.id.bimbingan_ket);
            iv_bimbingan = itemView.findViewById(R.id.bimbingan_iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = listStudent.get(getBindingAdapterPosition());
                    bimbinganClickListener.onItemBimbinganClick(student);
                }
            });
        }
    }
}
