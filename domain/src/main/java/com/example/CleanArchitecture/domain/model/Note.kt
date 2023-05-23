package com.example.CleanArchitecture.domain.model

class Note(
    val id: Int = DEFAULT_ID,
    var tittle: String? = null,
    var description: String? = null
): java.io.Serializable {
    companion object {
        const val  DEFAULT_ID = 0
    }
}