package com.example.myapplication.model.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    primaryKeys = arrayOf("stuId", "subId"),
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Student::class,
            parentColumns = arrayOf("studjentId"),
            childColumns = arrayOf("stuId"),
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Subject::class,
            parentColumns = arrayOf("subjectId"),
            childColumns = arrayOf("subId"),
            onDelete = ForeignKey.NO_ACTION
        )
    ), indices = [Index(value = ["stuId"]), Index(value = ["subId"])]
)
data class SSJoin(
    val stuId: Int = 0, val subId: Int = 0
)
