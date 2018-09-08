package inc.machine_code.matira_prana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import inc.machine_code.matira_prana.All_Activity.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText m_User_Name;
    private EditText m_Pass_Word;
    Button m_Login_In;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        m_User_Name = findViewById(R.id.et_user_name);
        m_Pass_Word = findViewById(R.id.et_pass_word);
        m_Login_In = findViewById(R.id.bt_login_in);
        m_Login_In.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (m_User_Name != null && m_Pass_Word != null) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
