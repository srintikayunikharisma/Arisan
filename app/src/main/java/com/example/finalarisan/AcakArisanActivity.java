package com.example.finalarisan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AcakArisanActivity extends AppCompatActivity {
    ImageView images;

    String [] sectors = {"nama1","nama2", "nama3", "nama4", "nama5", "nama6", "nama7", "nama8", "nama9", "nama10", "nama11", "nama12"};

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acak_arisan);
        images = findViewById(R.id.image);
        textView = findViewById(R.id.txtarisan);

        Collections.reverse(Arrays.asList(sectors));
    }
    public void  spinWhell(View view){
        Random rr = new Random();
        final int degree = rr.nextInt(360);

        RotateAnimation rotateAnimation = new RotateAnimation(0,degree +720, // untuk take two rotation
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator( new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatorPoint(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        images.startAnimation((rotateAnimation));

    }

    private void CalculatorPoint(int degree) {
        // total degree 360 || 12 segment || 30 degree each segment
        int intialPoint = 0;
        int endPoint = 30;
        int i = 0;
        String res = null;
        do {
            if (degree > intialPoint && degree < endPoint) {
                res = sectors[i];
            }
            intialPoint += 30; endPoint += 30;
            i++;
        }while(res == null);

        textView.setText(res);
    }
    }
