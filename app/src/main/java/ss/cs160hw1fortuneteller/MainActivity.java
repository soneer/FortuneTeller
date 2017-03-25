package ss.cs160hw1fortuneteller;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    Button showFortuneButton;
    TextView fortuneOutcomeTextView;
    Random randomNumberGen;
    final Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);;
    final Animation fadeOut = new AlphaAnimation(1.0f, 0.0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        fortuneButtonController();
    }


    /**
     * Basic function to initialize all global variables
      */
    public void initializeVariables(){
        showFortuneButton = (Button) findViewById(R.id.button_show_fortune);
        fortuneOutcomeTextView = (TextView) findViewById(R.id.textview_fortune_outcome);
        randomNumberGen = new Random();

        fadeIn.setDuration(3000);//Random Fortune text fade in speed
        fadeOut.setDuration(6000);//Random Fortune text fade out speed
    }

    /**
     * Controller for the random fortune button (text on button is "Will do"
     * Used ontouch as opposed to onclick becuase it works better for custom buttons
     */
    public void fortuneButtonController(){
        showFortuneButton.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    //Random number between 1-8. Lower limit = inclusive; upper limit = exclusive
                    randomFortuneGenerator(randomNumberGen.nextInt(9 - 1) + 1);
                    showFortuneButton.setBackground(getResources().getDrawable(R.drawable.button_custom_clicked));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                   
                    showFortuneButton.setBackground(getResources().getDrawable(R.drawable.button_custom_unclicked));
                }
                return true;
            }
        });
    }

    /**
     * Matches random int to corresponding fortune
     * @param randomInt A randomly generated number between 1-8 that will created per button click
     */
    public void randomFortuneGenerator(int randomInt){
        fortuneOutcomeTextView.startAnimation(fadeOut);//Fades out previous fortune
        switch(randomInt)
        {
            case 1 :
                fortuneOutcomeTextView.setText(R.string.outcome_1);
                break;
            case 2 :
                fortuneOutcomeTextView.setText(R.string.outcome_2);
                break;
            case 3 :
                fortuneOutcomeTextView.setText(R.string.outcome_3);
                break;
            case 4 :
                fortuneOutcomeTextView.setText(R.string.outcome_4);
                break;
            case 5 :
                fortuneOutcomeTextView.setText(R.string.outcome_5);
                break;
            case 6 :
                fortuneOutcomeTextView.setText(R.string.outcome_6);
                break;
            case 7 :
                fortuneOutcomeTextView.setText(R.string.outcome_7);
                break;
            case 8 :
                fortuneOutcomeTextView.setText(R.string.outcome_8);
                break;
            default :
                fortuneOutcomeTextView.setText(R.string.outcome_blank);
        }
         fortuneOutcomeTextView.startAnimation(fadeIn);//fades in current fortune

    }



}
