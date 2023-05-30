package com.example.inflearn_workmanager

import android.content.Context
import android.util.Log
import androidx.work.*

class WorkManagerB(context : Context, workerParams : WorkerParameters) : Worker(context, workerParams){

    private val TAG = this::class.java.simpleName

    override fun doWork(): Result {

        val a = inputData.getInt("a", 0)
        val b = inputData.getInt("b", 0)
        val c = inputData.getInt("c", 0)

        Log.d(TAG, "a : $a / b : $b / c : $c")


        val outputData : Data = workDataOf(
            "result" to a + b + c
        )

        return Result.success(outputData)

    }

}