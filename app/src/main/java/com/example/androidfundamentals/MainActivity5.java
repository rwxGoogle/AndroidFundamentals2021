package com.example.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    private static final String TAG = MainActivity5.class.getSimpleName();
    private TextView username;
    private EditText lastname;
    private EditText firstname;

    private String userLastname;
    private String userFirstname;

    private static final String LAST_NAME = "lastname";
    private static final String FIRST_NAME = "firstname";
    static final String MESSAGE = "message";
    private static final int REQ_CODE_SECOND_ACTIVITY = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Log.d(TAG, "onCreate(), savedInstanceState= " + savedInstanceState);

        username = (TextView) findViewById(R.id.username);
        lastname = (EditText) findViewById(R.id.lastname);
        firstname = (EditText) findViewById(R.id.firstname);

        if (savedInstanceState != null) {
            String lastname = savedInstanceState.getString(LAST_NAME);
            String firstname = savedInstanceState.getString(FIRST_NAME);
            String userName = lastname + " " + firstname;
            //  username.setText(userName);
        }


        lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userLastname = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userFirstname = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        findViewById(R.id.openBrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN BROWSER USING IMPLICIT INTENT

                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    intent.setData(Uri.parse("http://developer.android.com/guide/components/intents-common.html"));
                    startActivity(intent);
                }

//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                Log.d(TAG, "Resolve Activity: " + intent.resolveActivity(getPackageManager()));
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    intent.setData(Uri.parse("023456"));
//                    startActivity(intent);
//                }

            }
        });

        findViewById(R.id.startSecondActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //OPEN SECOND ACTIVITY and set a message USING EXPLICIT INTENT
                Intent intent = new Intent(MainActivity5.this, SecondMainActivity5.class);
                // intent.putExtra(MESSAGE, "Hello, from first Activity");
                Person person = new Person("Roxana", "29");
                intent.putExtra(MESSAGE, person);
                startActivity(intent);
            }
        });

        findViewById(R.id.startSecondActivityForResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, SecondMainActivity5.class);
                startActivityForResult(intent, REQ_CODE_SECOND_ACTIVITY);
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(LAST_NAME, userLastname);
        outState.putString(FIRST_NAME, userFirstname);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    String message = data.getStringExtra(SecondMainActivity5.SECOND_MESSAGE);
                    username.setText(message);
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                username.setText("REQuest failed");
            }
        }
    }
}