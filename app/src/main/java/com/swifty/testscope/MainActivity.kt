package com.swifty.testscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
  val TAG = MainActivity::class.java.simpleName

  val mainScope = MainScope()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


  }

  fun btn1_click(view: View) {
    mainScope.launch {
      while (true) {
        delay(1000)
        Log.d(TAG, "still looping")
      }
    }
  }
  fun btn2_click(view: View) {
    mainScope.launch {
      Log.d(TAG, "btn2_click")
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    mainScope.cancel()
  }
}