package com.example.roomdbdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

public class EditNoteViewModel extends AndroidViewModel {

    private String TAG=this.getClass().getSimpleName();
    private NoteDAO noteDAO;
    private NoteRoomDataBase db;

    public EditNoteViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "Edit ViewModel");
        db = NoteRoomDataBase.getDataBase(application);
        noteDAO = db.noteDao();
    }

    public LiveData<Note> getNote(String noteId){
        return noteDAO.getNote(noteId);
    }
}
