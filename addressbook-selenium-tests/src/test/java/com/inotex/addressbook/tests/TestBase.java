package com.inotex.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicatiomManager app = new ApplicatiomManager();

    @BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
