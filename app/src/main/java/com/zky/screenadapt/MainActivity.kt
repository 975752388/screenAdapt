package com.zky.screenadapt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zky.lib.ScreenAdapt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenAdapt.initDesignWidthDp(application,360f,this)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener { startActivity(Intent(this,SecondActivity::class.java)) }
    }
}
