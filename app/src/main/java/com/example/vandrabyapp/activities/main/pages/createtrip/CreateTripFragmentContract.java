package com.example.vandrabyapp.activities.main.pages.createtrip;

public interface CreateTripFragmentContract {

    interface View {
        void openSubpage1();
        void openSubpage2();
        void openSubpage3();

        void openSaveTripDialog();
    }

    interface Model {
    }

    interface Presenter {
        void clickNextOnSubpage1();
        void clickNextOnSubpage2();
        void clickSaveTrip();
    }
}