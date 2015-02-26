package io.github.gatimus.somepix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, SlideShowListFragment.newInstance())
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_new :
                Intent intent = new Intent(getApplicationContext(), EditSlideShowActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings :
                //TODO
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
