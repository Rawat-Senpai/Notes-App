package com.example.ultimatenote2_0

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_.view.*
import kotlinx.coroutines.job


class list_Fragment : Fragment(),androidx.appcompat.widget.SearchView.OnQueryTextListener{

    lateinit var mUserViewModel: UserViewModel

//   val mUserViewModel: UserViewModel by lazy {
//     ViewModelProvider(this).get(UserViewModel::class.java)
// }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list_, container, false)

        val recyclerView=view.recyclerView
        val adapter =ListAdapter()
        recyclerView.adapter=adapter
        recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)//.apply { recyclerView.layoutManager = this}

        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->
            adapter.setData(user)
        })

        view.addBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_list_Fragment_to_add_Fragment)
        }
        return  view
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.search_menue,menu)
//        val searchView= search?.actionView as? androidx.appcompat.widget.SearchView
//        searchView?.isSubmitButtonEnabled=true
//        searchView?.setOnQueryTextListener(this)
//
//    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }
}