package com.betulantep.todolistappbootcamp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddWorkToDoViewModel @Inject constructor(var repoTodo: ToDoDaoRepository) : ViewModel() {

    fun addTodo(todo_work:String){
        repoTodo.addTodoRepo(todo_work)
    }
}