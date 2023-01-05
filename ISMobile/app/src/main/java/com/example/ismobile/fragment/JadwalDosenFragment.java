package com.example.ismobile.fragment;
import com.example.ismobile.R;
import com.example.ismobile.activity.*;
import com.example.ismobile.adapter.*;
import com.example.ismobile.model.*;
import com.example.ismobile.modelapi.ListUndangan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ismobile.activity.DetailUndanganActivity;
import com.example.ismobile.adapter.JadwalDosenAdapter;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.Student;
import com.example.ismobile.modelapi.SeminarsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalDosenFragment extends Fragment implements JadwalDosenAdapter.ItemUndanganClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView tv_nama;
    String token, gettoken, mhsnama, mhsnim, mhsket;
    private RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    BimbinganAdapter bimbinganAdapter;

    public JadwalDosenFragment() {

    }

    public static JadwalDosenFragment newInstance(String param1, String param2) {
        JadwalDosenFragment fragment = new JadwalDosenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jadwaldosen, container, false);

        sharedPreferences = getActivity().getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        recyclerView = view.findViewById(R.id.recview_jadwaldosen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<ListUndangan> call = APIClient.getUserService().listUndangan(token);
        call.enqueue(new Callback<ListUndangan>() {
            @Override
            public void onResponse(Call<ListUndangan> call, Response<ListUndangan> response) {
                ListUndangan listUndangan = response.body();
                if (response.code() == 200) {
                    Toast.makeText(getContext(), "Jml Undangan: " + listUndangan.getCount(), Toast.LENGTH_SHORT);
                    List<SeminarsItem> listTesis = listUndangan.getSeminars();
                    ArrayList<Student> studentArrayList = new ArrayList<>();
                    JadwalDosenAdapter jadwalDosenAdapter = new JadwalDosenAdapter(studentArrayList);
                    for (SeminarsItem itemTesis: listTesis){
                        Student student = new Student(
                                itemTesis.getId(),
                                itemTesis.getThesis().getStudent().getName(),
                                itemTesis.getThesis().getStudent().getNim()
                        );
                        studentArrayList.add(student);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setHasFixedSize(true);
                    if(!studentArrayList.isEmpty()){
                        jadwalDosenAdapter = new JadwalDosenAdapter(studentArrayList);
                    }
                    else {
                        jadwalDosenAdapter = new JadwalDosenAdapter(getJadwalDosen());
                    }
                    jadwalDosenAdapter.setListStudent(studentArrayList);
                    recyclerView.setAdapter(jadwalDosenAdapter);
                    jadwalDosenAdapter.notifyDataSetChanged();
                    Log.d("data", String.valueOf(studentArrayList));;
                } else {
                    Toast.makeText(getContext(), "kode: " + response.code(), Toast.LENGTH_SHORT);

                }
            }

            @Override
            public void onFailure(Call<ListUndangan> call, Throwable t) {
                Toast.makeText(getContext(), "gagal call ", Toast.LENGTH_SHORT);
            }
        });
        Toast.makeText(getContext(), "gagal call ", Toast.LENGTH_SHORT);

        return view;
    }

    @Override
    public void onItemUndanganClick(Student student) {

    }

    /*@Override
    public void onItemUndanganClick(SeminarsItem seminarsItem) {
        Intent detail = new Intent(getActivity().getApplicationContext(), DetailUndanganActivity.class);



    }*/

    @Override
    public void onItemBimbinganClick(SeminarsItem seminarsItem) {

    }

    private ArrayList<Student> getJadwalDosen(){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_4),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_3),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_1),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_2),
                getString(R.string.bimbingan_nim_2)
        ));
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_4),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_3),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_1),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_2),
                getString(R.string.bimbingan_nim_2)
        ));
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_4),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_3),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_1),
                getString(R.string.bimbingan_nim_2)
        ));;
        studentArrayList.add(new Student(
                1,
                getString(R.string.bimbingan_nama_2),
                getString(R.string.bimbingan_nim_2)
        ));
        return studentArrayList;
    }

    @Override
    public void onItemUndanganClick(SeminarsItem seminarsItem) {
        Intent detail = new Intent(new Intent(getActivity(), DetailUndanganActivity.class));
        Toast.makeText(getContext(),"Alhamdulillah: "+seminarsItem.getThesis().getStudent().getName(),Toast.LENGTH_SHORT);
        detail.putExtra("id", seminarsItem.getThesisId());
        getActivity().startActivity(detail);
    }
}