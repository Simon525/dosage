package com.example.dosage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        List<Drug> drugList = new ArrayList<>();
        Drug drug1 = new Drug(R.drawable.adenosine,"Adenosine","- 6mg/2mL(Adult with weight > 50Kg)\n- 0.05 to 0.1mg/Kg(Pediatric with weight < 50Kg)");
        Drug drug2 = new Drug(R.drawable.amiodarone,"Amiodarone"," 15mg/min");
        Drug drug3 = new Drug(R.drawable.gtn,"GTN"," 5mg/mL");
        Drug drug4 = new Drug(R.drawable.normalsaline,"Normal Saline 0.9%"," 15mg/min");
        Drug drug5 = new Drug(R.drawable.tramadol,"Tramadol"," 0.15mg/Kg");
        Drug drug6 = new Drug(R.drawable.vs,"Ventolin Salbutamol"," 2.5mg/3mL");
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugList.add(drug4);
        drugList.add(drug5);
        drugList.add(drug6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter  = new MyAdapter(drugList);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drug_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}