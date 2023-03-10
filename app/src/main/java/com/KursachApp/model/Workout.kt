package com.KursachApp.model

import java.util.*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var date: Date? = null,
    var reminder: Long? = null,
    var completed: Boolean = false
) {
    companion object {
        fun newInstance(): Workout =
            Workout(name = Workout::class.java.simpleName)
    }
}