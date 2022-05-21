package com.example.taskmaster.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskmaster.R;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    List<Task> taskList;

    public RecyclerViewActivity(List<Task> taskList){
        this.taskList = taskList;
    }
    public RecyclerViewActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        CustomListRecyclerViewAdapter customListRecyclerViewAdapter = new CustomListRecyclerViewAdapter(taskList
                , position -> navigateToTaskDetailsPage());

        recyclerView.setAdapter(customListRecyclerViewAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void navigateToTaskDetailsPage() {

        Intent intent = new Intent(this, TaskDetailsActivity.class);
        startActivity(intent);

    }


}