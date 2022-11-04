package vn.dlu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_login);
        initControl();
    }

    public void initControl() {
        EditText EtxtEmail = findViewById(R.id.txtEmail);
        EditText EtxtPassWord = findViewById(R.id.txtPassword);
        TextView txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EtxtEmail.getText().length() > 0 && EtxtPassWord.getText().length() > 0) {
                    String toastMessage = "Email: " + EtxtEmail.getText().toString() + ", Password: " + EtxtPassWord.getText().toString();
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                } else {
                    String toastMessage = "Username or Password are not populated";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}