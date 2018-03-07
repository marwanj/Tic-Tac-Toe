package selcouth.TicTacToe;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    int number=0;
    public int check []={0,0,0,0,0,0,0,0,0};
    boolean endgame=true;
    int greenwins;
    int bluewins;
    public void dropIn(View view)
    {
        int winningpositions [][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        ImageView counter = (ImageView) view;
        int tagbutton = Integer.parseInt(counter.getTag().toString()); //noidea why i did this
        if (check[tagbutton] != 0)
        {
            Toast.makeText(getApplicationContext(),"Invalid Move",Toast.LENGTH_SHORT).show();
        }
        else if (check[tagbutton]==0) {
            view.setTranslationY(-1000f);
            if (number % 2 == 0) {
                counter.setImageResource(R.drawable.bluedothi);
                number++;
                check[tagbutton] = 1;
                counter.animate().translationYBy(1000f).rotation(360f).setDuration(500);
            } else if (number % 2 != 0) {
                counter.setImageResource(R.drawable.neonclipartneongreendotmd);
                number++;
                check[tagbutton] = 2;
                counter.animate().translationYBy(1000f).rotation(360f).setDuration(500);
            }

        }
        for (int k=0;k<8;k++)
        {
            if (check[winningpositions[k][0]]== check[winningpositions[k][1]]&&check[winningpositions[k][1]] == check[winningpositions[k][2]] && check[winningpositions[k][1]]==1) {
                Toast.makeText(getApplicationContext(),"Blue won",Toast.LENGTH_LONG).show();bluewins++;endgamedialog();}
            else if (check[winningpositions[k][0]]== check[winningpositions[k][1]]&&check[winningpositions[k][1]] == check[winningpositions[k][2]] && check[winningpositions[k][1]]==2){
                Toast.makeText(getApplicationContext(),"Green won",Toast.LENGTH_LONG).show();greenwins++;endgamedialog();
            }
            endgame=true;
            for (int m=0;m<8;m++)
                if (check[m]==0)
                {
                    endgame=false;
                }
        }
        if (endgame) {
            Toast.makeText(getApplicationContext(), "Game has ended", Toast.LENGTH_LONG).show();
            endgamedialog();}
    }

    public void endgamedialog()
    {   number=0;
        for (int n=0;n<9;n++)
        {
            check[n]=0;
        }
        GridLayout griddy= (GridLayout) findViewById(R.id.gridLayout);
        for (int n=0;n<griddy.getChildCount();n++)
            ((ImageView) griddy.getChildAt(n)).setImageResource(0);
        Bundle wins_ammounts = new Bundle();
        wins_ammounts.putInt("blue",bluewins);
        wins_ammounts.putInt("green",greenwins);
        Intent menu =new Intent(MainActivity.this,menuactivity.class);
        menu.putExtras(wins_ammounts);
        startActivityForResult(menu,1);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {   //// If Reset Reset scores
        if (requestCode == 1) {
            if(resultCode == 0) {
                greenwins=0;
                bluewins=0;

        }
    }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluewins=0;
        greenwins=0;
        Toast.makeText(getApplicationContext(),"Blue Always Starts",Toast.LENGTH_LONG).show();


    }

}
