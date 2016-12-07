package org.androidtown.finalproject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalendarActivity extends ActionBarActivity {

    CalendarMonthView monthView; //월별 캘린더 뷰 객체
    CalendarMonthAdapter monthViewAdapter; //월별 캘린더 어댑터
    TextView monthText; //월 표시

    int curYear; //현재 년도
    int curMonth; //현재 월

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        monthView = (CalendarMonthView) findViewById(R.id.monthView); //월별 캘린더뷰 객체 등록
        monthViewAdapter = new CalendarMonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);

        monthView.setOnDataSelectionListener(new OnDataSelectionListener() {
            public void onDataSelected(AdapterView parent, View v, int position, long id) { //리스너설정

                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position); //현재 선택한 일자 정보표시
                int year = monthViewAdapter.getCurYear();
                int month = (monthViewAdapter.getCurMonth() + 1);
                int day = curItem.getDay();

                Toast.makeText(getApplicationContext(), "Selected : "
                        + year + "year " + month + "month " + day + "day", Toast.LENGTH_LONG).show();
            }
        });

        monthText = (TextView) findViewById(R.id.monthText);
        setMonthText();

        Button monthPrevious = (Button) findViewById(R.id.monthPrevious); //이전월로 넘어가는 이벤트처리(화면갱신)
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        Button monthNext = (Button) findViewById(R.id.monthNext); //다음월로 넘어가는 이벤트처리(화면갱신)
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });
    }

    private void setMonthText() { //월표시 택스트 설정
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "year " + (curMonth+1) + "month");
    }
}