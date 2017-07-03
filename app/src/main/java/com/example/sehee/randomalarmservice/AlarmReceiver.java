package com.example.sehee.randomalarmservice;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by dsm2015 on 2017-06-20.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        Uri uri1 = Uri.parse("android.resource://com.example.sehee.randomalarmservice/"+R.raw.am4);
        Uri uri2 = Uri.parse("android.resource://com.example.sehee.randomalarmservice/"+R.raw.born_singer);
        Uri uri3 = Uri.parse("android.resource://com.example.sehee.randomalarmservice/"+R.raw.someone_like_you);
        Uri uri4 = Uri.parse("android.resource://com.example.sehee.randomalarmservice/"+R.raw.we_dont_talk_anymore);

        Random random = new Random();
        int randomInt = random.nextInt(4)+1;
        Uri uri = null;
        switch (randomInt){
            case 1:uri = uri1;
                MainActivity.getTextView2().setText("A.M 4 - RM&V");
                MainActivity.getImageView().setImageResource(R.drawable.am4);
                MainActivity.getImageView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case 2:uri = uri2;
                MainActivity.getTextView2().setText("Born Singer - BTS");
                MainActivity.getImageView().setImageResource(R.drawable.born_singer);
                MainActivity.getImageView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case 3:uri = uri3;
                MainActivity.getTextView2().setText("Someone Like You - V");
                MainActivity.getImageView().setImageResource(R.drawable.someone_like_you);
                MainActivity.getImageView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case 4:uri = uri4;
                MainActivity.getTextView2().setText("We Don't Talk Anymore - JK&JM");
                MainActivity.getImageView().setImageResource(R.drawable.we_dont_talk_anymore);
                MainActivity.getImageView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        Log.d(TAG, "onReceive: "+uri);
        ringtone.play();
    }
}