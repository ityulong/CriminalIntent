package xaircraft.criminalintent;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        UUID id = (UUID) getIntent().getExtras().getSerializable(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(id);
    }

}
