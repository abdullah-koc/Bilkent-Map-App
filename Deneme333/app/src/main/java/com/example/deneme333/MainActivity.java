package com.example.deneme333;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        buttonGo = findViewById(R.id.buttonGo);

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
        arrayListGenel.add("-Lütfen bina seçin");
        Collections.sort(arrayListGenel);

        System.out.print(arrayListGenel.toString());
        arrayAdapterGenel = new ArrayAdapter<String>(getApplicationContext()
                , R.layout.spinneritem
                , android.R.id.text1
                ,arrayListGenel);
        arrayAdapterGenel.setDropDownViewResource(R.layout.forspinner);
        spinner1.setAdapter(arrayAdapterGenel);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 5){
                    buttonGo.setEnabled(true);
                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    intent.putExtra("answer", "A");
                    buttonGo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intent);
                        }
                    });
                }
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
}
