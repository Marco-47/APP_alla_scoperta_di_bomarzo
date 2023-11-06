package  com.example.allascopertadibomarzo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ActivityDrago extends AppCompatActivity {
    boolean open=false;
    ViewPager vDrago;
    String descrizione_breve="La bestia leggendaria per eccellenza il drago alato, mentre combatte non contro un uomo... ma contro altre tre belve: un cane, un leone ed un lupo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("La Statua Del Drago");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drago);
        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView descrizione_txt = (TextView) findViewById(R.id.descrizione_drago_txt);
        //slide show
        CircleIndicator circleIndicator= findViewById(R.id.cerchiDrago);
        vDrago=findViewById(R.id.viewPagerDrago);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.seconda);
        imageList.add(R.drawable.drago);
        imageList.add(R.drawable.drago3);
        MyAdapter myAdapter= new MyAdapter(imageList);
        vDrago.setAdapter(myAdapter);
        circleIndicator.setViewPager(vDrago);
        //String descrizione_lunga="";
        //descrizione_txt.setText(descrizione_lunga);


        TextView descrizione_breve_txt= (TextView) findViewById(R.id.descrizione_breve_drago_txt);
        descrizione_breve_txt.setText(descrizione_breve);



        Button spinner_descrizione=(Button)findViewById(R.id.descrizione_lunga_drago_btn);
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







/**/