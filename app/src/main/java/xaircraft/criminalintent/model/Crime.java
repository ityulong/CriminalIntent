package xaircraft.criminalintent.model;

import java.util.UUID;

/**
 * Created by chenyulong on 2017/7/3.
 */

public class Crime {
    private String mTitle;
    private UUID mId;

    public Crime() {
        mId = UUID.randomUUID();
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
}
