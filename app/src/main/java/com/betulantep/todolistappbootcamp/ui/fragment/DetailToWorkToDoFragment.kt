package com.betulantep.todolistappbootcamp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.betulantep.todolistappbootcamp.R
import com.betulantep.todolistappbootcamp.databinding.FragmentDetailToWorkToDoBinding
import com.betulantep.todolistappbootcamp.ui.viewmodel.DetailToWorkToDoViewModel
import com.betulantep.todolistappbootcamp.utils.actionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailToWorkToDoFragment : Fragment() {
    private lateinit var binding: FragmentDetailToWorkToDoBinding
    private val navArgs: DetailToWorkToDoFragmentArgs by navArgs()
    private val viewModel: DetailToWorkToDoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_to_work_to_do,
            container,
            false
        )
        binding.detailFragment = this
        binding.detailToolbar = R.string.detailToWorkToDo
        binding.todoObject = navArgs.todo
        return binding.root
    }

    fun updateTodo(todo_id: Int, todo_work: String) {
        viewModel.updateTodo(todo_id, todo_work)
        Navigation.actionFragment(
            binding.root,
            DetailToWorkToDoFragmentDirections.actionDetailToWorkToDoFragmentToToDoListFragment()
        )
    }
}