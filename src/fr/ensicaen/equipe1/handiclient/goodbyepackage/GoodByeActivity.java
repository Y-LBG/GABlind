package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.R.layout;
import fr.ensicaen.equipe1.handiclient.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GoodByeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
}
