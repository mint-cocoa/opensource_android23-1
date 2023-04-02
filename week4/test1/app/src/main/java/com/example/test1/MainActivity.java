package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.animation.RotateAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.graphics.Point;
import android.view.Display;


public class MainActivity extends AppCompatActivity {

    private CheckBox enableCheckBox, clickableCheckBox, rotationCheckBox;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableCheckBox = findViewById(R.id.enableCheckBox);
        clickableCheckBox = findViewById(R.id.clickableCheckBox);
        rotationCheckBox = findViewById(R.id.rotationCheckBox);
        myButton = findViewById(R.id.myButton);

        enableCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                myButton.setEnabled(isChecked);
                if (!isChecked) {
                    myButton.setClickable(false);
                }
            }
        });

        clickableCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                myButton.setClickable(isChecked);
            }
        });

        rotationCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                if (isChecked) {
                    RotateAnimation rotateAnimation = new RotateAnimation(0, 45,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setInterpolator(new LinearInterpolator());
                    rotateAnimation.setDuration(500);
                    rotateAnimation.setFillEnabled(true);
                    rotateAnimation.setFillAfter(true);
                    myButton.startAnimation(rotateAnimation);

                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int centerX = size.x / 2;
                    int centerY = size.y / 2;
                    myButton.setX(centerX - myButton.getWidth() / 2);
                    myButton.setY(centerY - myButton.getHeight() / 2);
                } else {
                    RotateAnimation rotateAnimation = new RotateAnimation(45, 0,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setInterpolator(new LinearInterpolator());
                    rotateAnimation.setDuration(500);
                    rotateAnimation.setFillEnabled(true);
                    rotateAnimation.setFillAfter(true);
                    myButton.startAnimation(rotateAnimation);
                }
            }
        });
    }
}
