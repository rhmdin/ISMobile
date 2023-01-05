package com.example.ismobile.fragment;
import com.example.ismobile.R;
import com.example.ismobile.activity.DetailMahasiswaActivity;
import com.example.ismobile.adapter.*;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.data.Listmahasiswabimbingan;
import com.example.ismobile.model.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.example.ismobile.data.Thesis;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<Request> requestArrayList;
    private String[] request_nama, request_nim, request_skripsi;
    private int[] request_avaID;
    private RecyclerView recyclerview;
    private String token;

    public RequestFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RequestFragment newInstance(String param1, String param2) {
        RequestFragment fragment = new RequestFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request, container, false);
    }



    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println(token);
                        Toast.makeText(RequestFragment.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
        super.onViewCreated(view, savedInstanceState);

        recyclerview = view.findViewById(R.id.recview_jadwaldosen);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        RequestAdapter myAdapter = new RequestAdapter(getContext(), requestArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


    }

    public ArrayList<Thesis>getMahasiswaTA(){
        APIClient config = new APIClient();
        ArrayList<Thesis>listmb = new ArrayList<>();
        //panggil client
        Call<Listmahasiswabimbingan> call = config.configRetrofit().getListmahasiswabimbingan(token);
        call.enqueue(new Callback<Listmahasiswabimbingan>() {
            @Override
            public void onResponse(Call<Listmahasiswabimbingan> call, Response<Listmahasiswabimbingan> response) {
                Listmahasiswabimbingan thesesData = response.body();
                List<Thesis> listmahasiswa = thesesData.getTheses();
                ArrayList<Thesis>Request = new ArrayList<>();
                for(Thesis thesis : listmahasiswa){
                    listmb.add(thesis);
                }
            }

            @Override
            public void onFailure(Call<Listmahasiswabimbingan> call, Throwable t) {
                Toast.makeText(listmb.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return listmb;

    }



    }
