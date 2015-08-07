package com.mcenere.provadagger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


// importante!!!
//http://stackoverflow.com/questions/27036933/how-to-set-up-dagger-dependency-injection-from-scratch-in-android-project

public class MainActivity extends ActionBarActivity
{
    private Veicolo veicolo;
    //    @Inject
//    public Veicolo veicolo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        veicolo.aumentaVelocita(3);

        VeicoloComponent veicoloComponent = DaggerVeicoloComponent.builder()
                .veicoloModule(new VeicoloModule())
                .build();

        veicolo = veicoloComponent.provideVeicolo();
        findViewById(R.id.accelera_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                accelera();
            }
        });

        findViewById(R.id.fermati_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fermati();
            }
        });

    }

    public void accelera()
    {
        veicolo.aumentaVelocita(10);
        mostraVelocitaAttuale();
    }

    private void mostraVelocitaAttuale()
    {
        ((TextView) findViewById(R.id.text_velocita)).setText(veicolo.getVelocita() + "");
    }

    public void fermati()
    {
        veicolo.fermati();
        mostraVelocitaAttuale();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
