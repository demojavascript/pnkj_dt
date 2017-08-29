package com.app.preetaharit.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.adapters.EventGridAdapter;
import com.app.preetaharit.activities.gridviews.EventsGridView;
import com.app.preetaharit.activities.models.CEvent;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EventGridAdapter eventGridAdapter;
    private EventsGridView eventGridView;
    private ArrayList<CEvent> allevents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Events");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showEvents();
    }

    private void showEvents(){
        Resources objres = getResources();
        String[] titles = objres.getStringArray(R.array.eventstitle);
        String[] descs = objres.getStringArray(R.array.eventsdesc);
        allevents = new ArrayList<CEvent>();
        for(int i=0;i<3;i++){
            CEvent obj = new CEvent(titles[i], descs[i], "");
            allevents.add(obj);
        }
        eventGridAdapter = new EventGridAdapter(this, allevents);
        eventGridView = (EventsGridView) findViewById(R.id.gridEvents);
        eventGridView.setNumColumns(1);
        eventGridView.setAdapter(eventGridAdapter);
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
