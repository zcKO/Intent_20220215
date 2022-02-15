package com.jc.intent_20220215

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnReturnToMain.setOnClickListener {

//            val myIntent = Intent(this, MainActivity::class.java)
//            startActivity(myIntent)

//            돌아가는 경우에는 인텐트를 사용하지 않는다.
            finish()

        }

    }
}