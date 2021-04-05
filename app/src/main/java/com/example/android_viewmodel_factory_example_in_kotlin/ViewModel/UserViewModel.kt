package com.example.android_viewmodel_factory_example_in_kotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_viewmodel_factory_example_in_kotlin.Model.User
import com.example.android_viewmodel_factory_example_in_kotlin.Repository.UserRepository

class UserViewModel (private val userRepository: UserRepository):ViewModel(){

    val userMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun getData()
    {
        val response=userRepository.getUserData()
        userMutableLiveData.value=response
    }

}