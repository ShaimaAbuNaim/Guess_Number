package com.example.abunaim.guessnumber;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import javax.xml.datatype.Duration;


public class MainActivity extends ActionBarActivity {
    int max = 1000;
    int min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

//build a method
    public void GenRandom(View view) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplication(), "your answer very close to correct number, try again", duration);
        toast.setGravity(Gravity.CENTER, 0, 0);

        //get the guess number vlue which user entered it
        EditText enterednum = (EditText) findViewById(R.id.editText);

            // get the user value as string (covert numeric value to string)
            int usernum = Integer.parseInt(enterednum.getText().toString());
            //generate random number from 0-1000 by Random class
            Random num = new Random();
            int randomnum = num.nextInt(1000);

//create a value with textview type
            TextView msgrslt = (TextView) findViewById(R.id.textView2);
            //make a result massage

            if ((usernum - randomnum) == 0) {
                msgrslt.setText("Wow,its a correct guess ");
            }
            if (Math.abs(usernum - randomnum) <= (5) && Math.abs(usernum - randomnum) > 0) {
               msgrslt.setText("");
                toast.show();
            }
            if (usernum > randomnum & Math.abs(usernum - randomnum) > 5) {

                msgrslt.setText("your guess is greater,Try again");

            }
            if (usernum < randomnum && Math.abs(usernum - randomnum) >= 6) {

                msgrslt.setText("Your guess is smaller, Try again");


            }
        }
    }

