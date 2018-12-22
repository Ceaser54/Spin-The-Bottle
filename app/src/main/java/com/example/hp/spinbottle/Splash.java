package com.example.hp.spinbottle;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class Splash extends Activity {
    MediaPlayer ourSong;
    private int lastAngle = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView image=(ImageView)findViewById(R.id.the_bottle);
        ourSong = MediaPlayer.create(Splash.this, R.raw.sound);
        ourSong.start();
        int angle=360;
        int x=image.getWidth()/2;
        int y=image.getHeight()/2;
        final Animation animRotate = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, x, y);
        lastAngle = angle;
        animRotate.setDuration(2500);
        animRotate.setRepeatMode(Animation.ZORDER_BOTTOM);
        animRotate.setFillAfter(true);
        animRotate.setFillEnabled(true);
        image.startAnimation(animRotate);
        Thread timer = new Thread()
        {
            public void run() {
                try{
                    sleep(3500);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally{
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        ourSong.release();
        finish();
    }
}
