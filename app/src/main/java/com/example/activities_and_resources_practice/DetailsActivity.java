package com.example.activities_and_resources_practice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activities_and_resources_practice.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private String mDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        User user = getIntent().getParcelableExtra(Constants.USER_DATA_KEY);

        if (user != null) {
            mDetails = user.getName() + " is " + user.getAge() + " old ";
        }

        binding.detailsView.setText(mDetails);
    }
}