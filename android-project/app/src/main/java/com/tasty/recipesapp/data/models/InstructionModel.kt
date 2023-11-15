package com.tasty.recipesapp.data.models

import com.tasty.recipesapp.data.dto.InstructionDTO

data class InstructionModel(
    val id: Int,
    val display_text: String,
    val time: InstructionTime,
)

data class InstructionTime(
    val start_time: Int,
    val end_time: Int,
)


//fun InstructionDTO.toModel(): InstructionModel {
//    return InstructionModel(
//        id = this.id,
//        display_text = this.display_text,
//        time = InstructionTime(this.start_time,this.end_time),
//    )
//}
//fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
//    return this.map { it.toModel() }
//}