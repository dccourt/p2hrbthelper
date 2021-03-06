package com.alessap.p2hrbthelper;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;

/**
 * Receives the job start notification.
 */
public class PollJobService extends JobService {
    private static final String TAG = "PollJobService";

    @Override
    public boolean onStartJob(JobParameters params) {
        final Context context = getApplicationContext();

//        Intent service = new Intent(context, PollService.class);
//        context.startService(service);
        ForgetPebble.forgetIt();

        MainActivity.scheduleJob(context); // reschedule the job

        // Make sure the foreground service is running if enabled.
        MainActivity.startForegroundService(context);

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
