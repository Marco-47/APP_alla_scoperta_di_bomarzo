package  com.example.allascopertadibomarzo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ActivitySfingi extends AppCompatActivity {
    boolean open=false;
    ViewPager vSfingi;
    String descrizione_breve="La sfinge è una creatura dal corpo leonino e dalla testa di donna, desunta dalla mitologia greca. Essa si lega al destino della città di Tebe e di Edipo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Le Sfingi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfingi);
        //slide show
        CircleIndicator circleIndicator= findViewById(R.id.cerchiSfingi);
        vSfingi=findViewById(R.id.viewPagerSfingi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.sfinge_left);
        imageList.add(R.drawable.sfinge_right);
        imageList.add(R.drawable.sfinge3);
        MyAdapter myAdapter= new MyAdapter(imageList);
        vSfingi.setAdapter(myAdapter);
        circleIndicator.setViewPager(vSfingi);



        //back arrow
        TextView descrizione_txt = (TextView) findViewById(R.id.descrizione_sfingi_txt);

        TextView descrizione_breve_txt= (TextView) findViewById(R.id.descrizione_breve_sfingi_txt);
        descrizione_breve_txt.setText(descrizione_breve);


        Button spinner_descrizione=(Button)findViewById(R.id.spinner_sfingi_btn);
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

