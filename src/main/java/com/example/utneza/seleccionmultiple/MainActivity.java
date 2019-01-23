package com.example.utneza.seleccionmultiple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EnumSet;

enum Celebridades{SHAKIRA,MESSI,PEYTON,RIHANNA,CR}
public class MainActivity extends AppCompatActivity {
    private CheckBox[] celebridades;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        salida=(TextView)findViewById(R.id.salida);
        celebridades = new CheckBox[]{
            (CheckBox)findViewById(R.id.sh),
            (CheckBox)findViewById(R.id.li),
            (CheckBox)findViewById(R.id.pe),
            (CheckBox)findViewById(R.id.ri),
            (CheckBox)findViewById(R.id.cr)
        };
        for (CheckBox cb:celebridades){
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    procesar();
                }

            });
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void procesar() {
        EnumSet <Celebridades> seleccion = EnumSet.noneOf(Celebridades.class);
        for (CheckBox cb: celebridades) {
            if(cb.isChecked()){
                switch (cb.getId()){
                    case R.id.sh:
                        seleccion.add(Celebridades.SHAKIRA);
                        continue;
                    case R.id.li:
                        seleccion.add(Celebridades.MESSI);
                        continue;
                    case R.id.pe:
                        seleccion.add(Celebridades.PEYTON);
                        continue;
                    case R.id.ri:
                        seleccion.add(Celebridades.RIHANNA);
                        continue;
                    case R.id.cr:
                        seleccion.add(Celebridades.CR);
                        break;

                }
            }
        }
        salida.setText(seleccion.toString());
        Toast.makeText(MainActivity.this,seleccion.size()==3?"Autorizado":"No autorizado", Toast.LENGTH_LONG).show();
    }
}
