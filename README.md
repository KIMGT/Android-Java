# PRO
안드로이드 계산기
#activity_main_xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:weightSum="1">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical" >

        <TextView
            android:id="@+id/Input"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="4.02"
            android:background="@android:color/background_light"
            android:gravity="top|right"
            android:hint="0"
            android:text="0"
            android:textColor="@android:color/holo_blue_bright"
            android:textSize="50dp" />

        <EditText
            android:id="@+id/result"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_weight="0"
            android:backgroundTint="@android:color/holo_blue_bright"
            android:clickable="false"
            android:ems="10"
            android:gravity="right"
            android:textColor="@android:color/holo_blue_bright"
            android:textSize="40dp" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1">

        <Button
            android:id="@+id/Start"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="@android:color/holo_orange_dark"
            android:onClick="function"
            android:text="("
            android:textColor="#ffffff"
            android:textSize="20dp" />

        <Button
            android:id="@+id/End"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="@android:color/holo_orange_dark"
            android:onClick="function"
            android:text=")"
            android:textColor="#ffffff"
            android:textSize="20dp" />

        <Button
            android:id="@+id/dot"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="@android:color/holo_orange_dark"
            android:textColor="#ffffff"
            android:text='.'
            android:textSize="20dp" />

        <Button
            android:id="@+id/del"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="@android:color/holo_orange_dark"
            android:onClick="function"
            android:text="←"
            android:textColor="#ffffff"
            android:textSize="20dp" />

    </LinearLayout>


    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1" >

        <Button
            android:id="@+id/btn1"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="1" />/>

        <Button
            android:id="@+id/btn2"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="#ff000000"
            android:onClick="numClick"
            android:text="2"
            android:textColor="#ffffff"
            android:textSize="20dp" />

        <Button
            android:id="@+id/btn3"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="3" />

        <Button
            android:id="@+id/add"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="function"
            android:background="#ffcc0000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="+" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1" >

        <Button
            android:id="@+id/btn4"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="4" />

        <Button
            android:id="@+id/btn5"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="5" />

        <Button
            android:id="@+id/btn6"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="6" />

        <Button
            android:id="@+id/min"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="#ffcc0000"
            android:onClick="function"
            android:text="-"
            android:textColor="#ffffff"
            android:textSize="40dp" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1" >

        <Button
            android:id="@+id/btn7"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="7" />

        <Button
            android:id="@+id/btn8"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="8" />

        <Button
            android:id="@+id/btn9"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="9" />

        <Button
            android:id="@+id/mul"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:background="#ffcc0000"
            android:onClick="function"
            android:text="X"
            android:textColor="#ffffff"
            android:textSize="20dp" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1" >

        <Button
            android:id="@+id/reset"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="function"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="C" />

        <Button
            android:id="@+id/btn0"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="numClick"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="0" />

        <Button
            android:id="@+id/equal"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="function"
            android:background="#ff000000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="=" />

        <Button
            android:id="@+id/div"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_weight="1"
            android:onClick="function"
            android:background="#ffcc0000"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:text="/" />


    </LinearLayout>

</LinearLayout>
