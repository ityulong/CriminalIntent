package xaircraft.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

import xaircraft.criminalintent.model.Crime;
import xaircraft.criminalintent.model.CrimeLab;

/**
 * Created by chenyulong on 2017/9/8.
 */

public class CrimePagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);
        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fm = getSupportFragmentManager();


        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime item = mCrimes.get(position);
                return CrimeFragment.newInstance(item.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Crime item = mCrimes.get(position);
                if (item.getTitle() != null) {
                    setTitle(item.getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID id = (UUID) getIntent().getExtras().getSerializable(CrimeFragment.EXTRA_CRIME_ID);
        for (int i = 0; i < mCrimes.size() ; i++) {
            if(mCrimes.get(i).getId().equals(id)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
