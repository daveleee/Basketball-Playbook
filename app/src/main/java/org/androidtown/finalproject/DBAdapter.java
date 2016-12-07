package org.androidtown.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by LDH on 2015-06-21.
 */
public class DBAdapter extends CursorAdapter{
    public DBAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView pname=(TextView)view.findViewById(R.id.pname_entry);
        final TextView matchteam=(TextView)view.findViewById(R.id.matchteam_entry);
        final TextView get=(TextView)view.findViewById(R.id.get_entry);
        final TextView rebound=(TextView)view.findViewById(R.id.rebound_entry);
        final TextView steal=(TextView)view.findViewById(R.id.steal);
        final TextView block=(TextView)view.findViewById(R.id.block_entry);
        final TextView threepoint=(TextView)view.findViewById(R.id.threepoint_entry);
        final TextView freethrow=(TextView)view.findViewById(R.id.freethrow_entry);

        pname.setText("NAME : "+cursor.getString(cursor.getColumnIndex("p_name")));
        matchteam.setText("MATCH : "+cursor.getString(cursor.getColumnIndex("match_team")));
        get.setText("GET : "+cursor.getString(cursor.getColumnIndex("get")));
        rebound.setText("REBOUND : "+cursor.getString(cursor.getColumnIndex("rebound")));
        steal.setText("STEAL : "+cursor.getString(cursor.getColumnIndex("steal")));
        block.setText("BLOCK : "+cursor.getString(cursor.getColumnIndex("block")));
        threepoint.setText("THREE POINT : "+cursor.getString(cursor.getColumnIndex("three_point")));
        freethrow.setText("FREE THROW : "+cursor.getString(cursor.getColumnIndex("free_throw")));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.itemlist, parent, false);

        return v;
    }


}
