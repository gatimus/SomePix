package io.github.gatimus.somepix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SlideShowAdapter extends ArrayAdapter<SlideShow> {

    Context context;
    List<SlideShow> slideShows;

    public SlideShowAdapter(Context context, List<SlideShow> objects) {
        super(context, R.layout.slideshow_item, objects);
        this.context = context;
        slideShows = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SlideShow slideShow = slideShows.get(position);
        ImageView preview = (ImageView)convertView.findViewById(R.id.preview);
        TextView name = (TextView) convertView.findViewById(android.R.id.text1);
        Picasso.with(context).load(slideShow.getPreview()).into(preview);
        //Picasso.with(context).load(ContentUris.parseId(slideShow.getPreview())).into(preview);
        name.setText(slideShow.toString());
        return convertView;
    }

}
