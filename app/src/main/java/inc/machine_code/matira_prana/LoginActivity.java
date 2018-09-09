package inc.machine_code.matira_prana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import inc.machine_code.matira_prana.all_activity.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText m_User_Name;
    private EditText m_Pass_Word;
    Button m_Login_In;
    String User_Name;
    String Pass_Word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        m_User_Name = findViewById(R.id.et_user_name);
        m_Pass_Word = findViewById(R.id.et_pass_word);
        m_Login_In = findViewById(R.id.bt_login_in);
        m_Login_In.setOnClickListener(this);
        User_Name = m_User_Name.getText().toString();

    }

    @Override
    public void onClick(View view) {
        User_Name = m_User_Name.getText().toString();
        Pass_Word = m_Pass_Word.getText().toString();

        if (isEmailValid(User_Name)== true && !Pass_Word.equals("")) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            m_User_Name.getText().clear();
            m_Pass_Word.getText().clear();
        } else {

            Toast.makeText(getApplicationContext(), "Wrong Username & Password", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
