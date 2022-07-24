package com.betulantep.todolistappbootcamp.room

import androidx.room.*
import com.betulantep.todolistappbootcamp.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todos")
    suspend fun getTodos() : List<ToDo>

    @Insert
    suspend fun addTodo(toDo: ToDo)

    @Update
    suspend fun updateTodo(toDo: ToDo)

    @Delete
    suspend fun deleteTodo(toDo: ToDo)

    @Query("SELECT * FROM todos WHERE todo_work like '%' || :searchWord || '%'")
    suspend fun searchTodo(searchWord:String) : List<ToDo>
}