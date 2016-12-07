package org.androidtown.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawLineActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawLine drawLine = new DrawLine(this);
        setContentView(drawLine);
    }

    protected class DrawLine extends View
    {
        private Bitmap image; //이미지 불러오기위한 변수
        Canvas onCanvas;
        Point ptStart=new Point();


        public DrawLine(Context context) {
            super(context);
            Resources r=context.getResources();
            //image= BitmapFactory.decodeResource(r, R.drawable.court1_copy); //이미지 띄우기

            Bitmap tempImg=BitmapFactory.decodeResource(r, R.drawable.court1_copy); //임시 이미지변수
            image=tempImg.copy(Bitmap.Config.ARGB_8888, true); //비트맵이미지를 캔버스와 연동
            onCanvas=new Canvas(image); //비트맵과 연동되는 캔버스 생성
        }

        //이미지 띄우기
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(image, null, new Rect(0,0,this.getWidth(),this.getHeight()),null);

        }

        //터치이벤트 구현
        public boolean onTouchEvent(MotionEvent event)
        {
            super.onTouchEvent(event);
            if(event.getAction()==MotionEvent.ACTION_DOWN)
            {
                Log.d("tag", "TouchDown:"+(int)event.getX()+"/"+(int)event.getY());
            }
            else if(event.getAction()==MotionEvent.ACTION_MOVE)
            {
                Log.d("tag", "TouchMove:"+(int)event.getX()+"/"+(int)event.getY());

                //이미지에 그림 그리기
                Paint pnt=new Paint();
                pnt.setColor(Color.RED);
                pnt.setStrokeWidth(5);
                onCanvas.drawLine(ptStart.x, ptStart.y, event.getX(), event.getY(), pnt);
                this.invalidate(); //화면 갱신
            }

            ptStart.x=(int)event.getX(); //다음에 라인을 그리기 위해 현재 터치위치좌표를 저장
            ptStart.y=(int)event.getY();

            return true;
        }
    }
}
