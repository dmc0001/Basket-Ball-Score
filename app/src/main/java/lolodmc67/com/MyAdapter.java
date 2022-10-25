package lolodmc67.com;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {
    Context context;
    ArrayList<Game> data = new ArrayList<Game>();

    /**
     * Initialize the data of the Adapter.
     * Initialize the context of the Adapter.
     *
     * @param data String[] containing the data to populate views to be used
     * @param  context Context containing the context to populate views to be used
     *
     * by RecyclerView.
     */
    public MyAdapter(Context context, ArrayList<Game> data) {
        // Create new views (invoked by the layout manager)
        this.context = context;
        this.data = data;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Define click listener for the myViewHolder's View
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new myViewHolder(view);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        holder.name1.setText(data.get(position).getNameTeamA());
        holder.name2.setText(data.get(position).getNameTeamB());
    }
    // Return the size of your data and context (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView name1;
        TextView name2;
        //ImageView img;
        CardView card;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name1 = (TextView) itemView.findViewById(R.id.team_a_name);
            name2 = (TextView) itemView.findViewById(R.id.team_b_name);
            //img = (ImageView) itemView.findViewById(R.id.team_b_name);
            card = (CardView) itemView.findViewById(R.id.card);
            card.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }
}
