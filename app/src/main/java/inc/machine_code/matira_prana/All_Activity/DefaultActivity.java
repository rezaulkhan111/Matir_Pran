package inc.machine_code.matira_prana.All_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import inc.machine_code.matira_prana.Adapter.DefaultAdapter;
import inc.machine_code.matira_prana.Model.Default_Item;
import inc.machine_code.matira_prana.R;

public class DefaultActivity extends AppCompatActivity implements DefaultAdapter.InterfaceCallback{
    DefaultAdapter adapter;
    ArrayList<Default_Item> defult_classArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        mRecyclerView = findViewById(R.id.rv_defult_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();

        ArrayList<Default_Item> _defult_classes_Seri_able = (ArrayList<Default_Item>) intent.getSerializableExtra("savedUser");
        defult_classArrayList = _defult_classes_Seri_able;

        adapter = new DefaultAdapter(this, defult_classArrayList);
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void inClickEvent(Default_Item satellite) {

    }
}
