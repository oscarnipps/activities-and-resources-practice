package com.example.activities_and_resources_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activities_and_resources_practice.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = SecondActivity.class.getSimpleName();
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second);

        binding.finish.setOnClickListener(v ->{
            Log.d(TAG, "setting result in second activity");
            Intent intent = new Intent();
            intent.putExtra(Constants.DATA_KEY ,"result : John Snow");
            setResult(RESULT_OK,intent);
            finish();
        });

    }

    @Override
    public boolean isFinishing() {
        Log.d(TAG, "second activity is finishing");
        return super.isFinishing();
    }
}