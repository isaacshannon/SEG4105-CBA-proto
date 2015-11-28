package com.studio.wri.cba_app;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
public class TransferActivity extends AppCompatActivity {
    UserAccountModel model;
    private Button cancelButton;
    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent i = getIntent();
        model = (UserAccountModel)i.getSerializableExtra("model");

        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initButtons();
    }

    private void initButtons(){
        final Context context = this;
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) { //travel to the exercise display screen
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
        acceptButton = (Button) findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) { //travel to the exercise display screen
                transferRequest();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
    }

    private void transferRequest(){
       model.performTransfer(0,1,55.50);
    }
}
