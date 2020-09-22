package com.grondstofapps.bilatlas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.location.LocationManagerCompat;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

    private Spinner spinner1, spinner2;
    private ArrayAdapter<String> arrayAdapterKategori, arrayAdapterBinalar, arrayAdapterYurtlar, arrayAdapterKafeler, arrayAdapterDiger
            , arrayAdapterGenel;
    private ArrayList<String> arrayListKategori, arrayListBinalar, arrayListYurtlar, arrayListKafeler, arrayListDiger, arrayListGenel;
    private Button buttonGo , buttonGeriBildirim2;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, MapActivity.class);

        spinner1 = findViewById(R.id.spinner1);

        buttonGo = findViewById(R.id.buttonGo);
        buttonGeriBildirim2 = findViewById(R.id.buttonGeriBildirim2);
        tv = findViewById(R.id.textViewBilgi);

        isInternetEnabled();

        if(isLocationEnabled(this) == false){
            Toast.makeText(getApplicationContext(),  "Öncelikle konumunu açmalısın.", Toast.LENGTH_LONG).show();
            startActivity( new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS) );
        }

        arrayListKategori = new ArrayList<>();
    //    arrayListKategori.add("Lütfen kategori seçiniz");
        arrayListKategori.add("Binalar");
        arrayListKategori.add("Yurtlar");
        arrayListKategori.add("Kafeler");
        arrayListKategori.add("Diğer");

        arrayListBinalar = new ArrayList<>();
     //   arrayListBinalar.add("Lütfen bina seçiniz");
		
        arrayListBinalar.add("A Binası (H, MA, T)");
        arrayListBinalar.add("B Binası");
        arrayListBinalar.add("D Binası");
        arrayListBinalar.add("EA Binası");
        arrayListBinalar.add("EE Binası");
        arrayListBinalar.add("Fx Binaları");
        arrayListBinalar.add("G Binası");
        arrayListBinalar.add("MSSF Binası");
        arrayListBinalar.add("N Binası");
        arrayListBinalar.add("SA-SB Binaları");
        arrayListBinalar.add("V Binası");

        arrayListYurtlar = new ArrayList<>();
      //  arrayListYurtlar.add("Lütfen bina seçiniz");
        arrayListYurtlar.add("76.Yurt");
        arrayListYurtlar.add("77.Yurt");
        arrayListYurtlar.add("78.Yurt");
        arrayListYurtlar.add("90-91.Yurtlar");

        arrayListKafeler = new ArrayList<>();
     //   arrayListKafeler.add("Lütfen kafe seçiniz");
        arrayListKafeler.add("Merkez Yemekhane");
        arrayListKafeler.add("Doğu Yemekhane");
        arrayListKafeler.add("Bilka-Merkez Kampüs");
        arrayListKafeler.add("Bilka-Doğu Kampüs");
        arrayListKafeler.add("Cafe In");
        arrayListKafeler.add("Coffee Break-Doğu");
        arrayListKafeler.add("Coffee Break-Merkez");
        //---------------------Erhan----------------------------------
        arrayListKafeler.add("Coffee Break-Kütüphane Alt Kat");
        arrayListKafeler.add("Coffee Break-Kütüphane Üst Kat");
        arrayListKafeler.add("Express Cafe-G Binası");
        arrayListKafeler.add("Fameo-EA Binası");
        arrayListKafeler.add("Fiero-G Binası");
        arrayListKafeler.add("Kıraç-Speed");
        arrayListKafeler.add("Mozart Cafe-B Binası");
        arrayListKafeler.add("Mozart Cafe-D Binası");
        arrayListKafeler.add("Mozart Cafe-EE Binası");
        arrayListKafeler.add("Mozart Cafe-N Binası");
        arrayListKafeler.add("Sofa");
        arrayListKafeler.add("Starbucks-A Binası");
        arrayListKafeler.add("Starbucks-FC Binası");

        arrayListDiger = new ArrayList<>();
     //   arrayListDiger.add("Lütfen seçiniz");
        arrayListDiger.add("Bilgisayar Laboratuvarları");
        //--------------------------Furkan-------------------------------
        arrayListDiger.add("Bilkent Store");
        arrayListDiger.add("C Blok Amfi");
        arrayListDiger.add("Kütüphane");
        arrayListDiger.add("Mescid");
        arrayListDiger.add("Meteksan Kırtasiye");
        arrayListDiger.add("Meteksan Market");
        arrayListDiger.add("Mithat Çoruh Amfi");
        arrayListDiger.add("Oğrenci İşleri");
        arrayListDiger.add("Rektörlük");
        arrayListDiger.add("Sağlık Merkezi-Merkez Kampüs");
        arrayListDiger.add("Sağlık Merkezi-Doğu Kampüs");
        arrayListDiger.add("Spor Salonu-Doğu");
        arrayListDiger.add("Spor Salonu-Merkez");
        arrayListDiger.add("Spor Salonu-Yurtlar");
        //-----------------Abdullah------------------------

        arrayListGenel = new ArrayList<>();
        arrayListGenel.addAll(arrayListBinalar);
        arrayListGenel.addAll(arrayListDiger);
        arrayListGenel.addAll(arrayListKafeler);
        arrayListGenel.addAll(arrayListYurtlar);
        arrayListGenel.add(" ODEON");
        Collections.sort(arrayListGenel);


        arrayAdapterGenel = new ArrayAdapter<String>(getApplicationContext()
                , R.layout.spinneritem
                , android.R.id.text1
                ,arrayListGenel);
        arrayAdapterGenel.setDropDownViewResource(R.layout.forspinner);
        spinner1.setAdapter(arrayAdapterGenel);

        buttonGeriBildirim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.grondstofapps.bilatlas")));
            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    intent.putExtra("answer", "ODEON");
                    tv.setText("GE100, Mayfest konserleri ve bazı etkinliklerin yapıldığı yer");
                }
                if(position == 1){
                    intent.putExtra("answer", "76");
                    tv.setText("");
                }
                if(position == 2){
                    intent.putExtra("answer", "77");
                    tv.setText("");
                }
                if(position == 3){
                    intent.putExtra("answer", "78");
                    tv.setText("");
                }
                if(position == 4){
                    intent.putExtra("answer", "9091");
                    tv.setText("");
                }
                if(position == 5){
                    intent.putExtra("answer", "A");
                    tv.setText("İşletme binası, mescid-yemekhane yolu tarafında da girişi vardır (MA, T, H binaları da bu binanın içindedir)");
                }
                if(position == 6){
                    intent.putExtra("answer", "B");
                    tv.setText("");
                }
                if(position == 7){
                    intent.putExtra("answer", "Lab");
                    tv.setText("");
                }
                if(position == 8){
                    intent.putExtra("answer", "BilkaDogu");
                    tv.setText("Bazı market ürünlerini de bulabileceğiniz bir kafe");
                }
                if(position == 9){
                    intent.putExtra("answer", "BilkaMerkez");
                    tv.setText("Bazı market ürünlerini de bulabileceğiniz bir kafe");
                }
                if(position == 10){
                    intent.putExtra("answer", "BilkentStore");
                    tv.setText("Bilkent logolu ürünlerin satıldığı mağaza");
                }
                if(position == 11){
                    intent.putExtra("answer", "CBlokAmfi");
                    tv.setText("Bazı etkinliklerin ve derslerin yapıldığı amfi");
                }
                if(position == 12){
                    intent.putExtra("answer", "CafeIn");
                    tv.setText("Öğle araları ve akşam yemek yiyebileceğiniz güzel bir restoran");
                }
                if(position == 13){
                    intent.putExtra("answer", "CBDogu");
                    tv.setText("");
                }
                if(position == 14){
                    intent.putExtra("answer", "CBKutuphaneAlt");
                    tv.setText("");
                }
                if(position == 15){
                    intent.putExtra("answer", "CBKutuphaneUst");
                    tv.setText("");
                }
                if(position == 16){
                    intent.putExtra("answer", "CBMerkez");
                    tv.setText("");
                }
                if(position == 17){
                    intent.putExtra("answer", "D");
                    tv.setText("");
                }
                if(position == 18){
                    intent.putExtra("answer", "YemekhaneDogu");
                    tv.setText("");
                }
                if(position == 19){
                    intent.putExtra("answer", "EA");
                    tv.setText("Mühendislik binası");
                }
                if(position == 20){
                    intent.putExtra("answer", "EE");
                    tv.setText("Elektrik-Elektronik Mğhendisliği binası");
                }
                if(position == 21){
                    intent.putExtra("answer", "ExpressCafeG");
                    tv.setText("");
                }
                if(position == 22){
                    intent.putExtra("answer", "FameoEA");
                    tv.setText("");
                }

                if(position == 23){
                    intent.putExtra("answer", "FieroG");
                    tv.setText("");
                }
                if(position == 24){
                    intent.putExtra("answer", "Fx");
                    tv.setText("FA, FB, FC, FF binaları");
                }
                if(position == 25){
                    intent.putExtra("answer", "G");
                    tv.setText("");
                }
                if(position == 26){
                    intent.putExtra("answer", "Kutuphane");
                    tv.setText("");
                }
                if(position == 27){
                    intent.putExtra("answer", "KiracSpeed");
                    tv.setText("Öğle araları ve akşam yemek yiyebileceğiniz güzel bir restoran");
                }
                if(position == 28){
                    intent.putExtra("answer", "MSSF");
                    tv.setText("Müzik ve sahne sanatları fakültesi");
                }
                if(position == 29){
                    intent.putExtra("answer", "YemekhaneMerkez");
                    tv.setText("");
                }
                if(position == 30){
                    intent.putExtra("answer", "Mescid");
                    tv.setText("");
                }
                if(position == 31){
                    intent.putExtra("answer", "MeteksanKirtasiye");
                    tv.setText("");
                }
                if(position == 32){
                    intent.putExtra("answer", "MeteksanMarket");
                    tv.setText("");
                }
                if(position == 33){
                    intent.putExtra("answer", "MithatCoruhAmfi");
                    tv.setText("Bazı etkinliklerin yapıldığı amfi");
                }
                if(position == 34){
                    intent.putExtra("answer", "MozartB");
                    tv.setText("");
                }
                if(position == 35){
                    intent.putExtra("answer", "MozartD");
                    tv.setText("");
                }
                if(position == 36){
                    intent.putExtra("answer", "MozartEE");
                    tv.setText("");
                }
                if(position == 37){
                    intent.putExtra("answer", "MozartN");
                    tv.setText("");
                }
                if(position == 38){
                    intent.putExtra("answer", "N");
                    tv.setText("");
                }
                if(position == 39){
                    intent.putExtra("answer", "OgrenciIsleri");
                    tv.setText("");
                }
                if(position == 40){
                    intent.putExtra("answer", "Rektorluk");
                    tv.setText("");
                }
                if(position == 41){
                    intent.putExtra("answer", "SASB");
                    tv.setText("Fen fakültesi binaları");
                }
                if(position == 42){
                    intent.putExtra("answer", "SaglikDogu");
                    tv.setText("");
                }
                if(position == 43){
                    intent.putExtra("answer", "SaglikMerkez");
                    tv.setText("");
                }
                if(position == 44){
                    intent.putExtra("answer", "Sofa");
                    tv.setText("Öğle araları ve akşam yemek yiyebileceğiniz güzel bir restoran");
                }
                if(position == 45){
                    intent.putExtra("answer", "SporDogu");
                    tv.setText("");
                }
                if(position == 46){
                    intent.putExtra("answer", "SporMerkez");
                    tv.setText("");
                }
                if(position == 47){
                    intent.putExtra("answer", "SporYurtlar");
                    tv.setText("");
                }
                if(position == 48){
                    intent.putExtra("answer", "StarbucksA");
                    tv.setText("");
                }
                if(position == 49){
                    intent.putExtra("answer", "StarbucksFC");
                    tv.setText("");
                }
                if(position == 50){
                    intent.putExtra("answer", "V");
                    tv.setText("");
                }
                buttonGo.setEnabled(true);
                buttonGo.setOnClickListener(v -> {
                    startActivity(intent);
                    finish();
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }





    private boolean isLocationEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return LocationManagerCompat.isLocationEnabled(locationManager);
    }

    public void isInternetEnabled() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if ( netInfo != null && netInfo.isConnectedOrConnecting() ) {
            return;
        } else {
            Toast.makeText(this, "BilMap'i kullanabilmek için geçerli bir internet bağlantısı gerekir.", Toast.LENGTH_LONG).show();
            startActivity( new Intent(Settings.ACTION_SETTINGS) );
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
