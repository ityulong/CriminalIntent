package xaircraft.criminalintent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenyulong on 2017/7/17.
 */

public class MyView extends View {
    private Object o = new Object();
    private int[] mInts = new int[]{1, 2, 3, 4, 5, 6};

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        int a = 1;


    }
}
