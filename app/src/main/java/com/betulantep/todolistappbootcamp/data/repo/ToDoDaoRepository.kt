package com.betulantep.todolistappbootcamp.data.repo

import androidx.lifecycle.MutableLiveData
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.room.ToDoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoDaoRepository(var tododao: ToDoDao) {
    val todolist : MutableLiveData<List<ToDo>> = MutableLiveData()

    fun getTodosRepo() : MutableLiveData<List<ToDo>>{
        return todolist
    }

    fun getAllTodosRepo(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            todolist.value = tododao.getTodos()
        }
    }

    fun addTodoRepo(todo_work:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = ToDo(0,todo_work)
            tododao.addTodo(todo)
        }
    }

    fun updateTodoRepo(todo_id: Int,todo_work: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = ToDo(todo_id,todo_work)
            tododao.updateTodo(todo)
        }
    }

    fun deleteTodoRepo(todo_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val todo = ToDo(todo_id,"")
            tododao.deleteTodo(todo)
            getAllTodosRepo()
        }
    }

    fun searchTodoRepo(searchWord:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            todolist.value = tododao.searchTodo(searchWord)
        }
    }

}