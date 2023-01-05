package com.example.ismobile.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.activity.DetailMahasiswaActivity;
import com.example.ismobile.adapter.BimbinganAdapter;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.ListBimbingan;
import com.example.ismobile.modelapi.Student;
import com.example.ismobile.modelapi.Theses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BimbinganFragment extends Fragment implements BimbinganAdapter.ItemBimbinganClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView tv_nama;
    String token, gettoken, mhsnama, mhsnim, mhsket;
    private RecyclerView rv_bimbingan;
    SharedPreferences sharedPreferences;
    BimbinganAdapter bimbinganAdapter;

    public BimbinganFragment() {
        // Required empty public constructor
    }

    public static BimbinganFragment newInstance(String param1, String param2) {
        BimbinganFragment fragment = new BimbinganFragment();
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bimbingan, container, false);

        sharedPreferences = getActivity().getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        rv_bimbingan = view.findViewById(R.id.recview_bimbingan);
        rv_bimbingan.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<ListBimbingan> call = APIClient.getUserService().listBimbingan(token);
        call.enqueue(new Callback<ListBimbingan>() {
            @Override
            public void onResponse(Call<ListBimbingan> call, Response<ListBimbingan> response) {
                ListBimbingan listBimbingan = response.body();
                if(response.code()==200){
                    Toast.makeText(getContext(),"Jml bimbingan: "+listBimbingan.getCount(),Toast.LENGTH_SHORT);
                    List<Theses> listTesis = listBimbingan.getTheses();
                    ArrayList<Student> studentArrayList = new ArrayList<>();
                    bimbinganAdapter = new BimbinganAdapter(studentArrayList);
                    for (Theses itemTesis: listTesis){
                        Student student = new Student(
                                itemTesis.getId(),
                                itemTesis.getStudent().getName(),
                                itemTesis.getStudent().getNim(),
                                itemTesis.getStartAt()
                        );
                        studentArrayList.add(student);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        rv_bimbingan.setLayoutManager(manager);
                        rv_bimbingan.setAdapter(bimbinganAdapter);
                    }
                    Log.d("data", String.valueOf(studentArrayList));
                    bimbinganAdapter.setBimbinganClickListener(BimbinganFragment.this);
                }
                else {
                    Toast.makeText(getContext(),"kode: "+response.code(),Toast.LENGTH_SHORT);

                }
            }

            @Override
            public void onFailure(Call<ListBimbingan> call, Throwable t) {
                Toast.makeText(getContext(),"gagal call ",Toast.LENGTH_SHORT);
            }
        });
        Toast.makeText(getContext(),"gagal call ",Toast.LENGTH_SHORT);

        return view;
    }

    public void getBimbingan(String token){
    }
    @Override
    public void onItemBimbinganClick(Student student) {
        Intent detail = new Intent(getActivity().getApplicationContext(), DetailMahasiswaActivity.class);

        Toast.makeText(getContext(),"Alhamdulillah: "+student.getName(),Toast.LENGTH_SHORT);
        detail.putExtra("id", student.getIdThesis());
        getActivity().startActivity(detail);

    }
}