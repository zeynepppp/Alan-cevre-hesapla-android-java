package com.example.user.alancevrehacimhesapla;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class rectangle extends AppCompatActivity {
    EditText kenarbir,kenariki,yukseklik;

    CheckBox cbAlan,cbCevre,cbHacim;
    TextView tvAlan,tvCevre,tvHacim;
    Button angry_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        cbAlan=(CheckBox)findViewById(R.id.cbAlanD);
        cbCevre=(CheckBox)findViewById(R.id.cbCevreD);
        cbHacim=(CheckBox)findViewById(R.id.cbHacimD);
        kenarbir=(EditText)findViewById(R.id.kenarsayisi);
        tvAlan=(TextView)findViewById(R.id.tvAlanD);
        tvCevre=(TextView)findViewById(R.id.tvCevreD);
        tvHacim=(TextView)findViewById(R.id.tvHacimD);
        angry_btn=(Button)findViewById(R.id.btn_dikdortgen);
        kenariki=(EditText)findViewById(R.id.dikmeuzunluk);
        yukseklik=(EditText)findViewById(R.id.dikmekenari);

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


                if(!TextUtils.isEmpty(yukseklik.getText())&&!TextUtils.isEmpty(kenariki.getText())&&!TextUtils.isEmpty(kenarbir.getText())) {

                    final int ikincikenar = Integer.valueOf(String.valueOf(kenariki.getText()));
                    final int h = Integer.valueOf(String.valueOf(yukseklik.getText()));
                    final int birincikenar = Integer.valueOf(String.valueOf(kenarbir.getText()));

                    hesapla islem = new hesapla();

                    if (cbAlan.isChecked()) {


                        int Asonuc = islem.DikdortgenAlanHesapla(birincikenar, ikincikenar);
                        String sonucA = String.valueOf(Asonuc);
                        tvAlan.setText(sonucA);
                    }
                    if (cbHacim.isChecked()) {

                        int Hsonuc = islem.DikdortgenHacim(birincikenar, ikincikenar, h);
                        String sonucH = String.valueOf(Hsonuc);
                        tvHacim.setText(sonucH);
                    }
                    if (cbCevre.isChecked()) {

                        int Csonuc = islem.DikdörtgenCevreHesapla(birincikenar, ikincikenar);
                        String sonucC = String.valueOf(Csonuc);
                        tvCevre.setText(sonucC);
                    }

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(rectangle.this);
                    builder.setTitle("Boş Alan");
                    builder.setMessage("Alanları doldurun!!!");
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

            }
        });

    }
}
