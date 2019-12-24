package com.example.help;
//BottomNavigationView 사용

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.help.login.login;
import com.example.help.menulist.addpost;
import com.example.help.menulist.graph.graph_next;
import com.example.help.menulist.home_menu;
import com.example.help.menulist.plus.notice;
import com.example.help.menulist.plus.version;
import com.example.help.menulist.post;
import com.example.help.menulist.recycle.post2;
import com.example.help.menulist.recycle.recycle_tip;
import com.example.help.menulist.recycle.recycle_tip2;
import com.example.help.menulist.search_menu;
import com.example.help.menulist.graph_menu;
import com.example.help.menulist.recycle.recycle_menu;
import com.example.help.menulist.plus.plus_menu;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();

    // 5개의 메뉴에 들어갈 Fragment
    private home_menu menu1Fragment = new home_menu();
    private search_menu menu2Fragment = new search_menu();
    private graph_menu menu3Fragment = new graph_menu();
    private recycle_menu menu4Fragment = new recycle_menu();
    private plus_menu menu5Fragment = new plus_menu();


    //(recycle) imageView , 버튼

    Button bt_pap,bt_gls,bt_met,bt_pla,bt_sty,bt_ele,bt_tir,bt_oi,bt_el,
            bt_lam, bt_iro,bt_clo,bt_was,bt_foo,bt_oth;

    ImageView re_view;
    TextView te_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    // 홈버튼
                    case R.id.navigation_menu1: {
                        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
                        break;
                    }
                    // 검색버튼
                    /**case R.id.navigation_menu2: {
                        transaction.replace(R.id.frame_layout, menu2Fragment).commitAllowingStateLoss();
                        break;
                    }**/
                    //그래프 버튼
                    case R.id.navigation_menu3: {
                        transaction.replace(R.id.frame_layout, menu3Fragment).commitAllowingStateLoss();
                        break;
                    }
                    //배출팁 버튼
                    case R.id.navigation_menu4: {
                        transaction.replace(R.id.frame_layout, menu4Fragment).commitAllowingStateLoss();

                        break;
                    }
                    //더보기 버튼
                    case R.id.navigation_menu5: {
                        transaction.replace(R.id.frame_layout, menu5Fragment).commitAllowingStateLoss();
                        break;
                    }

                }

                return true;
            }
        });

    }





    // 게시물 작성 버튼
    public void bt_addPost(View v){
        switch(v.getId()) {
            case R.id.addPost:
                Intent intent = new Intent(this, addpost.class);
                startActivity(intent);
        }
    }
    // 게시물 보기 버튼1
    public void bt_post1(View v){
        switch(v.getId()){
            case R.id.button10:
                Intent intent = new Intent(this, post.class);
                startActivity(intent);
        }
    }
    //게시물 보기 버튼2
    public void bt_post2(View v){
        switch (v.getId()){
            case R.id.button11:
                Intent intent = new Intent(this, post.class);
                startActivity(intent);
        }
    }
    //게시물 보기 버튼3
    public void bt_post3(View v){
        switch(v.getId()){
            case R.id.cat:
                Intent intent = new Intent(this, post2.class);
                startActivity(intent);
        }
    }

    //검색 버튼
    public void bt_search(View v) {
        switch (v.getId()) {
            case R.id.search:
                Toast.makeText(this, "일치하는 정보가 없습니다.", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    //그래프 버튼
    public void bt_graph(View v){
        switch(v.getId()){
            case R.id.graph:
                //TextView textView1 = (TextView)findViewById(R.id.tg_view);
                TextView textView2 = (TextView)findViewById(R.id.in_text_view);
                int values = Integer.parseInt(textView2.getText().toString());
                Intent intent = new Intent(this,graph_next.class); // 보여주기 식으로 선언
                intent.putExtra("my",values); // 보여주기 식으로 자료 넘기기 -> graph_next.java 파일에 setExtras로 넘김
                startActivity(intent);
                break;
        }
    }
    // 그래프 종이
    public void bt_paper(View v){
        switch(v.getId()){
            case R.id.bt_paper:
                EditText editText = (EditText)findViewById(R.id.paperText); // 종이 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view); // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("종이");
                textView.setText(editText.getText()); // 위로 보낸다
                editText.setText("");
        }
    }
    // 그래프 플라스틱
    public void bt_plastic(View v){
        switch(v.getId()){
            case R.id.bt_plastic:
                EditText editText = (EditText)findViewById(R.id.plasticText); // 플라스틱 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view); // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("플라스틱");
                textView.setText(editText.getText());
                editText.setText("");
        }
    }
    // 그래프 캔
    public void bt_metal(View v){
        switch(v.getId()){
            case R.id.bt_metal:
                EditText editText = (EditText)findViewById(R.id.metalText); // 캔 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view);  // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("캔");
                textView.setText(editText.getText());
                editText.setText("");
        }
    }

    // 그래프 유리
    public void bt_glass(View v){
        switch(v.getId()){
            case R.id.bt_glass:
                EditText editText = (EditText)findViewById(R.id.glasstText); // 유리 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view); // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("유리");
                textView.setText(editText.getText());
                editText.setText("");
        }
    }

    // 그래프 금속
    public void bt_iron(View v){
        switch(v.getId()){
            case R.id.bt_iron:
                EditText editText = (EditText)findViewById(R.id.ironText); // 금속 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view); // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("금속");
                textView.setText(editText.getText());
                editText.setText("");
        }
    }

    // 그래프 음식물
    public void bt_food(View v){
        switch(v.getId()){
            case R.id.bt_food:
                EditText editText = (EditText)findViewById(R.id.foodText); // 음식물 입력 text
                TextView textView = (TextView)findViewById(R.id.in_text_view); // 전달 받을 text
                TextView tg_view = (TextView)findViewById(R.id.tg_view); // 종류 출력 text
                tg_view.setText("음식물");
                textView.setText(editText.getText());
                editText.setText("");
        }
    }


    //로그인버튼
    public void bt_loign2(View v){
        switch (v.getId()){
            case R.id.login2:
                Intent intent = new Intent(this, login.class);
                finish();
        }
    }

    //공지사항 버튼
    public void bt_notice(View v){
        switch (v.getId()){
            case R.id.notice:
                Intent intent = new Intent(this, notice.class);
                startActivity(intent);
        }
    }

    //버전 버튼
    public void bt_ver(View v){
        switch (v.getId()){
            case R.id.ver:
                Intent intent = new Intent(this, version.class);
                startActivity(intent);
        }
    }

    //분리수거 팁 버튼
    public void bt_retip(View v){
        switch ((v.getId())){
            case R.id.retip :
                Intent intent = new Intent(this, recycle_tip.class);
                startActivity(intent);
                Toast.makeText(this, "분리수거", Toast.LENGTH_SHORT).show();
        }
    }
    //폐기물 팁 버튼
    public void bt_retip2(View v){
        switch ((v.getId())){
            case R.id.retip2 :
                Intent intent = new Intent(this, recycle_tip2.class);
                startActivity(intent);
                Toast.makeText(this, "폐기물", Toast.LENGTH_SHORT).show();
        }
    }

    //뒤로가기 두번연속으로 누르실 종료되는 메소드
    private long pressedTime;   //시간저장할 변수
    @Override
    public void onBackPressed() {
        if (pressedTime == 0) {   // 한번 누르면
            Toast.makeText(this, "한번 더 누르면 로그인창으로 이동합니다.", Toast.LENGTH_LONG).show();
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