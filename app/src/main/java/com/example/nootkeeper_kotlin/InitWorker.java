package com.example.nootkeeper_kotlin;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class InitWorker extends Worker {
    OneTimeWorkRequest createNotificationChannelRequest = new OneTimeWorkRequest.Builder(InitWorker.class).build();

    public InitWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        createNotificationChannel();
        return Result.success();
    }

    private void createNotificationChannel() {
        ItemsActivity itemActivity = new ItemsActivity();
        itemActivity.createNotificationChannel();
    }
}
