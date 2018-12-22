package com.example.hp.spinbottle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private int lastAngle = -1;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = (ImageView) findViewById(R.id.bottle);

        ImageView image1 = (ImageView) findViewById(R.id.user1);
        ImageView image2 = (ImageView) findViewById(R.id.user2);
        ImageView image3 = (ImageView) findViewById(R.id.user3);
        ImageView image4 = (ImageView) findViewById(R.id.user4);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {     spinTheBottle();  }
        });image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {     spinTheBottle();     }
        });image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {       spinTheBottle();   }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {      spinTheBottle();    }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_spin:
                spinTheBottle();
                break;
            case R.id.action_zero:
                resetTheBottle();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void spinTheBottle()
    {
        int angle=rand.nextInt(3600-360)+360;
        float pivotX = bottle.getWidth()/2;
        float pivotY = bottle.getHeight()/2;
        final Animation animRotate = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY);
        lastAngle = angle;
        animRotate.setDuration(2500);
        animRotate.setRepeatCount(0);
        animRotate.setStartOffset(361);
        animRotate.setRepeatMode(Animation.REVERSE);
        animRotate.setFillAfter(true);
        animRotate.setFillEnabled(true);
        bottle.startAnimation(animRotate);
    }
    private void resetTheBottle()
    {
        float pivotX = bottle.getWidth() / 2;
        float pivotY = bottle.getHeight() / 2;
        final Animation animRotate = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, 0, pivotX, pivotY);
        lastAngle = -1;
        animRotate.setDuration(2000);
        animRotate.setFillAfter(true);
        bottle.startAnimation(animRotate);
    }
}