package com.example.inflearn_workmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        val workManagerBData: Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(workManagerBData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id).observe(
            this, Observer {info ->
                if(info != null && info.state.isFinished) {
                    val result = info.outputData.getInt("result", -1)
                    Log.d(TAG, "$result")
                }
            }
        )


    }
}
