package com.example.CleanArchitecture.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tittle : String? = null,
    val description : String? = null
        )