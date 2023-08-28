package com.example.coroutinestutorials

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {
    val TAG = "MYCOROUTINES"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.async(Dispatchers.IO){
            val time= measureTimeMillis {
                val answer1=async { doNetworkCall1() }
                val answer2=async { doNetworkCall2() }
                Log.d(TAG,"Answer One is ${answer1.await()}")
                Log.d(TAG,"Answer two is ${answer2.await()}")
            }
            Log.d(TAG,"Request took ${time} .ms time")
        }


            }

    suspend fun doNetworkCall1():String{
        delay(2000L)
        return "This is Answer 1"
    }

    suspend fun doNetworkCall2():String{
        delay(2000L)
        return "This is Answer 2"
    }
    }
