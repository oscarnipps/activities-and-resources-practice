package com.example.activities_and_resources_practice;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Utils implements LifecycleObserver {
    public static final String TAG = Utils.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void clearCache() {
        Log.d(TAG, "cache cleared in onPause ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void restoreCache() {
        Log.d(TAG, "cache restored in onResume ");
    }


}
