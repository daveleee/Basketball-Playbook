package org.androidtown.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends ActionBarActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6; //menu activity의 각 메뉴당 버튼변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); //menu.xml 메모리상에 등록
        btn1 = (Button)findViewById(R.id.btn1); //1번메뉴 등록
        btn2 = (Button)findViewById(R.id.btn2); //2번메뉴 등록
        btn3=(Button)findViewById(R.id.btn3);   //3번메뉴 등록
        btn4=(Button)findViewById(R.id.btn4);   //4번메뉴 등록
        btn5=(Button)findViewById(R.id.btn5);   //5번메뉴 등록
        btn6=(Button)findViewById(R.id.btn6);   //6번메뉴 등록

        //버튼 1번에 대한 인텐트 생성
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BasketBallActivity.class);
                startActivity(intent);
            }
        });

        //버튼 2번에 대한 인텐드 생성
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DrawLineActivity.class);
                startActivity(intent2);
            }
        });

        //버튼 3번에 대한 인텐드 생성
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getApplicationContext(), TweenAnimationActivity.class);
                startActivity(intent3);
            }
        });

        //버튼 4번에 대한 인텐트 생성
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getApplicationContext(), ManagementActivity.class);
                startActivity(intent4);
            }
        });

        //버튼 5번에 대한 인텐트 생성
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent5);
            }
        });

        //버튼 6번에 대한 인텐트 생성
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent6);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); //메뉴 인플레이션
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
