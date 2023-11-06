package  com.example.allascopertadibomarzo;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ActivityOrco extends AppCompatActivity {
    boolean open=false;
    ViewPager vOrco;
    String descrizione_breve="L'enorme mascherone con la bocca spalancata, emblema del Parco dei Mostri di Bomarzo. C'è chi l'ha chiamato Orco, chi ha interpretato la sua bocca come la porta dell inferno, ma al suo interno c'è un tavolo di pietra che invita a banchettare con un particolare effetto eco";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orco);
        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        this.setTitle("L' Orco Delle Favole");
        TextView descrizione_txt = (TextView) findViewById(R.id.descrizione_orco_txt);

        String descrizione_lunga = "Questa grande scultura, un enorme volto con la bocca spalancata e lo sguardo terrorizzante,\n"+
                "è il simbolo del Parco dei Mostri di Bomarzo e racchiude in sè molti dei significati del \"Giardino incantato\"\n"+
                "Forse vuole incutere terrore ed anche meraviglia e comunque invita il visitatore a penetrare all'interno della sua bocca;"+
                "a che servirebbe sennò l'ampia scalinata? \n\n" +
                "Quella bocca spalancata è l'ingresso dell'Inferno ed al suo interno c'è un tavolo in pietra che invita ad entrare e banchettare.\n" +
                "La scritta che compare attualmente intorno alle sue fauci \"OGNI PENSIERO VOLA\"\n" +
                "non è sicuramente quella originaria: un disegno di Giovanni Guerra del 1598 che riproduce l'Orco di Bomarzo riporta anche la scritta, allora ben conservata: \n" +
                "\"LASCIATE OGNI PENSIERO VOI CH'INTRATE\", \ncon evidente riferimento all'Inferno dantesco.";

        descrizione_txt.setText(descrizione_lunga);


        TextView descrizione_breve_txt= (TextView) findViewById(R.id.descrizione_breve_orco);
        descrizione_breve_txt.setText(descrizione_breve);

        //slide show
        CircleIndicator circleIndicator= findViewById(R.id.cerchiOrco);
        vOrco=findViewById(R.id.viewPagerOrco);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.parco_dei_mostri);
        imageList.add(R.drawable.orco_due);
        imageList.add(R.drawable.orco_tre);
        MyAdapter myAdapter= new MyAdapter(imageList);
        vOrco.setAdapter(myAdapter);
        circleIndicator.setViewPager(vOrco);


        Button spinner_descrizione=(Button)findViewById(R.id.spinner_descrizione);
        spinner_descrizione.setOnClickListener(v -> {
            if(open){
                //allora chiudi
                descrizione_txt.setVisibility(View.GONE);
                open=false;
            }else{
                //allora apri
                descrizione_txt.setVisibility(View.VISIBLE);
                open=true;
            }
        });

    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
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