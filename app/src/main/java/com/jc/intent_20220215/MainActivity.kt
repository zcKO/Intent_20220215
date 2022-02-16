package com.jc.intent_20220215

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    모든 함수에서 공유할 수 있는 변수. (맴버 변수 or 전역 변수)
    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOtherActivity.setOnClickListener {
//            OtherActivity 로 이동
            // 출발지 -> this : 현재 액티비티, 도착지 -> OtherActivity::class.java
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }

        btnSendMessage.setOnClickListener {
//            1. 무엇을 입력 했는지 추출
            val inputMessage = edtMessage.text.toString()

//            2. 추출한 내용을 다른 화면에 전달 (화면으로 이동)
            val myIntent = Intent(this, ViewMessageActivity::class.java)
//            myIntent 에서 입력한 내용 첨부.
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            새로운 닉네임을 받아내러 (결과를 얻으로) 가는 동작.
            startActivityForResult(myIntent, REQ_CODE_NICKNAME)      // 숫자 값으로, 닉네임을 받으러 간다고 구별하는데 사용.

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤 결과든, 결과를 받아 돌아올 때 실행
//        ex) 닉네임을 받아와도, 폰번호를 받아와도 모두 이 코드가 실행된다.

//        닉네임을 받아와서 실행된게 맞는지 확인
        if (requestCode == REQ_CODE_NICKNAME) {

//            확인 버튼을 누른 것이 맞는지 확인
            if (resultCode == RESULT_OK) {

//                닉네임을 받아왔을 때, 받아온 닉네임 추출
//                data : resultIntent 가 담겨 있다.
                val newNickname = data?.getStringExtra("nick")
                txtNickname.text = newNickname

            }

        }

    }

}