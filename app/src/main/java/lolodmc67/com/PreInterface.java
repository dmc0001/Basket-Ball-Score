package lolodmc67.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PreInterface extends AppCompatActivity {
    LinearLayout preInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_interface);
        preInterface = findViewById(R.id.preInterface);
        preInterface.setOnClickListener(View -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

    }

}
