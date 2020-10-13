package com.neotys.experitest.sampleproject;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            ExperitestAppium.class,
    })

    public class EndUserExperienceTestSuite {
        public static void main(String[] args) throws Exception {
            JUnitCore.main(EndUserExperienceTestSuite.class.getName());
        }
    }

