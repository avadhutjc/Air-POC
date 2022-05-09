package com.example.calendar_view.room

import androidx.room.*

@Dao
interface GraphDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(graphEntity: GraphEntity) //loginEntity is object and LoginEntity is table

    @Query("select * from graph_table where pointsOnGraphX = :pointX and pointsOnGraphY = :pointY")
    fun getUser(pointX: Float, pointY: Float): GraphEntity

    @Update
    fun updateUser(graphEntity: GraphEntity)

    @Delete
    fun deleteUser(graphEntity: GraphEntity)


}