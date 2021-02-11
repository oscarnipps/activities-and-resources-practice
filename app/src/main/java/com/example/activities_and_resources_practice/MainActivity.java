package com.example.activities_and_resources_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activities_and_resources_practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.proceed.setOnClickListener(v -> {
            Intent intent = new Intent(this , SecondActivity.class);
            startActivityForResult(intent,Constants.MAIN_ACTIVITY_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.MAIN_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                if (data != null) {
                    String name = data.getStringExtra(Constants.DATA_KEY);
                    binding.resultField.setText(name);
                }

            }

            Log.d(TAG, "result not okay");

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "on re-start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy");
    }

}