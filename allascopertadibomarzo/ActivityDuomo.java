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


public class ActivityDuomo extends AppCompatActivity {

    ViewPager vDuomo;
    boolean open=false;
    boolean open2=false;
    boolean openE= false;
    String descrizione_breve="Il duomo di Bomarzo, dedicato a Santa Maria Assunta in Cielo, è un edificio religioso sede dell'omonima parrocchia. Ad essa si accede attraverso due gradinate di accesso a ferro di cavallo; al suo interno, sotto l’altare maggiore sono conservate le spoglie di Sant’Anselmo, vescovo e patrono di Bomarzo.";


    private Recensione rec1,rec2,rec3,rec4;
    private RatingBar voto1,voto2,voto3,voto4;
    private TextView nome1,nome2,nome3,nome4;
    private TextView testo1,testo2,testo3,testo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duomo);
        this.setTitle("Duomo Di Bomarzo");
        //back arrow

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //slide show
        CircleIndicator circleIndicator= findViewById(R.id.cerchiDuomo);
        vDuomo=findViewById(R.id.viewPagerDuomo);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.duomoest2);
        imageList.add(R.drawable.duomoint1);
        imageList.add(R.drawable.duomoint2);
        MyAdapter myAdapter= new MyAdapter(imageList);
        vDuomo.setAdapter(myAdapter);
        circleIndicator.setViewPager(vDuomo);


        //storia
        String storia="L'evangelizzazione di Bomarzo deve risalire ad un periodo molto antico se già nel VI secolo possedeva un vescovo ed un capitolo. Lo storico Flavio Biondo ipotizza addirittura che il Papa Sabiniano, pontefice dal 604 al 606, sia nato proprio a Bomarzo. Da ciò possiamo arguire che già in epoca bizantina il borgo fosse anche provvisto di una chiesa di una certa importanza, costruita in stile paleocristiano. In età carolingia il duomo venne probabilmente modificato, come dimostrano alcuni elementi architettonici risalenti al VII-IX secolo.\n" +
                "\n" +
                "La struttura attuale risale al XV secolo e risente dello stile di Filippo Brunelleschi che in quel periodo operava a Firenze. Nel 1546, sotto la loggia della facciata, fu scavato un pozzo a beneficio della comunità bomarzese. L'opera, voluta dal defunto signore di Bomarzo Giovanni Corrado Orsini, fu completata dalla di lui nuora Giulia Farnese mentre suo marito, Pietro Francesco detto Vicino, era in Germania a combattere per Carlo V. Ulteriori modifiche si ebbero nel Seicento, quando furono completate la facciata e la gradinata di accesso.";
        TextView storia_txt = (TextView) findViewById(R.id.storia_duomo_txt);
        storia_txt.setText(storia);

        //descrizione breve
        TextView descrizione_breve_txt= (TextView) findViewById(R.id.descrizione_breve_duomo);
        descrizione_breve_txt.setText(descrizione_breve);

        Button spinner_storia=(Button)findViewById(R.id.spinner_storia_duomo_btn);
        spinner_storia.setOnClickListener(v -> {
            if(open){
                //allora chiudi
                storia_txt.setVisibility(View.GONE);
                open=false;
            }else{
                //allora apri
                storia_txt.setVisibility(View.VISIBLE);
                open=true;
            }
        });


        String descrizione_lunga="La facciata, dalle linee sobrie e semplici, è caratterizzata da un'elegante scalinata a ferro di cavallo, risalente al XVII secolo. Altri elementi salienti sono le porte, ingentilite da dei lacunari classicheggianti, ed i pignoni inseriti nel secondo ordine, contemporaneo alla gradinata.\n \nL'interno della chiesa è a tre navate divise da pilastri in peperino, e si accorda bene con l'austerità e l'eleganza dell'esterno. Nell'altare maggiore è inserita una pregevole pala raffigurante Sant'Anselmo che sostiene la città di Bomarzo e la rivolge alla Vergine Assunta, a cui è dedicato il duomo. Sotto l'altare sono custodite le spoglie del santo stesso. Sulle pareti del presbiterio sono raffigurate scene della vita della Vergine (XVI secolo) ed il miracolo operato da Sant'Anselmo per liberare Bomarzo da Totila. Il soffitto dell'abside raffigura invece lo stemma degli Orsini affiancato da dei medaglioni con le raffigurazioni degli Evangelisti. Sull'arco di trionfo è invece raffigurata l'incoronazione della Vergine, attorniata da angeli e santi (XVII secolo). La tempera è affiancata dalle statue dei Santi Pietro e Paolo sorrette da dei capitelli di epoca romana.\n \nIn fondo alla navata, inserito in una nicchia, è raffigurato il martirio di San Sebastiano, risalente agli inizi del secolo XVI e mutilo in alcune sue parti. Sotto a questo altare era custodito, fino al 1647, il corpo di Sant'Anselmo. Sulla parete destra sono poi presenti una tela raffigurante la Vergine del Rosario (XVI secolo), una Maestà di scuola umbra (XV secolo) ed un sarcofago romano in marmo con coperchio di epoca carolingia, inserito in una piccola abside ricavata dal muro perimetrale. Sopra il confessionale fa mostra di sé una tela raffigurante Sant'Anna e la Vergine bambina di scuola lombarda (XVII secolo).\n \nIn fondo alla navata si trova l'altare della Madonna del Rosario, attorniato da lacunari contenenti le raffigurazione dei Misteri del Rosario. L'opera risale al Quattrocento, ma non è completamente leggibile a causa di un altare marmoreo appostovi in epoca successiva. Sopra la porta dell'attuale sacrestia, un tempo adibita a battistero, si trovano l'affresco del Battesimo di Gesù ed una tela dell'Assunzione di Maria (XVII secolo), inserita in una ricca cornice barocca. In una piccola abside ora utilizzata come battistero trova posto un'acquasantiera sostenuta da un capitello di epoca carolingia. Sulla parete sinistra trovano inoltre posto una tela raffigurante il martirio di San Giovanni Battista (XVI secolo) ed una San Carlo Borromeo, provenienti ambedue dalla Chiesa della Misericordia. Si possono ammirare inoltre l'altare di San Giuseppe, con tracce di affreschi, e quello della Madonna del Pozzarello, portata nel Duomo nel 1933 in seguito all'abbandono dell'omonima chiesa.\n \nLa torre campanaria, eretta su una struttura di origine etrusca, è costruito in blocchi di peperino. L'unica particolarità è rappresentata da una lapide romana raffigurante un uomo ed una donna, che è stata inglobata nella struttura del campanile.";
        TextView descrizione_lunga_txt= (TextView) findViewById(R.id.duomo_descrizione_txt);
        descrizione_lunga_txt.setText(descrizione_lunga);



        Button spinner_descrizione=(Button)findViewById(R.id.spinner_descrizione_duomo_btn);
        spinner_descrizione.setOnClickListener(v -> {
            if(open2){
                //allora chiudi
                descrizione_lunga_txt.setVisibility(View.GONE);
                open2=false;
            }else{
                //allora apri
                descrizione_lunga_txt.setVisibility(View.VISIBLE);
                open2=true;
            }
        });

        ConstraintLayout layout_esperienze =(ConstraintLayout)findViewById(R.id.layout_esperienze_lay);
        Button esperienze_btn = (Button) findViewById(R.id.esperienze_btn);
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

        ImageView posizione_specifica = (ImageView)findViewById(R.id.indirizzo_oduomo);
        posizione_specifica.setClickable(true);
        posizione_specifica.setOnClickListener(v -> {
            Intent polpette = new Intent(this, specificmapmeglio.class);
            polpette.putExtra("idmappa",2);
            startActivity(polpette);

        });

        ImageView esperienza = (ImageView)findViewById(R.id.esperienza_duomo);
        esperienza.setClickable(true);
        esperienza.setOnClickListener(x -> {
            Intent h = new Intent(this, scrivi_recensione.class);
            startActivityForResult(h, 1);
        });
        voto1=(RatingBar) findViewById(R.id.ratingBar5);
        voto2=(RatingBar)findViewById(R.id.ratingBar6);
        voto3=(RatingBar)findViewById(R.id.ratingBar7);
        voto4=(RatingBar)findViewById(R.id.ratingBar8);

        nome1=(TextView)findViewById(R.id.nome1);
        nome2=(TextView)findViewById(R.id.nome2);
        nome3=(TextView)findViewById(R.id.nome3);
        nome4=(TextView)findViewById(R.id.nome4);

        testo1=(TextView)findViewById(R.id.testoc1);
        testo2=(TextView)findViewById(R.id.testoc2);
        testo3=(TextView)findViewById(R.id.testoc3);
        testo4=(TextView)findViewById(R.id.testoc4);

        rec1= new Recensione((float) 4.5,"Francesco","Mi piacciono i duomi.");
        rec2= new Recensione((float) 3.2,"Franco Harambe","il parroco è simpaticissimo");
        rec3= new Recensione((float) 2.1,"Pino","Bellissima esperienza culturale!");
        rec4= new Recensione((float) 5.0,"Totti","Magick");

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