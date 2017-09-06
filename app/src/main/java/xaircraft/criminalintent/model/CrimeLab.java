package xaircraft.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by chenyulong on 2017/9/4.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    public CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("crime" + i);
            crime.setsSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime getCrime(String uuid){
        for (Crime c : mCrimes) {
            if(c.getId().equals(uuid)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }
}
