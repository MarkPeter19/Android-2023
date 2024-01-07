package com.tasty.recipesapp.repositories

import android.content.Context

interface IGenericRepository<Td,Tm>{

    fun Td.toModel(): Tm
    fun List<Td>.toModelList(): List<Tm>
}