package com.sheygam.java_18_09_04_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyItemClickListener, View.OnClickListener {

    private RecyclerView myList;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        adapter = new MyAdapter(this);
        myList = findViewById(R.id.my_list);
        myList.setLayoutManager(manager);
        myList.setAdapter(adapter);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        myList.addItemDecoration(divider);

        findViewById(R.id.add_btn)
                .setOnClickListener(this);

    }

    @Override
    public void onItemClick(Person p, int position) {
        Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            adapter.addPerson(new Person("New Person","newemail@mail.com",""));
        }
    }
}
