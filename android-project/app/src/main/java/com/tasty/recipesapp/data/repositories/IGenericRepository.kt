package com.tasty.recipesapp.data.repositories

import android.content.Context

interface IGenericRepository<T> {
    fun getAll(context: Context): List<T>

}