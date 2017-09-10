package xaircraft.criminalintent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

import xaircraft.criminalintent.model.Crime;
import xaircraft.criminalintent.model.CrimeLab;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {
    public static final String EXTRA_CRIME_ID = "crime_id";
    public static final String FRAGMENT_CHOSE_DATE = "chose_date";
    public static final int REQUEST_DATE = 0;

    private EditText mTitle;
    private Crime mCrime;
    private CheckBox cbSolved;
    private Button btnDate;

    public CrimeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        UUID id = (UUID) b.getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitle = (EditText) v.findViewById(R.id.et_crime_title);
        mTitle.setText(mCrime.getTitle());
        mTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnDate = (Button) v.findViewById(R.id.btn_crime_date);
        btnDate.setText(mCrime.getDate().toString());
        btnDate.setClickable(true);
        btnDate.setOnClickListener(dateClickListener);
        cbSolved = (CheckBox) v.findViewById(R.id.cb_crime_solved);
        cbSolved.setChecked(mCrime.issSolved());
        cbSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setsSolved(isChecked);
            }
        });
        return v;
    }

    private View.OnClickListener dateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            if (fm.findFragmentByTag(FRAGMENT_CHOSE_DATE) == null) {
                DatePickFragment datePickFragment = DatePickFragment.newInstance(mCrime.getDate());
                datePickFragment.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
                datePickFragment.show(fm, FRAGMENT_CHOSE_DATE);
            }
        }
    };

    public static CrimeFragment newInstance(UUID id) {
        Bundle b = new Bundle();
        b.putSerializable(EXTRA_CRIME_ID, id);
        CrimeFragment crime = new CrimeFragment();
        crime.setArguments(b);
        return crime;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_DATE:
                if (resultCode == Activity.RESULT_OK) {
                    Date date = (Date) data.getSerializableExtra(DatePickFragment.EXTRA_DATE);
                    mCrime.setDate(date);
                    btnDate.setText(mCrime.getDate().toString());
                }
                break;
        }

    }
}
