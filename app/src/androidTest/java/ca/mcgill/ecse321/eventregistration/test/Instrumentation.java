package ca.mcgill.ecse321.eventregistration.test;

/**
 * Created by Jastaj on 2018-11-13.
 */

import android.os.Bundle;

import cucumber.api.android.CucumberInstrumentationCore;
import android.support.test.runner.AndroidJUnitRunner;

public class Instrumentation extends AndroidJUnitRunner {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        instrumentationCore.create(arguments);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
