package com.example.tarea4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AlertEdit extends DialogFragment {
    EditText txbNombre, txbAsignatura, txbInstituto;
    TextView txtNombre, txtAsignatura, txtInstituto;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_alert_edit, null);
        //txbNombre = view.findViewById(R.id.txbNombre);
        txbAsignatura = view.findViewById(R.id.txbAsignatura);
        txbInstituto = view.findViewById(R.id.txbInstituto);

        txtAsignatura = view.findViewById(R.id.txtAsignatura);
        txtInstituto = view.findViewById(R.id.txtInstituto);



        builder.setView(view)
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        txbNombre = view.findViewById(R.id.txbNombre);
                        txtNombre.setTextColor(getResources().getColor(R.color.white));
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
        return builder.create();
    }




}




