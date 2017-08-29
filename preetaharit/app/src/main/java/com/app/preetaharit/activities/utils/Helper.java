package com.app.preetaharit.activities.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Rahul on 28-08-2017.
 */

public class Helper {
    public static void playVideo(String key, Context ctx){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + key));
        if (intent.resolveActivity(ctx.getPackageManager()) == null) {
            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=" + key));
        }
        ctx.startActivity(intent);
    }
}
