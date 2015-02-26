package io.github.gatimus.somepix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class EditSlideShowActivity extends ActionBarActivity {

    public static final int IMAGE = 0;
    private SlideShow slideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, ImageListFragment.newInstance())
                .commit();
        slideShow = new SlideShow("test");
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
                /*
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT)
                        .setType("image/*");
                startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.chooser_image)), IMAGE);
                */
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE);
                break;
            case R.id.action_settings :
                //TODO
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            if(requestCode == IMAGE){
                slideShow.addImage(uri);
            }
        } else {
            Log.w(getClass().getSimpleName(), "No Result");
        }
    }

}
