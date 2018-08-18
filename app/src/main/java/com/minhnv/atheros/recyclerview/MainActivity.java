package com.minhnv.atheros.recyclerview;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void addDivider(RecyclerView recyclerView, int orientation) {
        DividerItemDecoration decoration = new DividerItemDecoration(this,
                orientation);
        Drawable divider = getResources().getDrawable(R.drawable.custom_divider);
        decoration.setDrawable(divider);
        recyclerView.addItemDecoration(decoration);
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this,
                DividerItemDecoration.VERTICAL, 3));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL, 3));
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image(R.drawable.a1, "Hình 1"));
        images.add(new Image(R.drawable.a2, "Hình 2"));
        images.add(new Image(R.drawable.a3, "Hình 3"));
        images.add(new Image(R.drawable.a4, "Hình 4"));
        images.add(new Image(R.drawable.a5, "Hình 5"));
        images.add(new Image(R.drawable.a6, "Hình 6"));
        images.add(new Image(R.drawable.a7, "Hình 7"));
        images.add(new Image(R.drawable.a8, "Hình 8"));
        images.add(new Image(R.drawable.a9, "Hình 9"));
        images.add(new Image(R.drawable.a10, "Hình 10"));
        images.add(new Image(R.drawable.a11, "Hình 11"));
        images.add(new Image(R.drawable.a12, "Hình 12"));
        images.add(new Image(R.drawable.a13, "Hình 13"));
        images.add(new Image(R.drawable.a14, "Hình 14"));
        images.add(new Image(R.drawable.a15, "Hình 15"));
        images.add(new Image(R.drawable.a16, "Hình 16"));
        images.add(new Image(R.drawable.a17, "Hình 17"));


        ImageAdapter imageAdapter = new ImageAdapter(this, images);
        recyclerView.setAdapter(imageAdapter);

    }
}
