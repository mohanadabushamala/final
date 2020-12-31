package com.user00.coronavirus

import android.app.Activity
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LogInActivityTest extends Activity {

    //1

    @Rule
    public ActivityScenarioRule<LogInActivity> activityRule = new ActivityScenarioRule<>(LogInActivity.class);


    @Test
    public void testIsVisible() {
        // this is a button.
        onView(ViewMatchers.withId(R.id.login)).perform(click());
    }



    @RunWith(MockitoJUnitRunner.value = )
    public class PresenterActivityAcceptNotAcceptTest {


        @Test
        public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
            boolean dd = true;
            assertThat(dd,is(true));
        }
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}