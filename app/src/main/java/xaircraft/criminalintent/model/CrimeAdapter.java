package xaircraft.criminalintent.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import xaircraft.criminalintent.R;

/**
 * Created by chenyulong on 2017/9/6.
 */

public class CrimeAdapter extends ArrayAdapter<Crime> {

    private Context mContext;
    public CrimeAdapter(Context context, List<Crime> datas) {
        super(context, 0, datas);
        this.mContext = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.ly_crime_item, null);
        }
        Crime crime = getItem(position);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_crime_title);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_crime_date);
        CheckBox cbSloved = (CheckBox) convertView.findViewById(R.id.cb_crime_item_solved);
        tvTitle.setText(crime.getTitle());
        tvDate.setText(crime.getDate());
        cbSloved.setChecked(crime.issSolved());

        return convertView;
    }

}
