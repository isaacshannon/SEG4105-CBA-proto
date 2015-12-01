package com.studio.wri.cba_app;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
public class TransactionsActivity extends AppCompatActivity {
    ListView listView ;
    UserAccountModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling CBA help line...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //check if an existing user account has been passed
        Intent i = getIntent();
        Serializable extras = i.getSerializableExtra("model");
        if(extras != null) {
            model = (UserAccountModel) i.getSerializableExtra("model");
        }

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, model.transactions);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }
}
