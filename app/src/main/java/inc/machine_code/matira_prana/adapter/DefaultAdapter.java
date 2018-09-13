package inc.machine_code.matira_prana.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import inc.machine_code.matira_prana.model.Default_Item;
import inc.machine_code.matira_prana.R;
import inc.machine_code.matira_prana.view_holder.Default_View_Holder;

public class DefaultAdapter extends RecyclerView.Adapter<Default_View_Holder> {
    private InterfaceCallback callback;
    private ArrayList<Default_Item> default_item_ArrayList;
    private Default_Item default_itemObj;

    public DefaultAdapter(InterfaceCallback callback, ArrayList<Default_Item> defult_classArrayList) {
        this.callback = callback;
        this.default_item_ArrayList = defult_classArrayList;
    }

    public interface InterfaceCallback {
        void inClickEvent(Default_Item default_item, String serial_No);

    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Default_View_Holder default_view_holder, final int position) {
        try {
            default_view_holder.onBind(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        default_view_holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                default_itemObj = new Default_Item();
                String get_Serial_No = default_item_ArrayList.get(position).getSerial_NO();
                Default_Item defult_class = default_item_ArrayList.get(position);
                callback.inClickEvent(defult_class, get_Serial_No);
            }
        });
    }

    @Override
    public int getItemCount() {
        return default_item_ArrayList.size();
    }

    public class ViewHolder extends Default_View_Holder {
        ImageView image_photo;
        TextView p_name,
                p_range,
                p_type;

        private ViewHolder(View v) {
            super(v);
            image_photo = v.findViewById(R.id.iv_any_photo);
            p_name = v.findViewById(R.id.tv_name);
            p_range = v.findViewById(R.id.tv_range);
            p_type = v.findViewById(R.id.tv_type);
        }

        public void onBind(int position) {
            try {
                Default_Item defult_class = default_item_ArrayList.get(position);
                image_photo.setImageResource(default_item_ArrayList.get(position).getImage());
                p_name.setText(String.valueOf(defult_class.getName()));
                p_range.setText(String.valueOf(defult_class.getRange()));
                p_type.setText(String.valueOf(defult_class.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
