package com.example.test3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button rotationButton;
    private Button rotateButton;
    private float currentRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotationButton = findViewById(R.id.rotation_button);
        rotateButton = findViewById(R.id.rotate_button);
        currentRotation = rotateButton.getRotation();

        rotationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRotation += 10.0f;
                rotateButton.setRotation(currentRotation);
            }
        });
    }
}
