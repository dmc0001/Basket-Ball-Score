package lolodmc67.com;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MatchesFragment extends Fragment {

    FloatingActionButton floatingButton;

    String nameTeamA , nameTeamB , Team_A = " Team A" , Team_B = "Team B";
    ArrayList<Game> data = new ArrayList<Game>();
    RecyclerView myrecycler;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_matches, container, false);
        myrecycler = (RecyclerView) view.findViewById(R.id.recyler_view);
        floatingButton= view.findViewById(R.id.floating_button);
//ViewGroup viewGroup = view.findViewById(androidx.appcompat.R.id.content);


        RecyclerView myrecycler = view.findViewById(R.id.recyler_view);
        MyAdapter adapter = new MyAdapter(getActivity(), data);

        myrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycler.setAdapter(adapter);


        floatingButton= view.findViewById(R.id.floating_button);

        floatingButton.setOnClickListener(view -> {


            Dialog dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.dialog);
            dialog.setCancelable(false);

            EditText teamA = dialog.findViewById(R.id.team_a_);
            EditText teamB = dialog.findViewById(R.id.team_b_);
            Button save = dialog.findViewById(R.id.save);
            //controlling the width and height of the dialog size
            int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
            int height = (int)(getResources().getDisplayMetrics().heightPixels*0.50);
            dialog.getWindow().setLayout(width, height);
            // to make all window transparent
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nameTeamA =teamA.getText().toString();
                    nameTeamB =teamB.getText().toString();
                    Game game = new Game(Team_A, Team_B);
                    game.setNameTeamA(nameTeamA);
                    game.setNameTeamB(nameTeamB);

                    Intent i = new Intent(getActivity(),MainActivity.class);

                    if(game.getNameTeamA().equals("") || game.getNameTeamB().equals("") ||game.getNameTeamA().equals("") && game.getNameTeamB().equals("") ) {
                        game.setNameTeamA("Team A");
                        game.setNameTeamB("Team B");
                        data.add(game);
                        i.putExtra("Team A name",Team_A);
                        i.putExtra("Team B name",Team_B);
                        startActivity(i);
                    }
                    else {
                        data.add(game);

                        i.putExtra("Team A name",nameTeamA);
                        i.putExtra("Team B name",nameTeamB);
                        startActivity(i);
                    }
                    dialog.dismiss();
                    MyAdapter adapter = new MyAdapter(getActivity(), data);
                    myrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                    myrecycler.setAdapter(adapter);
                }
            });

            dialog.show();
        });




        return view;
    }


}