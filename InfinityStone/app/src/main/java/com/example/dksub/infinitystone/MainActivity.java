package com.example.dksub.infinitystone;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int x;
    int[] arr={100,100,100,100,100,100};
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getStone (View view)
    {
        String[] myArray = {"Power", "Space", "Time", "Reality", "Soul", "Mind"};
        if(c==6)
        {
            resetFunc();
            return;
        }
        else
        generateRan(myArray);

    }
    public void generateRan(String[] my)
    {
        Random rand = new Random();
        int  n = rand.nextInt(6) + 0;
        if(arr[n]==100) {
            TextView disp = (TextView) findViewById(R.id.chosen_stone);
            disp.setText(my[n]);
            LinearLayout ll = (LinearLayout) findViewById(R.id.list_linear);
            TextView list_item= new TextView(this);
            list_item.setText(my[n] + " Stone");
            ll.addView(list_item);
            arr[n]=n;
            c++;
            if(c==6)
            {
                TextView finish = (TextView) findViewById(R.id.all_stones);
                finish.setText("Congrats Thanos! You got them all :)");
            }
            if(n==0)
            disp.setBackgroundColor(Color.rgb(127,0,255));
            else if(n==1)
                disp.setBackgroundColor(Color.rgb(51,51,255));
            else if(n==2)
                disp.setBackgroundColor(Color.rgb(0,204,0));
            else if(n==3)
                disp.setBackgroundColor(Color.rgb(205,0,0));
            else if(n==4)
                disp.setBackgroundColor(Color.rgb(255,128,0));
            else if(n==5)
                disp.setBackgroundColor(Color.rgb(255,255,51));

        }
        else
            generateRan(my);
    }
    public void resetFunc()
    {
        c=0;
        for(int i=0;i<6;i++)
            arr[i]=100;
        LinearLayout ll = (LinearLayout) findViewById(R.id.list_linear);
        ll.removeAllViews();
        TextView disp = (TextView) findViewById(R.id.chosen_stone);
        disp.setText("");
        disp.setBackgroundColor(Color.rgb(255,255,255));
        TextView finish = (TextView) findViewById(R.id.all_stones);
        finish.setText("");
    }
    public void viewReset(View view)
    {
       c=0;
        for(int i=0;i<6;i++)
            arr[i]=100;
        LinearLayout ll = (LinearLayout) findViewById(R.id.list_linear);
        ll.removeAllViews();
        TextView disp = (TextView) findViewById(R.id.chosen_stone);
        disp.setText("");
        disp.setBackgroundColor(Color.rgb(255,255,255));
        TextView finish = (TextView) findViewById(R.id.all_stones);
        finish.setText("");
    }
}
