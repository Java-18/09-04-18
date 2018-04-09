package com.sheygam.java_18_09_04_18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Person>  persons;
    private MyItemClickListener listener;

    public MyAdapter(MyItemClickListener listener) {
        this.listener = listener;
        persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person("Person " + i,"person" + i + "@mail.com",""));
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MY_TAG", "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("MY_TAG", "onBindViewHolder: " + position);
        Person p = persons.get(position);
        holder.nameTxt.setText(p.getName());
        holder.emailTxt.setText(p.getEmail());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void addPerson(Person p){
        persons.add(2,p);
        notifyItemInserted(2);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView rowImg;
        private TextView nameTxt, emailTxt;
        public MyViewHolder(View itemView) {
            super(itemView);
            rowImg = itemView.findViewById(R.id.row_img);
            nameTxt = itemView.findViewById(R.id.name_txt);
            emailTxt = itemView.findViewById(R.id.email_txt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onItemClick(persons.get(getAdapterPosition()),getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface MyItemClickListener{
        void onItemClick(Person p, int position);
    }
}
