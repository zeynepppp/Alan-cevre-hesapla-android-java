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

public class triangle extends AppCompatActivity {

    EditText ilkkenarkenar,ikincikenar,dikmekenari,dikmeuzunluk;
    CheckBox cbAlan,cbCevre ;
    TextView tvAlan,tvCevre ;
    Button angry_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);


        cbAlan=(CheckBox)findViewById(R.id.cbUAlan);
        cbCevre=(CheckBox)findViewById(R.id.cbUCevre);
        tvAlan=(TextView)findViewById(R.id.tvUAlan);
        tvCevre=(TextView)findViewById(R.id.tvUCevre);
        angry_btn=(Button)findViewById(R.id.angry_btn);
        ilkkenarkenar=(EditText)findViewById(R.id.kenar1);
        dikmeuzunluk=(EditText)findViewById(R.id.dikmeuzunluk);
        dikmekenari =(EditText)findViewById(R.id.dikmekenari);
        ikincikenar=(EditText)findViewById(R.id.kenar2);

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



        angry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(ilkkenarkenar.getText())&&!TextUtils.isEmpty(ikincikenar.getText())&&!TextUtils.isEmpty(dikmekenari.getText())&&!TextUtils.isEmpty(dikmeuzunluk.getText())) {


                    final int kenar1=Integer.valueOf(String.valueOf(ilkkenarkenar.getText()));
                final int kenar2 =Integer.valueOf(String.valueOf(ikincikenar.getText()));
                final int kenardikme=Integer.valueOf(String.valueOf(dikmekenari.getText()));
                final int duzunluk=Integer.valueOf(String.valueOf(dikmeuzunluk.getText()));

                hesapla islem= new hesapla();


                if(cbAlan.isChecked()){


                    int Asonuc=islem.Alanucgen(kenardikme,duzunluk);
                    String sonucA= String.valueOf(Asonuc);
                    tvAlan.setText(sonucA);
                }

                if (cbCevre.isChecked()){

                    int Csonuc=islem.UcgenCevreHesapla(kenar1,kenar2,kenardikme);
                    String sonucC=String.valueOf(Csonuc);
                    tvCevre.setText(sonucC);
                }

                if(!cbCevre.isChecked()&& !cbAlan.isChecked()){
                    Toast.makeText(getApplicationContext(),"SEÇİM YAPIN..",Toast.LENGTH_LONG).show();


                }}else{




                    AlertDialog.Builder builder = new AlertDialog.Builder(triangle.this);
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
