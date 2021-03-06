package com.abhinav.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import org.w3c.dom.Text;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteHolder>{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See
     * {@link FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
   // private OnItemClickListener listener;
    public NoteAdapter(FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(NoteHolder noteHolder, int i, Note note) {
        noteHolder.textViewTitle.setText(note.getTitle());
        noteHolder.textViewDescription.setText(note.getDescription());
        noteHolder.textViewPriority.setText(String.valueOf(note.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false);
        return new NoteHolder(v);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int postion = getAdapterPosition();
//                    if(postion != RecyclerView.NO_POSITION && listener != null){
//                        listener.onItemClick(getSnapshots().getSnapshot(postion),postion);
//                    }
//                }
//            });
        }
    }

//    public interface OnItemClickListener{
//        void onItemClick(DocumentSnapshot documentSnapshot,int position);
//    }
//
//    public  void setOnItemClickListener(OnItemClickListener listener){
//        this.listener = listener;
//    }
}
