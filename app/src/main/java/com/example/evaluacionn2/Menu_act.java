package com.example.evaluacionn2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        vf = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Maps(View v) {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }

    public void Info(View v) {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Insumos(View v) {
        Intent i = new Intent(this, Insumos_act.class);
        startActivity(i);
    }

    public void Clientes(View v) {
        ArrayList<String> ropa = new ArrayList<String>();

        ropa.add("Empty");
        ropa.add("Polera Karambit");
        ropa.add("Polera Pray");
        ropa.add("Polera Los Andes");
        ropa.add("Polera Calavera");
        ropa.add("Polera Molotov");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("ListaCatalogo", ropa);
        startActivity(i);
    }
}