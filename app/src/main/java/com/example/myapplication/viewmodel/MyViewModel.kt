package com.example.myapplication.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.MyRoomDatabase
import com.example.myapplication.model.data.SSJoin
import com.example.myapplication.model.data.StudentHasSubjectList


class MyViewModel(application: Application) : AndroidViewModel(application) {

    val ssJoinList: LiveData<List<SSJoin>> = MyRoomDatabase.getDatabase(application, viewModelScope).myDao().getSSJoinList()
//    val studentHasSubjectList: LiveData<List<StudentHasSubjectList>> = MyRoomDatabase.getDatabase(application, viewModelScope).myDao().getStudjentHasSubjectList()

}