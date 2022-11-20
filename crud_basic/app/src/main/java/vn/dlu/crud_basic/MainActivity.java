package vn.dlu.crud_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init() {
        TextView name = (TextView) findViewById(R.id.editTextName);
        TextView address = (TextView) findViewById(R.id.editTextAddress);
        Button btnInsert = (Button) findViewById(R.id.btnAdd);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = connectionclass();
                try {
                    if (connection != null) {
                        String sqlinsert = "INSERT INTO UserInfo_Tab VALUES(N'" + name.getText().toString() + "', N'" + address.getText().toString() + "')";
                        Statement st = connection.createStatement();
                        ResultSet rs = st.executeQuery(sqlinsert);
                    }
                } catch (Exception exception) {
                    Log.e("Error", exception.getMessage());
                }
            }
        });
    }

    @SuppressLint("NewApi")
    public Connection connectionclass() {
        Connection con = null;
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionUrl = "jdbc:jtds:sqlserver://192.168.71.96:1433;databasename=EnglishDictionary;user=sa;password=1";
            con = DriverManager.getConnection(connectionUrl);
            Log.i("Thongbao", "Thanh cong");
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return con;
    }
}