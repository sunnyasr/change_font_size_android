package com.example.fontchange;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fontchange.preferences.FontSizePref;

public class BaseTextView extends androidx.appcompat.widget.AppCompatTextView {


    public BaseTextView(@NonNull Context context) {
        super(context);
        init(context);
    }


    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context ctx) {


        int textSize = new FontSizePref(ctx).getTextSize();

        Log.d("SizeFont", "" + textSize);
        setTextSize(textSize);

    }
}
