package com.betulantep.todolistappbootcamp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.betulantep.todolistappbootcamp.R
import com.betulantep.todolistappbootcamp.data.entity.ToDo
import com.betulantep.todolistappbootcamp.databinding.FragmentToDoListBinding
import com.betulantep.todolistappbootcamp.ui.adapter.ToDoAdapter
import com.betulantep.todolistappbootcamp.ui.viewmodel.ToDoListViewModel
import com.betulantep.todolistappbootcamp.utils.actionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoListFragment : Fragment(),SearchView.OnQueryTextListener{
    private lateinit var binding: FragmentToDoListBinding
    private lateinit var viewModel : ToDoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_list, container, false)
        binding.todoFragment = this
        binding.todoToolbar = R.string.toDoList
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarToDoList)

        viewModel.todolist.observe(viewLifecycleOwner){
            binding.todoAdapter = ToDoAdapter(it,viewModel)
            emptyListControl(it)
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel : ToDoListViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun emptyListControl(list: List<ToDo>){
        if(list.isEmpty()){
            binding.tvEmptyList.visibility = View.VISIBLE
        }else{
            binding.tvEmptyList.visibility = View.GONE
        }
    }
    fun fabClick(view: View) {
        Navigation.actionFragment(view,R.id.action_toDoListFragment_to_addWorkToDoFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)
        val item = menu.findItem(R.id.actionSearch)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchTodo(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchTodo(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.todosLoad()
    }
}