
package com.example.user.alancevrehacimhesapla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class MainActivity extends AppCompatActivity {
// bu uygulmada
    ImageView triangle,square,rectangle,pentagonal,circle,geo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        triangle=(ImageView)findViewById(R.id.triangle);
        square=(ImageView)findViewById(R.id.square);
        rectangle=(ImageView)findViewById(R.id.rectangle);
        pentagonal=(ImageView)findViewById(R.id.pentagonal);
        circle=(ImageView)findViewById(R.id.circle);




        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Toast.makeText(MainActivity.this,"üçgen için hesaplama yapacaksınız..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),triangle.class);
                startActivity(i);
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Toast.makeText(MainActivity.this,"kare için hesaplama yapacaksınız..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),sqare.class);
                startActivity(i);
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"dikdörtgen için hesaplama yapacaksınız..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),rectangle.class);
                startActivity(i);
            }
        });

       pentagonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"çokgenler için hesaplama yapacaksınız..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),morepenta.class);
                startActivity(i);
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"daire için hesaplama yapacaksınız..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),circle.class);
                startActivity(i);
    }
});


    }

}
