package com.example.ultimatenote2_0

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_.*
import kotlinx.android.synthetic.main.fragment_add_.view.*
import kotlinx.android.synthetic.main.fragment_list_.view.*


class add_Fragment : Fragment() {

      private lateinit var mUserViewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view= inflater.inflate(R.layout.fragment_add_, container, false)

        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)

        view.doneBtn.setOnClickListener(){
            insertDataToDatabase()

        }

        return  view
    }

    private fun insertDataToDatabase() {

          val mainBody=titleNote.text.toString()
          val mainHeading=bodyNote.text.toString()

        if(isCheck(mainHeading,mainBody)){
            val user=User(0,mainHeading,mainBody)

            mUserViewModel.insert(user)

            Toast.makeText(requireContext(),"Note is saved successfully ", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_add_Fragment_to_list_Fragment)

        }
        else{
            Toast.makeText(requireContext(),"Fill all data", Toast.LENGTH_SHORT).show()
        }

    }

    fun isCheck(mainHeading:String,mainBody:String):Boolean{
        return !(TextUtils.isEmpty(mainHeading) && TextUtils.isEmpty(mainBody))
    }

}