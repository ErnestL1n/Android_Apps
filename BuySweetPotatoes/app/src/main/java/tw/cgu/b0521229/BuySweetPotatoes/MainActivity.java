package tw.cgu.b0521229.BuySweetPotatoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {


    RadioGroup perdollargroup, buynumbergroup;
    EditText buyperdollar, numbers;
    TextView pergindollar, pergogindollar, gin, gogin, show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perdollargroup = (RadioGroup) findViewById(R.id.perdollargroup);
        perdollargroup.setOnCheckedChangeListener(this);
        buynumbergroup = (RadioGroup) findViewById(R.id.buynumbergroup);
        buynumbergroup.setOnCheckedChangeListener(this);

        buyperdollar = (EditText) findViewById(R.id.buyperdollar);
        buyperdollar.addTextChangedListener(this);
        numbers = (EditText) findViewById(R.id.numbers);
        numbers.addTextChangedListener(this);

        pergindollar = (TextView) findViewById(R.id.pergindollar);
        pergogindollar = (TextView) findViewById(R.id.pergogindollar);
        gin = (TextView) findViewById(R.id.gin);
        gogin = (TextView) findViewById(R.id.gogin);
        show = (TextView) findViewById(R.id.show);
        show.setText("請輸入單價");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        after();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        after();
    }

    protected void after() {
        double x1=0,x2=0,x3=0,x4=0,x5=0,input1,input2;   //input1=輸入每斤價錢    ////input2=輸入購買重量
         //每斤價錢X1元           // 每公斤價錢X2元        //購買重量:X3斤        X4公斤       //總共X5元
        String str1=buyperdollar.getText().toString();           //讀取地瓜單價(元)
        try{
            input1=Double.parseDouble(str1);
        }
        catch(Exception e){
            input1=0;
        }
        if(perdollargroup.getCheckedRadioButtonId()==R.id.set1){
            x1=input1;           x2=x1*5/3;
            String str2=numbers.getText().toString();           //讀取地瓜單價(元)
            try{
                input2=Double.parseDouble(str2);
            }
            catch(Exception e) {
                input2 = 0;
            }
                switch(buynumbergroup.getCheckedRadioButtonId()){
                    case R.id.set3:
                        x3=input2;  x4=x3*0.6;
                        x5=x1*x3;
                        if (buyperdollar.getText().toString().isEmpty()) {
                            show.setText("請輸入單價");
                        }
                        else if(numbers.length() == 0 || buyperdollar.getText().toString().equals("請輸入單價")) {
                            show.setText("請輸入重量");
                        }
                        else {
                            pergindollar.setText("每斤價錢:" + String.format("%.1f", x1)+"元");
                            pergogindollar.setText("每公斤價錢:" + String.format("%.1f", x2)+"元");
                            gin.setText(String.format("%.1f", x3) + "斤");
                            gogin.setText(String.format("%.1f", x4) + "公斤");
                            show.setText("總共" + String.format("%.1f", x5) + "元");
                        }
                        break;
                    case R.id.set4:
                        x4=input2;  x3=x4*5/3;
                        x5=x1*x3;
                        if (buyperdollar.getText().toString().isEmpty()) {
                            show.setText("請輸入單價");
                        }
                        else if(numbers.length() == 0 || buyperdollar.getText().toString().equals("請輸入單價")) {
                            show.setText("請輸入重量");
                        }
                        else {
                            pergindollar.setText("每斤價錢:" + String.format("%.1f", x1)+"元");
                            pergogindollar.setText("每公斤價錢:" + String.format("%.1f", x2)+"元");
                            gin.setText(String.format("%.1f", x3) + "斤");
                            gogin.setText(String.format("%.1f", x4) + "公斤");
                            show.setText("總共" + String.format("%.1f", x5) + "元");
                        }
                        break;
                }
            }

        else if(perdollargroup.getCheckedRadioButtonId()==R.id.set2){
            x2=input1;           x1=x2*0.6;
            String str2=numbers.getText().toString();           //讀取地瓜單價(元)
            try{
                input2=Double.parseDouble(str2);
            }
            catch(Exception e) {
                input2 = 0;
            }
                switch(buynumbergroup.getCheckedRadioButtonId()){
                    case R.id.set3:
                        x3=input2;  x4=x3*0.6;
                        x5=x2*x4;
                        if (buyperdollar.getText().toString().isEmpty()) {
                            show.setText("請輸入單價");
                        }
                        else if(numbers.length() == 0 || buyperdollar.getText().toString().equals("請輸入單價")) {
                            show.setText("請輸入重量");
                        }
                        else {
                            pergindollar.setText("每斤價錢:" + String.format("%.1f", x1)+"元");
                            pergogindollar.setText("每公斤價錢:" + String.format("%.1f", x2)+"元");
                            gin.setText(String.format("%.1f", x3) + "斤");
                            gogin.setText(String.format("%.1f", x4) + "公斤");
                            show.setText("總共" + String.format("%.1f", x5) + "元");
                        }
                        break;
                    case R.id.set4:
                        x4=input2;  x3=x4*5/3;
                        x5=x2*x4;
                        if (buyperdollar.getText().toString().isEmpty()) {
                            show.setText("請輸入單價");
                        }
                        else if(numbers.length() == 0 || buyperdollar.getText().toString().equals("請輸入單價")) {
                            show.setText("請輸入重量");
                        }
                        else {
                            pergindollar.setText("每斤價錢:" + String.format("%.1f", x1)+"元");
                            pergogindollar.setText("每公斤價錢:" + String.format("%.1f", x2)+"元");
                            gin.setText(String.format("%.1f", x3) + "斤");
                            gogin.setText(String.format("%.1f", x4) + "公斤");
                            show.setText("總共" + String.format("%.1f", x5) + "元");
                        }
                        break;
                }
            }
        }
}
