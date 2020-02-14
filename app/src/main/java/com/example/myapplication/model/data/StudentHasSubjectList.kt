package com.example.myapplication.model.data

data class StudentHasSubjectList(
    val stduentId: Int = 0,
    val studentName: String = "noname",
    val subjectList: List<Subject>
)
