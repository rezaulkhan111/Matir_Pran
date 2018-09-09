package inc.machine_code.matira_prana.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class Default_View_Holder extends RecyclerView.ViewHolder {
    public Default_View_Holder(@NonNull View itemView) {
        super(itemView);
    }
    public abstract void onBind(int position);
}
