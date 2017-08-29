package com.app.preetaharit.activities.adapters;

/**
 * Created by Rahul on 10-01-2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.models.CEvent;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventGridAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<CEvent> allEvents;
    private String [] images = {
        "https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-0/s480x480/21077408_1712731079036157_8791637294913081417_n.jpg?oh=7dd754c9a1574303b1d59dbba3ffceb3&oe=5A1DEC35",
        "https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-0/s480x480/21106715_1712629082379690_1827816776699502009_n.jpg?oh=1d42e0973fb9967922ea572b039332a6&oe=5A125395",
            "https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-0/p480x480/21032359_1712577695718162_9018000375624096068_n.jpg?oh=0b96c7e40db254b7a64856eeda1fe998&oe=5A1843E5"
    };
    @Override
    public int getCount() {
        return allEvents.size();
    }

    public EventGridAdapter(Context c, ArrayList<CEvent> allEvents) {
        mContext = c;
        this.allEvents = allEvents;
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
            grid = inflater.inflate(R.layout.grid_events, null);
            ImageView img_photo = (ImageView) grid.findViewById(R.id.img_photo);
            TextView tv_title = (TextView)grid.findViewById(R.id.tv_title);
            TextView tv_desc = (TextView)grid.findViewById(R.id.tv_desc);
            final CEvent cevent = allEvents.get(position);
            tv_title.setText(cevent.getTitle());
            tv_desc.setText(cevent.getDesc());
            Picasso.with(mContext).load(images[position]).into(img_photo);
            final CardView cardView = (CardView)grid.findViewById(R.id.cardview_events);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}