package com.lukey.greendao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.lukey.greendao.dbmanager.CommonUtils;
import com.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CommonUtils mCommonUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mCommonUtils = new CommonUtils(this);
    }

    /**
     * 插入数据库的操作
     *
     * @param view
     */
    public void insert(View view) {
        Student student = new Student();
        student.setAddress("深圳");
        student.setName("周杰伦");
        student.setAge(23);
        student.setId(1001l);
        mCommonUtils.insertStudent(student);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void insertMultData(View view) {
        Log.i("MainActivity", "insertMultData");
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAddress("深圳");
            student.setName("李四" + i);
            student.setAge(23 + i);
            student.setId(1001l);
            list.add(student);
        }
        mCommonUtils.insertMultStudent(list);
    }

    public void updataData(View view) {
        Student student = new Student();
        student.setId(1001l);
        student.setAge(100);
        student.setName("jack");
        student.setAddress("我爱深圳");
        mCommonUtils.updateStudent(student);
    }
}
