package com.betulantep.todolistappbootcamp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.betulantep.todolistappbootcamp.R
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.databinding.TodoRowLayoutBinding
import com.betulantep.todolistappbootcamp.ui.fragment.ToDoListFragmentDirections
import com.betulantep.todolistappbootcamp.ui.viewmodel.ToDoListViewModel
import com.betulantep.todolistappbootcamp.utils.actionFragment
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(val toDoList: List<ToDo>, val viewModel: ToDoListViewModel) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    class ToDoViewHolder(val binding: TodoRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = DataBindingUtil.inflate<TodoRowLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.todo_row_layout, parent, false
        )
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) = with(holder) {
        val mContext = binding.root.context
        val todo = toDoList[position]

        binding.todoObject = todo
        binding.cardViewToDo.setOnClickListener {
            Navigation.actionFragment(
                it,
                ToDoListFragmentDirections.actionToDoListFragmentToDetailToWorkToDoFragment(todo = todo)
            )
        }
        binding.ivToDoDelete.setOnClickListener {
            Snackbar.make(it, R.string.areYouSureToDelete, Snackbar.LENGTH_LONG)
                .setAction(R.string.yes) {
                    viewModel.deleteTodo(todo.todo_id)
                }.show()

        }
    }

    override fun getItemCount(): Int = toDoList.size
}