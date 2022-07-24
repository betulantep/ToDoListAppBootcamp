package com.betulantep.todolistappbootcamp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.betulantep.todolistappbootcamp.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getToDoDao() : ToDoDao
}