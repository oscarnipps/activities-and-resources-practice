package com.example.activities_and_resources_practice;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void activity_is_launched_and_visible() {
        onView(withId(R.id.result_field)).check(matches(withEffectiveVisibility(Visibility.GONE)));
    }

    @Test
    public void button_visible() {
        onView(withId(R.id.proceed)).check(matches(isDisplayed()));
    }
}