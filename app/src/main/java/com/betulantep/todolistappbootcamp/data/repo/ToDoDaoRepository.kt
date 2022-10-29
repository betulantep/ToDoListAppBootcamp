package com.betulantep.todolistappbootcamp.data.repo

import androidx.lifecycle.MutableLiveData
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.room.ToDoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ToDoDaoRepository(var tododao: ToDoDao) {
    val todolist : MutableLiveData<List<ToDo>> = MutableLiveData()
    private var job : Job? = null
    var isSwap = MutableLiveData(false)

    fun getTodosRepo() : MutableLiveData<List<ToDo>>{
        return todolist
    }
    fun getIsSwap() : MutableLiveData<Boolean>{
        return isSwap
    }


    fun getAllTodosRepo(){
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            if(isSwap.value == false){
                todolist.value = tododao.getTodos()
            }else{
                todolist.value = tododao.getTodosDesc()
            }
        }
    }

    fun addTodoRepo(todo_work:String){
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            val todo = ToDo(0,todo_work)
            tododao.addTodo(todo)
        }
    }

    fun updateTodoRepo(todo_id: Int,todo_work: String){
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            val todo = ToDo(todo_id,todo_work)
            tododao.updateTodo(todo)
        }
    }

    fun deleteTodoRepo(todo_id:Int){
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            val todo = ToDo(todo_id,"")
            tododao.deleteTodo(todo)
            getAllTodosRepo()
        }
    }

    fun searchTodoRepo(searchWord:String){
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            todolist.value = tododao.searchTodo(searchWord)
        }
    }

}