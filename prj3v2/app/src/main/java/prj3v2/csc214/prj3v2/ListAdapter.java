package prj3v2.csc214.prj3v2;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import database.Post;

/**
 * Created by Mike on 5/1/2018.
 */

public class ListAdapter extends ArrayAdapter<Post> {
    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Post> posts) {
        super(context, resource, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_post_view, null);
        }

        Post p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.userPostedText);
            ImageView tt2 = (ImageView) v.findViewById(R.id.userPostedImage);

            if (tt1 != null) {
                tt1.setText(p.getPostinfo());
            }

            if (tt2 != null && p.getPath() != " ") {
                tt2.setImageURI(Uri.parse(p.getPath()));
            }

        }

        return v;
    }
}
