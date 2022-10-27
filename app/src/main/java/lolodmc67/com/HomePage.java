package lolodmc67.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
FloatingActionButton floatingButton;
String nameTeamA,nameTeamB;
    ArrayList<Game> data = new ArrayList<Game>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

/*
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));


        RecyclerView myrecycler = (RecyclerView) findViewById(R.id.recyler_view);
        MyAdapter adapter = new MyAdapter(this, data);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));
        myrecycler.setAdapter(adapter);*/

        RecyclerView myrecycler = (RecyclerView) findViewById(R.id.recyler_view);

        floatingButton= findViewById(R.id.floating_button);
        floatingButton.setOnClickListener(view -> {

            Dialog dialog = new Dialog(HomePage.this);
            dialog.setContentView(R.layout.dialog);
            EditText teamA = dialog.findViewById(R.id.team_a_);
            EditText teamB = dialog.findViewById(R.id.team_b_);
            Button save =dialog.findViewById(R.id.save);
            //controlling the width and height of the dialog size
            int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
            int height = (int)(getResources().getDisplayMetrics().heightPixels*0.40);
            dialog.getWindow().setLayout(width, height);

            // to make all window transparent
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nameTeamA =teamA.getText().toString();
                    nameTeamB =teamB.getText().toString();
                    Game game = new Game("Team A", "Team B");
                    game.setNameTeamA(nameTeamA);
                    game.setNameTeamB(nameTeamB);
                    if(game.getNameTeamA().equals("") || game.getNameTeamB().equals("") ||game.getNameTeamA().equals("") && game.getNameTeamB().equals("") ) {
                        game.setNameTeamA("Team A");
                        game.setNameTeamB("Team B");
                        data.add(game);
                    }
                    else {
                        data.add(game);
                    }
                    dialog.dismiss();
                    MyAdapter adapter = new MyAdapter(HomePage.this, data);
                    myrecycler.setLayoutManager(new LinearLayoutManager(HomePage.this));
                    myrecycler.setAdapter(adapter);
                }
            });

            dialog.show();
        });

    }
}

