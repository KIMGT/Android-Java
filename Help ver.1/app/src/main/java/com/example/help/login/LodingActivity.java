package com.example.help.login;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.help.R;
 // 2. 로딩 java 파일 생성 -> login.java 이동
public class LodingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        startLoading();
    }
    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                finish();
            }
        },1500);
    }
}
