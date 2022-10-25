package lolodmc67.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ArrayList<Game> data = new ArrayList<Game>();
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));
        data.add(new Game("barcalona", "real madrid"));


        RecyclerView myrecycler = (RecyclerView) findViewById(R.id.recyler_view);
        MyAdapter adapter = new MyAdapter(this, data);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));
        myrecycler.setAdapter(adapter);

        CardView cardView = findViewById(R.id.card);



    }
}
