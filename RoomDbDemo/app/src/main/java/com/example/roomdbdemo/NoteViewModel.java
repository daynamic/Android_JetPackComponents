package com.example.roomdbdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private String TAG=this.getClass().getSimpleName();
    private NoteDAO noteDAO;
    private NoteRoomDataBase noteDB;
    private LiveData<List<Note>> mAllNotes;

    public NoteViewModel(Application application){
        super(application);

        noteDB=NoteRoomDataBase.getDataBase(application);
        noteDAO=noteDB.noteDao();
        mAllNotes=noteDAO.getAllNotes();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDAO).execute(note);
    }

    public void update(Note note){
        new UpdateAsyncTask(noteDAO).execute(note);
    }

    public void delete(Note note){
        new DeleteAsyncTask(noteDAO).execute(note);
    }
    LiveData<List<Note>> getmAllNotes(){
        return mAllNotes;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }

    private class OperationsAsyncTask extends AsyncTask<Note, Void, Void>{

        NoteDAO mAsyncTaskDao;

         OperationsAsyncTask(NoteDAO dao) {
            this.mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask{


        InsertAsyncTask(NoteDAO mNoteDAO) {
            super(mNoteDAO);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends OperationsAsyncTask{


        UpdateAsyncTask(NoteDAO noteDAO) {
            super(noteDAO);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.Update(notes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends OperationsAsyncTask{


        DeleteAsyncTask(NoteDAO noteDAO) {
            super(noteDAO);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.delete(notes[0]);
            return null;
        }
    }
}
