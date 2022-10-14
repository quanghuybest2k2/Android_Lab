package vn.dlu.truyencuoi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg(new M000SplashFrg());
    }

    private void showFrg(M000SplashFrg frg) {
        getSupportFragmentManager().beginTransaction().replace(R.id.In_main, frg, null).commit();
    }

    public void gotoM001Screen() {

    }

    public void gotoM002Screen(String topicName) {

    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    public void gotoM003Screen(/*ArrayList<StoryEntity> listStory, StoryEntity story*/) {

    }
}