package com.studio.wri.cba_app;
/**
 * Created by isaac on 2015-11-27.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TransferAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] accountTypes;
    private final String[] accountAmounts;

    public TransferAdapter(Context context, String[] types, String[] amounts) {
        super(context, -1, types);
        this.context = context;
        this.accountTypes = types;
        this.accountAmounts = amounts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.transfer_row_layout, parent, false);

        TextView accountText = (TextView) rowView.findViewById(R.id.firstLine);
        TextView amountText = (TextView) rowView.findViewById(R.id.secondLine);
        accountText.setText(accountTypes[position]);
        amountText.setText(accountAmounts[position]);
        return rowView;
    }
}
