#intro.java

package com.techtown.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by rlxo5 on 2017-10-31.
 */

public class intro extends MainActivity {
    Handler handler = new Handler();
    Runnable r = new Runnable() {


        public void run() {
// 4초뒤에 다음화면(MainActivity)으로 넘어가기 Handler 사용
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent); // 다음화면으로 넘어가기
            finish(); // Activity 화면 제거
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro); // xml과 java소스를 연결
    } // end of onCreate

    @Override
    protected void onResume() {
        super.onResume();
// 다시 화면에 들어어왔을 때 예약 걸어주기
        handler.postDelayed(r, 4000); // 4초 뒤에 Runnable 객체 수행
    }

    @Override
    protected void onPause() {
        super.onPause();
// 화면을 벗어나면, handler 에 예약해놓은 작업을 취소하자
        handler.removeCallbacks(r); // 예약 취소
    }
}





#Id.java
package com.techtown.calculator;

/**
 * Created by rlxo5 on 2017-10-31.
 */
public class Id {
public final int btn_num[] = { //버튼의 숫자 id 변수 초기화
        R.id.btn0,
        R.id.btn1,
        R.id.btn2,
        R.id.btn3,
        R.id.btn4,
        R.id.btn5,
        R.id.btn6,
        R.id.btn7,
        R.id.btn8,
        R.id.btn9
        };

public final int btn_op[] = { //버튼의 연산자 id 변수 초기화
        R.id.add,
        R.id.min,
        R.id.mul,
        R.id.div,
        R.id.equal,
        R.id.reset,
        R.id.del,
        R.id.dot,
        R.id.Start,
        R.id.End
        };

public final int text_id[] = { //계산 과정 결과 화면 텍스트 뷰 id 변수 초기화
        R.id.Input,
        R.id.result
        };
        }








#MainActivity.java

package com.techtown.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Id id;
    Button[] btn_num;
    Button[] btn_op;
    TextView[] textViews;
    Context context;
    Init init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        context = getApplicationContext();
        id = new Id();
        btn_num = new Button[id.btn_num.length];
        btn_op = new Button[id.btn_op.length];

        init = new Init(this, btn_op, btn_num, textViews); //Init 클래스에 변수 전달
    }

}




#Calculator.java

package com.techtown.calculator;

