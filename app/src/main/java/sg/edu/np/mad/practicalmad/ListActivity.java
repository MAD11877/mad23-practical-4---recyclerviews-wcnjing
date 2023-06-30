package sg.edu.np.mad.practicalmad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> users = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 21; i++) {
            int randomNumber = random.nextInt(1000000000);
            users.add(new User("Name-" + randomNumber, "Description-" + randomNumber));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(this, users));
    }

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
        private ArrayList<User> data;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView nameView;
            private TextView descView;

            public MyViewHolder(View view) {
                super(view);
                nameView = view.findViewById(R.id.name);
                descView = view.findViewById(R.id.desc);
            }

            public TextView getNameView() {
                return nameView;
            }

            public TextView getDescView() {
                return descView;
            }
        }

        public UserAdapter(Context context, ArrayList<User> input) {
            data = input;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
            User user = data.get(position);
            myViewHolder.getNameView().setText(user.getName());
            myViewHolder.getDescView().setText(user.getDescription());

            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Profile");
                    builder.setMessage(user.getName());
                    builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(ListActivity.this, MainActivity.class);
                            intent.putExtra("USERNAME", user.getName());
                            intent.putExtra("DESCRIPTION", user.getDescription());
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("CLOSE", null);
                    builder.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
