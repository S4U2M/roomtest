package com.example.roomtest.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "list_table")
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int
)

// 1 대 다 구조가 필요함
// join을 통한 데이터를 자기고 와야 함.
// room db와 firebase 둘 다 사용하는게 과연 맞는가? << 이득이 무엇인가?
// 전부 firebase에 올리면 되는게 아닌가?
// 하나에 집중을 해보자
//

data class ListWithTextAndWord(
    @Embedded
    val listEntity: ListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val textList: List<TextEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val wordList: List<WordEntity>
)

