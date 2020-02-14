package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.data.SSJoin
import com.example.myapplication.model.data.Student
import com.example.myapplication.model.data.StudentHasSubjectList
import com.example.myapplication.model.data.Subject

@Dao
interface MyDao {

    @Query("SELECT * FROM SSJoin")
    fun getSSJoinList(): LiveData<List<SSJoin>>

    @Insert
    fun insert(studentSubjectJoin: SSJoin)

    @Insert
    fun insert(student: Student)

    @Insert
    fun insert(subject: Subject)

//    @Query("SELECT * ")
//    fun getStudjentHasSubjectList(): LiveData<List<StudentHasSubjectList>>

}