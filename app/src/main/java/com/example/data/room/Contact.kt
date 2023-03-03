package com.example.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")

data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "hospitalName")
    var hospitalName: String,

    @ColumnInfo(name = "hospitalType")
    var hospitalType: String,

    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}
