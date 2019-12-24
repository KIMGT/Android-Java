package com.example.help.menulist.recycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.help.R;

public class recycle_tip extends AppCompatActivity implements View.OnClickListener {

    //(recycle) imageView , 버튼
    Button bt_pap,bt_gls,bt_met,bt_pla,bt_sty,bt_ele,bt_tir,bt_oi,bt_el,
            bt_lam, bt_iro,bt_clo,bt_was,bt_food,bt_oth;


    //ImageView re_view;
    TextView te_view;
    TextView te_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tip);

        //xml에 불러올 이미지뷰를 bt에 넣어 속성 사용
        bt_pap =(Button)findViewById(R.id.bt_paper);
        bt_gls =(Button)findViewById(R.id.bt_glass);
        bt_met =(Button)findViewById(R.id.bt_metal);
        bt_pla =(Button)findViewById(R.id.bt_plastic);
        bt_sty =(Button)findViewById(R.id.bt_styrofoam);
        bt_ele =(Button)findViewById(R.id.bt_electric);
        bt_tir =(Button)findViewById(R.id.bt_tire);
        bt_oi =(Button)findViewById(R.id.bt_oil);
        //bt_el =(Button)findViewById(R.id.bt_electron);
        bt_lam =(Button)findViewById(R.id.bt_lamp);
        bt_iro =(Button)findViewById(R.id.bt_iron);
        bt_clo =(Button)findViewById(R.id.bt_clothes);
        //bt_was =(Button)findViewById(R.id.bt_waste);
        //bt_food =(Button)findViewById(R.id.bt_food);
        bt_oth =(Button)findViewById(R.id.bt_other);


        //버튼 클릭이벤트 처리
        bt_pap.setOnClickListener(this);
        bt_gls.setOnClickListener(this);
        bt_met.setOnClickListener(this);
        bt_pla.setOnClickListener(this);
        bt_sty.setOnClickListener(this);
        bt_ele.setOnClickListener(this);
        bt_tir.setOnClickListener(this);
        bt_oi.setOnClickListener(this);
        //bt_el.setOnClickListener(this);
        bt_lam.setOnClickListener(this);
        bt_iro.setOnClickListener(this);
        bt_clo.setOnClickListener(this);
        //bt_was.setOnClickListener(this);
        //bt_food.setOnClickListener(this);
        bt_oth.setOnClickListener(this);

        //xml에 불러올 이미지뷰를 re_view 속성사용
        //re_view = (ImageView)findViewById(R.id.re_view);

        //xml에 불러온 텍스트뷰 (제목)
        te_view = (TextView)findViewById(R.id.re_text);

        //xml에 불러올 텍스트뷰 (내용)
        //문자열 리소스 활용(string.xml)
        te_view2 = findViewById(R.id.re_text2);
    }



    //팁 버튼
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_paper:
                //이미지뷰 사진을 출력하는 구문
                //re_view.setImageResource(R.drawable.tip_paper);
                //텍스트뷰 문자열 출력 구문
                te_view.setText(" 종 이");
                te_view2.setText(getString(R.string.paper2));
                break;

            case R.id.bt_glass:

                te_view.setText(" 유 리");
                te_view2.setText(getString(R.string.glass));
                break;

            case R.id.bt_metal:
                te_view.setText("  금 속 캔");
                te_view2.setText(getString(R.string.metal));
                break;

            case R.id.bt_plastic:
                te_view.setText("  플 라 스 틱");
                te_view2.setText(getString(R.string.plastic));
                break;
            case R.id.bt_styrofoam:
                te_view.setText("  스 트 리 폼");
                te_view2.setText(getString(R.string.styrofoam));
                break;
            case R.id.bt_electric:
                te_view.setText("  전 지 류");
                te_view2.setText(getString(R.string.electric));
                break;
            case R.id.bt_tire:
                te_view.setText("  타 이 어");
                te_view2.setText(getString(R.string.tire));
                break;
            case R.id.bt_oil:
                te_view.setText("  윤 활 유");
                te_view2.setText(getString(R.string.oil));
                break;
            //case R.id.bt_electron:
                //te_view.setText("  전 자 제 품");
                //te_view2.setText(getString(R.string.electron));
                //break;
            case R.id.bt_lamp:
                te_view.setText("  형 광 등");
                te_view2.setText(getString(R.string.lamp));
                break;
            case R.id.bt_iron:
                te_view.setText("  고 철 류");
                te_view2.setText(getString(R.string.iron));
                break;
            case R.id.bt_clothes:
                te_view.setText("  의 류");
                te_view2.setText(getString(R.string.clothes));
                break;
            //case R.id.bt_waste:
                //te_view.setText("  영 농 폐 기 물");
                //te_view2.setText(getString(R.string.waste));
                //break;
            //case R.id.bt_food:
                //te_view.setText("  음 식 물");
                //te_view2.setText(getString(R.string.food));
                //break;
            case R.id.bt_other:
                te_view.setText("  기 타");
                te_view2.setText(getString(R.string.other));
                break;
        }
    }
}

