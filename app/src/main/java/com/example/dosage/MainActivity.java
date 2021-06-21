package com.example.dosage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        List<Drug> drugList = new ArrayList<>();
        Drug drug1 = new Drug(R.drawable.ic_launcher_background,"Adenosine","- 6mg/2mL(Adult with weight > 50Kg)\n- 0.05 to 0.1mg/Kg(Pediatric with weight < 50Kg)");
        Drug drug2 = new Drug(R.drawable.ic_launcher_background,"Amiodarone"," 15mg/min");
        Drug drug3 = new Drug(R.drawable.ic_launcher_background,"GTN"," 5mg/mL");
        Drug drug4 = new Drug(R.drawable.ic_launcher_background,"Normal Saline 0.9%"," 15mg/min");
        Drug drug5 = new Drug(R.drawable.ic_launcher_background,"Tramadol"," 0.15mg/Kg");
        Drug drug6 = new Drug(R.drawable.ic_launcher_background,"Ventolin Salbutamol"," 2.5mg/3mL");
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugList.add(drug4);
        drugList.add(drug5);
        drugList.add(drug6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter myAdapter  = new MyAdapter(drugList);

        recyclerView.setAdapter(myAdapter);
    }
}