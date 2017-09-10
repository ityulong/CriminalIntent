package xaircraft.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by chenyulong on 2017/9/10.
 */

public class DatePickFragment extends DialogFragment {
    public static final String EXTRA_DATE = "criminal_date";

    private Date mDate;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePicker v = (DatePicker) getActivity().getLayoutInflater().inflate(R.layout.ly_date_picker, null);
        mDate = (Date) getArguments().getSerializable(EXTRA_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        v.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
                getArguments().putSerializable(EXTRA_DATE, mDate);
                if (getTargetFragment() == null) {
                    return;
                }
                Intent i = new Intent();
                i.putExtra(EXTRA_DATE, mDate);
                getTargetFragment().onActivityResult(CrimeFragment.REQUEST_DATE, Activity.RESULT_OK,i);
            }
        });

        AlertDialog dialog = new AlertDialog.Builder(getContext()).
                setView(v).
                setTitle("date of crime").
                setPositiveButton("ok",null).
                create();
        return dialog;
    }

    public static DatePickFragment newInstance(Date date) {
        if (date != null) {
            DatePickFragment pickFragment = new DatePickFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(EXTRA_DATE, date);

            pickFragment.setArguments(bundle);
            return pickFragment;
        }else{
            return null;
        }
    }
}
