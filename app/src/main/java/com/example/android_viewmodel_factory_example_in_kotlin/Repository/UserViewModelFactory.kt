package com.example.android_viewmodel_factory_example_in_kotlin.Repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_viewmodel_factory_example_in_kotlin.ViewModel.UserViewModel

class UserViewModelFactory (private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }


}