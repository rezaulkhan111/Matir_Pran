package inc.machine_code.matira_prana.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import inc.machine_code.matira_prana.model.Home_Screen_Item;
import inc.machine_code.matira_prana.R;

public class ListViewAdapter extends ArrayAdapter<Home_Screen_Item>{
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Home_Screen_Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;

        if(null==v){
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.list_item,null);
        }
        Home_Screen_Item home_screen_item=getItem(position);
        ImageView imageView=v.findViewById(R.id.iv_gv_image_icon_id);
        TextView textView=v.findViewById(R.id.tv_description_id);

        imageView.setImageResource(home_screen_item.getImage());
        textView.setText(home_screen_item.getDescription());
        return v;
    }
}
