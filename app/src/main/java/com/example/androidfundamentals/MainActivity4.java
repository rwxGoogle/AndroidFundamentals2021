package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //define data source for recyclerView
        DataSource dataSource = new DataSource();
        List<String> photoList = dataSource.getPhotoList();

        List<DataSource.Person> personList = dataSource.getPersons();

        RecyclerView photoListRecycler = findViewById(R.id.photoList);

        //define layoutManager for recycler
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        photoListRecycler.setLayoutManager(linearLayoutManager);

        //define photos list
        PhotosAdapter photosAdapter = new PhotosAdapter(photoList, personList);
        photoListRecycler.setAdapter(photosAdapter);
    }
}