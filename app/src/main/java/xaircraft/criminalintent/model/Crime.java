package xaircraft.criminalintent.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chenyulong on 2017/7/3.
 */

public class Crime {
    private String mTitle;
    private UUID mId;
    private boolean sSolved;
    private String mDate;

    public Crime() {
        mId = UUID.randomUUID();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
        mDate = dateFormat.format(new Date());
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    private static Crime mCrime = null;
    public static Crime getInstance() {
        synchronized (Crime.class) {
            if (mCrime == null) {
                mCrime = new Crime();
            }
        }
        return mCrime;
    }

    public boolean issSolved() {
        return sSolved;
    }

    public void setsSolved(boolean sSolved) {
        this.sSolved = sSolved;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
