package com.studio.wri.cba_app;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class AccountsFragment extends ListFragment implements OnItemClickListener {
    UserAccountModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get the user's account model
        MainActivity mainActivity = ((MainActivity)getActivity());
        model = mainActivity.model;

        ArrayAdapter adapter = new AccountsAdapter(this.getActivity(),model.getAccountTypes(),model.getAccountAmounts());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        model.selectedAccount = position;
        Intent i = new Intent(getActivity(), TransactionsActivity.class);
        i.putExtra("model", model);
        startActivity(i);
    }
}
