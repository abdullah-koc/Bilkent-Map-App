package com.example.deneme333;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

    private Spinner spinner1, spinner2;
    private ArrayAdapter<String> arrayAdapterKategori, arrayAdapterBinalar, arrayAdapterYurtlar, arrayAdapterKafeler, arrayAdapterDiger
            , arrayAdapterGenel;
    private ArrayList<String> arrayListKategori, arrayListBinalar, arrayListYurtlar, arrayListKafeler, arrayListDiger, arrayListGenel;
    private Button buttonGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, MapActivity.class);

        spinner1 = findViewById(R.id.spinner1);

        buttonGo = findViewById(R.id.buttonGo);

        isInternetEnabled();


        arrayListKategori = new ArrayList<>();
    //    arrayListKategori.add("Lütfen kategori seçiniz");
        arrayListKategori.add("Binalar");
        arrayListKategori.add("Yurtlar");
        arrayListKategori.add("Kafeler");
        arrayListKategori.add("Diğer");

        arrayListBinalar = new ArrayList<>();
     //   arrayListBinalar.add("Lütfen bina seçiniz");
		
        arrayListBinalar.add("A Binası");
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

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                buttonGo.setEnabled(true);
                buttonGo.setOnClickListener(v -> {
					
					if(position == 0){
						intent.putExtra("answer", "ODEON");
					}
                    if(position == 1){
                        intent.putExtra("answer", "76");
                    }
                    if(position == 2){
                        intent.putExtra("answer", "77");
                    }
                    if(position == 3){
                        intent.putExtra("answer", "78");
                    }
                    if(position == 4){
                        intent.putExtra("answer", "9091");
                    }
                    if(position == 5){
                        intent.putExtra("answer", "A");
                    }
                    if(position == 6){
                        intent.putExtra("answer", "B");
                    }
                    if(position == 7){
                        intent.putExtra("answer", "Lab");
                    }
                    if(position == 8){
                        intent.putExtra("answer", "BilkaDogu");
                    }
                    if(position == 9){
                        intent.putExtra("answer", "BilkaMerkez");
                    }
                    if(position == 10){
                        intent.putExtra("answer", "BilkentStore");
                    }
                    if(position == 11){
                        intent.putExtra("answer", "CBlokAmfi");
                    }
                    if(position == 12){
                        intent.putExtra("answer", "CafeIn");
                    }
                    if(position == 13){
                        intent.putExtra("answer", "CBDogu");
                    }
                    if(position == 14){
                        intent.putExtra("answer", "CBKutuphaneAlt");
                    }
                    if(position == 15){
                        intent.putExtra("answer", "CBKutuphaneUst");
                    }
                    if(position == 16){
                        intent.putExtra("answer", "CBMerkez");
                    }
                    if(position == 17){
                        intent.putExtra("answer", "D");
                    }
                    if(position == 18){
                        intent.putExtra("answer", "YemekhaneDogu");
                    }
                    if(position == 19){
                        intent.putExtra("answer", "EA");
                    }
                    if(position == 20){
                        intent.putExtra("answer", "EE");
                    }
                    if(position == 21){
                        intent.putExtra("answer", "ExpressCafeG");
                    }
                    if(position == 22){
                        intent.putExtra("answer", "FameoEA");
                    }
                    if(position == 23){
                        intent.putExtra("answer", "FieroG");
                    }
                    if(position == 24){
                        intent.putExtra("answer", "Fx");
                    }
                    if(position == 25){
                        intent.putExtra("answer", "G");
                    }
                    if(position == 26){
                        intent.putExtra("answer", "Kutuphane");
                    }
                    if(position == 27){
                        intent.putExtra("answer", "KiracSpeed");
                    }
                    if(position == 28){
                        intent.putExtra("answer", "MSSF");
                    }
                    if(position == 29){
                        intent.putExtra("answer", "YemekhaneMerkez");
                    }
                    if(position == 30){
                        intent.putExtra("answer", "Mescid");
                    }
                    if(position == 31){
                        intent.putExtra("answer", "MeteksanKirtasiye");
                    }
                    if(position == 32){
                        intent.putExtra("answer", "MeteksanMarket");
                    }
                    if(position == 33){
                        intent.putExtra("answer", "MithatCoruhAmfi");
                    }
                    if(position == 34){
                        intent.putExtra("answer", "MozartB");
                    }
                    if(position == 35){
                        intent.putExtra("answer", "MozartD");
                    }
                    if(position == 36){
                        intent.putExtra("answer", "MozartEE");
                    }
                    if(position == 37){
                        intent.putExtra("answer", "MozartN");
                    }
                    if(position == 38){
                        intent.putExtra("answer", "N");
                    }
                    if(position == 39){
                        intent.putExtra("answer", "OgrenciIsleri");
                    }
                    if(position == 40){
                        intent.putExtra("answer", "Rektorluk");
                    }
                    if(position == 41){
                        intent.putExtra("answer", "SASB");
                    }
                    if(position == 42){
                        intent.putExtra("answer", "SaglikDogu");
                    }
                    if(position == 43){
                        intent.putExtra("answer", "SaglikMerkez");
                    }
                    if(position == 44){
                        intent.putExtra("answer", "Sofa");
                    }
                    if(position == 45){
                        intent.putExtra("answer", "SporDogu");
                    }
                    if(position == 46){
                        intent.putExtra("answer", "SporMerkez");
                    }
                    if(position == 47){
                        intent.putExtra("answer", "SporYurtlar");
                    }
                    if(position == 48){
                        intent.putExtra("answer", "StarbucksA");
                    }
                    if(position == 49){
                        intent.putExtra("answer", "StarbucksFC");
                    }
                    if(position == 50){
                        intent.putExtra("answer", "V");
                    }


                    startActivity(intent);
                    finish();
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



/*
        arrayAdapterKategori = new ArrayAdapter<String>(getApplicationContext()
                , R.layout.spinneritem
                , android.R.id.text1
                ,arrayListKategori);
        arrayAdapterKategori.setDropDownViewResource(R.layout.forspinner);
        spinner1.setAdapter(arrayAdapterKategori);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                if(spinner1.getSelectedItemPosition() == 2 && position == 1){
                    spinner2.setVisibility(View.VISIBLE);
                    arrayAdapterBinalar = new ArrayAdapter<String>(getApplicationContext()
                            , R.layout.spinneritem
                            , android.R.id.text1
                            ,arrayListBinalar);
                    arrayAdapterBinalar.setDropDownViewResource(R.layout.forspinner);
                    spinner2.setAdapter(arrayAdapterBinalar);
                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position == 1){
                                intent.putExtra("A", "A");
                                buttonGo.setEnabled(true);
                                buttonGo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {}
                    });

                }
                if(position == 2){
                    spinner2.setVisibility(View.VISIBLE);
                    arrayAdapterYurtlar = new ArrayAdapter<String>(getApplicationContext()
                            , R.layout.spinneritem
                            , android.R.id.text1
                            ,arrayListYurtlar);
                    arrayAdapterYurtlar.setDropDownViewResource(R.layout.forspinner);
                    spinner2.setAdapter(arrayAdapterYurtlar);
                }
                if(position == 3){
                    spinner2.setVisibility(View.VISIBLE);
                    arrayAdapterKafeler = new ArrayAdapter<String>(getApplicationContext()
                            , R.layout.spinneritem
                            , android.R.id.text1
                            ,arrayListKafeler);
                    arrayAdapterKafeler.setDropDownViewResource(R.layout.forspinner);
                    spinner2.setAdapter(arrayAdapterKafeler);
                }
                if(position == 4){
                    spinner2.setVisibility(View.VISIBLE);
                    arrayAdapterDiger = new ArrayAdapter<String>(getApplicationContext()
                            , R.layout.spinneritem
                            , android.R.id.text1
                            ,arrayListDiger);
                    arrayAdapterDiger.setDropDownViewResource(R.layout.forspinner);
                    spinner2.setAdapter(arrayAdapterDiger);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); */


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
}
