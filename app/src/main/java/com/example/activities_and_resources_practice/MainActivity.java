package com.example.activities_and_resources_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activities_and_resources_practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private UserRepo userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userRepo = UserRepo.getInstance();

        //add lifecycle observer to monitor lifecycle changes in this component (activity / fragment)
        getLifecycle().addObserver(new Utils());

        binding.proceed.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , SecondActivity.class);
            startActivityForResult(intent,2);
        });

        binding.viewDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
            //pass the first user
            intent.putExtra(Constants.USER_DATA_KEY ,userRepo.getUsers().get(0));
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "request code : " + requestCode);
        Log.d(TAG, "result code : " + resultCode);

        if (requestCode == 2) {

            if (resultCode == RESULT_OK) {

                if (data != null) {
                    String name = data.getStringExtra(Constants.DATA_KEY);
                    binding.resultField.setText(name);
                }

            }

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
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