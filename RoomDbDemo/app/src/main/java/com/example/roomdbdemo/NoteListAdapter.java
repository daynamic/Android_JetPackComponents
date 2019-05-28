package com.example.roomdbdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    public interface onDeleteClickListener{
        void onDeleteClickListener(Note myNote);
    }

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<Note> mNote;
    private onDeleteClickListener onDeleteClickListener;

    public NoteListAdapter(Context context, onDeleteClickListener listener) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
        this.onDeleteClickListener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        NoteViewHolder viewHolder = new NoteViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (mNote != null) {
            Note note = mNote.get(position);
            holder.setData(note.getNote(), position);
            holder.setListeners();
        } else {
            holder.noteItemView.setText(R.string.not_saved);
        }
    }

    @Override
    public int getItemCount() {
        if (mNote != null)
            return mNote.size();
        else
            return 0;
    }

    public void setNotes(List<Note> notes) {
        mNote = notes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView noteItemView;
        private int mPosition;
        private ImageView imgDelete, imgEdit;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteItemView = itemView.findViewById(R.id.txvNote);
            imgDelete = itemView.findViewById(R.id.ivRowDelete);
            imgEdit = itemView.findViewById(R.id.ivRowEdit);

        }

        public void setData(String note, int position) {
            noteItemView.setText(note);
            mPosition = position;
        }

        public void setListeners() {
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mContext,EditNoteActivity.class);
                    intent.putExtra("note_id",mNote.get(mPosition).getId());
                    ((Activity)mContext).startActivityForResult(intent,MainActivity.UPDATE_NOTE_ACTIVITY_REQUEST_CODE);
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onDeleteClickListener!=null){
                        onDeleteClickListener.onDeleteClickListener(mNote.get(mPosition));
                    }
                }
            });
        }
    }
}
