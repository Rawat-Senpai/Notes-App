package com.example.ultimatenote2_0

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_add_.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class updateFragment : Fragment() {

    private val args by navArgs<updateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateNote.setText(args.currentUser.nameTitle)
        view.updateBody.setText(args.currentUser.lastNote)

        view.updateBtn.setOnClickListener(){

            updateItem()
        }

        setHasOptionsMenu(true)

        return view;
    }


    private fun updateItem(){
        val mainHeading=updateNote.text.toString()
        val mainBody=updateBody.text.toString()


        if(isCheck(mainHeading,mainBody)){

          //  val updateUser=User(args.currentUser.id,mainBody,mainHeading)

           val updatedUser=User(args.currentUser.id,mainHeading,mainBody)
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"updated Successfully",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_list_Fragment)

        }
        else
        {
            Toast.makeText(requireContext(),"fill all data ",Toast.LENGTH_LONG).show()
        }

    }

    fun isCheck(mainHeading:String,mainBody:String):Boolean{
        return !(TextUtils.isEmpty(mainHeading) && TextUtils.isEmpty(mainBody))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.delete_menue,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_->
            mUserViewModel.deleteUser(args.currentUser)

            Toast.makeText(requireContext(),"Note Deleted Successfully ",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_list_Fragment)
        }
        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete Note")
        builder.setMessage("Are you sure you wamt to delete this note")
        builder.create().show()

    }


}