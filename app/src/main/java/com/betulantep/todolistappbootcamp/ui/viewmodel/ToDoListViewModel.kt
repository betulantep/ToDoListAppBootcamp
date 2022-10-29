package com.betulantep.todolistappbootcamp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(var repoTodo: ToDoDaoRepository) : ViewModel() {
    var todolist : MutableLiveData<List<ToDo>> = MutableLiveData()
    var isSwap : MutableLiveData<Boolean> = MutableLiveData()
    init {
        getIsSwap()
        todosLoad()
       todolist = repoTodo.getTodosRepo()
    }

    fun getIsSwap(){
        isSwap = repoTodo.getIsSwap()
    }

    fun todosLoad(){
        repoTodo.getAllTodosRepo()
    }

    fun deleteTodo(todo_id:Int){
        repoTodo.deleteTodoRepo(todo_id)
    }

    fun searchTodo(searchWord:String){
        repoTodo.searchTodoRepo(searchWord)
    }
}