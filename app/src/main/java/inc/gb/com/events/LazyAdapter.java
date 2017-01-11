package inc.gb.com.events;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private String[] data;
    private static LayoutInflater inflater = null;
    String[][] events;

    public LazyAdapter(Activity a, String[][] events) {
        activity = a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.events = events;
    }

    public int getCount() {
        return events.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView) vi.findViewById(R.id.title); // title
        TextView artist = (TextView) vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView) vi.findViewById(R.id.duration); // duration
        ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image); // thumb image


        // Setting all values in listview
        title.setText(events[position][0]);
        artist.setText(events[position][1]);
        duration.setText(events[position][2]);
        return vi;
    }
}