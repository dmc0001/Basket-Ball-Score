package lolodmc67.com;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score_A;
    int score_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private void displayA() { TextView questionTextView = findViewById(R.id.score_teamA);
        questionTextView.setText("" + 0);
        Toast.makeText(this,"Rest",Toast.LENGTH_SHORT).show();
    }
    private void displayB() { TextView questionTextView = findViewById(R.id.score_teamB);
        questionTextView.setText("" + 0);
        Toast.makeText(this,"Rest",Toast.LENGTH_SHORT).show();
    }

    private void displayB(int num,int num2) {
        TextView questionTextView = findViewById(R.id.score_teamB);
        questionTextView.setText("" + num);

    }
}