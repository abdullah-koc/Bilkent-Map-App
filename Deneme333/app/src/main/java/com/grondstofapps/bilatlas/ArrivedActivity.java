package com.grondstofapps.bilatlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrivedActivity extends AppCompatActivity {

    private ImageView imageView2;
    private String buildingsFromMap;
    private TextView textViewBuilding;
    private Button buttonMainMenu2, buttonFeedback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrived);

        imageView2 = findViewById(R.id.imageView2);
        buildingsFromMap = getIntent().getStringExtra("building");
        textViewBuilding = findViewById(R.id.textViewBuilding);
        buttonFeedback2 = findViewById(R.id.buttonFeedback2);
        buttonMainMenu2 = findViewById(R.id.buttonMainMenu2);


        if(buildingsFromMap.equals("A")){ imageView2.setImageResource(R.drawable.a); textViewBuilding.setText("A Binası"); }
        if(buildingsFromMap.equals("B")){ imageView2.setImageResource(R.drawable.b); textViewBuilding.setText("B Binası"); }
        if(buildingsFromMap.equals("D")){ imageView2.setImageResource(R.drawable.d); textViewBuilding.setText("D Binası"); }
        if(buildingsFromMap.equals("EA")){ imageView2.setImageResource(R.drawable.ea); textViewBuilding.setText("EA Binası"); }
        if(buildingsFromMap.equals("EE")){ imageView2.setImageResource(R.drawable.ee); textViewBuilding.setText("EE Binası"); }
        if(buildingsFromMap.equals("Fx")){ imageView2.setImageResource(R.drawable.fx); textViewBuilding.setText("FX Binaları");}
        if(buildingsFromMap.equals("G")){ imageView2.setImageResource(R.drawable.g); textViewBuilding.setText("G Binası"); }
        if(buildingsFromMap.equals("MSSF")){ imageView2.setImageResource(R.drawable.mssf); textViewBuilding.setText("MSSF Binası"); }
        if(buildingsFromMap.equals("N")){ imageView2.setImageResource(R.drawable.n); textViewBuilding.setText("N Binası"); }
        if(buildingsFromMap.equals("SASB")){ imageView2.setImageResource(R.drawable.sasb); textViewBuilding.setText("SA/SB Binaları"); }
        if(buildingsFromMap.equals("V")){ imageView2.setImageResource(R.drawable.v); textViewBuilding.setText("V Binası"); }
        if(buildingsFromMap.equals("76")){ imageView2.setImageResource(R.drawable.yetmisalti); textViewBuilding.setText("76. Yurt"); }
        if(buildingsFromMap.equals("77")){ imageView2.setImageResource(R.drawable.yetmisyedi); textViewBuilding.setText("77. Yurt"); }
        if(buildingsFromMap.equals("78")){ imageView2.setImageResource(R.drawable.yetmissekiz); textViewBuilding.setText("78.Yurt"); }
        if(buildingsFromMap.equals("9091")){ imageView2.setImageResource(R.drawable.doksandoksanbir); textViewBuilding.setText("90/91. Yurtlar"); }
        if(buildingsFromMap.equals("YemekhaneMerkez")){ imageView2.setImageResource(R.drawable.yemekhanemerkez); textViewBuilding.setText("Merkez Yemekhane"); }
        if(buildingsFromMap.equals("YemekhaneDogu")){ imageView2.setImageResource(R.drawable.yemekhanedogu); textViewBuilding.setText("Doğu Yemekhane"); }
        if(buildingsFromMap.equals("BilkaMerkez")){ imageView2.setImageResource(R.drawable.bilkamerkez); textViewBuilding.setText("Merkez Bilka"); }
        if(buildingsFromMap.equals("BilkaDogu")){ imageView2.setImageResource(R.drawable.bilkadogu); textViewBuilding.setText("Doğu Bilka"); }
        if(buildingsFromMap.equals("CafeIn")){ imageView2.setImageResource(R.drawable.cafein); textViewBuilding.setText("Cafe In"); }
        if(buildingsFromMap.equals("CBMerkez")){ imageView2.setImageResource(R.drawable.cbmerkez); textViewBuilding.setText("Merkez Coffee Break"); }
        if(buildingsFromMap.equals("CBDogu")){ imageView2.setImageResource(R.drawable.cbdogu); textViewBuilding.setText("Doğu Coffee Break"); }
        if(buildingsFromMap.equals("KiracSpeed")){ imageView2.setImageResource(R.drawable.kiracspeed); textViewBuilding.setText("Kıraç/Speed"); }
        if(buildingsFromMap.equals("Sofa")){ imageView2.setImageResource(R.drawable.sofa); textViewBuilding.setText("Sofa Cafe"); }
        if(buildingsFromMap.equals("BilkentStore")){ imageView2.setImageResource(R.drawable.bilkentstore); textViewBuilding.setText("Bilkent Store"); }
        if(buildingsFromMap.equals("Kutuphane")){ imageView2.setImageResource(R.drawable.kutuphane); textViewBuilding.setText("Kütüphane"); }
        if(buildingsFromMap.equals("Mescid")){ imageView2.setImageResource(R.drawable.mescid); textViewBuilding.setText("Mescid"); }
        if(buildingsFromMap.equals("MeteksanKirtasiye")){ imageView2.setImageResource(R.drawable.meteksankirtasiye); textViewBuilding.setText("Meteksan Kırtasiye"); }
        if(buildingsFromMap.equals("MeteksanMarket")){ imageView2.setImageResource(R.drawable.meteksanmarket); textViewBuilding.setText("Meteksan Market"); }
        if(buildingsFromMap.equals("SaglikMerkez")){ imageView2.setImageResource(R.drawable.saglikmerkez); textViewBuilding.setText("Merkez Sağlık Merkezi"); }
        if(buildingsFromMap.equals("SaglikDogu")){ imageView2.setImageResource(R.drawable.saglikdogu); textViewBuilding.setText("Doğu Sağlık Merkezi"); }
        if(buildingsFromMap.equals("SporMerkez")){ imageView2.setImageResource(R.drawable.spormerkez); textViewBuilding.setText("Merkez Spor Salonu"); }
        if(buildingsFromMap.equals("SporDogu")){ imageView2.setImageResource(R.drawable.spordogu); textViewBuilding.setText("Doğu Spor Salonu"); }
        if(buildingsFromMap.equals("SporYurtlar")){ imageView2.setImageResource(R.drawable.sporyurtlar); textViewBuilding.setText("Yurtlar Spor Salonu"); }
        if(buildingsFromMap.equals("OgrenciIsleri")){  imageView2.setImageResource(R.drawable.ogrenciisleri); textViewBuilding.setText("Öğrenci İşleri"); }
        if(buildingsFromMap.equals("ODEON")){ imageView2.setImageResource(R.drawable.odeon); textViewBuilding.setText("ODEON"); }

        buttonMainMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArrivedActivity.this, MainActivity.class));
                finish();
            }
        });

        buttonFeedback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.grondstofapps.bilatlas")));
            }
        });


    }
}
