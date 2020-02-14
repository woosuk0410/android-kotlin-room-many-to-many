package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        myViewModel.ssJoinList.observe(this, Observer {
            it?.let {
                for(ssjoin in it) {
                    Log.e("My Application", ssjoin.toString())
                }

            }
        })
//        myViewModel.studentHasSubjectList.observe(this, Observer{})


    }
}
