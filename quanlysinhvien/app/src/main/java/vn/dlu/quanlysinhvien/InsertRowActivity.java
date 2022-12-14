package vn.dlu.quanlysinhvien;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class InsertRowActivity extends AppCompatActivity {
    private TextView mUserName;
    private TextView mUserPhone;
    private TextView mUserEmail;
    private Button insertRowFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_row);

        insertRowFrom = (Button) findViewById(R.id.insertRowFrom);
        mUserName = (TextView) findViewById(R.id.userNameTxt);
        mUserPhone = (TextView) findViewById(R.id.userPhoneTxt);
        mUserEmail = (TextView) findViewById(R.id.userEmailTxt);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Inser New User");
        }
    }

    public void insertRow(View view) {

        TextView userNameTxtView = findViewById(R.id.userNameTxt);
        TextView userPhoneTxtView = findViewById(R.id.userPhoneTxt);
        TextView userEmailTxtView = findViewById(R.id.userEmailTxt);

        if (userNameTxtView.getText().toString().trim().equals("")
                || userPhoneTxtView.getText().toString().trim().equals("")
                || userEmailTxtView.getText().toString().trim().equals("")) {
            Utils.showToast(InsertRowActivity.this, "Please Fill All Fields ");
        } else {
            UsersDatabaseAdapter usersDB = new UsersDatabaseAdapter(getApplicationContext());
            usersDB.insertEntry(userNameTxtView.getText().toString().trim(), userPhoneTxtView.getText().toString(), userEmailTxtView.getText().toString());
            Intent myIntent = new Intent(InsertRowActivity.this, MainActivity.class);
            InsertRowActivity.this.startActivity(myIntent);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}