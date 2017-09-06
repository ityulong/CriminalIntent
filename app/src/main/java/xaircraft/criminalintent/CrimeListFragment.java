package xaircraft.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import xaircraft.criminalintent.model.Crime;
import xaircraft.criminalintent.model.CrimeAdapter;
import xaircraft.criminalintent.model.CrimeLab;

/**
 * Created by chenyulong on 2017/9/4.
 */

public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(getString(R.string.crime_list_activity_title));
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
        setListAdapter(new CrimeAdapter(getContext(), mCrimes));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime crime = (Crime) getListAdapter().getItem(position);
        Toast.makeText(getContext(), crime.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
