package com.example.roomdbdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = Note.class, version = 1)
public abstract class NoteRoomDataBase extends RoomDatabase {

    public abstract NoteDAO noteDao();

    private static volatile NoteRoomDataBase noteRoomInstance;

    static NoteRoomDataBase getDataBase(final Context context) {
        if (noteRoomInstance == null) {
            synchronized (NoteRoomDataBase.class) {
                if (noteRoomInstance == null) {
                    noteRoomInstance = Room.databaseBuilder(context.getApplicationContext(), NoteRoomDataBase.class, "note_database").build();
                }
            }
        }
        return noteRoomInstance;
    }
}
