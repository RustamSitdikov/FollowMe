package com.sitdikovrm.followme.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sitdikovrm.followme.R;
import com.sitdikovrm.followme.adapter.TapeAdapter;
import com.sitdikovrm.followme.model.Image;

public class TapeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tape_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.tape_images);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);

        TapeAdapter adapter = new TapeAdapter(this, Image.getImages());
        mRecyclerView.setAdapter(adapter);
    }
}
