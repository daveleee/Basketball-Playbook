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
        private Bitmap image; //�̹��� �ҷ��������� ����
        Canvas onCanvas;
        Point ptStart=new Point();


        public DrawLine(Context context) {
            super(context);
            Resources r=context.getResources();
            //image= BitmapFactory.decodeResource(r, R.drawable.court1_copy); //�̹��� ����

            Bitmap tempImg=BitmapFactory.decodeResource(r, R.drawable.court1_copy); //�ӽ� �̹�������
            image=tempImg.copy(Bitmap.Config.ARGB_8888, true); //��Ʈ���̹����� ĵ������ ����
            onCanvas=new Canvas(image); //��Ʈ�ʰ� �����Ǵ� ĵ���� ����
        }

        //�̹��� ����
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(image, null, new Rect(0,0,this.getWidth(),this.getHeight()),null);

        }

        //��ġ�̺�Ʈ ����
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

                //�̹����� �׸� �׸���
                Paint pnt=new Paint();
                pnt.setColor(Color.RED);
                pnt.setStrokeWidth(5);
                onCanvas.drawLine(ptStart.x, ptStart.y, event.getX(), event.getY(), pnt);
                this.invalidate(); //ȭ�� ����
            }

            ptStart.x=(int)event.getX(); //������ ������ �׸��� ���� ���� ��ġ��ġ��ǥ�� ����
            ptStart.y=(int)event.getY();

            return true;
        }
    }
}
