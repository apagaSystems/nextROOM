package com.example.roomapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>

//    @Query("SELECT title FROM notes")
//    suspend fun getAllNotesTitle(): Set<Note>
}