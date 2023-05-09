package com.example.simpleparadox.listycity;

import static org.junit.Assert.*;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void uiTest()
    {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Khulna"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Rangpur"));
        onView(withId(R.id.button_confirm)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());
        onView(withId(R.id.showActivity)).check(matches(isDisplayed()));
        onView(withText("Khulna")).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));

        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(1).perform(click());
        onView(withId(R.id.showActivity)).check(matches(isDisplayed()));
        onView(withText("Rangpur")).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));


    }
}