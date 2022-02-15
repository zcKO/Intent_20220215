package com.jc.intent_20220215

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOtherActivity.setOnClickListener {
//            OtherActivity 로 이동
            // 출발지 -> this : 현재 액티비티, 도착지 -> OtherActivity::class.java
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }

    }
}