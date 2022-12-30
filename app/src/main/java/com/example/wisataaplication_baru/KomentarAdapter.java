package com.example.wisataaplication_baru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.viewholder> {
    public ArrayList<Komentar> listKomentar;

    public KomentarAdapter(ArrayList<Komentar> listKomentar){
        this.listKomentar = listKomentar;
    }

    @NonNull
    @Override
    public KomentarAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        viewholder holder = new viewholder(inflater.inflate(R.layout.item_komen, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KomentarAdapter.viewholder holder, int position) {
        Komentar komentar = listKomentar.get(position);
        holder.txtkomen.setText(komentar.getIsiKomentar());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                int newPosition = holder.getAdapterPosition();
                listKomentar.remove(newPosition);
                notifyItemRemoved(newPosition);
                notifyItemRangeChanged(newPosition, listKomentar.size());

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listKomentar.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        public TextView txtkomen;
        public LinearLayout itemView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            txtkomen = itemView.findViewById(R.id.txtkomen);
            this.itemView = (LinearLayout) itemView.findViewById(R.id.komen_layout);
        }
    }
}
