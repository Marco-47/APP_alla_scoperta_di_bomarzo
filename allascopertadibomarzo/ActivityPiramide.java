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


public class ActivityPiramide extends AppCompatActivity {
    ViewPager vPiramide;
    boolean open = false;
    boolean openE = false;
    String descrizione_breve="Nei pressi del delizioso borgo di Bomarzo, famoso per ospitare il Sacro Bosco, noto come anche Parco dei Mostri, sorge un'enorme masso di pietra locale che già al tempo degli Etruschi, fra VII e VI secolo a.C, era stato adibito a luogo di culto. ";

    private Recensione rec1,rec2,rec3,rec4;
    private RatingBar voto1,voto2,voto3,voto4;
    private TextView nome1,nome2,nome3,nome4;
    private TextView testo1,testo2,testo3,testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Piramide Etrusca");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piramide);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //slide show
        CircleIndicator circleIndicator = findViewById(R.id.cerchiPiramide);
        vPiramide = findViewById(R.id.viewPagerPiramide);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.piramide);
        imageList.add(R.drawable.piramide2);
        imageList.add(R.drawable.piramide3);
        MyAdapter myAdapter = new MyAdapter(imageList);
        vPiramide.setAdapter(myAdapter);
        circleIndicator.setViewPager(vPiramide);


        TextView storia_txt = (TextView) findViewById(R.id.dettagli_piramide_txt);
        String storia= "Nota come Piramide Etrusca, essa si trova in zona “Tacchiolo”, vicino alla zona di “Santa Cecilia”; l’intero territorio circostante è ricco di reperti e insediamenti risalenti al periodo protostorico ed etrusco, come abitazioni rupestri, altari, tagliate e un cimitero paleocristiano.\n" +
                "\n" +
                "    La Piramide Etrusca è nota anche come “Altare piramidale” o “Sasso del predicatore”, nomi che ne evidenziano la funzione di sito per riti religiosi.\n" +
                "\n" +
                "    Il grande masso che costituisce la Piramide Etrusca misura circa 8 metri per 16 ed è stato rinvenuto tra la fitta vegetazione locale all’inizio degli anni Novanta da una spedizione guidata da alcuni ricercatori locali tra cui Giovanni Lamoratta e Giuseppe Maiorano.\n" +
                "\n" +
                "    Successivamente, nel 2008 la zona è stata completamente ripulita da Salvatore Fosci che armato di pazienza e passione per la sua terra, ha provveduto a tagliare via la fitta vegetazione che copriva la piramide etrusca di Bomarzo donandogli nuova vita e rendendo possibile l'accesso ai numerosi visitatori che da allora sono giunti fino a lì.\n" +
                "\n" +
                "    La struttura è una piramide tronca che ricorda in alcuni tratti quelle della civiltà Maya. Sul suo costone sono stati ricavati diversi sedili, delle piccole nicchie e una serie di gradini che permettono di raggiungere i due altari intermedi e quello posto alla sommità della piramide.\n" +
                "\n" +
                "    Salendo lungo la Piramide Etrusca è possibile osservare anche una serie di canali che molto probabilmente erano stati scavati per facilitare la raccolta dei liquidi versati durante i riti sacrificali.\n" +
                "\n" +
                "    Sono presenti inoltre una serie di canali che dovevano servire per la raccolta di liquidi versati durante i riti sacrificali e delle nicchie profonde circa 15 cm destinate ad accogliere strumenti di culto.\n" +
                "\n" +
                "    Il percorso per raggiungere la piramide, che parte dalla tagliata romana presente in località Rocchette non è dei più agevoli: sono necessari spirito di orientamento e delle buone scarpe da trekking ma i tesori che incontrerete durante il sentiero vi ripagheranno di ogni sforzo.";
        storia_txt.setText(storia);

        //descrizione breve
        TextView descrizione_breve_txt=(TextView)findViewById(R.id.descrizione_breve_piramide_txt);
        descrizione_breve_txt.setText(descrizione_breve);

        Button spinner_storia = (Button) findViewById(R.id.spinner_dettagli_piramide_btn);
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

        ImageView posizione_specifica = (ImageView) findViewById(R.id.indirizzo_piramide);
        posizione_specifica.setClickable(true);
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa", 3);
            startActivity(polpette);

        });

        ImageView esperienza = (ImageView) findViewById(R.id.esperienza_piramide);
        esperienza.setClickable(true);
        esperienza.setOnClickListener(x -> {
            Intent h = new Intent(this, scrivi_recensione.class);
            startActivityForResult(h, 1);
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

        rec1 = new Recensione((float) 4.5, "Tonino", "Mi piacciono le piramidi.");
        rec2 = new Recensione((float) 3.2, "Ezio Greggio", "Non immaginavo che ci fosse una piramide anche in Italia.");
        rec3 = new Recensione((float) 2.1, "Cristina", "Amo Bomarzo e la sua storia.");
        rec4 = new Recensione((float) 5.0, "Totti", "Magick");

        aggiorna();


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //Fai le cose qui
                float voto = data.getFloatExtra("voto", 3);
                String nome = data.getStringExtra("nome");
                String testo = data.getStringExtra("testo");

                Recensione r = new Recensione(voto, nome, testo);
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