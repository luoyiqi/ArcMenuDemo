package com.example.zhuzihao.arcmenudemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click(View view){
        final Button button= (Button) view;
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(100*1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value= (int) animation.getAnimatedValue();
                button.setText(value+"");
            }
        });
        valueAnimator.start();

    }
}
