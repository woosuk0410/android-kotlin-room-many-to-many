package com.example.myapplication.model.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(@PrimaryKey @NonNull @ColumnInfo val studjentId: Int = 0, @NonNull @ColumnInfo val studjentName: String = "noname")