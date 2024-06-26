package com.example.firstmvvm.data.repo

import com.example.firstmvvm.data.db.AppDatabase
import com.example.firstmvvm.data.db.entities.User
import com.example.firstmvvm.data.network.MyApi
import com.example.firstmvvm.data.network.SafeApiRequest

class UserRepository(
    private val api: MyApi, private val db: AppDatabase
) : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): User? = apiRequest {
        api.userLogin(email, password)
    }

    suspend fun saveUser(user: User) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()

    suspend fun userSignUp(
        firstName: String,
        lastName: String,
        age: String,
        email: String,
        username: String,
        password: String
    ): User? {
        return apiRequest {
            api.userSignUp(
                firstName, lastName, age, email, username, password
            )
        }
    }

}