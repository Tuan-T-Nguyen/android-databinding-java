package com.example.nguyenthanhtuan.basicsample.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.nguyenthanhtuan.basicsample.R;
import com.example.nguyenthanhtuan.basicsample.data.Popularity;

public class BindingAdapters {
    /**
     * Unused Binding Adapter to replace the Binding Converter that hides a view if the number
     * of likes is zero.
     */
    @BindingAdapter({"app:hideIfZero"})
    public static void hideIfZero(View view, int number) {
        view.setVisibility(number == 0 ? View.GONE : View.VISIBLE);
    }

    /**
     * A Binding Adapter that is called whenever the value of the attribute `app:popularityIcon`
     * changes. Receives a popularity level that determines the icon and tint color to use.
     */
    @BindingAdapter("app:popularityIcon")
    public static void popularityIcon(ImageView view, Popularity popularity) {
        int color = getAssociatedColor(popularity, view.getContext());
        ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color));
        view.setImageDrawable(getDrawablePopularity(popularity, view.getContext()));
    }

    @BindingAdapter("app:progressTint")
    public static void tintPopularity(ProgressBar view, Popularity popularity) {
        int color = getAssociatedColor(popularity, view.getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setProgressTintList(ColorStateList.valueOf(color));
        }
    }

    /**
     *  Sets the value of the progress bar so that 5 likes will fill it up.
     *
     *  Showcases Binding Adapters with multiple attributes. Note that this adapter is called
     *  whenever any of the attribute changes.
    */
    @BindingAdapter(value={"app:progressScaled", "android:max"})
    public static void setProgress(ProgressBar progressBar, int likes, int max) {
        int progressVal = (likes * max / 5) >= max ? max : (likes * max / 5);
        progressBar.setProgress(progressVal);
    }

    private static int getAssociatedColor(Popularity popularity, Context context) {
        switch (popularity) {
            case NORMAL:
                return context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorForeground}).getColor(0, 0x000000);
            case POPUlAR:
                return ContextCompat.getColor(context, R.color.popular);
            case STAR:
                return ContextCompat.getColor(context, R.color.star);
        }
        return 0;
    }

    private static Drawable getDrawablePopularity(Popularity popularity, Context context) {
        switch (popularity) {
            case NORMAL:
                return ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp);
            case POPUlAR:
                return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
            case STAR:
                return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
        }
        return null;
    }
}
