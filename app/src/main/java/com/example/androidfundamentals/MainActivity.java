package com.example.androidfundamentals;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "This is a debug!!");

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText("This is the new string title!");

        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        ivImage.setImageResource(R.drawable.ic_launcher_foreground);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_circular);

        Button button = (Button) findViewById(R.id.button);
        int yellowIdColor = ContextCompat.getColor(this, R.color.yellow);
        button.setBackgroundColor(yellowIdColor);
        button.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button click!!");
                seekBar.setProgress(40);

                progressBar.setVisibility(View.GONE);
            }
        });

        EditText username = (EditText) findViewById(R.id.etUsername);
        EditText pass = (EditText) findViewById(R.id.etPass);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "username beforeTextChanged " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "username onTextChanged " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "username afterTextChanged " + s);
            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "pass beforeTextChanged " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "pass onTextChanged " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "pass afterTextChanged " + s);
            }
        });

        ((CheckBox) findViewById(R.id.checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged(), isChecked= " + isChecked);
                if (isChecked) {
                    username.setVisibility(View.GONE);
                    pass.setVisibility(View.GONE);
                } else {
                    username.setVisibility(View.VISIBLE);
                    pass.setVisibility(View.VISIBLE);
                }
            }
        });

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Log.d(TAG, "onCheckedChanged()" + radioButton.getText().toString());
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setRating(1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "onRatingChanged(),rating= " + rating);
            }
        });

        ((Switch) findViewById(R.id.notifications)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged(), isChecked= " + isChecked);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged(), progress" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQuery("", false);
    }

}