package inc.machine_code.matira_prana.all_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import inc.machine_code.matira_prana.R;

public class All_Text_View_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__text__view_);

        TextView m_show_all_text = findViewById(R.id.tv_show_all_text);
        m_show_all_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        m_show_all_text.setVerticalScrollBarEnabled(true);

        Intent intent = getIntent();
        String getString = intent.getExtras().getString("SendData");
        m_show_all_text.setText(getString);
    }
}
