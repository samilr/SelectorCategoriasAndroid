package com.example.tarea4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    CheckBox persona, carro, musica, calle;
    Button btnMostrarImg, btnEditar, btnVerInfo;
    ImageView imagenMostrar;
    EditText txbNombre, txbAsignatura, txbInstituto, txb;
    TextView txtNombre, txtAsignatura, txtInstituto, txt;

    private static final String TAG = "Swipe Position";
    private float x1, x2, y1, y2;
    private static int MIN_DISTANCE = 150;
    private GestureDetector gestureDetector;
    String nombre = "Samir", asignatura = "Mobile", instituto = "ITLA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicial();
        this.gestureDetector = new GestureDetector(MainActivity.this, this);
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

    public void alertEdit(View view){
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final View vistaAlertEdit = inflater.inflate(R.layout.activity_alert_edit, null);

        txbNombre = vistaAlertEdit.findViewById(R.id.txbNombre);
        txbAsignatura = vistaAlertEdit.findViewById(R.id.txbAsignatura);
        txbInstituto = vistaAlertEdit.findViewById(R.id.txbInstituto);

        txbNombre.setText(nombre);
        txbAsignatura.setText(asignatura);
        txbInstituto.setText(instituto);

        builder.setView(vistaAlertEdit)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            nombre = txbNombre.getText().toString();
                            asignatura = txbAsignatura.getText().toString();
                            instituto = txbInstituto.getText().toString();
                        }
                    }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            builder.create();
            builder.show();
    }

    public void alertInfo(View view){
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final View vistaAlertEdit = inflater.inflate(R.layout.activity_alert, null);

        txtNombre = vistaAlertEdit.findViewById(R.id.txtNombre);
        txtAsignatura = vistaAlertEdit.findViewById(R.id.txtAsignatura);
        txtInstituto = vistaAlertEdit.findViewById(R.id.txtInstituto);

        builder.setView(vistaAlertEdit)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        txtNombre.setText(nombre);
        txtAsignatura.setText(asignatura);
        txtInstituto.setText(instituto);
        builder.create();
        builder.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float valueX = x2 - x1;
                float valueY = y2 - y1;

                if (Math.abs(valueX) > MIN_DISTANCE){
                    if (x2>x1){
                        MainActivity.this.finish();
                        System.exit(0);
                    }else {
                        MainActivity.this.finish();
                        System.exit(0);
                    }
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

}




