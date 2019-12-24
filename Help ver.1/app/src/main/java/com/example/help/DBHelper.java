package com.example.help;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //  db 생성자로 관리할 DB 이름과 버전 정보
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    // db를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db){
        // 새로운 테이블 생성
        db.execSQL("CREATE TABLE HELPER (user_id VARCHAR(30) PRIMARY KEY, user_name VARCHAR(15), user_pwd VARCHAR(10), user_phone VARCHAR(30), user_address1 VARCHAR(15), user_address2 VARCHAR(100));");
        db.execSQL("CREATE TABLE GRAPH(graph_id VARCHAR(30) not null PRIMARY KEY, paper int not null, can int not null, glass int not null, metal int not null, food int not null, plastic int not null, FOREIGN KEY(graph_id) REFERENCES HELPER(user_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    }

    public void signup_insert(String name, String id, String pwd, String phone, String address1, String address2){
        //읽고 쓰기가 가능한게 DB열기
        SQLiteDatabase db = getWritableDatabase();
        //DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO HELPER VALUES('"+id+"','"+name+"','"+pwd+"','"+phone+"','"+address1+"','"+address2+"')");
        db.close();
    }

    //그래프 값 입력
    public void graph_insert(String id, int paper, int can, int glass, int metal, int food, int plastic){
        //일고 쓰기가 가능하게 DB열기
        SQLiteDatabase db = getWritableDatabase();
        //DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO GRAPH VALUES('"+id+"',"+paper+","+can+","+glass+","+metal+","+food+","+plastic+")");
        db.close();
    }

    //중복값 찾기
    public boolean getid(String id){
        boolean checkDB = false;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Helper user_id",null);
        while(cursor.moveToNext()){
            if(cursor.getString(0).equals(id)){
                checkDB = true;
                break;
            }
        }
        cursor.close();
        return checkDB;
    }

    //로그인 버튼 메소드
    public boolean login(String id,String pwd){
        boolean checkDB = false;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Helper user_id",null);

        while(cursor.moveToNext()){
            if(cursor.getString(0).equals(id)){
                if(cursor.getString(2).equals(pwd)){
                    checkDB=true;
                    break;
                }
            }
        }
        cursor.close();
        return checkDB;
    }
    public int values(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GRAPH graph_id",null);

        return Integer.parseInt(cursor.getString(1));
    }
}