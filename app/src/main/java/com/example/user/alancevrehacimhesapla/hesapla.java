package com.example.user.alancevrehacimhesapla;

public class hesapla {
    //medodlar



    public int KareAlanHesapla(int kareKenar){

        int Alan=kareKenar*kareKenar;

        return Alan;
    }

    public int DikdortgenAlanHesapla(int kenar1,int kenar2){

        return kenar1*kenar2;

    }

    public int CokgenAlan(int kenarsayisi,int kenaruzunlugu,int dikme){

        //Alan=n.a.r/2
int sonuc=(kenarsayisi*kenaruzunlugu*dikme)/2;

return sonuc;

    }

    public  int Alanucgen(int kenar,int yukseklik){
        int sonuc= (kenar*yukseklik)/2;
                return sonuc;
    }

    public Double DaireAlanHesapla(Double pi,int r){

        Double alan=pi*r*r;
        return alan;
    }

    public int KareCevreHesapla(int kareKenar){

        int Cevre=kareKenar*4;

        return Cevre;
    }
    public int DikdörtgenCevreHesapla(int kenar1 ,int kenar2 ){

        int sonuc=(2*kenar1)+(2*kenar2);
        return sonuc ;
    }

    public int moreCevre(int sayı,int uzunluk){

        return sayı*uzunluk;

    }



    public  Double DaireCevreHesapla(Double pi,int r){
        return 2*pi*r;
    }


    public int UcgenCevreHesapla(int k1,int k2,int k3){

        return k1+k2+k3;

    }
    public int KareHacimHesapla(int kareKenar){

        int Hacim=(kareKenar*kareKenar)*kareKenar;

        return Hacim;
    }

    public  int DikdortgenHacim(int a,int b,int c){

        return a*b*c;
    }

    public Double DaireHacim(Double pi,int r){
        return 4/3*pi*r*r*r;
    }


    public int CokgenHacim(int kuzunluk,int ksayı,int kr ,int h){
       int taban= CokgenAlan(kuzunluk, ksayı,kr);
        return taban*h;

    }



}

