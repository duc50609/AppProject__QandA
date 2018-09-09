package boring.boy.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class end extends AppCompatActivity {
    TextView tv;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        SharedPreferences star_editor = getSharedPreferences("star5", MODE_PRIVATE);
        count = star_editor.getInt("答對",0);
        tv=findViewById(R.id.tv);
        tv.setText("你答對了"+count+"題!!!");
    }
    public void go_menu(View v){
        Intent it =new Intent(this,menu.class) ;
        startActivity(it);
        finish();
    }
    public void go_star(View v){
        Intent it =new Intent(this,star1.class) ;
        startActivity(it);
        finish();
    }
}
