package com.example.user.alancevrehacimhesapla;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circle extends AppCompatActivity {

    EditText kareKenar;
    CheckBox cbAlan,cbCevre,cbHacim;
    TextView tvAlan,tvCevre,tvHacim;
    Button btn_Daire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        cbAlan=(CheckBox)findViewById(R.id.cbDAlan);
        cbCevre=(CheckBox)findViewById(R.id.cbDCevre);
        cbHacim=(CheckBox)findViewById(R.id.cbDHacim);
        kareKenar=(EditText)findViewById(R.id.yaricap);
        tvAlan=(TextView)findViewById(R.id.tvDAlan);
        tvCevre=(TextView)findViewById(R.id.tvDCevre);
        tvHacim=(TextView)findViewById(R.id.tvDHacim);
        btn_Daire=(Button)findViewById(R.id.btn_daire);

        cbAlan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbAlan.isChecked()) {

                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbCevre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbCevre.isChecked()){

                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbHacim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbHacim.isChecked()){

                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        btn_Daire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //kenar=> yaricap
                if(kareKenar.getText().toString().trim().equals("")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(circle.this);
                    builder.setTitle("Boş Alan ");
                    builder.setMessage("Boş alan bırakmayın..!!!");
                    builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {

                            //İptal butonuna basılınca yapılacaklar.Sadece kapanması isteniyorsa boş bırakılacak
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }
                    });


                    builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Tamam butonuna basılınca yapılacaklar

                        }
                    });

                    builder.show();


                }
                else{

                final int yaricap=Integer.valueOf(String.valueOf(kareKenar.getText()));
                NumberFormat nf = NumberFormat.getInstance();
                DecimalFormat df=new DecimalFormat("#.##");
                nf.setMaximumFractionDigits(2);

                hesapla islem= new hesapla();
                double pi=3.14;
                if(cbAlan.isChecked()){

                    Double Asonuc=islem.DaireAlanHesapla(pi,yaricap);
                    String dx=df.format(Asonuc);
                    String sonucA= String.valueOf(dx);

                    tvAlan.setText(sonucA);
                }
                if (cbHacim.isChecked()){

                    Double Hsonuc=islem.DaireHacim(pi,yaricap);
                    String sonucH=String.valueOf(Hsonuc);
                    tvHacim.setText(sonucH);
                }
                if (cbCevre.isChecked()){

                    Double Csonuc=islem.DaireCevreHesapla(pi,yaricap);
                    String sonucC=String.valueOf(Csonuc);
                    tvCevre.setText(sonucC);
                }

            }}
        });
    }


}
