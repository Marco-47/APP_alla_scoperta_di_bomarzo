package com.example.allascopertadibomarzo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ActivityRestaurant1 extends AppCompatActivity {

    String numero_ristorante = "Assente";
    String indirizzo_web = "Assente";

    private Recensione rec1,rec2,rec3,rec4;
    private RatingBar voto1,voto2,voto3,voto4;
    private TextView nome1,nome2,nome3,nome4;
    private TextView testo1,testo2,testo3,testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView restaurantID = (TextView) findViewById(R.id.restaurantID);
        TextView orarioID = (TextView) findViewById(R.id.orarioID);
        ImageView immagine_ristorante = (ImageView) findViewById((R.id.ristorante1));
        ImageView web = (ImageView) findViewById(R.id.web_image);
        ImageView posizione_specifica = (ImageView)findViewById(R.id.posizione_image);
        ImageView telefono = (ImageView) findViewById(R.id.telefono_image);

        immagine_ristorante.setImageResource(R.drawable.ristorante1);


        Intent intent = new Intent();
        restaurantID.setText("La Cantina del Borgo");
        orarioID.setText("Assente");

        /**Inizio Tre Bottoni*/
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa",5);
            startActivity(polpette);

        });
        web.setOnClickListener(v -> {
            openDialog();
        });
        telefono.setOnClickListener(v -> {
            openDialog();
        });
        /**Fine Tre Bottoni*/


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

        rec1= new Recensione((float) 4.5,"Piergiorgio","Si mangia bene");
        rec2= new Recensione((float) 3.2,"Massimo Dalema","Il pesce era un po' scotto ma per il resto okay");
        rec3= new Recensione((float) 2.1,"Alessio","Mi compro la barca e me le pesco le cozze");
        rec4= new Recensione((float) 5.0,"Totti","Magick");

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

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resturant, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //back arrow funzionante
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }




}