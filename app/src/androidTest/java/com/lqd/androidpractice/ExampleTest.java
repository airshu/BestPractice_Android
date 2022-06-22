package com.lqd.androidpractice;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Copyright (C) 2021 shjlone Inc. All rights reserved.
 *
 * @author a564
 * @version 1.0
 * @Date 5/7/21
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleTest {


    @Before
    public void launchActivity() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void greeterHello() {
        Espresso.onView(ViewMatchers.withId(R.id.start)).perform(ViewActions.click());
    }
}
