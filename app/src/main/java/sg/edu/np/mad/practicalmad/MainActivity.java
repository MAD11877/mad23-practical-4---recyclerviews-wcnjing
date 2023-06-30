package sg.edu.np.mad.practicalmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean following = false;

    private TextView name;
    private TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textView2);
        desc = findViewById(R.id.textView3);
        Button followButton = findViewById(R.id.flwButton);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!following){
                    followButton.setText("Unfollow");
                }
                else{
                    followButton.setText("Follow");
                }
                following = !following;
            }
        });
        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("Key");
        String username = receivingEnd.getStringExtra("USERNAME");
        String description = receivingEnd.getStringExtra("DESCRIPTION");

        this.name.setText(username);
        this.desc.setText(description);
        // follow button
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!following) {
                    followButton.setText("Unfollow");
                } else {
                    followButton.setText("Follow");
                }
                following = !following;

            }
        });
        // Message button
        Button msgButton = findViewById(R.id.messagebutton);
        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i);
            }
        });

    }



}