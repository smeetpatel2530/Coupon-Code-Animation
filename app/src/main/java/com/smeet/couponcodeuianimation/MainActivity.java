package com.smeet.couponcodeuianimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        final String coupon = "smeet";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(coupon)){

                    final TickerView tickerView = findViewById(R.id.tickerView);
                    tickerView.setCharacterLists(TickerUtils.provideNumberList());
                    tickerView.setAnimationDuration(5000);
                    tickerView.setAnimationInterpolator(new OvershootInterpolator());
                    tickerView.setText("$1,800");
                    tickerView.setText("$200");
                }else {

                    Toast.makeText(MainActivity.this, "Coupon is Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}