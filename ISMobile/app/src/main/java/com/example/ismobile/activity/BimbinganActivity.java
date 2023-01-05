package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.adapter.BimbinganAdapter;
import com.example.ismobile.adapter.LogbookAdapter;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.fragment.BimbinganFragment;
import com.example.ismobile.model.Bimbingan;
import com.example.ismobile.model.Logbook;
import com.example.ismobile.modelapi.ListBimbingan;
import com.example.ismobile.modelapi.Student;
import com.example.ismobile.modelapi.Theses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BimbinganActivity extends AppCompatActivity implements BimbinganAdapter.ItemBimbinganClickListener{

    TextView tv_nama;
    String token, gettoken, mhsnama, mhsnim, mhsket;
    private RecyclerView rv_bimbingan;
    SharedPreferences sharedPreferences;
    BimbinganAdapter bimbinganAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimbingan);
        sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        rv_bimbingan = findViewById(R.id.recview_bimbingan);
        rv_bimbingan.setLayoutManager(new LinearLayoutManager(this));
        rv_bimbingan.setHasFixedSize(true);
        /*BimbinganAdapter adapter = new BimbinganAdapter(getBimbingan());
        adapter.setListener(this);
        rv_bimbingan.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/


        Call<ListBimbingan> call = APIClient.getUserService().listBimbingan(token);
        call.enqueue(new Callback<ListBimbingan>() {
            @Override
            public void onResponse(Call<ListBimbingan> call, Response<ListBimbingan> response) {
                ListBimbingan listBimbingan = response.body();
                if(response.code()==200){
                    Toast.makeText(BimbinganActivity.this,"Jml bimbingan: "+listBimbingan.getCount(),Toast.LENGTH_SHORT);
                    List<Theses> listTesis = listBimbingan.getTheses();
                    ArrayList<Student> studentArrayList = new ArrayList<>();
                    for (Theses itemTesis: listTesis){
                        Student student = new Student(
                                itemTesis.getId(),
                                itemTesis.getStudent().getName(),
                                itemTesis.getStudent().getNim()
                        );
                        studentArrayList.add(student);
                    }
                    rv_bimbingan.setLayoutManager(new LinearLayoutManager(BimbinganActivity.this));
                    rv_bimbingan.setHasFixedSize(true);
                    if(!studentArrayList.isEmpty()){
                        bimbinganAdapter = new BimbinganAdapter(studentArrayList);
                    }
                    else {
                        bimbinganAdapter = new BimbinganAdapter(getBimbingan());
                    }
                    bimbinganAdapter.setListStudent(studentArrayList);
                    rv_bimbingan.setAdapter(bimbinganAdapter);
                    bimbinganAdapter.notifyDataSetChanged();
                    Log.d("data", String.valueOf(studentArrayList));;
                }
                else {
                    Toast.makeText(BimbinganActivity.this,response.code()+" "+response.message(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ListBimbingan> call, Throwable t) {
                Toast.makeText(BimbinganActivity.this,"gagal call",Toast.LENGTH_SHORT);
            }
        });
    }


    private ArrayList<Student> getBimbingan(){
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
    public void onItemBimbinganClick(Student student) {
        Intent bimbingandetail = new Intent(BimbinganActivity.this, DetailMahasiswaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("idtesis", student.getIdThesis());
        bimbingandetail.putExtras(bundle);
        startActivity(bimbingandetail);
    }
}