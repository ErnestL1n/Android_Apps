package tw.cgu.b0521229.standardweightcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent it=getIntent();
        String sex=it.getStringExtra("性別");
        Double height=it.getDoubleExtra("身高",0);
        Double weight=it.getDoubleExtra("標準體重",0);
        TextView txv=(TextView)findViewById(R.id.txv);
        txv.setText("您是一位"+sex+"\n您的身高是"+String.format("%.1f", height)+"cm\n"+"您的標準體重是"+String.format("%.1f", weight)+"kg");

    }
    public void goback(View v){
        finish();
    }
}
