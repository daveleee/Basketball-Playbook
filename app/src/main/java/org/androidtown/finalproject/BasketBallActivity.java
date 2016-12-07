package org.androidtown.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BasketBallActivity extends Activity implements View.OnTouchListener {

    // 이미지 이동을 위한 변수
    private RelativeLayout rlPitch;
    private int _xDelta;
    private int _yDelta;
    // 타이머를 위한 변수
    private int val=91; //남은 시간에 대한 초기값
    private TextView timer; //남은 시간을 띄워줄 TextView 변수 선언
    Handler handler; //UI상에 접근하기위한 핸들러 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        // Init list of team member 이미지 이동에 관련된 코드
        rlPitch = (RelativeLayout)findViewById(R.id.rlPitch);

        initTeam();
        // Timer 생성과 관련된 코드
        timer=(TextView)findViewById(R.id.timer);
        handler=new Handler()
        {
            public void handleMessage(Message msg)
            {
                val--;
                timer.setText(""+val);
                if(val>0)
                {
                    handler.sendEmptyMessageDelayed(-1, 1000); // 1초에 1씩 감소(1000 = 1초)
                }
                else if(val==0)
                {
                    Toast.makeText(getApplication(),"작전 타임 종료!",Toast.LENGTH_LONG).show();
                }
            }
        };
        handler.sendEmptyMessage(0);
        // timer 생성과 관련된 코드 종료


    }

    public void initTeam() {

        int iDisplayWidth = getResources().getDisplayMetrics().widthPixels;
        int iDisplayHeight = getResources().getDisplayMetrics().heightPixels;

        int iMemberWidth = iDisplayWidth/8;
        for(int i = 0 ; i < 5; i++) {

            // Init member and set imageresource, position follow image size
            ImageView imgMembert1 = new ImageView(getApplicationContext());
            imgMembert1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgMembert1.setBackgroundResource(getResources().getIdentifier("t1_" + (i + 1), "drawable", getPackageName()));

            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(iMemberWidth, iMemberWidth);

            lp1.setMargins(iDisplayWidth - iMemberWidth * 2, iDisplayHeight - (5 - i + 1) * iMemberWidth, 0, 0);

            imgMembert1.setLayoutParams(lp1);
            // Touch on member to move it
            imgMembert1.setOnTouchListener(this);

            rlPitch.addView(imgMembert1);
        }
        for(int i=0;i<5;i++) {
            ImageView imgMembert2 = new ImageView(getApplicationContext());
            imgMembert2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgMembert2.setBackgroundResource(getResources().getIdentifier("t2_" + (i+1), "drawable", getPackageName()));

            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(iMemberWidth, iMemberWidth);
            lp2.setMargins(iDisplayWidth-iMemberWidth, iDisplayHeight-(5-i + 1)*iMemberWidth, 0, 0);

            imgMembert2.setLayoutParams(lp2);
            // Touch on member to move it
            imgMembert2.setOnTouchListener(this);

            rlPitch.addView(imgMembert2);
        }

    }

    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub
        final int X = (int) arg1.getRawX();
        final int Y = (int) arg1.getRawY();
        switch (arg1.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) arg0.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) arg0.getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                arg0.setLayoutParams(layoutParams);
                break;
        }
        return true;
    }

}


