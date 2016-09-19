package com.example.zhuzihao.arcmenudemo;

import android.animation.ObjectAnimator;
import android.print.PrinterCapabilitiesInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res={R.id.composer_button,R.id.composer_camera,R.id.composer_music,R.id.composer_place,R.id.composer_sleep,R.id.composer_thought,R.id.composer_with};
    private List<ImageView> mImageViews=new ArrayList<>();
    private boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView= (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.composer_button:
                if(flag){
                    startCircleAnim();
                } else {
                    closeCircleAnim();
                }
                break;
            case R.id.composer_camera:
                Toast.makeText(this,"composer_camera",Toast.LENGTH_SHORT).show();
                break;
            case R.id.composer_place:
                Toast.makeText(this,"composer_place",Toast.LENGTH_SHORT).show();
                break;
            case R.id.composer_sleep:
                Toast.makeText(this,"composer_sleep",Toast.LENGTH_SHORT).show();

                break;
            case R.id.composer_with:
                Toast.makeText(this,"composer_with",Toast.LENGTH_SHORT).show();

                break;
            case R.id.composer_music:
                Toast.makeText(this,"composer_music",Toast.LENGTH_SHORT).show();

                break;
            case R.id.composer_thought:
                Toast.makeText(this,"composer_thought",Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void startAnim() {
        for (int i = 1; i < res.length ; i++) {
            ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",0,i*200F);
            objectAnimator.setDuration(500);
            objectAnimator.setInterpolator(new BounceInterpolator());
            objectAnimator.setStartDelay(300*i);
            objectAnimator.start();
        }
        flag=false;
    }

    private void closeAnim(){
        for (int i = 1; i < res.length ; i++) {
            ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",i*200f,0);
            objectAnimator.setDuration(300);
            objectAnimator.setInterpolator(new BounceInterpolator());
            objectAnimator.setStartDelay(300*i);
            objectAnimator.start();
        }
        flag=true;
    }

    private void startCircleAnim() {
        for (int i = 1; i < res.length ; i++) {
           ObjectAnimator o1= ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",0,(float)Math.sin(Math.toRadians(i-1)*90/5)*500).setDuration(500);
            ObjectAnimator o2=ObjectAnimator.ofFloat(mImageViews.get(i),"translationX",0,(float)Math.cos(Math.toRadians(i-1)*90/5)*500).setDuration(500);
            o1.setStartDelay(i*100);
            o2.setStartDelay(i*100);
            o1.start();
            o2.start();
        }
        flag=false;
    }

    private void closeCircleAnim(){
        for (int i = 1; i < res.length ; i++) {
            ObjectAnimator o1=ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",(float)Math.sin(Math.toRadians(i-1)*90/5)*500,0).setDuration(500);
            ObjectAnimator o2=ObjectAnimator.ofFloat(mImageViews.get(i),"translationX",(float)Math.cos(Math.toRadians(i-1)*90/5)*500,0).setDuration(500);

            o1.setStartDelay(i*100);
            o2.setStartDelay(i*100);
            o1.start();
            o2.start();
        }
        flag=true;
    }

}
