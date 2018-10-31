package com.liuh.builderpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Student stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stu = new Student.Builder()
                .id(111)
                .name("小明")
                .passwd("123456")
                .sex("男")
                .address("紫禁城")
                .build();
    }
}
