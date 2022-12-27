package com.example.ismobile.fragment;
import com.example.ismobile.activity.LoginActivity;
import com.example.ismobile.R;
import com.example.ismobile.adapter.*;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.model.*;
import com.example.ismobile.modelapi.*;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<Bimbingan> bimbinganArrayList;
    private String[] bimbingan_nama, bimbingan_nim;
    private int[] bimbingan_avaID;
    private RecyclerView rv_bimbingan;
    private TextView tv_nip, tv_nama;
    private String usn,status,gettoken,token;
    public HomeFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        tv_nama = rootview.findViewById(R.id.home_nama);
        tv_nip = rootview.findViewById(R.id.home_nip);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;


        Call<ProfileResponse> profileResponseCall = APIClient.getUserService().userProfile(token);
        profileResponseCall.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse profileResponse = response.body();
                tv_nama.setText(profileResponse.getName());
                tv_nip.setText(profileResponse.getUsername());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });
        ImageButton logout = rootview.findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home2logout = new Intent(getActivity(), LoginActivity.class);
                startActivity(home2logout);
            }
        });

        ImageButton home2bimbingan = rootview.findViewById(R.id.btn_homebimbingan);
        home2bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new BimbinganFragment());
                fr.commit();
            }
        });

        return rootview;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialized();
        rv_bimbingan = view.findViewById(R.id.recview_logbook);
        rv_bimbingan.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_bimbingan.setHasFixedSize(true);
        BimbinganAdapter myAdapter = new BimbinganAdapter(getContext(), bimbinganArrayList);
        rv_bimbingan.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialized(){
        bimbinganArrayList = new ArrayList<>();
        bimbingan_nama = new String[]{
                getString(R.string.bimbingan_nama_1),
                getString(R.string.bimbingan_nama_2),
                getString(R.string.bimbingan_nama_3),
                getString(R.string.bimbingan_nama_4),
                getString(R.string.bimbingan_nama_5),
                getString(R.string.bimbingan_nama_6),
                getString(R.string.bimbingan_nama_7),
                getString(R.string.bimbingan_nama_8),
                getString(R.string.bimbingan_nama_9),
                getString(R.string.bimbingan_nama_10),
        };
        bimbingan_nim = new String[]{
                getString(R.string.bimbingan_nim_1),
                getString(R.string.bimbingan_nim_2),
                getString(R.string.bimbingan_nim_3),
                getString(R.string.bimbingan_nim_4),
                getString(R.string.bimbingan_nim_5),
                getString(R.string.bimbingan_nim_6),
                getString(R.string.bimbingan_nim_7),
                getString(R.string.bimbingan_nim_8),
                getString(R.string.bimbingan_nim_9),
                getString(R.string.bimbingan_nim_10),
        };
        bimbingan_avaID = new int[]{
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
                R.drawable.ic_profile,
        };

        for(int i = 0; i<bimbingan_nim.length;i++){
            Bimbingan bimbingan = new Bimbingan(bimbingan_nama[i], bimbingan_nim[i], bimbingan_avaID[i]);
            bimbinganArrayList.add(bimbingan);
        }


    }

}