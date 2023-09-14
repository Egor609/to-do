package com.example.android.architecture.blueprints.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

public class SplashScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, TasksActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
        @Override
        public void onBackPressed() {
            super.onBackPressed();

        }
}
