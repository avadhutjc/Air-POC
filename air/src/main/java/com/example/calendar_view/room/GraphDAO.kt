package com.example.calendar_view.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GraphDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(graphEntity: GraphEntity) //loginEntity is object and LoginEntity is table

    @Query("select * from graph_table")
    fun getUser(): LiveData<List<GraphEntity>>

    @Update
    fun updateUser(graphEntity: GraphEntity)

    @Delete
    fun deleteUser(graphEntity: GraphEntity)


}
/*
    @Query("select * from graph_table")
    fun getUser(): List<GraphEntity>
 */