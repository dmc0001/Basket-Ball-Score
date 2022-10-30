package lolodmc67.com;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score_A;
    int score_B;
    Button button_save;
    String nameTeamA,nameTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Intent i = getIntent();
            nameTeamA = i.getStringExtra("Team A name");
            nameTeamB = i.getStringExtra("Team B name");
        TextView teamA = findViewById(R.id.team_name_a);
        TextView teamB = findViewById(R.id.team_name_b);
        teamA.setText("" + nameTeamA);
        teamB.setText("" + nameTeamB);


        button_save=  findViewById(R.id.button_save);


       button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();

             /* Intent i2 = new Intent(MainActivity.this,HomePage.class);
                i2.putExtra("Team A score",score_A);
                //i2.putExtra("Team B score",score_B);
                startActivity(i2);*/
            }
        });



       /* Intent i2 = new Intent(MainActivity.this,HomePage.class);
        i.putExtra("Team A score",score_A);
        i.putExtra("Team B score",score_B);
        startActivity(i2);*/

    }




    public void plus3_Points_A(View view) {
       score_A=score_A +3;

        displayA(score_A,3);


    }
    public void plus2_Points_A(View view) {
        score_A=score_A +2;
        displayA(score_A,2);

    }
    public void freethrow_Points_A(View view) {
        score_A ++;
        displayA(score_A,1);

    }
    public void plus3_Points_B(View view) {
        score_B=score_B +3;
        displayB(score_B,3);

    }
    public void plus2_Points_B(View view) {
        score_B=score_B +2;
        displayB(score_B,2);

    }
    public void freethrow_Points_B(View view) {
        score_B ++;
        displayB(score_B,1);

    }
    public void rest(View view){
        displayB();
        displayA();
    }

    private void displayA(int num, int num2) {
        TextView questionTextView = findViewById(R.id.score_teamA);
        questionTextView.setText("" + num);

    }

    private void displayA() {
        TextView questionTextView = findViewById(R.id.score_teamA);
        score_A=0;
        questionTextView.setText("" + 0);
        Toast.makeText(this,"Rest",Toast.LENGTH_SHORT).show();
    }
    private void displayB() {
        TextView questionTextView = findViewById(R.id.score_teamB);
        score_B=0;
        questionTextView.setText("" + 0);
        Toast.makeText(this,"Rest",Toast.LENGTH_SHORT).show();
    }

    private void displayB(int num,int num2) {
        TextView questionTextView = findViewById(R.id.score_teamB);
        questionTextView.setText("" + num);

    }
}