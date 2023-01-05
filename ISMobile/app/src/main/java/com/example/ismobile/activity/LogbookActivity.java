package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ismobile.R;
import com.example.ismobile.adapter.LogbookAdapter;
import com.example.ismobile.model.Logbook;

import java.util.ArrayList;

public class LogbookActivity extends AppCompatActivity implements LogbookAdapter.ItemLogbookClickListener {

    private RecyclerView rv_logbook;
    private ArrayList<Logbook> listlogbook;
    private String tgl,ket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);
        rv_logbook = findViewById(R.id.recview_logbook);
        rv_logbook.setLayoutManager(new LinearLayoutManager(this));
        rv_logbook.setHasFixedSize(true);
        LogbookAdapter adapter = new LogbookAdapter(getLogbook());
        adapter.setListener(this);
        rv_logbook.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> listLogbook = new ArrayList<>();
        listLogbook.add(new Logbook(
                "01/05/2002",
                "fames ac turpis egestas sed",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "bibendum est ultricies integer quis auctor elit sed vulputate mi sit amet mauris commodo quis",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "bibendum arcu vitae elementum curabitur vitae nunc sed velit dignissim",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "Revisi bab pembahasan",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "fames ac turpis egestas sed",
                1
        ));
        listLogbook.add(new Logbook(
                "12/02/2003",
                "bibendum est ultricies integer quis auctor elit sed vulputate mi sit amet mauris commodo quis",
                1
        ));
        listLogbook.add(new Logbook(
                "01/05/2002",
                "bibendum arcu vitae elementum curabitur vitae nunc sed velit dignissim",
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

    @Override
    public void onItemLogbookClick(Logbook logbook) {
        Intent logbookdetail = new Intent(LogbookActivity.this, LogbookDetailActivity.class);
        startActivity(logbookdetail);
    }
}