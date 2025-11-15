package com.example.androidjava.lesson_8_todo_list;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Insert
    Completable add(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    void remove(int id);
}
