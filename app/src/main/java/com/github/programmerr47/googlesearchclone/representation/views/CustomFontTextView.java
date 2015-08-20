package com.github.programmerr47.googlesearchclone.representation.views;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.github.programmerr47.googlesearchclone.R;
import com.github.programmerr47.googlesearchclone.utils.Constants;

/**
 * Extension of standard {@link android.widget.TextView} that can specify type of font.
 * All not-standard fonts stored at assets folder, in {@link Constants#ASSETS_FONTS_DIR} directory.
 *
 * @author Michael Spitsin
 * @since 2015-08-20
 */
public class CustomFontTextView extends TextView {

    public CustomFontTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
            String fontName = typedArray.getString(R.styleable.CustomFontTextView_fontName);

            if (fontName != null) {
                Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), Constants.ASSETS_FONTS_DIR + fontName);
                setTypeface(typeface);
            }
            typedArray.recycle();
        }
    }

    @SuppressWarnings("unused")
    public void setFontName(String fontName) {
        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), Constants.ASSETS_FONTS_DIR + fontName);
            setTypeface(typeface);
        }
    }
}
