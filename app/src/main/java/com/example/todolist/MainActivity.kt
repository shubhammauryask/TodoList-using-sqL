package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.todolist.db.MyDbHelper

class MainActivity : AppCompatActivity() {
    val todos = ArrayList<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        val db = MyDbHelper(this).writableDatabase  // get the database Reference with writableDataBase

          fun refreshTodoList(){  /// refresh my todoList
            val  todoList =   TodoTable.getAllTodos(db)
             todos.clear()
              todos.addAll(todoList)
              todoAdapter.notifyDataSetChanged()

          }
        val lvTodo:ListView = findViewById(R.id.lvTodos)
         lvTodo.adapter = todoAdapter
        val btnTodo:Button = findViewById(R.id.btnAdd)
        val etNewTodo:EditText = findViewById(R.id.edTextView)
        refreshTodoList()
        btnTodo.setOnClickListener{

            val newTodo  = Todo(
                etNewTodo.text.toString(),
                false
            )
            TodoTable.insertTodo(db,newTodo)
             refreshTodoList()

        }
    }

}