/**
 * Created by rlxo5 on 2017-10-31.
 */
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator {
private Context context;
private Stack stack;

public Calculator(Context context)
        {
        this.context = context;
        stack = new Stack();
        }

public boolean isPairExpression(ArrayList<String> exp) //exp를 받아와 괄호쌍 검사
        {
        String pop; //String pop 선언
        Stack s = new Stack(); //stack s 객체 선언&초기화
        boolean a = true; //boolean형 a true로 초기화

        for(int i = 0;i < exp.size(); i++) //받은 리스트의 길이만큼 반복
        {
        if(exp.get(i).equals("(")) //exp의 i번째 값이 "("일경우
        {
        s.push(exp.get(i)); //스택 객체인 s에 푸쉬
        }
        else if(exp.get(i).equals(")")) //exp의 i번째 값이 ")"일경우
        {
        pop = (String)s.pop(); //pop에 String으로 형변환을 해 값을 팝하여 저장
        if(pop==null) //pop에 널값이 저장될경우 a를 false로 바꾸어주고 리턴시킨다.
        {
        a = false;
        return a;
        }
        if(pop.equals("(")&&!exp.get(i).equals(")")) //pop에 저장된 값이 "("이고 exp문자열의 i번째 값이 ")"가 아닐경우
        {
        a = false; //a를 false로 바꾸고 리턴
        return a;
        }
        }
        }

        if(!s.isEmpty()) //스택의 s객체가 안비었을 경우
        {
        a = false; //a를 false로 바꾸고 리턴
        return a;
        }
        Log.v("Boolean", String.valueOf(a));
        return true; //모든 조건에 걸리지 않을 경우 true 리턴
        }

public ArrayList<String> infixToPostfix(ArrayList<String> infix) //중위연산자 -> 후위연산자 메소드
        {
        String pop = null; //string pop을 null로 초기화
        Stack s = new Stack(); //Stack 객체 s 생성
        ArrayList<String> postfix = new ArrayList<String>(); //ArrayList potstfix 선언 초기화

        if(isPairExpression(infix)) //괄호쌍 최종계산 결과가 true일 경우 실행
        {
        for(int i = 0; i < infix.size(); i++) //중위연산자의 길이만큼 반복
        {
        if (isInt(infix.get(i))) //infix의 i번째 값이 정수형일 경우
        {
        postfix.add(infix.get(i)); //posfix에 추가
        }
        else if (isDouble(infix.get(i))) //infix의 i번째 값이 실수형일 경우
        {
        postfix.add(infix.get(i)); //postfix에 추가
        }
        else if (infix.get(i).equals("(")) //infix의 i번째 값이 "("와 같을 경우
        {
        stack.push(infix.get(i)); //stack에 푸쉬
        }
        else if (infix.get(i).equals(")")) //infix의 i번째 값이 ")"와 같을 경우
        {
        pop = (String) stack.pop(); //pop에 stack에 있는 값 팝하여 저장
        while (!pop.equals("(")) //String pop이 "("와 같을때까지 반복
        {
        postfix.add(pop); //postfix에 pop에 있는 값 저장
        pop = (String) stack.pop(); //pop에 stack에 있는 값 (String)으로 형변환하고 팝하여 저장
        }
        }
        else if (infix.get(i).equals("+") || infix.get(i).equals("-")) //infix에 있는 i번째 값이 + 또는 - 일 경우
        {
        while (!stack.isEmpty() && (stack.peek().equals("X") || stack.peek().equals("/")))
        //스택이 텅비지 않고 스택의 top이 *이나 -일경우 postfix에 pop하여 저장
        {
        postfix.add((String) stack.pop());
        }
        stack.push(infix.get(i)); //stack에 infix의 i번째 값 푸쉬해서 저장
        }
        else if (infix.get(i).equals("X") || infix.get(i).equals("/")) //infix의 i번째 값이 *이나 / 일 경우
        {
        stack.push(infix.get(i)); //stack에 infix의 i번째 값 푸쉬해서 저장
        }
        }
        while (!stack.isEmpty()) //stack이 안비었을경우
        {
        postfix.add((String)stack.pop()); //postfix에 stack에 있는값 pop하여 추가
        }
        }
        else
        {
        Toast.makeText(context, "Input Error", Toast.LENGTH_SHORT).show();//잘못되게 입력했을 경우 출력
        }
        Log.v("Stack", String.valueOf(postfix));
        return postfix; //후위연산자 리턴
        }

public Double PostfixCal(ArrayList<String> postfix)
        {
        Stack<Double> stack = new Stack<Double>(); //Stack 객체 stack 선언
        double result = 0.0; //result값 0으로 초기화

        for(int i = 0; i < postfix.size(); i++) //후위연산자 길이 만큼 반복
        {
        try{
        if(isInt(postfix.get(i))) //후위연산자의 i값이 정수형일 경우
        {
        stack.push(Double.parseDouble(postfix.get(i))); //stack에 실수형으로 반환하여 푸쉬
        }
        else if(isDouble(postfix.get(i))) //후위연산자의 i값이 실수형일 경우
        {
        stack.push(Double.parseDouble(postfix.get(i))); //stack에 실수형으로 푸쉬
        }
        else if(postfix.get(i).equals("+")) //후위연산자의 i값이 +일 경우
        {
        stack.push(stack.pop()+stack.pop()); //팝하여 더한후 푸쉬
        }
        else if(postfix.get(i).equals("-")) //후위연산자의 i값이 -일 경우
        {
        double data = stack.pop(); //data를 팝하여 미리저장
        stack.push(stack.pop()-data); //stack에 팝한것으로부터 data의 값을 빼준다
        }
        else if(postfix.get(i).equals("X")) //후위연산자의 i값이 X일 경우
        {
        stack.push(stack.pop() * stack.pop());  //팝한것들을 곱하여 푸쉬
        }
        else if(postfix.get(i).equals("/")) //후위연산자의 i값이 /일 경우
        {
        double data = (double) stack.pop(); //data에 팝하여 미리저장
        stack.push(stack.pop() / data); //stack에 팝한것을 data로 나눈다
        }
        }catch (EmptyStackException e) {
        Toast.makeText(context, "Input Error", Toast.LENGTH_SHORT).show(); //잘못 됐을경우 뜨는 문장
        }
        }
        try {
        return stack.pop(); //결과값 팝하여 출력
        }catch(EmptyStackException e){
        Toast.makeText(context, "Input Error", Toast.LENGTH_SHORT).show();
        }
        return null;// 잘못됐을 경우 null값 반환
        }

public boolean isInt(String s){ //정수형 확인 메소드
        try{
        Integer.parseInt(s);
        }catch (NumberFormatException e){
        return false;
        }
        return true;
        }

public boolean isDouble(String s){ //실수형 확인 메소드
        try{
        Double.parseDouble(s);
        }catch(NumberFormatException e){
        return false;
        }
        return true;
        }

public ArrayList<String> makeInfix(String exp) //중위연산자 메소드
        {
        String temp = ""; //String형 temp 초기화
        ArrayList<String> str = new ArrayList<String>(); //ArrayList String형 str 선언&초기화
        for(int i = 0; i < exp.length(); i++) //exp의 길이만큼 반복
        {
        if(exp.charAt(i) == '(') //'(' 일 경우
        {
        str.add(Character.toString(exp.charAt(i))); //str에 추가
        }
        else if(exp.charAt(i) == ')') //')'일 경우
        {
        if(temp != "") //temp가 비어있지 않으면
        {
        str.add(temp); //str에 temp값 추가
        temp = ""; //temp "" 로 초기화
        }
        str.add(Character.toString(exp.charAt(i))); //str에 추가
        }
        else if(Character.isDigit(exp.charAt(i))) //exp의 i번째 값이 숫자일경우
        {
        temp += exp.charAt(i); //temp에 저장
        continue;
        }
        else if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == 'X' || exp.charAt(i) == '/') //exp의 i번째 값이 사칙연산일 경우
        {
        if(temp != "") //temp가 비어있지 않으면
        str.add(temp); //str에 temp값 추가
        str.add((Character.toString(exp.charAt(i)))); //str에 exp의 i번째 값 추가
        temp = ""; //temp ""로 초기화
        continue;
        }
        else if(exp.charAt(i) == '.') //exp의 i번째 값이 '.' 일 경우
        {
        temp += "."; //temp에 '.' 추가
        continue;
        }
        }
        if(temp != "") //temp가 비어있지 않을경우
        {
        str.add(temp); //str에 temp값 추가
        temp = ""; //temp ""로 초기화
        }

        Log.d("call_test", str.toString());

        return str; //str 리턴
        }

