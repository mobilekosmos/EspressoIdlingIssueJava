package com.issues.espressoidling;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class ExampleInstrumentedTest {

//    @Rule
//    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
//            MainActivity.class);

//    @Rule
//    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        Intents.init();
        final Intent intent = new Intent(ApplicationProvider.getApplicationContext(), MainActivity.class);
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(intent)) {
            Log.d("++", "state: " + scenario.getState());
            assertTrue(scenario.getState() == Lifecycle.State.RESUMED);
            intended(hasComponent(MainActivity.class.getName()));
            Intents.release();
        }
    }
}