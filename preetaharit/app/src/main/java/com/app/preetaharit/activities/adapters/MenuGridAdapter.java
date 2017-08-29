package com.app.preetaharit.activities.adapters;

/**
 * Created by Rahul on 10-01-2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.AspirationsActivity;
import com.app.preetaharit.activities.ContactUsActivity;
import com.app.preetaharit.activities.EventsActivity;
import com.app.preetaharit.activities.GalleryActivity;
import com.app.preetaharit.activities.MainActivity;
import com.app.preetaharit.activities.NotificationsActivity;
import com.app.preetaharit.activities.ProfleActivity;

public class MenuGridAdapter extends BaseAdapter {
    private Context mContext;
    private String [] cMenus;

    @Override
    public int getCount() {
        return cMenus.length;
    }

    public MenuGridAdapter(Context c, String [] cMenus) {
        mContext = c;
        this.cMenus = cMenus;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_menu, null);
            TextView tv_title = (TextView) grid.findViewById(R.id.tv_title);
            final String cmenu = cMenus[position];
            tv_title.setText(cmenu);

            final CardView cardView = (CardView)grid.findViewById(R.id.cardview_menu);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(position){
                        case 0:
                            Intent intent1 = new Intent(mContext, ProfleActivity.class);
                            mContext.startActivity(intent1);
                            break;
                        case 1:
                            Intent intent2 = new Intent(mContext, AspirationsActivity.class);
                            mContext.startActivity(intent2);
                            break;
                        case 2:
                            Intent intent3 = new Intent(mContext, EventsActivity.class);
                            mContext.startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4 = new Intent(mContext, GalleryActivity.class);
                            mContext.startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5 = new Intent(mContext, NotificationsActivity.class);
                            mContext.startActivity(intent5);
                            break;
                        case 5:
                            Intent intent6 = new Intent(mContext, ContactUsActivity.class);
                            mContext.startActivity(intent6);
                            break;
                        case 6:
                            MainActivity activity = MainActivity.instance();
                            activity.shareApp();
                            break;
                        case 7:
                            MainActivity activity2 = MainActivity.instance();
                            activity2.callUs();
                            break;
                    }
                }
            });

        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}