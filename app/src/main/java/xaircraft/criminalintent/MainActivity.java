package xaircraft.criminalintent;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    int a = 0;
    int b = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        Fragment fg = fm.findFragmentById(R.id.ly_container);
        if (fg == null) {
            fg = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.ly_container, fg)
                    .commit();
        }
    }
}
