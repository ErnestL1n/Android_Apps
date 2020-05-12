package tw.cgu.b0521229.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int iScore =0;  int iNum =0 ; int opencard = 0; int iFirstCard=-1;
    TextView score;
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    Toast tos;
    int[] btn = {R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15,R.id.b16};
    int[] iValues={1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,0};
    int[] images = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score =(TextView)findViewById(R.id.score);
        b1 =(ImageButton) findViewById(R.id.b1);b2 =(ImageButton) findViewById(R.id.b2);
        b3 =(ImageButton) findViewById(R.id.b3);b4 =(ImageButton) findViewById(R.id.b4);
        b5 =(ImageButton) findViewById(R.id.b5);b6 =(ImageButton) findViewById(R.id.b6);
        b7 =(ImageButton) findViewById(R.id.b7);b8 =(ImageButton) findViewById(R.id.b8);
        b9 =(ImageButton) findViewById(R.id.b9);b10 =(ImageButton) findViewById(R.id.b10);
        b11 =(ImageButton) findViewById(R.id.b11);b12 =(ImageButton) findViewById(R.id.b12);
        b13 =(ImageButton) findViewById(R.id.b13);b14 =(ImageButton) findViewById(R.id.b14);
        b15 =(ImageButton) findViewById(R.id.b15);b16 =(ImageButton) findViewById(R.id.b16);

        b1.setOnClickListener(this); b2.setOnClickListener(this); b3.setOnClickListener(this); b4.setOnClickListener(this); b5.setOnClickListener(this); b6.setOnClickListener(this);
        b7.setOnClickListener(this); b8.setOnClickListener(this); b9.setOnClickListener(this); b10.setOnClickListener(this); b11.setOnClickListener(this); b12.setOnClickListener(this);
        b13.setOnClickListener(this); b14.setOnClickListener(this); b15.setOnClickListener(this); b16.setOnClickListener(this);

        tos = Toast.makeText(this,"",Toast.LENGTH_LONG);

        Random generator = new Random();
        int iTemp = 0, iRandom = 0;  iScore = 0;
        ((TextView)findViewById(R.id.score)).setText(Integer.toString(iScore));
        for (int i = 0; i < 16; i++) {
            ((ImageButton) findViewById(btn[i])).setImageResource(R.drawable.i);
            iRandom = generator.nextInt(16);
            iTemp = iValues[i];
            iValues[i] = iValues[iRandom];
            iValues[iRandom] = iTemp;
        }

    }
    public void newGame(View v) {
        Random generator = new Random();
        int iTemp = 0, iRandom = 0;  iScore = 0;
        ((TextView) findViewById(R.id.score)).setText(Integer.toString(iScore));

        for (int i = 0; i < 16; i++) {

            ((ImageButton) findViewById(btn[i])).setImageResource(R.drawable.i);
            iRandom = generator.nextInt(16);
            iTemp = iValues[i];
            iValues[i] = iValues[iRandom];
            iValues[iRandom] = iTemp;

        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b1: iNum = 0; break;
            case R.id.b2: iNum = 1; break;
            case R.id.b3: iNum = 2; break;
            case R.id.b4: iNum = 3; break;
            case R.id.b5: iNum = 4; break;
            case R.id.b6: iNum = 5; break;
            case R.id.b7: iNum = 6; break;
            case R.id.b8: iNum = 7; break;
            case R.id.b9: iNum = 8; break;
            case R.id.b10: iNum = 9; break;
            case R.id.b11: iNum = 10; break;
            case R.id.b12: iNum = 11; break;
            case R.id.b13: iNum = 12; break;
            case R.id.b14: iNum = 13; break;
            case R.id.b15: iNum = 14; break;
            case R.id.b16: iNum = 15; break;
            default:
                break;
        }

        if(iFirstCard==-1)
        {
            ((ImageButton)findViewById(btn[iNum])).setImageResource(images[
                    iValues[iNum]]);
            iFirstCard=iNum;
        }

        else if(iFirstCard!=-1)
            if(iValues[iFirstCard]==iValues[iNum])
            {

                ((ImageButton)findViewById(btn[iNum])).setImageResource(images[iValues[iNum]]);
                iFirstCard=-1;
                iScore+=200;
                opencard+=1;
                ((TextView)findViewById(R.id.score)).setText(Integer.toString(iScore));

                if(opencard==8){

                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            //過兩秒後要做的事情
                            tos.setText("遊戲結束 得分:"+iScore);
                            tos.show();
                        }}, 1000);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            //過兩秒後要做的事情
                            Intent it1 = new Intent();
                            it1.putExtra("對對碰分數",  iScore);
                            setResult(RESULT_OK, it1);
                            finish();
                        }}, 4000);


                }

            }

            else
            {
                ((ImageButton)findViewById(btn[iNum])).setImageResource(images[iValues[iNum]]);
                iScore-=40;
                ((TextView)findViewById(R.id.score)).setText(Integer.toString(iScore));



                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {

                        //過0.5秒後要做的事情
                        ((ImageButton) findViewById(btn[iNum])).setImageResource(R.drawable.i);
                        ((ImageButton) findViewById(btn[iFirstCard])).setImageResource(R.drawable.i);
                        iFirstCard=-1;
                    }}, 550);
            }
    }

    public  void  back(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

}