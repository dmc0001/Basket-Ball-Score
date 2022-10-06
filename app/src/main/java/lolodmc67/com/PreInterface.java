package lolodmc67.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Timer;
import java.util.TimerTask;

public class PreInterface extends AppCompatActivity {
    LinearLayout preInterface;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_interface);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(PreInterface.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


//        preInterface = findViewById(R.id.preInterface);
//        preInterface.setOnClickListener(View -> {
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//        });

    }

}
