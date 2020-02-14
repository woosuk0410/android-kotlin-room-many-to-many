package com.example.myapplication.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.model.data.Student
import com.example.myapplication.model.data.SSJoin
import com.example.myapplication.model.data.Subject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [(Student::class), (Subject::class), (SSJoin::class)], version = 1, exportSchema = false)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun myDao(): MyDao

    companion object {

        @Volatile
        private var INSTANCE: MyRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MyRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, MyRoomDatabase::class.java, "my_database").addCallback(MyDatabaseCallback(scope)).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }

        private class MyDatabaseCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.myDao())
                    }
                }
            }
        }

        fun populateDatabase(myDao: MyDao) {

            myDao.insert(Student(1, "aaa"))
            myDao.insert(Student(2, "bbb"))

            myDao.insert(Subject(1, "Math"))
            myDao.insert(Subject(2, "Science"))

            myDao.insert(SSJoin(1, 1))
            myDao.insert(SSJoin(1, 2))
            myDao.insert(SSJoin(2, 1))
            myDao.insert(SSJoin(2, 2))
        }

    }
}