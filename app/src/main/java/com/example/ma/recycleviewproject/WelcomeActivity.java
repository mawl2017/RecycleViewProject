package com.example.ma.recycleviewproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ma.recycleviewproject.activity_five.Main5Activity;
import com.example.ma.recycleviewproject.activity_four.Main4Activity;
import com.example.ma.recycleviewproject.activity_one.MainActivity;
import com.example.ma.recycleviewproject.activity_threen.Main3Activity;
import com.example.ma.recycleviewproject.activity_two.Main2Activity;

public class WelcomeActivity extends Activity implements View.OnClickListener{
private Button btn_1,btn_2,btn_3,btn_4,btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_1= (Button) findViewById(R.id.button1);
        btn_2= (Button) findViewById(R.id.button2);
        btn_3= (Button) findViewById(R.id.button3);
        btn_4= (Button) findViewById(R.id.button4);
        btn_5= (Button) findViewById(R.id.button5);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(WelcomeActivity.this, Main2Activity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(WelcomeActivity.this, Main3Activity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(WelcomeActivity.this, Main4Activity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(WelcomeActivity.this, Main5Activity.class));
                break;
        }
    }
}
