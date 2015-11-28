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
import android.widget.EditText;
import android.widget.TextView;
public class TransferActivity extends AppCompatActivity {
    UserAccountModel model;
    private Button cancelButton;
    private Button acceptButton;
    private TextView senderName;
    private TextView senderAmount;
    private TextView receiverName;
    private TextView receiverAmount;
    private EditText editText;

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

        initViews();
    }

    private void initViews(){
        final Context context = this;
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                model.transferFromAccount = -1;
                model.transferToAccount = -1;
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
        acceptButton = (Button) findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                transferRequest();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
        editText = (EditText) findViewById(R.id.editText);

        senderName = (TextView) findViewById(R.id.senderName);
        senderName.setText(model.getSenderAccountName());
        senderAmount = (TextView) findViewById(R.id.senderAmount);
        senderAmount.setText(model.getSenderAccountAmount());
        receiverName = (TextView) findViewById(R.id.receiverName);
        receiverName.setText(model.getReceiverAccountName());
        receiverAmount = (TextView) findViewById(R.id.receiverAmount);
        receiverAmount.setText(model.getReceiverAccountAmount());
    }

    private void transferRequest(){
        double amount = Double.valueOf(String.valueOf(editText.getText()));
        model.performTransfer(amount);
    }
}
