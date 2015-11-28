package com.studio.wri.cba_app;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class TransferFragment extends ListFragment implements OnItemClickListener {
    UserAccountModel model;
    MainActivity parentActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get the user's account model
        parentActivity = ((MainActivity)getActivity());
        model = parentActivity.model;

        ArrayAdapter adapter = new TransferAdapter(this.getActivity(),model.getAccountTypes(),model.getAccountAmounts());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

        //if there is a from account, set a to account and start the transfer activity
        if(model.transferFromAccount > -1 && model.transferFromAccount != position){
            model.transferToAccount = position;
            parentActivity.startTransferActivity();
        } //if there is no from account, use this one
        else if(model.transferFromAccount == -1){
            model.transferFromAccount = position;
        } //if this is the from account, deselect it
        else if(model.transferFromAccount == position){
            model.transferFromAccount = -1;
        }

        View operation = view.findViewById(R.id.operation);
        if(model.transferFromAccount == position) {
            operation.setVisibility(View.VISIBLE);
        }else{
            operation.setVisibility(View.INVISIBLE);
        }
    }
}
