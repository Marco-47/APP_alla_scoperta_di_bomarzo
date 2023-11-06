package com.example.allascopertadibomarzo;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class ParcoDeiMostri extends AppCompatActivity {

    ViewPager vPPDM; //ViewPager Parco Dei Mostri
    boolean openS=false;
    boolean openO=false;
    boolean openE=false;

    private Recensione rec1, rec2, rec3, rec4;
    private RatingBar voto1, voto2, voto3, voto4;
    private TextView nome1, nome2, nome3, nome4;
    private TextView testo1, testo2, testo3, testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parco_dei_mostri);
        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Parco dei Mostri");

        //slide image
        vPPDM=findViewById(R.id.viewPagerParcoMostri);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.prima);
        imageList.add(R.drawable.seconda);
        MyAdapter myAdapter= new MyAdapter(imageList);
        vPPDM.setAdapter(myAdapter);
        CircleIndicator circleIndicator= findViewById(R.id.cerchiParcoMostri);
        circleIndicator.setViewPager(vPPDM);



        //button phone
        ImageView btnPhone= (ImageView) findViewById(R.id.telefono_image2);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0761924029"));
                startActivity(intent); }
        });

        //recensione
        /*Recensione rec1 = new Recensione();
        GestioneRecensione lsRec = new GestioneRecensione();
        lsRec.list.add(rec1);
        EditText mEdit = (EditText)findViewById(R.id.recensione);;
        Button btnPublica= (Button) findViewById(R.id.publica);
        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEdit != null) {
                    rec1.nome = mEdit.getText().toString();
                    btnPublica.setText(rec1.nome);
                }
            }
        });*/

        //button map
        ImageView posizione_specifica = (ImageView)findViewById(R.id.posizione_image5);
        posizione_specifica.setClickable(true);
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa",1);
            startActivity(polpette);
        });

        ImageView esperienza = (ImageView) findViewById(R.id.esperienza_parco);
        esperienza.setClickable(true);
        esperienza.setOnClickListener(x -> {
            Intent h = new Intent(this, scrivi_recensione.class);
            startActivityForResult(h, 1);
        });


        Button storia = (Button) findViewById(R.id.storia);
        Button esperienze_btn = (Button) findViewById(R.id.esperienze_btn);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutId);
        TextView textView = (TextView) findViewById(R.id.storiaId);
        ConstraintLayout layout_esperienze =(ConstraintLayout)findViewById(R.id.layout_esperienze_lay);
        Button buttonOpere= (Button) findViewById(R.id.buttonOpere);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        TextView orcoDelleFavole = (TextView) findViewById(R.id.orcoFavoleId);
        TextView statuaDelDrago = (TextView) findViewById(R.id.dragoId);
        TextView sfingi = (TextView) findViewById(R.id.sfingiId);
        constraintLayout2.setVisibility(View.GONE);
        orcoDelleFavole.setVisibility(View.GONE);
        sfingi.setVisibility(View.GONE);
        statuaDelDrago.setVisibility(View.GONE);


        orcoDelleFavole.setOnClickListener(o-> {
            Intent intent = new Intent(this, ActivityOrco.class);
            startActivity(intent);
        });
        statuaDelDrago.setOnClickListener(d-> {
            Intent intent2 = new Intent(this, ActivityDrago.class);
            startActivity(intent2);
        });
        sfingi.setOnClickListener(s-> {
            Intent intent3 = new Intent(this, ActivitySfingi.class);
            startActivity(intent3);
        });



        storia.setOnClickListener(v -> {
            if(openS){
                //allora chiudi
                constraintLayout.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                openS=false;
            }else{
                //allora apri
                constraintLayout.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                openS=true;
            }
        });

        buttonOpere.setOnClickListener(v -> {
            if(openO){
                //allora chiudi
                constraintLayout2.setVisibility(View.GONE);
                orcoDelleFavole.setVisibility(View.GONE);
                sfingi.setVisibility(View.GONE);
                statuaDelDrago.setVisibility(View.GONE);

                openO=false;
            }else{
                //allora apri
                constraintLayout2.setVisibility(View.VISIBLE);
                orcoDelleFavole.setVisibility(View.VISIBLE);
                statuaDelDrago.setVisibility(View.VISIBLE);
                sfingi.setVisibility(View.VISIBLE);
                openO=true;
            }
        });

        esperienze_btn.setOnClickListener(v -> {
            if(openE){
                //allora chiudi
                layout_esperienze.setVisibility(View.GONE);
                openE=false;
            }else{
                //allora apri
                layout_esperienze.setVisibility(View.VISIBLE);
                openE=true;
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

        rec1 = new Recensione((float) 4.5, "Piergiorgio", "Mi piacciono gli orchi");
        rec2 = new Recensione((float) 3.2, "Massimo Dalema", "Esperienza unica, la consiglio a tutti.");
        rec3 = new Recensione((float) 2.1, "Alessio", "La sicurezza non mi ha permesso di portarmi a casa le panche");
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
}
