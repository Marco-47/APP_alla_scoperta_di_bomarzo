package com.example.allascopertadibomarzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class scrivi_recensione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrivi_recensione);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView nome= (TextView) findViewById(R.id.inserisci_nome_txt);
        TextView commento= (TextView) findViewById(R.id.inserisci_commento);
        RatingBar voto= (RatingBar) findViewById(R.id.inserisci_voto);

        Button inserisci= (Button) findViewById(R.id.inserisci_btn);

        inserisci.setOnClickListener(v -> {

            Intent intent = new Intent();

            float voto_da_inserire = voto.getRating();
            String commento_da_inserire=commento.getText().toString();
            String nome_da_inserire=nome.getText().toString();

            intent.putExtra("voto",voto_da_inserire);
            intent.putExtra("nome", nome_da_inserire);
            intent.putExtra("testo",commento_da_inserire);

            setResult(RESULT_OK, intent);
            finish();

        });
    }
    //back arrow funzionante
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}