package com.example.inflearn_workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters){

    private val TAG = this::class.java.simpleName

    override fun doWork(): Result {

        for(i in 1..10) {
            sleep(1_000)
            Log.d(TAG, "WorkManagerA : $i")
        }

        return Result.success()

    }


}