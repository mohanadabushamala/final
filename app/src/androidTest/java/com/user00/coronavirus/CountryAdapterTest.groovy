package com.user00.coronavirus

import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import java.util.regex.Matcher

@RunWith(AndroidJUnit4.class)
//4 5
class CountryAdapterTest {
    private static Matcher<View> withAdaptedData(final Matcher<Object> dataMatcher) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(" name: ");
                dataMatcher.describeTo(description);
            }
            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof AdapterView)) {
                    return false;
                }
                @SuppressWarnings("@NAME")
                Adapter adapter = (Adapter) ((AdapterView) view).getAdapter();
                for (int i = 0; i < adapter.getCount(); i++) {
                    if (dataMatcher.matches(adapter.getItem(i))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
    @Rule
    public ActivityScenarioRule<CountryAdapter> activityRule = new ActivityScenarioRule<>(CountryAdapter.class);
    @Test
    public  void testIsVisible() {
        onView(ViewMatchers.withId(R.id.menlist)).check(matches(isDisplayed()));
    }}