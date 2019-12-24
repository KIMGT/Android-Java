package com.example.help.menulist.plus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.help.R;

public class version  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
    }

    //뒤로가기 버튼
    public void bt_back2(View v) {
        finish();
    }
}
