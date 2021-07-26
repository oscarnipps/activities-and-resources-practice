package com.example.activities_and_resources_practice;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            //get the data from the bundle and restore the necessary views
            String restoredValue = savedInstanceState.getString(Constants.USER_INPUT_KEY);

            Log.d(TAG, "value from savedInstanceState : " + restoredValue);
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userRepo = UserRepo.getInstance();

        //add lifecycle observer to monitor lifecycle changes in this component (activity / fragment)
        getLifecycle().addObserver(new Utils());

        binding.proceed.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 2);
        });

        binding.viewDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

            //pass the first user
            intent.putExtra(Constants.USER_DATA_KEY, userRepo.getUsers().get(0));

            startActivity(intent);
        });

        binding.input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable input) {
                userInput = input.toString().trim();
            }
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
        //always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState");

        //save the user input or other related data
        outState.putString(Constants.USER_INPUT_KEY, userInput);

        Log.d(TAG, "value saved before onSaveInstanceState : " + userInput);
    }

    //this is called after onStart() method only if the bundle is not empty/null (no need to check for nulls)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "onRestoreInstanceState");

        //get the data from the bundle and restore the necessary views
        String restoredValue = savedInstanceState.getString(Constants.USER_INPUT_KEY);

        Log.d(TAG, "value from savedInstanceState : " + restoredValue);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}