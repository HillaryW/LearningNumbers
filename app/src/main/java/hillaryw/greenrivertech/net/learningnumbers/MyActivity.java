package hillaryw.greenrivertech.net.learningnumbers;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MyActivity extends AppCompatActivity {

    public int leftSide;
    public int rightSide;
    public int score = 0;
    public int timesPlayed =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        generateNumber();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void generateNumber() {

        Random random = new Random();

        leftSide = random.nextInt(10)+1;
        rightSide = random.nextInt(10)+1;

        while(leftSide == rightSide) {

            rightSide = random.nextInt(10) + 1;

        }

        Button leftButton = (Button) findViewById(R.id.number1);
        String left = String.valueOf(leftSide);
        leftButton.setText(left);

        Button rightButton = (Button) findViewById(R.id.number2);
        String right = String.valueOf(rightSide);
        rightButton.setText(right);

        TextView scoreTracker = (TextView) findViewById(R.id.scoreNumber);
        String scoreNumber = String.valueOf(score);
        scoreTracker.setText(scoreNumber);

        TextView gameCounter = (TextView) findViewById(R.id.gameNumber);
        String game = String.valueOf(timesPlayed);
        gameCounter.setText(game);
    }

    public void checkLeft(View view) {

        if (leftSide > rightSide) {

            Context context = getApplicationContext();
            CharSequence text = "Correct!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            score++;


        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

        timesPlayed++;
        generateNumber();
    }

    public void checkRight(View view) {

        if (leftSide < rightSide) {

            Context context = getApplicationContext();
            CharSequence text = "Correct!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            score++;


        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        timesPlayed++;
        generateNumber();
    }

}

