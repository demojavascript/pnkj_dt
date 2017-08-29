package com.app.preetaharit.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.adapters.PhotoGridAdapter;
import com.app.preetaharit.activities.adapters.VideoGridAdapter;
import com.app.preetaharit.activities.gridviews.PhotoGridView;
import com.app.preetaharit.activities.gridviews.VideoGridView;

public class GalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private PhotoGridAdapter photoGridAdapter;
    private PhotoGridView photoGridView;
    private String [] photos;
    private VideoGridAdapter videoGridAdapter;
    private VideoGridView videoGridView;
    private String [] videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Gallery");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showPhotos();
    }

    private void showPhotos(){
        Resources objres = getResources();
        photos = objres.getStringArray(R.array.photos);
        photoGridAdapter = new PhotoGridAdapter(this, photos);
        photoGridView = (PhotoGridView) findViewById(R.id.gridPhotos);
        photoGridView.setNumColumns(2);
        photoGridView.setAdapter(photoGridAdapter);
        showVideos();
    }

    private void showVideos(){
        Resources objres = getResources();
        videos = objres.getStringArray(R.array.videos);
        videoGridAdapter = new VideoGridAdapter(this, videos);
        videoGridView = (VideoGridView) findViewById(R.id.gridVideos);
        videoGridView.setNumColumns(2);
        videoGridView.setAdapter(videoGridAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    public void onStart() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onStart();
    }
}
