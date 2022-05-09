package com.example.calendar_view.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "graph_table")
data class GraphEntity(
    //  @ColumnInfo(name = "name") var name: String,
//    @ColumnInfo(name = "email") var email: String,
    //  @ColumnInfo(name = "age") var age: Int,
//    @ColumnInfo(name = "password") var password: String

    @ColumnInfo(name = "pointsOnGraphX") var xPoints: Float,
    @ColumnInfo(name = "pointsOnGraphY") var yPoints: Float
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    //@ColumnInfo(name = "id")
    // var id: Int? = null

}