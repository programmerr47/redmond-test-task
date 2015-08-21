package com.github.programmerr47.googlesearchclone.representation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.github.programmerr47.googlesearchclone.R;
import com.github.programmerr47.googlesearchclone.utils.Constants;

/**
 * @author Michael Spitsin
 * @since 2015-08-21
 */
public class CustomFontEditText extends EditText {

    public CustomFontEditText(Context context) {
        super(context);
        init(null);
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFontEditText);
            String fontName = typedArray.getString(R.styleable.CustomFontEditText_fontName);

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
