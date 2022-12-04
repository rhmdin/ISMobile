package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ismobile.R;
import com.example.ismobile.adapter.LogbookAdapter;
import com.example.ismobile.model.Logbook;

import java.util.ArrayList;

public class LogbookActivity extends AppCompatActivity {

    private RecyclerView rv_logbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        rv_logbook = findViewById(R.id.recview_logbook);

        LogbookAdapter adapter = new LogbookAdapter(getLogbook());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_logbook.setLayoutManager(layoutManager);
        rv_logbook.setAdapter(adapter);
    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> listLogbook = new ArrayList<>();
        listLogbook.add(new Logbook(
                "01/05/2002",
                "Revisi bab pendahuluan",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "Revisi bab pendahuluan",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "Revisi bab pendahuluan",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "Revisi bab pendahuluan",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "Revisi bab pendahuluan",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));

        return listLogbook;
    }
}