package io.github.gatimus.somepix;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class SlideShow implements Serializable{

    private String name;
    private ArrayList<Uri> images;

    public SlideShow(String name){
        this.name = name;
        images = new ArrayList<Uri>();
    }

    @Override
    public String toString(){
        return name;
    }

    public Uri getPreview(){
        return images.get(0);
    }

    public void addImage(Uri uri){
        images.add(uri);
    }

}
