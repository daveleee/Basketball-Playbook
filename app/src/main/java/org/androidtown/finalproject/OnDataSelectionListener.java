package org.androidtown.finalproject;


import android.view.View;
import android.widget.AdapterView;


public interface OnDataSelectionListener {
//아이템이 선택되었을때 호출되는 메서드
    public void onDataSelected(AdapterView parent, View v, int position, long id);

}