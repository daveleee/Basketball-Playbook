package org.androidtown.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenAnimationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweenanimation);

        //xml���� ��ġ�ߴ� �̹����並 ã�� image��� ��ü�� ���
        //�ִϸ��̼� ȿ����AnimationUtils()�޼��� �̿��ؼ� ani������
        //this(�� Ŭ����)�� ȣ���ϰ� animation�̶�� ��ü�� ���
        //startAnimation �޼ҵ� �̿��ؼ� ����
        ImageView image1=(ImageView)findViewById(R.id.t1_1);
        Animation animation1= AnimationUtils.loadAnimation(this, R.anim.ani1_1);
        image1.startAnimation(animation1);

        ImageView image2=(ImageView)findViewById(R.id.t1_2);
        Animation animation2= AnimationUtils.loadAnimation(this, R.anim.ani1_2);
        image2.startAnimation(animation2);

        ImageView image3=(ImageView)findViewById(R.id.t1_3);
        Animation animation3= AnimationUtils.loadAnimation(this, R.anim.ani1_3);
        image3.startAnimation(animation3);

        ImageView image4=(ImageView)findViewById(R.id.t1_4);
        Animation animation4= AnimationUtils.loadAnimation(this, R.anim.ani1_4);
        image4.startAnimation(animation4);

        ImageView image5=(ImageView)findViewById(R.id.t1_5);
        Animation animation5= AnimationUtils.loadAnimation(this, R.anim.ani1_5);
        image5.startAnimation(animation5);
//
        ImageView image6=(ImageView)findViewById(R.id.t2_1);
        Animation animation6= AnimationUtils.loadAnimation(this, R.anim.ani2_1);
        image6.startAnimation(animation6);

        ImageView image7=(ImageView)findViewById(R.id.t2_2);
        Animation animation7= AnimationUtils.loadAnimation(this, R.anim.ani2_2);
        image7.startAnimation(animation7);
//
        ImageView image8=(ImageView)findViewById(R.id.t2_3);
        Animation animation8= AnimationUtils.loadAnimation(this, R.anim.ani2_3);
        image8.startAnimation(animation8);

        ImageView image9=(ImageView)findViewById(R.id.t2_4);
        Animation animation9= AnimationUtils.loadAnimation(this, R.anim.ani2_4);
        image9.startAnimation(animation9);

        ImageView image10=(ImageView)findViewById(R.id.t2_5);
        Animation animation10= AnimationUtils.loadAnimation(this, R.anim.ani2_5);
        image10.startAnimation(animation10);


        ImageView ball=(ImageView)findViewById(R.id.ball);
        Animation animation11= AnimationUtils.loadAnimation(this, R.anim.ball);
        ball.startAnimation(animation11);
    }


}
