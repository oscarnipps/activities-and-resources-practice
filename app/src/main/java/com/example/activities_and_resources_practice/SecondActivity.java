package com.example.activities_and_resources_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    public boolean isFinishing() {
        Log.d(TAG, "second activity is finishing");
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA_KEY ,"John Snow");
        setResult(RESULT_OK);
        return super.isFinishing();
    }
}