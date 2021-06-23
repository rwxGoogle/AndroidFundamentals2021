package com.example.androidfundamentals.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidfundamentals.R;

public class MainActivity6 extends AppCompatActivity implements SetTextListener {
    private static final String TAG = MainActivity6.class.getSimpleName();
     static final String KEY = "Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Log.d(TAG, "onCreate()");

        Bundle bundle = new Bundle();
        bundle.putString(KEY, "Hello Fragment");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment6 fragment6 = new Fragment6();
        fragment6.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainer, fragment6, Fragment6.class.getSimpleName());
        fragmentTransaction.commit();

        //search for a fragment by ID or by TAG
        Fragment6 staticFragment = (Fragment6) fragmentManager.findFragmentById(R.id.firstFragment);
        Fragment6 dynamicFragment = (Fragment6) fragmentManager.findFragmentByTag(Fragment6.class.getSimpleName());

        findViewById(R.id.hideFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Is fragment visible: " + staticFragment.isHidden());
                // fragmentTransaction.hide(staticFragment);
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

        Fragment6 fragment6 = (Fragment6) getSupportFragmentManager().findFragmentById(R.id.firstFragment);
        fragment6.setText("Hello user");

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

    @Override
    public void setText(String text) {
        Log.d(TAG, "setText( " + text + " )");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed()");
    }
}