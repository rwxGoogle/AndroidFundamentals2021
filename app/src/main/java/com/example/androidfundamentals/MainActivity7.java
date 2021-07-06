package com.example.androidfundamentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ActivityInfoCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

public class MainActivity7 extends AppCompatActivity {
    private final static String TAG = MainActivity7.class.getSimpleName();
    private static final int REQ_CAMERA_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week7);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setColorFilter(ContextCompat.getColor(this, R.color.orange));
        Button button = (Button) findViewById(R.id.animButton);
        TextView textView = (TextView) findViewById(R.id.textView);

        AnimationDrawable animationDrawable = (AnimationDrawable) textView.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "FAB click!");
                Snackbar snackbar = Snackbar.make(v, "Hello this is a snackBar", Snackbar.LENGTH_LONG);
                snackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animationDrawable.start();
                    }
                });

                View snackbarView = snackbar.getView();
                snackbar.setBackgroundTint(ContextCompat.getColor(v.getContext(), R.color.lightPink));
                TextView textView1 = snackbarView.findViewById(R.id.snackbar_text);
                textView1.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
                snackbar.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity7.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity7.this, new String[]{Manifest.permission.CAMERA}, REQ_CAMERA_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult() requestCode= " + requestCode);
        if (requestCode == REQ_CAMERA_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "onRequestPermissionsResult() permission granted");
            } else {
                Log.d(TAG, "onRequestPermissionsResult() permission not granted");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed()");
        super.onBackPressed();
    }
}