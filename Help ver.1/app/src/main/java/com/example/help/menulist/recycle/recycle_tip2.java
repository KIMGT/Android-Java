package com.example.help.menulist.recycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.help.R;

public class recycle_tip2 extends AppCompatActivity implements View.OnClickListener {

    //(recycle) imageView , 버튼
    Button bt_el, bt_food, bt_ha, bt_no;


    ImageView re_view;
    TextView te_view3 ,te_view4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tip2);

        //xml에 불러올 이미지뷰를 bt에 넣어 속성 사용
        bt_el = (Button) findViewById(R.id.bt_electron);
        bt_food = (Button) findViewById(R.id.bt_food);
        bt_ha = (Button) findViewById(R.id.bt_ha_waste);
        bt_no = (Button) findViewById(R.id.bt_no_waste);

        //버튼 클릭이벤트 처리
        bt_el.setOnClickListener(this);
        bt_food.setOnClickListener(this);
        bt_ha.setOnClickListener(this);
        bt_no.setOnClickListener(this);

        //xml에 불러올 이미지뷰를 re_view 속성사용
        re_view = (ImageView) findViewById(R.id.re_view);

        //xml에 불러온 텍스트뷰 (제목)
        te_view3 = (TextView) findViewById(R.id.re_text3);
        te_view4 = findViewById(R.id.re_text4);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bt_electron:
                te_view3.setText("  전 자 제 품");

                //이미지뷰 사진을 출력하는 구문
                re_view.setImageResource(R.drawable.tip_electron);
                te_view4.setText("  * 출처 : 환경부");
                break;

            case R.id.bt_food:
                //텍스트뷰 문자열 출력 구문
                te_view3.setText("  음식물폐기물");
                re_view.setImageResource(R.drawable.tip_food);
                te_view4.setText("  * 출처 : 환경부");
                break;

            case R.id.bt_ha_waste:
                //텍스트뷰 문자열 출력 구문
                te_view3.setText("  유해폐기물");
                re_view.setImageResource(R.drawable.tip_ha_waste);
                te_view4.setText("  * 출처 : 환경부");
                break;

            case R.id.bt_no_waste:
                //텍스트뷰 문자열 출력 구문
                te_view3.setText("  불연성폐기물");
                re_view.setImageResource(R.drawable.tip_no_waste);
                te_view4.setText("  * 출처 : 환경부");
                break;
        }
    }
}