public Double equal(StringBuffer buffer) //결과값 출력 메소드
        {
        ArrayList<String> exp = makeInfix(buffer.toString()); //ArrayList exp에 makeInfix메소드를 이용한 buffer값 저장
        ArrayList cal = infixToPostfix(exp); //ArrayList cal 에 exp를 후위연산자로 바꾼값 저장
        Double result = PostfixCal(cal); //실수형 result에 후위연산자를 계산한 값 저장

        if(result==null) //결과값이 null일 경우 에러 출력
        {
        Toast.makeText(context, "오류 발생", Toast.LENGTH_SHORT).show();
        return null;
        }
        else
        {
        return result; //결과값이 정상일 경우 결과값 리턴
        }
        }
        }






#Init.java

package com.techtown.calculator;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rlxo5 on 2017-10-31.
 */

public class Init {
    Context context; //Context 객체 선언
    Calculator calculator; //Calculator클래스 객체 선언
    Button btn_op[]; //button 연산자 배열 선언
    Button btn_num[]; //button 숫자 배열 선언
    TextView textViews[]; //텍스트뷰 Input Output 배열 선언
    Id id; //Id 클래스 객체 선언
    String temp = ""; //temp 초기화
    ArrayList<String> exp; //ArrayList exp  선언
    StringBuffer buffer; //값을 저장해줄 buffer 선언
    Double result; //실수형 결과값 선언



