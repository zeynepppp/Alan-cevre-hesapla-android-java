package com.example.user.alancevrehacimhesapla;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sqare extends AppCompatActivity {
    EditText kareKenar;
    CheckBox cbAlan,cbCevre,cbHacim;
    TextView tvAlan,tvCevre,tvHacim;
    Button angry_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqare);
       cbAlan=(CheckBox)findViewById(R.id.cbAlan);
       cbCevre=(CheckBox)findViewById(R.id.cbCevre);
       cbHacim=(CheckBox)findViewById(R.id.cbHacim);
       kareKenar=(EditText)findViewById(R.id.dikmeuzunluk);
       tvAlan=(TextView)findViewById(R.id.tvAlan);
       tvCevre=(TextView)findViewById(R.id.tvCevre);
       tvHacim=(TextView)findViewById(R.id.tvHacim);
       angry_btn=(Button)findViewById(R.id.angry_btn);


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


        angry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(kareKenar.getText().toString().trim().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(sqare.this);
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
              final int kenar=Integer.valueOf(String.valueOf(kareKenar.getText()));

                Log.d(" D LOGU ", String.valueOf(kenar));

                hesapla islem= new hesapla();

                if(cbAlan.isChecked()){

                    int Asonuc=islem.KareAlanHesapla(kenar);
                    String sonucA= String.valueOf(Asonuc);
                    tvAlan.setText(sonucA);
                }
                if (cbHacim.isChecked()){

                    int Hsonuc=islem.KareHacimHesapla(kenar);
                    String sonucH=String.valueOf(Hsonuc);
                    tvHacim.setText(sonucH);
                }
                if (cbCevre.isChecked()){

                    int Csonuc=islem.KareCevreHesapla(kenar);
                    String sonucC=String.valueOf(Csonuc);
                    tvCevre.setText(sonucC);
                }

            }}
        });


    }

}
