package com.cwj.cwjdialogdemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * author : ChenWenJie
 * email  :1181620038@qq.com
 * date   : 2020/7/21
 * desc   : 演示 java 写法
 */
public class JavaActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
    }
}
