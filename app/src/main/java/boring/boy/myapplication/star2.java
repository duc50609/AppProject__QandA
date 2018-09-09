package boring.boy.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class star2 extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener{
    int choose,count=0,crrect,wrong;
    TextView answer_1,answer_2,answer_3,question_tv ;
    RadioGroup rg;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star2);
        SharedPreferences star_editor = getSharedPreferences("star1", MODE_PRIVATE);
        SharedPreferences test_editor = getSharedPreferences("test2", MODE_PRIVATE);
        String question = test_editor.getString("question","");
        String answer[] = test_editor.getString("answer","").split(",");
        choose = test_editor.getInt("choose",99);
        question_tv = findViewById(R.id.question);
        answer_1 = findViewById(R.id.answer_1);
        answer_2 = findViewById(R.id.answer_2);
        answer_3 = findViewById(R.id.answer_3);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        answer_1.setText(answer[0]);
        answer_2.setText(answer[1]);
        answer_3.setText(answer[2]);
        count = star_editor.getInt("答對",0);
        question_tv.setText(question);
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 5);
        crrect = soundPool.load(this, R.raw.crrect, 1);
        wrong = soundPool.load(this, R.raw.wrong, 1);
    }
    public void go_next(View v){
        SharedPreferences.Editor star_editor = getPreferences(MODE_PRIVATE).edit();
        Intent it =new Intent(this,star3.class) ;
        star_editor.putInt("答對",count);
        star_editor.commit();
        startActivity(it);
        finish();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_1:
                if(choose==1) {
                    soundPool.play(crrect, 1.0F, 1.0F, 0, 0, 1.0F);
                    answer_1.setBackgroundColor(Color.rgb(0, 255, 0));
                    count++;
                }
                else {
                    answer_1.setBackgroundColor(Color.rgb(255, 0, 0));
                    soundPool.play(wrong, 1.0F, 1.0F, 0, 0, 1.0F);
                }
                break;
            case R.id.rb_2:
                if(choose==2) {
                    soundPool.play(crrect, 1.0F, 1.0F, 0, 0, 1.0F);
                    answer_2.setBackgroundColor(Color.rgb(0, 255, 0));
                    count++;
                }
                else {
                    answer_2.setBackgroundColor(Color.rgb(255, 0, 0));
                    soundPool.play(wrong, 1.0F, 1.0F, 0, 0, 1.0F);
                }
                break;
            case R.id.rb_3:
                if(choose==3) {
                    soundPool.play(crrect, 1.0F, 1.0F, 0, 0, 1.0F);
                    answer_3.setBackgroundColor(Color.rgb(0, 255, 0));
                    count++;
                }
                else {
                    answer_3.setBackgroundColor(Color.rgb(255, 0, 0));
                    soundPool.play(wrong, 1.0F, 1.0F, 0, 0, 1.0F);
                }
                break;
        }
    }
}
