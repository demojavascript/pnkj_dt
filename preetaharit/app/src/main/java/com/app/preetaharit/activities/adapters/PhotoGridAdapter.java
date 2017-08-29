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
import android.widget.ImageView;

import com.app.preetaharit.R;
import com.app.preetaharit.activities.PhotoViewActivity;
import com.squareup.picasso.Picasso;

public class PhotoGridAdapter extends BaseAdapter {
    private Context mContext;
    private String [] Photos = {
            "http://bsspreeta.com/wp-content/uploads/2017/08/5.jpg",
            "http://bsspreeta.com/wp-content/uploads/2017/08/d-300x240.jpg",
            "http://bsspreeta.com/wp-content/uploads/2017/08/01.jpg",
            "http://bsspreeta.com/wp-content/uploads/2017/08/4-392x272.jpg",
            "http://bsspreeta.com/wp-content/uploads/2017/08/Comp-36-0-00-00-00-392x272.jpg",
            "http://bsspreeta.com/wp-content/uploads/2017/08/2-2-392x272.jpg"
    };

    @Override
    public int getCount() {
        return Photos.length;
    }

    public PhotoGridAdapter(Context c, String [] Photos) {
        mContext = c;
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
            grid = inflater.inflate(R.layout.grid_gallery_photos, null);
            ImageView img_photo = (ImageView) grid.findViewById(R.id.img_photo);
            final String cmenu = Photos[position];
            System.out.println(cmenu);
            Picasso.with(mContext).load(cmenu).into(img_photo);

            final CardView cardView = (CardView)grid.findViewById(R.id.cardview_photos);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PhotoViewActivity.class);
                    intent.putExtra("imgurl", cmenu);
                    mContext.startActivity(intent);
                }
            });

        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}