package com.example.android_viewmodel_factory_example_in_kotlin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_viewmodel_factory_example_in_kotlin.Adapter.UserAdapter
import com.example.android_viewmodel_factory_example_in_kotlin.Model.User
import com.example.android_viewmodel_factory_example_in_kotlin.R
import com.example.android_viewmodel_factory_example_in_kotlin.Repository.UserRepository
import com.example.android_viewmodel_factory_example_in_kotlin.Repository.UserViewModelFactory
import com.example.android_viewmodel_factory_example_in_kotlin.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val userRepository= UserRepository()
        val userViewModelFactory= UserViewModelFactory(userRepository)
        userViewModel= ViewModelProvider(this,userViewModelFactory)[UserViewModel::class.java]
        userViewModel.getData()
        userViewModel.userMutableLiveData.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<User>)
        })


        intiRecyclerView()

    }


    private fun intiRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        userAdapter= UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=userAdapter
        }
    }
}