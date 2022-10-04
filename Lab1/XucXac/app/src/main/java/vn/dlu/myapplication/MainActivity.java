package vn.dlu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtKq;
    Button btnRand;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void initControl() {
        txtKq.findViewById(R.id.txtKetQua);
        btnRand.findViewById(R.id.btnRandom);
        btnRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int rand = random.nextInt(6-1)+1;
                txtKq.setText(String.valueOf(rand));
            }
        });
    }
}