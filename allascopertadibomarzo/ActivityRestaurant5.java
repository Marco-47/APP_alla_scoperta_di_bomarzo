package com.example.allascopertadibomarzo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.allascopertadibomarzo.R;
import com.example.allascopertadibomarzo.specificmapmeglio;

public class ActivityRestaurant5 extends AppCompatActivity {

    String numero_ristorante = "+390761924466";
    String indirizzo_web = "http://www.clubpiccolomondo.it/";

    private Recensione rec1,rec2,rec3,rec4;
    private RatingBar voto1,voto2,voto3,voto4;
    private TextView nome1,nome2,nome3,nome4;
    private TextView testo1,testo2,testo3,testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);
        TextView restaurantID = (TextView) findViewById(R.id.restaurantID);
        TextView orarioID = (TextView) findViewById(R.id.orarioID);
        ImageView immagine_ristorante = (ImageView) findViewById((R.id.ristorante1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TextView titolorecensione1ID = (TextView) findViewById(R.id.recensione1) ;
        //TextView titolorecensione2ID = (TextView) findViewById(R.id.recensione2) ;
        //TextView titolorecensione3ID = (TextView) findViewById(R.id.recensione3) ;
        //TextView testorecensione1ID = (TextView) findViewById(R.id.recensione1) ;
        //TextView testorecensione2ID = (TextView) findViewById(R.id.recensione2) ;
        //TextView testorecensione3ID = (TextView) findViewById(R.id.recensione3) ;
        //TextView datarecensione1ID = (TextView) findViewById(R.id.recensione1) ;
        //TextView datarecensione2ID = (TextView) findViewById(R.id.recensione2) ;
        //TextView datarecensione3ID = (TextView) findViewById(R.id.recensione3) ;
        //titolorecensione1ID.setText("Marco Harambe");
        //titolorecensione2ID.setText("Nando Fettuccine");
        //titolorecensione3ID.setText("Carlo Verdone");
        //testorecensione1ID.setText("Ottima esperienza, pizza senza glutine molto buona, i primi ottimi e poi Ciro è troppo simpatico. Grazie.");
        //testorecensione2ID.setText("Tutte le volte che torniamo da Franco, devo dire sinceramente che è come tornare a casa.....ottima cucina, prezzi molto corretti, piatti curati e ben presentati ed accoglienza eccezionale. Ovviamente consigliato e da ritornare al più presto!!");
        //testorecensione3ID.setText("Tutto ottimo, la pizza mi ha stupito oltre ogni mia aspettativa!!! Una piacevole scoperta.");
        //datarecensione1ID.setText("1/02/2021");
        //datarecensione2ID.setText("25/01/2021");
        //datarecensione3ID.setText("19/11/2020 ");


        Intent intent = new Intent();
        restaurantID.setText("Tutto n'artro magnà");
        orarioID.setText("12–15:30 || 19:30–22. Chiuso il mercoledi");
        immagine_ristorante.setImageResource(R.drawable.ristorante5);



        ImageView posizione_specifica = (ImageView)findViewById(R.id.posizione_image);
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa",4);
            startActivity(polpette);

        });

        ImageView web = (ImageView)findViewById(R.id.web_image);
        web.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(indirizzo_web));
            startActivity(browserIntent);
        });

        ImageView telefono = (ImageView) findViewById(R.id.telefono_image);
        telefono.setOnClickListener(v -> {
            Intent phoneintent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numero_ristorante));
            startActivity(phoneintent);
        });

/**Inizio Sezione Delle Recensioni*/
        voto1=(RatingBar) findViewById(R.id.ratingbar_ristorante_1);
        voto2=(RatingBar)findViewById(R.id.ratingbar_ristorante_2);
        voto3=(RatingBar)findViewById(R.id.ratingbar_ristorante_3);
        voto4=(RatingBar)findViewById(R.id.ratingbar_ristorante_4);

        nome1=(TextView)findViewById(R.id.nome_ristorante_1_txt);
        nome2=(TextView)findViewById(R.id.nome_ristorante_2_txt);
        nome3=(TextView)findViewById(R.id.nome_ristorante_3_txt);
        nome4=(TextView)findViewById(R.id.nome_ristorante_4_txt);

        testo1=(TextView)findViewById(R.id.commento_ristorante_1_txt);
        testo2=(TextView)findViewById(R.id.commento_ristorante_2_txt);
        testo3=(TextView)findViewById(R.id.commento_ristorante_3_txt);
        testo4=(TextView)findViewById(R.id.commento_ristorante_4_txt);

        rec1= new Recensione((float) 5.0,"Er Braciola","Di nome e di fatto");
        rec2= new Recensione((float) 0.0,"","");
        rec3= new Recensione((float) 0.0,"","");
        rec4= new Recensione((float) 0.0,"","");

        aggiorna();

        /**Fine Sezione Delle Recensioni*/

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                //Fai le cose qui
                float voto = data.getFloatExtra("voto",3);
                String nome = data.getStringExtra("nome");
                String testo = data.getStringExtra("testo");

                Recensione r=new Recensione(voto, nome, testo);
                exange(r);

            }
        }
    }


    public void exange(Recensione r){
        rec4=rec3;
        rec3=rec2;
        rec2=rec1;
        rec1=r;
        aggiorna();
    }

    private void aggiorna(){
        voto1.setRating(rec1.getVoto());
        voto2.setRating(rec2.getVoto());
        voto3.setRating(rec3.getVoto());
        voto4.setRating(rec4.getVoto());

        nome1.setText(rec1.getNome());
        nome2.setText(rec2.getNome());
        nome3.setText(rec3.getNome());
        nome4.setText(rec4.getNome());

        testo1.setText(rec1.getTesto());
        testo2.setText(rec2.getTesto());
        testo3.setText(rec3.getTesto());
        testo4.setText(rec4.getTesto());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_review:
                Intent h = new Intent(this, scrivi_recensione.class);
                startActivityForResult(h, 1);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
        // return true;
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resturant, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void openDialog() {

        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }




}