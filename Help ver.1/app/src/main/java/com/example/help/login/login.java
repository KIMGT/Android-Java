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
public class login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 3. 아래 코드 추가 -> Manifest 이동
        Intent intent = new Intent(this, LodingActivity.class);
        final Intent main = new Intent(this, MainActivity.class);
        startActivity(intent);
        // 여기까지
        final DBHelper dbHelper = new DBHelper(this,"testDB.db",null,2);

        final EditText id = (EditText)findViewById(R.id.editText7);
        final EditText pwd = (EditText)findViewById(R.id.editText8);

        Button complete = (Button)findViewById(R.id.loginButton);
        complete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user_id = id.getText().toString();
                String user_pwd = pwd.getText().toString();

                //아이디 or 비밀번호 확인
                if(dbHelper.login(user_id,user_pwd)){
                    Toast.makeText(getApplicationContext(),"환영!",Toast.LENGTH_LONG).show();
                    startActivity(main);
                    id.setText("");
                    pwd.setText("");
                }else{
                    Toast.makeText(getApplicationContext(),"아이디 또는 비번이 틀립니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void bt_signup(View v){
        Intent intent = new Intent(this,signup.class);
        Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void bt_just(View v){
        Intent intent = new Intent(this,MainActivity.class);
        Toast.makeText(this, "그냥봄 ", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    //뒤로가기 두번연속으로 누르실 종료되는 메소드
    private long pressedTime;   //시간저장할 변수
    @Override
    public void onBackPressed() {
        if (pressedTime == 0) {   // 한번 누르면
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            pressedTime = System.currentTimeMillis();
        } else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);
            if (seconds > 2000) {   //2초보다 작으면
                pressedTime = 0;    //0초와 동일하게 적용
            } else { //현재 시간이 변수t + 2000보다 작으면 앱 종료
                finish();
            }
        }
    }
}