package com.zky.screenadapt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.zky.lib.ScreenAdapt;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenAdapt.Companion.cancleAdapt(this);
        setContentView(R.layout.activity_second);
    }
}
