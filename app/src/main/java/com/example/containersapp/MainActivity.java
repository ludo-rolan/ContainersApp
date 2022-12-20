package com.example.containersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView permet de charger la ressource de mise en page
        // à partir du code de l'application en lui transmettant la référence
        // à la ressource de mise en page sous la forme R.layout.activity_main
        // sachant que la ressource est activity_main.xml
        setContentView(R.layout.activity_main);
    }
}