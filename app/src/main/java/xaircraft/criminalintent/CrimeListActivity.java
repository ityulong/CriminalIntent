package xaircraft.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by chenyulong on 2017/9/4.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
