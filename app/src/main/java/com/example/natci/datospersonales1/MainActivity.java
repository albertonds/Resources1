package com.example.natci.datospersonales1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText lblNombre;
    EditText lblApellido;
    EditText lblEdad;
    Button buttonGenerar;
    ImageButton buttonBorrar;
    TextView txtFinal;
    Spinner spCivil;
    RadioButton radioH;
    RadioButton radioM;
    RadioGroup radioGroup;
    String genero;
    Switch switchHijos;
    String hijos;
    String edad;
    String[] civil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        lblNombre = findViewById(R.id.lblNombre);
        lblApellido = findViewById(R.id.lblApellido);
        lblEdad = findViewById(R.id.lblEdad);
        buttonGenerar = findViewById(R.id.buttonGenerar);
        txtFinal = findViewById(R.id.txtFinal);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        spCivil = findViewById(R.id.spCivil);
        radioGroup = findViewById(R.id.radiogroup);
        radioH = findViewById(R.id.radioH);
        radioM = findViewById(R.id.radioM);
        switchHijos = findViewById(R.id.switchHijos);
        hijos = getResources().getString(R.string.si);

        String[] civil = new String[] {getResources().getString(R.string.Otro),getResources().getString(R.string.Casado),getResources().getString(R.string.Soltero),getResources().getString(R.string.Viudo),getResources().getString(R.string.Casado)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, civil);
        spCivil.setAdapter(adaptador);

        buttonGenerar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(lblApellido.getText().toString().equals(""))//bibliografia: https://stackoverflow.com/questions/14500119/displaying-an-alert-dialog-is-a-text-field-is-empty
                {
                    Toast.makeText(getBaseContext(), "No has introducido el nombre",    Toast.LENGTH_SHORT).show();

                }
                else if(lblNombre.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(), "No has introducido el apellido",    Toast.LENGTH_SHORT).show();

                }
                else if(lblEdad.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(), "No has introducido la edad",    Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (Integer.parseInt(lblEdad.getText().toString()) >= 18) {
                        edad = getResources().getString(R.string.mayor);
                    } else {
                        edad = getResources().getString(R.string.menor);
                    }
                    String info = lblApellido.getText().toString() + " " + lblNombre.getText() + " , " + edad + " , " + spCivil.getSelectedItem().toString() + " , " + genero + " , " + hijos;
                    txtFinal.setText(info);

                }





            }
        });
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblEdad.setText("");
                lblApellido.setText("");
                lblNombre.setText("");
                txtFinal.setText("");
                radioH.setChecked(false);
                radioM.setChecked(false);
                switchHijos.setChecked(false);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioH) {
                    genero = getResources().getString(R.string.radioH);
                } else if (checkedId == R.id.radioM) {
                    genero = getResources().getString(R.string.radioM);
                }


            }
        });
        switchHijos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchHijos.isChecked() == false) {
                    hijos = getResources().getString(R.string.si);
                }else {

                    if (switchHijos.isChecked() == true) {
                        hijos = getResources().getString(R.string.no);
                    }
                }
            }
        });
        spCivil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spCivil.getSelectedItemPosition();
                spCivil.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }




}