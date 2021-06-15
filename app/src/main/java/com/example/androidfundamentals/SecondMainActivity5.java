package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondMainActivity5 extends AppCompatActivity {
    private static final String TAG = SecondMainActivity5.class.getSimpleName();
    static final String SECOND_MESSAGE = "second_message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main5);

        Log.d(TAG, "onCreate()");

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            //String message = bundle.getString(MainActivity5.MESSAGE);
            Person person = (Person) bundle.getSerializable(MainActivity5.MESSAGE);
            String name = person.name;
            ((TextView) findViewById(R.id.message)).setText(name);
        }

        Button closeActivity = findViewById(R.id.closeSecondActivity);
        closeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button closeActivityWithResult = findViewById(R.id.closeSecondActivityWishResult);
        closeActivityWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(SECOND_MESSAGE, "Hello, from second activity!");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }

}