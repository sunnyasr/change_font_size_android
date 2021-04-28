package com.example.fontchange.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fontchange.R;

public class FontSizePref {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "font_size_pref";

    private static final String TEXT_SIZE = "font_size";

    public FontSizePref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setTextSize(int isFirstTime) {
        editor.putInt(TEXT_SIZE, isFirstTime);
        editor.commit();
    }

    public int getTextSize() {
        return pref.getInt(TEXT_SIZE, Integer.parseInt( _context.getResources().getString(R.string.medium)));
    }
}
