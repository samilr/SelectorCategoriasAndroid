package com.example.tarea4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    CheckBox persona, carro, musica, calle;
    Button btnMostrarImg, btnEditar, btnVerInfo;
    ImageView imagenMostrar;
    Alert AlertaBuilder = new Alert();
    AlertEdit AlertaBuilderEdit = new AlertEdit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicial();
    }

    public void inicial() {
        persona = findViewById(R.id.cbPersona);
        carro = findViewById(R.id.cbCarro);
        musica = findViewById(R.id.cbMusica);
        calle = findViewById(R.id.cbCalle);

        imagenMostrar = findViewById(R.id.imgImagen);

        btnMostrarImg = findViewById(R.id.btnMostrarImg);
        btnEditar = findViewById(R.id.btnEditar);
        btnVerInfo = findViewById(R.id.btnVerInfo);
    }

    public void isChecked(View view) {
        if (persona.isChecked() && carro.isChecked() && musica.isChecked() && calle.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.musicacaroopersona);
        } else if (persona.isChecked() && carro.isChecked() && musica.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.pcm);
        } else if (persona.isChecked() && calle.isChecked() && musica.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.pcam);
        } else if (persona.isChecked() && calle.isChecked() && carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.personacarrocalle);
        } else if (musica.isChecked() && calle.isChecked() && carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.musicacallecarro);
        } else if (persona.isChecked() && musica.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.personamusica);
        } else if (persona.isChecked() && carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.personacarro);
        } else if (persona.isChecked() && calle.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.personacalle);
        } else if (musica.isChecked() && calle.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.musicacalle);
        } else if (musica.isChecked() && carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.musicacarro);
        } else if (calle.isChecked() && carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.carrocalle);
        } else if (persona.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.persona);
        } else if (carro.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.carro);
        } else if (musica.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.musica);
        } else if (calle.isChecked()) {
            imagenMostrar.setImageResource(R.drawable.calle);
        } else {
            imagenMostrar.setImageResource(R.drawable.error);
        }
    }

    public void alertDialog(View view){
        AlertaBuilder.show(getSupportFragmentManager(), "Ejemplo");
    }

    public void alertDialogEdit(View view){
        AlertaBuilderEdit.show(getSupportFragmentManager(), "Ejemplo");
    }


}


