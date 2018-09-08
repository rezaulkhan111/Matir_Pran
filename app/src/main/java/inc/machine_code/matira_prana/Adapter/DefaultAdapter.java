package inc.machine_code.matira_prana.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import inc.machine_code.matira_prana.Model.Default_Item;
import inc.machine_code.matira_prana.R;

public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.ViewHolder>{
    private InterfaceCallback callback;
    public ArrayList<Default_Item> default_item_ArrayList;
    Default_Item default_itemObj;

    public DefaultAdapter(InterfaceCallback callback, ArrayList<Default_Item> defult_classArrayList) {
        this.callback = callback;
        this.default_item_ArrayList = defult_classArrayList;
    }

    public interface InterfaceCallback {
        void inClickEvent(Default_Item satellite);

    }

    public class EmptyHolder extends Defult_View_Holder {

        public EmptyHolder(View view) {
            super(view);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        try {
            holder.onBind(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                default_itemObj = new Default_Item();
                Default_Item defult_class = default_item_ArrayList.get(position);
                callback.inClickEvent(defult_class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return default_item_ArrayList.size();
    }

    class Defult_View_Holder extends RecyclerView.ViewHolder {
        ImageView p_image;
        TextView p_name,
                p_range,
                p_type;

        public Defult_View_Holder(View view) {
            super(view);
            p_image = view.findViewById(R.id.iv_any_photo);
            p_name = view.findViewById(R.id.tv_name);
            p_range = view.findViewById(R.id.tv_range);
            p_type = view.findViewById(R.id.tv_type);
        }
    }


    public class ViewHolder extends Defult_View_Holder {
        ImageView image_photo;
        TextView p_name,
                p_range,
                p_type;

        public ViewHolder(View v) {
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
