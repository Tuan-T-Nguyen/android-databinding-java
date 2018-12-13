package com.example.nguyenthanhtuan.basicsample.data;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.nguyenthanhtuan.basicsample.util.ObservableViewModel;

public class ProfileObservableViewModel extends ObservableViewModel {

    public ObservableField<String> name = new ObservableField<>("Ada");
    public ObservableField<String> lastName = new ObservableField<>("Lovelace");
    public ObservableInt likes = new ObservableInt(0);
    /**
     * As an alternative, the @Bindable attribute can be replaced with an
     * `ObservableField`. In this case 'popularity' is an `ObservableField` which has to be computed when
     * `likes` change.
     */
    public ObservableField<Popularity> popularity = new ObservableField<>(Popularity.NORMAL);

    public void onLike() {
        likes.set(likes.get() + 1);
        // You control when the @Bindable properties are updated using `notifyPropertyChanged()`.
        //notifyPropertyChanged(BR.popularity);

        if (likes.get() > 9) {
            popularity.set(Popularity.STAR);
        } else if (likes.get() > 4) {
            popularity.set(Popularity.POPUlAR);
        } else {
            popularity.set(Popularity.NORMAL);
        }
    }

//    @Bindable
//    public Popularity getPopularity() {
//        if (likes.get() > 9) {
//            return Popularity.STAR;
//        } else if (likes.get() > 4) {
//            return Popularity.POPUlAR;
//        } else {
//            return Popularity.NORMAL;
//        }
//    }
}

