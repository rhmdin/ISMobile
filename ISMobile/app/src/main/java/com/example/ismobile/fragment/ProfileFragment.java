package com.example.ismobile.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ismobile.activity.LoginActivity;
import com.example.ismobile.R;
import com.example.ismobile.activity.*;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.databinding.FragmentProfileBinding;
import com.example.ismobile.modelapi.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tv_nama, tv_nip;
    private String usn,gettoken,token;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, container, false);
        tv_nama = rootview.findViewById(R.id.profile_nama);
        tv_nip = rootview.findViewById(R.id.profile_nip);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Call<Profile> profileResponseCall = APIClient.getUserService().userProfile(token);
        profileResponseCall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.code()==200){
                    if(response.isSuccessful()){
                        Toast.makeText(getActivity(), "Alhamdulillah", Toast.LENGTH_SHORT).show();
                        Profile profileResponse = response.body();
                        tv_nama.setText(profileResponse.getName());
                        tv_nip.setText(profileResponse.getUsername());
                    }
                }
                else if(response.code()==500){
                    if(!response.isSuccessful()){
                        Toast.makeText(getActivity(), "Servernya ada error", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal dipanggil servenya", Toast.LENGTH_SHORT).show();

            }
        });

        // Inflate the layout for this fragment
        TextView edit_profile = rootview.findViewById(R.id.profile_edit);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahProfilActivity.class);
                startActivity(intent);
            }
        });
        ImageView edit_profile_icon = rootview.findViewById(R.id.profile_edit_icon);
        edit_profile_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahProfilActivity.class);
                startActivity(intent);
            }
        });
        TextView edit_pw = rootview.findViewById(R.id.profile_password);
        edit_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahPasswordActivity.class);
                startActivity(intent);
            }
        });
        ImageView edit_pw_icon = rootview.findViewById(R.id.profile_password_icon);
        edit_pw_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahPasswordActivity.class);
                startActivity(intent);
            }
        });
        TextView logout = rootview.findViewById(R.id.profile_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userkey",  Context.MODE_PRIVATE);
                gettoken = sharedPreferences.getString("token", "");
                token = "Bearer " + gettoken;

                Call<Logout> call = APIClient.getUserService().userLogout(token);
                call.enqueue(new Callback<Logout>() {
                    @Override
                    public void onResponse(Call<Logout> call, Response<Logout> response) {
                        if(response.code()==200){
                            if(response.isSuccessful()){
                                Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                sharedPreferences.edit().clear().apply();
                                    Intent logout = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(logout);


                            }
                        }
                    }
                    //
                    @Override
                    public void onFailure(Call<Logout> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        ImageView logout_icon = rootview.findViewById(R.id.profile_logout_icon);
        logout_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userkey",  Context.MODE_PRIVATE);
                gettoken = sharedPreferences.getString("token", "");
                token = "Bearer " + gettoken;

                Call<Logout> call = APIClient.getUserService().userLogout(token);
                call.enqueue(new Callback<Logout>() {
                    @Override
                    public void onResponse(Call<Logout> call, Response<Logout> response) {
                        if(response.code()==200){
                            if(response.isSuccessful()){
                                Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                sharedPreferences.edit().clear().apply();
                                    Intent logout = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(logout);


                            }
                        }
                    }
                    //
                    @Override
                    public void onFailure(Call<Logout> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return rootview;
    }

    ProfileListener pListener;

    public interface ProfileListener{

    }

}