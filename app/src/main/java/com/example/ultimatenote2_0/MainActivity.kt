package com.example.ultimatenote2_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

   // lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)

    }
//
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menue,menu)
//        val search =menu?.findItem(R.id.menue_search)
//        val searchView= search?.actionView as? SearchView
//        searchView?.isSubmitButtonEnabled=true
//        searchView?.setOnQueryTextListener(this)
//        return true
//    }
//
//    override fun onQueryTextSubmit(query: String?): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun onQueryTextChange(newText: String?): Boolean {
//        TODO("Not yet implemented")
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId==R.id.menue_search){
//
//        }
//        return super.onOptionsItemSelected(item)
//    }


}