    public Init(Context context, Button btn_op[],Button btn_num[], TextView[] textViews) //MainActivity 에서 전달받은 button 과 textView 이용
    {
        //Init 생성자 모든것들 초기화 & 메소드 실행
        this.context = context;
        calculator = new Calculator(context);
        this.btn_op = btn_op;
        this.btn_num = btn_num;
        this.textViews = textViews;
        exp = new ArrayList<String>();
        buffer = new StringBuffer();

        id = new Id();

        init_btn_num();
        init_btn_op();
        init_textView();
    }

    public void init_btn_op() { //버튼 연산자 메소드
        btn_op = new Button[id.btn_op.length]; //길이값 만큼 배열 생성
        for (int i = 0; i < id.btn_op.length; i++) { //길이값 만큼 반복
            final int key = i; //key 값에 final 변수로 i값 고정
            btn_op[i] = (Button) ((Activity) context).findViewById(id.btn_op[i]); // findView 사용
            btn_op[key].setOnClickListener(new View.OnClickListener(){ //ClickListener 메소드 사용

                public void onClick(View v)
                {
                    btn_op_init(btn_op[key].getText().toString()); // 버튼 클릭시 btn_op_init 메소드 실행
                }
            });

        }
    }



    public void init_btn_num() {
        btn_num = new Button[id.btn_num.length];
        for (int i = 0; i < id.btn_num.length; i++) {
            btn_num[i] = (Button) ((Activity) context).findViewById(id.btn_num[i]);
            final int key = i;
            btn_num[i].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    temp = btn_num[key].getText().toString(); //temp에 버튼 클릭시 발생되는 값 저장
                    buffer.append(temp); //temp에 있는 값을 buffer에 추가
                    screen(btn_num[key].getText().toString()); //screen 메소드를 이용해 btn클릭시 발생 되는 값을 Input 텍스트뷰에 추가
                }
            });
        }
    }

    public void init_textView(){
        textViews = new TextView[id.text_id.length];
        for(int i=0; i< id.text_id.length; i++)
        {
            textViews[i] = (TextView) ((Activity) context).findViewById(id.text_id[i]);
        }
    }

    public void btn_op_init(String s) //연산자 버튼 클릭시 발생되는 메소드
    {
        Log.v("s의 값",s);
        if(s.equals(btn_op[4].getText().toString())) //누른 버튼의 s값이 btn_op인덱스 4번째인 = 와 같으면 실행
        {
            result = calculator.equal(buffer); //결과값 result에 저장

            try{ //try catch 문
                resultPrint(Double.toString(result)); //resultPrint 메소드 실행
            }catch(NullPointerException e){
                Toast.makeText(context, "Wrong input", Toast.LENGTH_SHORT).show(); //잘못됐을 경우 출력하는 알림
            }
            return;
        }
        else if(s.equals(btn_op[5].getText().toString())) //누른 버튼의 s값이 btn_op인덱스 5번째인 c와 같다면 clear 메소드 실행
        {
            clear();
            return;
        }
        else if(s.equals(btn_op[6].getText().toString())) //누른 버튼의 s값이 btn_op인덱스 6번째인 backspace와 같다면
        {
            if(buffer.length()==0) //buffer의 길이가 0일 경우 실행하면 에러 문장 출력
            {
                Toast.makeText(context, "delete error", Toast.LENGTH_SHORT).show();
            }
            buffer.deleteCharAt(buffer.length()-1); //buffer 하나 감소
            screen(s); //screen 메소드 실행
            return;
        }
        buffer.append(s); //buffer에 값 추가
        screen(s); //screen 메소드 실행
    }

    public void clear()
    {
        buffer = new StringBuffer(); //clear시 buffer 초기화
        temp = ""; //temp 초기화
        exp = new ArrayList<String>(); //arrayList exp 초기화
        textViews[0].setText(""); //textView 결과화면,계산화면 초기화
        textViews[1].setText("");
        result = null; //result값을 null값으로 초기화
    }

    public void screen(String s)
    {
        textViews[0].setText(buffer);
        Log.v("buffer의 값",buffer.toString());
    } //screen 메소드

    public void resultPrint(String s)
    {
        textViews[1].setText(s);
    } //결과값 출력 메소드
}

