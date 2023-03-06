package com.example.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//Entity - Database 안에 있는 테이블을 Java나 Kotlin 클래스로 나타낸 것이다. 데이터 모델 클래스라고 볼 수 있다.
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
