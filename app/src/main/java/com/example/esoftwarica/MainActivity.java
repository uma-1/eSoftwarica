package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.Students;
import Adapter.StudentsAdapter;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        //create list of contacts to display in recycleView
        List<Students> contactList=new ArrayList<>();
        contactList.add(new Students("Ram","26","India","Male",R.drawable.male));
        contactList.add(new Students("Anjeela","19","Nepal","Female",R.drawable.female));
        contactList.add(new Students("Suman","22","Nepal","Male",R.drawable.male));
        contactList.add(new Students("Dikshya","21","Nepal","Female",R.drawable.female));
        contactList.add(new Students("Shyam","23","China","Male",R.drawable.male));
        contactList.add(new Students("Shristi","21","Nepal","Female",R.drawable.female));


        StudentsAdapter studentsAdapter= new StudentsAdapter(this,contactList);
        recyclerView.setAdapter(studentsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
