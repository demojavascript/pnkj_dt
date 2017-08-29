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

import com.app.preetaharit.R;
import com.app.preetaharit.activities.utils.Helper;
import com.squareup.picasso.Picasso;

public class VideoGridAdapter extends BaseAdapter {
    private Context mContext;
    private String [] Videos;
    private String [] imgs = {
            "https://i.ytimg.com/vi/GM5plYq5_uA/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLCzchKkGrvfqkamYN_L11YW6Q7VgQ",
            "https://i.ytimg.com/vi/th5ph6_12-w/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLAC03JTEb3TQ6QMty6DOTZwe9Qm4Q",
            "https://i.ytimg.com/vi/4nQVxiKh0ds/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLCBvrgxFxpuCYupMxqfBDyJLv8Hkg",
            "https://i.ytimg.com/vi/U7M317AWigo/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLDp1QZYONRsu9mAsMTanxLeBlOFQQ",
            "https://i.ytimg.com/vi/zeNiCfSdE6s/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLAya9QNjppnjVPtL__S3-vQolPtxQ",
            "https://i.ytimg.com/vi/vRelGY5VZTA/hqdefault.jpg?sqp=-oaymwEXCPYBEIoBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLDn0GWVsEMyDVY83kfnIyG6xMsy5A"
    };

    @Override
    public int getCount() {
        return Videos.length;
    }

    public VideoGridAdapter(Context c, String [] Videos) {
        mContext = c;
        this.Videos = Videos;
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
            grid = inflater.inflate(R.layout.grid_gallery_videos, null);
            ImageView img_photo = (ImageView) grid.findViewById(R.id.img_photo);
            final String cmenu = imgs[position];

            Picasso.with(mContext).load(cmenu).into(img_photo);
            final CardView cardView = (CardView)grid.findViewById(R.id.cardview_videos);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Helper.playVideo(Videos[position], mContext);
                }
            });

        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}