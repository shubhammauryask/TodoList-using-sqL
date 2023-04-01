package com.example.todolist

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

                 //  Discribe what table the table to be like
object TodoTable{                       // Object are Saglaton Classes
    val TABLE_NAME = "todos"
    object Columns{              //Create Columns and add id,task and Done
        val ID = "id"
        val Task = "task"
        val Done = "done"
    }
                               ///we Created String  and  Adding them  using Triple code String like."""

    val CMD_CREATE_TABLE = """|CREATE TABLE IF NOT EXISTS $TABLE_NAME(${Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        |${Columns.Task} TEXT,${Columns.Done} BO0LEAN );""".trimMargin()

    fun insertTodo(db: SQLiteDatabase,todo:Todo) {
        val row = ContentValues()   //Creating new row which Have
        row.put(Columns.Task,todo.task) // task
        row.put(Columns.Done,todo.done) //Done

        db.insert(TABLE_NAME,null,row) //insert
    }
      

    fun getAllTodos(db:SQLiteDatabase):ArrayList<Todo>{
        val todos =  ArrayList<Todo>()
        val c =  db.query(    // function that take all the Query syntext And Give us Cursul like,c which  move in while loop
          TABLE_NAME,
          arrayOf(Columns.ID,Columns.Task,Columns.Done),
          null,null,null,null,null

      )
        while (c.moveToNext()){  // To go to Next Row And Add all the Todo
           val todo = Todo(c.getString(1), c.getInt(2) == 1)
            todos.add(todo)
        }
        return todos
    }
}
