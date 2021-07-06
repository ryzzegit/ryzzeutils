package com.ryzze.lib.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class BottomBarItem {

    /** Bottom navigation icon id **/
    @DrawableRes
    private final int iconId;

    /** Bottom navigation icon drawable**/
    @Nullable
    private final Drawable iconDrawable;

    /** bottom navigation title **/
    @StringRes
    private final int title;

    public BottomBarItem(int iconId, int outlineId, int title) {
        this.iconId = iconId;
        this.title = title;
        iconDrawable = null;

        if(iconId == 0) {
            throw new RuntimeException("Icone precisa ser mencionado.");
        }
    }

    public BottomBarItem(@Nullable Drawable iconDrawable, @StringRes int titleId) {
        this.iconId = 0;
        //
        this.iconDrawable = iconDrawable;
        //
        this.title = titleId;
    }

    public BottomBarItem(@Nullable Drawable iconDrawable) {
        this(iconDrawable,0);
    }

    public BottomBarItem(int iconId) {
        this(iconId, 0, 0);
    }

    @NonNull
    Drawable getIconDrawable(@NonNull Context context) {
        Drawable drawable;
        if (iconDrawable != null) {
            drawable = iconDrawable;
        } else {
            drawable = ContextCompat.getDrawable(context, iconId);
        }

        return DrawableCompat.wrap(drawable).mutate();
    }

    @StringRes
    public int getTitle() {
        return title;
    }
}
