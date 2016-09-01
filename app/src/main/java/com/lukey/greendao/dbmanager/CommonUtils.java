package com.lukey.greendao.dbmanager;

import android.content.Context;
import android.util.Log;

import com.student.entity.Student;

import java.util.List;

/**
 * 完成对某一张表的具体操作，ORM 操作的是对象，Student
 * Created  Lukey on 2016/6/18 10:03
 */
public class CommonUtils {
    private DaoManager mManager;

    public CommonUtils(Context context) {
        mManager = DaoManager.getInstance();
        mManager.init(context);
    }

    public boolean insertStudent(Student student) {
        boolean flag = false;
        try {
            flag = mManager.getDaoSession().insert(student) != -1 ? true : false;
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("CommonUtils", "--->" + flag);
        return flag;
    }

    /**
     * 插入多条记录，需要开辟新的线程
     *
     * @param students
     * @return
     */
    public boolean insertMultStudent(final List<Student> students) {
        boolean flag = false;
        try {
            mManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Student student : students) {
                        mManager.getDaoSession().insertOrReplace(student);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 完成对student的某一条记录的修改
     * @param student
     * @return
     */
    public boolean updateStudent(Student student) {
        boolean flag = false;
        try {
            mManager.getDaoSession().update(student);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

}
