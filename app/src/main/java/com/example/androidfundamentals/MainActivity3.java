package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity3.class.getSimpleName();
    private ArrayList<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.pass);
        Button signIn = findViewById(R.id.login);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 5) {
                    email.setError("Length should be bigger than 5 characters");
                } else {
                    email.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "EMAIL= " + email.getText() + "\nPASS= " + password.getText());

                if (email.getText().toString().isEmpty()) {
                    email.setError("The email filled should not be empty!");
                } else {
                    email.setError(null);
                }

                if (password.getText().toString().isEmpty()) {
                    password.setError("The password filled should not be empty!");
                } else {
                    password.setError(null);
                }
            }
        });

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://developer.android.com/");

        data = getResources().getStringArray(R.array.photos);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(getAdapter());
        spinner.setOnItemSelectedListener(this);

    }

    private ArrayList<String> getDataSource() {
        dataSource = new ArrayList<>();
        dataSource.add("Photos1");
        dataSource.add("Photos2");
        dataSource.add("Photos3");
        dataSource.add("Photos4");
        dataSource.add("Photos5");
        dataSource.add("Photos6");
        return dataSource;
    }

    private ArrayAdapter<String> getAdapter() {
        //android.R.layout.simple_list_item_1
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, getDataSource());
        return arrayAdapter;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "Item SELECTED: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}