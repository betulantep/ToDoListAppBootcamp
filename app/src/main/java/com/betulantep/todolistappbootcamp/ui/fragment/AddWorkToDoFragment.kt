package com.betulantep.todolistappbootcamp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.betulantep.todolistappbootcamp.R
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.databinding.FragmentAddWorkToDoBinding
import com.betulantep.todolistappbootcamp.ui.viewmodel.AddWorkToDoViewModel
import com.betulantep.todolistappbootcamp.utils.actionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWorkToDoFragment : Fragment() {
    private lateinit var binding: FragmentAddWorkToDoBinding
    private val viewModel: AddWorkToDoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_work_to_do, container, false)
        binding.addFragment = this
        binding.addToolbar = R.string.addWorkToDo
        return binding.root
    }

    fun addTodo(todo_work: String) {
        viewModel.addTodo(todo_work)
        Navigation.actionFragment(
            binding.root,
            AddWorkToDoFragmentDirections.actionAddWorkToDoFragmentToToDoListFragment()
        )
    }
}