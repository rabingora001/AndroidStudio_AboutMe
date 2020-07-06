package edu.tacoma.uw.rabin001;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for Log.information view in logCat
        Log.i(TAG, "onCreate");

        //antonymous class with ActionListener for the TEXT button
        //we can also do this from onClick attributes from res/layout/MainActivity.
        Button textButt = findViewById(R.id.text_btn);
        textButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MyInfoActivity.class);
                startActivity(i);
            }
        });

        //webButton click actionListener
        Button webButt = findViewById(R.id.web_btn);
        webButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://developer.android.com/index.html");
                Intent webPageIntent = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(webPageIntent);
            }
        });

        //Dialog button action listener
        Button diaglogButt = findViewById(R.id.dialog_btn);
        diaglogButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddItemDialog(MainActivity.this);
            }
        });
    }

    //another method to run the button
    /** called when the user taps the image button from the res/layout/main_activity. */
    public void imgButtClick(View view) {
        Intent i = new Intent(this, ImageActivity.class);
        startActivity(i);
    }

    public void toastButtClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "This is a toast message!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //dialog context method
    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Add Class")
                .setMessage("Add your fav class this quarter")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

}


