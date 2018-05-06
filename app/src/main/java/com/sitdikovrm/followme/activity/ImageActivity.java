package com.sitdikovrm.followme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.sitdikovrm.followme.R;
import com.sitdikovrm.followme.model.Image;

public class ImageActivity extends AppCompatActivity {
    public static final String ARG_IMAGE = "image";

    public static Intent getIntent(Context context, Image image) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(ARG_IMAGE, image);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Image image = getIntent().getParcelableExtra(ARG_IMAGE);

        Glide.with(this).load(image).into(imageView);
    }
}
