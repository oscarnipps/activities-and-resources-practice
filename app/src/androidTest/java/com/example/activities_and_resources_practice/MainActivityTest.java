package com.example.activities_and_resources_practice;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.Visibility;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    public UserRepo userRepo;

    @Before
    public void setUp() {
        Intents.init();
        userRepo = UserRepo.getInstance();
    }

    @Test
    public void activity_is_launched_and_visible() {
        onView(withId(R.id.result_field)).check(matches(withEffectiveVisibility(Visibility.GONE)));
    }

    @Test
    public void button_visible() {
        onView(withId(R.id.proceed)).check(matches(isDisplayed()));
    }

    @Test
    public void navigate_to_details_activity() {
        onView(withId(R.id.view_details)).perform(click());

        onView(withId(R.id.details_view)).check(matches(isDisplayed()));
    }

    @Test
    public void navigate_to_details_activity_with_passed_intent() {

        User actualUser = UserRepo.getUsers().get(1);

        onView(withId(R.id.view_details)).perform(click());

        onView(withId(R.id.details_view)).check(matches(isDisplayed()));

        intended(hasComponent("com.example.activities_and_resources_practice.DetailsActivity"));

        User retrievedUser = Intents.getIntents().get(0).getParcelableExtra(Constants.USER_DATA_KEY);

        String valueDisplayed = retrievedUser.getName() + " is " + retrievedUser.getAge() + " old ";

        onView(withId(R.id.details_view)).check(matches(withText(valueDisplayed)));

        assertEquals(actualUser.name, retrievedUser.name);
    }

    @After
    public void close() {
        Intents.release();
    }
}