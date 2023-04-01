package com.example.todolist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.todolist.TodoTable

// Database Related code     Using SqLiteOpenHelper too make easy to create database and excess and read and write
class MyDbHelper(context: Context):SQLiteOpenHelper(
    context,
    "todos.db",
    null,
    1    // when eskemo changes then change no of version , if we and one more type to add like cityName
){
    override fun onCreate(db: SQLiteDatabase?) {
        // Creating table for Todo  with we have to shave, like Modle.kt //
     db?.execSQL(TodoTable.CMD_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}

