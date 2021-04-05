package com.example.android_viewmodel_factory_example_in_kotlin.Repository

import com.example.android_viewmodel_factory_example_in_kotlin.Model.User

class UserRepository {

    fun getUserData():List<User>
    {
        val userList=ArrayList<User>()
        userList.add(User("Mithun"))
        userList.add(User("Riju"))
        userList.add(User("Beporna"))
        userList.add(User("Pori"))
        userList.add(User("Janemon"))
        userList.add(User("Shuna"))
        userList.add(User("Paki"))
        userList.add(User("Baby"))
        userList.add(User("Rupaa"))
        return userList
    }

}


