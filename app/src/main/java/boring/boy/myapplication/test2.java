package boring.boy.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class test2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    EditText question, answer_1, answer_2,  answer_3;
    RadioButton right;
    RadioGroup rg;
    int choose=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        question =findViewById(R.id.question);
        answer_1 =findViewById(R.id.answer_1);
        answer_2 =findViewById(R.id.answer_2);
        answer_3 =findViewById(R.id.answer_3);
        rg= findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);


    }
    public void go_next(View v){
        String x="",y="";
        x=question.getText().toString();
        y=answer_1.getText().toString()+","+answer_2.getText().toString()+","+answer_3.getText().toString();
        String z[]=y.split(",");
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("question",x);
        editor.putString("answer",y);
        editor.putInt("choose",choose);
        editor.commit();
        if(x.equals("") )
            Toast.makeText(this,"你必須輸入問題",Toast.LENGTH_SHORT).show();
        else if(z.length<3)
            Toast.makeText(this,"你必須輸入選項",Toast.LENGTH_SHORT).show();
        else if(choose==0)
            Toast.makeText(this,"你必須設定正確答案",Toast.LENGTH_SHORT).show();
        else {
            Intent it = new Intent(this, test3.class);
            startActivity(it);
        }
    }
    public void go_back(View v){
        finish();
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_1:
                choose=1;break;
            case R.id.rb_2:
                choose=2;break;
            case R.id.rb_3:
                choose=3;break;
        }
    }
}