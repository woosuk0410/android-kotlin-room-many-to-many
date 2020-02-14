package com.example.myapplication.model.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(@PrimaryKey @NonNull @ColumnInfo val subjectId: Int = 0, @NonNull @ColumnInfo val subjectName: String = "nosubject")