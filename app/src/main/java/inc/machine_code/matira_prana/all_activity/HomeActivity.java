package inc.machine_code.matira_prana.all_activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import inc.machine_code.matira_prana.adapter.GridViewAdapter;
import inc.machine_code.matira_prana.adapter.ListViewAdapter;
import inc.machine_code.matira_prana.model.Default_Item;
import inc.machine_code.matira_prana.model.Home_Screen_Item;
import inc.machine_code.matira_prana.R;

public class HomeActivity extends Activity {

    private ViewStub stubList;
    private ViewStub stubGrid;
    private ListView listView;
    //  private InterfaceCallbackM callGo;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Home_Screen_Item> home_screen_itemList;
    private int currentViewMode = 1;

    static final int VIEW_MODE_LIST_VIEW = 0;
    static final int VIEW_MODE_GRID_VIEW = 1;

    List<Default_Item> defult_classList;

    //    public interface InterfaceCallbackM {
//        void inClickDefult(List<Defult_Class> satellite);
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        stubList = findViewById(R.id.stub_list);
        stubGrid = findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = findViewById(R.id.my_list_view_id);
        gridView = findViewById(R.id.my_grid_view_id);

        getProductList();

//        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
//        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LIST_VIEW);


//        switchView();

        setAdapter();


    }

    public List<Home_Screen_Item> getProductList() {
        home_screen_itemList = new ArrayList<>();
        home_screen_itemList.add(new Home_Screen_Item(R.mipmap.ic_potential_of_hydrogen_foreground, "Potential Of Hydrogen"));
        home_screen_itemList.add(new Home_Screen_Item(R.mipmap.ic_naitrogen_foreground, "Nitrogen"));
        home_screen_itemList.add(new Home_Screen_Item(R.mipmap.ic_posporas_foreground, "Phosphorus"));
        home_screen_itemList.add(new Home_Screen_Item(R.mipmap.ic_potasiam_foreground, "Potassium"));
        home_screen_itemList.add(new Home_Screen_Item(R.mipmap.ic_potasiam_foreground, "Photo"));
        return home_screen_itemList;
    }

    private void switchView() {
        if (VIEW_MODE_GRID_VIEW == currentViewMode) {
            stubList.setVisibility(View.GONE);

            stubGrid.setVisibility(View.VISIBLE);
        } else {
            stubList.setVisibility(View.VISIBLE);

            stubGrid.setVisibility(View.GONE);
        }
        setAdapter();
    }

    private void setAdapter() {

        if (VIEW_MODE_GRID_VIEW == currentViewMode) {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, home_screen_itemList);
            gridView.setAdapter(gridViewAdapter);
            gridView.setOnItemClickListener(onItemClick);

        } else {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, home_screen_itemList);
            listView.setAdapter(listViewAdapter);
            listView.setOnItemClickListener(onItemClick);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if (VIEW_MODE_LIST_VIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRID_VIEW;
                } else {
                    currentViewMode = VIEW_MODE_LIST_VIEW;
                }
                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(getApplicationContext(), DefaultActivity.class);
            switch (position) {
                case 0:
                    intent.putExtra("savedUser", (Serializable) Number1List());
                    startActivity(intent);
                    break;
                case 1:
                    //callGo.inClickDefult(Number1List());
//                    intent.putExtra("savedUser", (Serializable) Number2List());
//                    startActivity(intent);
                    break;
                case 2:
//                    intent.putExtra("savedUser", (Serializable) Number3List());
//                    startActivity(intent);
                    break;
            }

        }
    };

    public List<Default_Item> Number1List() {
        defult_classList = new ArrayList<>();
        defult_classList.add(new Default_Item("1", "aaaaa", "10>50", "Matira_prana", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Default_Item("2", "aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Default_Item("3", "aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Default_Item("4", "aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Default_Item("5", "aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        return defult_classList;
    }

//    public List<Defult_Class> Number2List() {
//        List<Defult_Class> defult_classList = new ArrayList<>();
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_naitrogen_foreground));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_naitrogen_foreground));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_naitrogen_foreground));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_naitrogen_foreground));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_naitrogen_foreground));
//        return defult_classList;
//    }

//    public List<Defult_Class> Number3List() {
//        List<Defult_Class> defult_classList = new ArrayList<>();
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
//        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
//        return defult_classList;
//    }


}
