package org.androidtown.finalproject;


import android.view.View;
import android.widget.AdapterView;


public interface OnDataSelectionListener {
//�������� ���õǾ����� ȣ��Ǵ� �޼���
    public void onDataSelected(AdapterView parent, View v, int position, long id);

}