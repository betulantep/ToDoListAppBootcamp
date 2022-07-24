package com.betulantep.todolistappbootcamp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.betulantep.todolistappbootcamp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailToWorkToDoViewModel @Inject constructor(var repoTodo: ToDoDaoRepository) : ViewModel() {
    fun updateTodo(todo_id:Int,todo_work:String){
        repoTodo.updateTodoRepo(todo_id,todo_work)
    }
}