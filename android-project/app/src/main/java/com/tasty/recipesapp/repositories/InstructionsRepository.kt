package com.tasty.recipesapp.repositories

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.data.dto.InstructionDTO
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.data.models.InstructionTime


class InstructionRepository : IGenericRepository<InstructionDTO, InstructionModel> {
    override fun InstructionDTO.toModel(): InstructionModel {
        return InstructionModel(
            id = this.id,
            displayText = this.displayText,
            time = InstructionTime(this.startTime, this.endTime)
        )
    }

    override fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }


}