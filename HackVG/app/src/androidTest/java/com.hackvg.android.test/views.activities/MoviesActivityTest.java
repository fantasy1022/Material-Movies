package com.hackvg.android.test.views.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.hackvg.android.views.activities.MovieDetailActivity;
import com.hackvg.android.views.activities.MoviesActivity;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

/**
 * Created by saulmm on 17/02/15.
 */
public class MoviesActivityTest extends ActivityInstrumentationTestCase2<MoviesActivity> {

    private Solo solo;

    public MoviesActivityTest() {
        super(MoviesActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testMainActivityOpen() throws Exception {

        solo.waitForActivity(MoviesActivity.class);//Default timeout is 20s.
        solo.sleep(5000);

        getInstrumentation().waitForIdleSync();
        Spoon.screenshot(solo.getCurrentActivity(), "MoviesActivity");
    }

    public void testDetialActivityOpen() throws Exception {

        solo.waitForActivity(MoviesActivity.class);
        solo.sleep(5000);

        solo.clickOnText("Furious 7");
        solo.waitForActivity(MovieDetailActivity.class);
        solo.sleep(2000);

        getInstrumentation().waitForIdleSync();
        Spoon.screenshot(solo.getCurrentActivity(), "MovieDetailActivity");
        solo.assertCurrentActivity("This is not MovieDetailActivity", MovieDetailActivity.class);
    }

}
