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

public class morepenta extends AppCompatActivity {

    EditText ksayi,kuzunluk,dikme,uzunluk;

    CheckBox cbAlan,cbCevre,cbHacim;
    TextView tvAlan,tvCevre,tvHacim;
    Button angry_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morepenta);

        cbAlan=(CheckBox)findViewById(R.id.cbAlanC);
        cbCevre=(CheckBox)findViewById(R.id.cbCevreC);
        cbHacim=(CheckBox)findViewById(R.id.cbHacimC);
        ksayi=(EditText)findViewById(R.id.kenarsayisi);
        tvAlan=(TextView)findViewById(R.id.tvAlanC);
        tvCevre=(TextView)findViewById(R.id.tvCevreC);
        tvHacim=(TextView)findViewById(R.id.tvHacimC);
        angry_btn=(Button)findViewById(R.id.angry_btn);
        kuzunluk=(EditText)findViewById(R.id.dikmeuzunluk);
        dikme=(EditText)findViewById(R.id.dikmekenari);
        uzunluk=(EditText)findViewById(R.id.uzunluk);

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


                if(!TextUtils.isEmpty(dikme.getText())&&!TextUtils.isEmpty(ksayi.getText())&&!TextUtils.isEmpty(kuzunluk.getText())&&!TextUtils.isEmpty(uzunluk.getText())) {

                    final int kenars = Integer.valueOf(String.valueOf(ksayi.getText()));
                    final int kenaru= Integer.valueOf(String.valueOf(kuzunluk.getText()));
                    final int r= Integer.valueOf(String.valueOf(dikme.getText()));
                    final int h= Integer.valueOf(String.valueOf(uzunluk.getText()));

                    hesapla islem = new hesapla();

                    if (cbAlan.isChecked()) {


                        int Asonuc = islem.CokgenAlan(kenars, kenaru,r);
                        String sonucA = String.valueOf(Asonuc);

                        tvAlan.setText(sonucA);
                    }
                    if (cbHacim.isChecked()) {

                       int Hsonuc = islem.CokgenHacim(kenars, kenaru, r,h);
                        String sonucH = String.valueOf(Hsonuc);
                        tvHacim.setText(sonucH);
                    }
                    if (cbCevre.isChecked()) {

                        int Csonuc = islem.moreCevre(kenars, kenaru);
                        String sonucC = String.valueOf(Csonuc);
                        tvCevre.setText(sonucC);
                    }

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(morepenta.this);
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
