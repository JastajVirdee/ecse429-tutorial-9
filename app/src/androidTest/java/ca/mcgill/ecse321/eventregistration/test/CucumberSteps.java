package ca.mcgill.ecse321.eventregistration.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import ca.mcgill.ecse321.eventregistration.MainActivity;
import android.widget.EditText;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class CucumberSteps extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "ca.mcgill.ecse321.eventregistration.MainActivity";
    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CucumberSteps() throws ClassNotFoundException {
        super((Class<MainActivity>) launcherActivityClass);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        getActivity().finish();
        super.tearDown();
    }

    @Given("I have a MainActivity")
    public void i_have_a_MainActivity() throws Exception {
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @When("I input username some_random_guy_{int} in text field {string}")
    public void i_input_username_some_random_guy__in_text_field(Integer int1, String string) {
        solo.waitForActivity("MainActivity", 2000);

        String username = "some_random_guy" + int1;

        EditText editText = solo.getEditText(string);
        solo.enterText(editText, username);
    }

    @When("I press {string} button")
    public void i_press_button(String buttonName) {
        solo.waitForActivity("MainActivity", 2000);

        //click on button
        solo.clickOnText(buttonName);

        //make sure no error has been made
        boolean errorTextFound = solo.waitForText("exception", 1, 5000);
        assertFalse(errorTextFound);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        solo.waitForActivity("MainActivity", 2000);

        //click on button
        solo.clickOnText(buttonName);
    }

    @Then("I should see some_random_guy_{int} in the list")
    public void i_should_see_some_random_guy__in_the_list(Integer int1) {
        solo.waitForActivity("MainActivity", 2000);

        String expectedAddedParticipant = "some_random_guy" + int1;

        boolean textFound = solo.waitForText(expectedAddedParticipant, 1, 5000, true);
        assertTrue(textFound);
    }
}