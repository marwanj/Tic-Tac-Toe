package selcouth.TicTacToe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class menuactivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobileAds.initialize(this,"ca-app-pub-2011791433440590~8287035160");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        onstart_ads();
        Set_scores();


    }
    public void Set_scores()
    {
        Intent in= getIntent();
        Bundle b = in.getExtras();
        TextView greenwinstextout=(TextView)findViewById(R.id.pts_green_id);
        greenwinstextout.setText(Integer.toString(b.getInt("green")));
        TextView bluewinstextout=(TextView)findViewById(R.id.pts_blue_id);
        bluewinstextout.setText(Integer.toString(b.getInt("blue")));


    }

    public void reset_score(View view)
    {     setResult(0);
          Set_scores();
          finish();
    }

    public void new_game(View view)
    {   setResult(1);
        finish();
    }
    public void onstart_ads()
    { mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
