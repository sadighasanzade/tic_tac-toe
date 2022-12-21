package com.techsoldev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

import javax.security.auth.Subject;


public class SettingsActivity extends AppCompatActivity {

    Switch vibrationSwitch;
    Switch soundSwitch;


    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_settings);


         vibrationSwitch = (Switch)  findViewById(R.id.vibration_switch);
         soundSwitch = (Switch)  findViewById(R.id.sound_switch);

         backBtn = (ImageView) findViewById(R.id.settings_back_btn);

         if(MyServices.VIBRATION_CHECK)
         {
             vibrationSwitch.setChecked(true);
         }
         else if(!MyServices.VIBRATION_CHECK)
         {
             vibrationSwitch.setChecked(false);
         }



         vibrationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   MyServices.VIBRATION_CHECK =true;
               }
               else {
                   MyServices.VIBRATION_CHECK= false;
               }
            }

        });



        if(MyServices.SOUND_CHECK)
        {
            soundSwitch.setChecked(true);
        }
        else if(!MyServices.SOUND_CHECK)
        {
            soundSwitch.setChecked(false);
        }


       soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    MyServices.SOUND_CHECK =true;
                }
                else {
                    MyServices.SOUND_CHECK= false;
                }
            }

        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}