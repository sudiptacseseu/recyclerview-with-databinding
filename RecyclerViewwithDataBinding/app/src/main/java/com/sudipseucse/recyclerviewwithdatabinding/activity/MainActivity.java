package com.sudipseucse.recyclerviewwithdatabinding.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sudipseucse.recyclerviewwithdatabinding.adapter.RecyclerViewAdapter;
import com.sudipseucse.recyclerviewwithdatabinding.R;
import com.sudipseucse.recyclerviewwithdatabinding.databinding.ActivityMainBinding;
import com.sudipseucse.recyclerviewwithdatabinding.model.Version;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        populateData();
    }

    private void populateData() {
        List<Version> versionList = new ArrayList<>();

        versionList.add(new Version("Android 11", " (11.0)", "Api Level: 30"));
        versionList.add(new Version("Android 10", " (10.0)", "Api Level: 29"));
        versionList.add(new Version("Android Pie", " (9.0)", "Api Level: 28"));
        versionList.add(new Version("Android Oreo", " (8.0, 8.1)", "Api Level: 26, 27"));
        versionList.add(new Version("Android Nougat", " (7.0, 7.1.0 - 7.1.2)", "Api Level: 24, 25"));
        versionList.add(new Version("Android Marshmallow", " (6.0, 6.0.1)", "Api Level: 23"));

        binding.recyclerView.setAdapter(new RecyclerViewAdapter(versionList, this));
    }
}
