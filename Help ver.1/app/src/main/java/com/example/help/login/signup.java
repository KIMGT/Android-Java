package com.example.help.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.help.DBHelper;
import com.example.help.MainActivity;
import com.example.help.R;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //db 객체 생성
        final DBHelper dbHelper = new DBHelper(this, "testDB.db",null,2);


        //각 입력 받을 TEXT 빈칸 설정
        final EditText name = (EditText)findViewById(R.id.editText);
        final EditText id = (EditText)findViewById(R.id.editText2);
        final EditText pwd = (EditText)findViewById(R.id.editText3);
        final EditText phone = (EditText)findViewById(R.id.editText4);
        final EditText address1 = (EditText)findViewById(R.id.editText5);
        final EditText address2 = (EditText)findViewById(R.id.editText6);

        Button complete = (Button)findViewById(R.id.button5);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //빈칸에 입력 받은 값을 String으로 변환
                String user_name = name.getText().toString();
                String user_id = id.getText().toString();
                String user_pwd = pwd.getText().toString();
                String user_phone = phone.getText().toString();
                String user_address1 = address1.getText().toString();
                String user_address2 = address2.getText().toString();


                //아이디 중복 확인
                if(dbHelper.getid(user_id)){
                    Toast.makeText(getApplicationContext(),"중복된 아이디 입니다.!",Toast.LENGTH_LONG).show();
                }else{
                    dbHelper.signup_insert(user_id,user_name,user_pwd,user_phone,user_address1,user_address2);
                    Toast.makeText(getApplicationContext(),"완료!",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
    public void bt_back(View v){
        finish();
    }
}
