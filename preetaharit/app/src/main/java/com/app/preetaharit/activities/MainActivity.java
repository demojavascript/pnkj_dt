package com.app.preetaharit.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.adapters.MenuGridAdapter;
import com.app.preetaharit.activities.gridviews.MenuGridView;

public class MainActivity extends AppCompatActivity {

    private static MainActivity inst;
    private MenuGridAdapter menuGridAdapter;
    private MenuGridView menuGridView;
    private String [] cmenus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMenu();
    }

    private void showMenu(){
        Resources objres = getResources();
        cmenus = objres.getStringArray(R.array.menuoptions);
        menuGridAdapter = new MenuGridAdapter(this, cmenus);
        menuGridView = (MenuGridView) findViewById(R.id.gridProduct);
        menuGridView.setNumColumns(2);
        menuGridView.setAdapter(menuGridAdapter);
    }

    public void shareApp(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.app_google_play_url));
        startActivity(Intent.createChooser(shareIntent, "Error"));
    }
    public void callUs(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+getResources().getString(R.string.customer_care_no)));
        startActivity(intent);
    }
    public static MainActivity instance() {
        return inst;
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
        inst = this;
    }
}
