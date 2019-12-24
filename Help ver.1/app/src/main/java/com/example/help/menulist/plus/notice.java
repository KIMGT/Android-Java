package com.example.help.menulist.plus;

//공지사항

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.help.R;

public class notice extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
    }

    //뒤로가기 버튼
    public void bt_back(View v) {
        finish();
    }
}
