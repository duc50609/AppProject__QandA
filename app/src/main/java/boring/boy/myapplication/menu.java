package boring.boy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.ads.*;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void go_next(View v){
        Intent it =new Intent(this,test1.class) ;
        startActivity(it);
    }
    public void go_test(View v){
            Intent ot = getIntent();
            int count = ot.getIntExtra("執行",0);
            if(count!=0) {
                Intent it = new Intent(this, star1.class);
                startActivity(it);
            }
            else
                Toast.makeText(this,"你必須先製作測驗",Toast.LENGTH_SHORT).show();



    }
}
