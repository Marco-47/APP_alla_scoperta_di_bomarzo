package com.example.allascopertadibomarzo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class ActivityOrsini extends AppCompatActivity {
    ViewPager vOrsini;
    boolean open = false;
    boolean openE = false;
    String descrizione_breve="Il Palazzo Orsini è una struttura difensiva e residenziale sita nel comune di Bomarzo. Costruito a partire dal XVI secolo sui resti di un più antico castello medievale, fu poi rimaneggiato fino alla fine dell'Ottocento.";


    private Recensione rec1, rec2, rec3, rec4;
    private RatingBar voto1, voto2, voto3, voto4;
    private TextView nome1, nome2, nome3, nome4;
    private TextView testo1, testo2, testo3, testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Palazzo Orsini");
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_orsini);
        CircleIndicator circleIndicator = findViewById(R.id.cerchiOrsini);
        vOrsini = findViewById(R.id.viewPagerOrsini);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.palazzo_orsini);
        imageList.add(R.drawable.palazzoest1);
        imageList.add(R.drawable.palazzoest2);
        imageList.add(R.drawable.palazzoint1);
        imageList.add(R.drawable.palazzoint2);
        MyAdapter myAdapter = new MyAdapter(imageList);
        vOrsini.setAdapter(myAdapter);
        circleIndicator.setViewPager(vOrsini);

        TextView storia_txt = (TextView) findViewById(R.id.storia_orsini_txt);

        String storia = "Nel 1519 Giovanni Corrado Orsini, signore di Bomarzo, incaricò l'architetto senese Baldassarre Peruzzi di progettare un nuovo palazzo sulla struttura di un'ala del vecchio castello della città. L'anno dopo, in seguito alle seconde nozze di Gian Corrado con Clarice Orsini, i lavori ricevettero nuovo impulso sotto la direzione dello stesso Peruzzi e del di lui fratellastro, il pittore Pietro Antonio di Andrea.\n" +
                "\n" +
                "I lavori, tuttavia, non erano ancora finiti nel 1526, tanto che nel suo testamento Giovanni Corrado prescrisse ai figli di portarli a termine. Infatti, in seguito alla sua morte (1535), il progetto fu presso in mano dal secondogenito Pier Francesco, detto Vicino. Al suo impegno si devono la Loggia e l'Appartamento della Galleria, in origine destinato a lui ed a sua moglie, Giulia Farnese, oggi adibito a sede del municipale.\n" +
                "\n" +
                "Dopo la morte della Farnese i due figli e le rispettive mogli si insediarono nel palazzo: al pianterreno dell'ala del Peruzzi si stabilirono Corradino e Margherita Sabella; al primo piano Marzio e Porzia Vitelli. Ancora oggi si possono ammirare gli stemmi degli Orsini e dei Vitelli e i castelli delle rispettive famiglie, dipinti da Orazio Bernardo di Domenico.";
        TextView storia_breve_txt = (TextView) findViewById(R.id.storia_orsini_txt);
        storia_breve_txt.setText(storia);


        //descrizione breve
        TextView descrizione_breve_txt= (TextView)findViewById(R.id.descrizione_breve_orsini_txt);
        descrizione_breve_txt.setText(descrizione_breve);

        Button spinner_storia = (Button) findViewById(R.id.spinner_storia_orsini_btn);
        spinner_storia.setOnClickListener(v -> {
            if (open) {
                //allora chiudi
                storia_txt.setVisibility(View.GONE);
                open = false;
            } else {
                //allora apri
                storia_txt.setVisibility(View.VISIBLE);
                open = true;
            }
        });

        //click image
        ImageView posizione_specifica = (ImageView) findViewById(R.id.indirizzo_orsini);
        posizione_specifica.setClickable(true);
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa", 9);
            startActivity(polpette);

        });

        ImageView esperienza = (ImageView) findViewById(R.id.esperienza_orsini);
        esperienza.setClickable(true);
        esperienza.setOnClickListener(x -> {
            Intent h = new Intent(this, scrivi_recensione.class);
            startActivityForResult(h, 1);
        });

        ConstraintLayout layout_esperienze = (ConstraintLayout) findViewById(R.id.layout_esperienze_lay);
        Button esperienze_btn = (Button) findViewById(R.id.esperienze_btn);
        esperienze_btn.setOnClickListener(v -> {
            if (openE) {
                //allora chiudi
                layout_esperienze.setVisibility(View.GONE);
                openE = false;
            } else {
                //allora apri
                layout_esperienze.setVisibility(View.VISIBLE);
                openE = true;
            }
        });

        voto1 = (RatingBar) findViewById(R.id.ratingBar5);
        voto2 = (RatingBar) findViewById(R.id.ratingBar6);
        voto3 = (RatingBar) findViewById(R.id.ratingBar7);
        voto4 = (RatingBar) findViewById(R.id.ratingBar8);

        nome1 = (TextView) findViewById(R.id.nome1);
        nome2 = (TextView) findViewById(R.id.nome2);
        nome3 = (TextView) findViewById(R.id.nome3);
        nome4 = (TextView) findViewById(R.id.nome4);

        testo1 = (TextView) findViewById(R.id.testoc1);
        testo2 = (TextView) findViewById(R.id.testoc2);
        testo3 = (TextView) findViewById(R.id.testoc3);
        testo4 = (TextView) findViewById(R.id.testoc4);

        rec1 = new Recensione((float) 4.5, "Marco", "Mi piacciono gli orsi");
        rec2 = new Recensione((float) 3.2, "Tony Abbassa", "Bellissima esperienza con tutta la famiglia, torneremo sicuramente!");
        rec3 = new Recensione((float) 2.1, "Nando", "Bel posto");
        rec4 = new Recensione((float) 5.0, "Totti", "Magick");

        aggiorna();


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

    public void exange(Recensione r) {
        rec4 = rec3;
        rec3 = rec2;
        rec2 = rec1;
        rec1 = r;
        aggiorna();
    }

    private void aggiorna() {
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



    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_camera:
                Intent i = new Intent(this,ActivityCamera.class);
                i.putExtra("descrizione", descrizione_breve);
                startActivity(i);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}