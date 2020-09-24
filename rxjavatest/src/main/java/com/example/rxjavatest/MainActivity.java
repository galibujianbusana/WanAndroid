package com.example.rxjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView tv;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        List<String> yys = new ArrayList<>();
        yys.add("野猿新一");
        yys.add("野猿新二");
        yys.add("野猿新三");
        Observable.from(yys)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d(TAG, s);
                    }
                });

        String path = "this is path";
        Observable.just(path)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " : after -> map ";
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError:  this is error !!!");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.d(TAG, "onNext: " + o);
                        int i = 0;
                        int y = 3;
                        double sum = y / i;
                        Log.d(TAG,"this is error!!@");

                    }
                });




        test3();

        ImageView img = findViewById(R.id.img);

        Glide.with(this).load("http://10.193.199.30:8008/static/img/bank/cmb.png").into(img);




    }

    private void test3(){
        Gson gson = new Gson();
        String s = "{ \"name\":郭喜旺," + " \"age\":\"28\"}";
        TestBean bean = gson.fromJson(s,TestBean.class);
        Log.d(TAG, "test3: "+ bean.toString());


    }
    // 统一处理异常
    private void test() {
        RxJavaPlugins.getInstance().registerErrorHandler(
                new RxJavaErrorHandler() {
                    @Override
                    public void handleError(Throwable e) {
                        //在这里处理错误
                        if(e instanceof NullPointerException){
                            Log.d(TAG," 这里是空指针的全局处理!");
                        }
                    }
                }
        );


    }
    // 倒计时
    private void test1() {

        final int count = 20;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        Long x = count - aLong;
                        return x;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                        Log.d(TAG, "onNext:  -- - > " + aLong);
                        tv.setText("" + aLong);
                    }
                });
    }
    // flatMap 使用
    private void test2(){
        List<Student> students = new ArrayList<>();
        Course course1 = new Course("数学", "001");
        Course course2 = new Course("语文", "002");
        Course course3 = new Course("政治", "003");
        Course course4 = new Course("生物", "004");
        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        courseList1.add(course1);
        courseList1.add(course3);

        courseList2.add(course1);
        courseList2.add(course2);
        courseList2.add(course3);
        courseList2.add(course4);

        students.add(new Student(courseList1, "郭喜旺"));
        students.add(new Student(courseList2, "GUOXW"));
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {

                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.courses);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Course>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: this is error !");
                    }

                    @Override
                    public void onNext(Course course) {
                        Log.d(TAG, "onNext: " + course.toString());
                    }
                });
    }
}
