package org.androidtown.finalproject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalendarActivity extends ActionBarActivity {

    CalendarMonthView monthView; //���� Ķ���� �� ��ü
    CalendarMonthAdapter monthViewAdapter; //���� Ķ���� �����
    TextView monthText; //�� ǥ��

    int curYear; //���� �⵵
    int curMonth; //���� ��

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        monthView = (CalendarMonthView) findViewById(R.id.monthView); //���� Ķ������ ��ü ���
        monthViewAdapter = new CalendarMonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);

        monthView.setOnDataSelectionListener(new OnDataSelectionListener() {
            public void onDataSelected(AdapterView parent, View v, int position, long id) { //�����ʼ���

                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position); //���� ������ ���� ����ǥ��
                int year = monthViewAdapter.getCurYear();
                int month = (monthViewAdapter.getCurMonth() + 1);
                int day = curItem.getDay();

                Toast.makeText(getApplicationContext(), "Selected : "
                        + year + "year " + month + "month " + day + "day", Toast.LENGTH_LONG).show();
            }
        });

        monthText = (TextView) findViewById(R.id.monthText);
        setMonthText();

        Button monthPrevious = (Button) findViewById(R.id.monthPrevious); //�������� �Ѿ�� �̺�Ʈó��(ȭ�鰻��)
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        Button monthNext = (Button) findViewById(R.id.monthNext); //�������� �Ѿ�� �̺�Ʈó��(ȭ�鰻��)
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });
    }

    private void setMonthText() { //��ǥ�� �ý�Ʈ ����
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "year " + (curMonth+1) + "month");
    }
}