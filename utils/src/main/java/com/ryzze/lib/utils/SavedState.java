package com.ryzze.lib.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class SavedState extends View.BaseSavedState {

    int selectedPosition;

    SavedState(Parcelable superState) {
        super(superState);
    }

    SavedState(Parcel source) {
        super(source);
        selectedPosition = source.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(selectedPosition);
    }

    public static final Creator<SavedState> CREATOR =
            new Creator<SavedState>() {
                @Override
                public SavedState createFromParcel(Parcel in) {
                    return new SavedState(in);
                }

                @Override
                public SavedState[] newArray(int size) {
                    return new SavedState[size];
                }
            };
}
