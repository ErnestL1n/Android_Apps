package tw.cgu.b0521229.standardweightcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity{

    RadioGroup gender;
    EditText height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender=(RadioGroup)findViewById(R.id.gender);
        height=(EditText)findViewById(R.id.height);
    }
    public void calculator(View v){
        Double InputHeight=0.0;
        Double niceweight=0.0;
        String sex="";
        String getsHeight;
        getsHeight=height.getText().toString();
        switch(gender.getCheckedRadioButtonId()){
            case R.id.men:
                InputHeight=Double.parseDouble(getsHeight);
                niceweight=(InputHeight-80)*0.7;
                sex="男生";
                break;
            case R.id.women:
                InputHeight=Double.parseDouble(getsHeight);
                niceweight=(InputHeight-70)*0.6;
                sex="女生";
                break;
        }
        Intent it=new Intent(this,Edit.class);
        it.putExtra("性別",sex);
        it.putExtra("身高",InputHeight);
        it.putExtra("標準體重",niceweight);
        startActivity(it);
    }

}
