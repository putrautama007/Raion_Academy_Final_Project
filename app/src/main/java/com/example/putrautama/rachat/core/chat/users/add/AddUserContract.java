package com.example.putrautama.rachat.core.chat.users.add;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by ASUS ROG on 15/12/2017.
 */

public interface AddUserContract {
    interface View {
        void onAddUserSuccess(String message);

        void onAddUserFailure(String message);
    }

    interface Presenter {
        void addUser(Context context, FirebaseUser firebaseUser);
    }

    interface Interactor {
        void addUserToDatabase(Context context, FirebaseUser firebaseUser);
    }

    interface OnUserDatabaseListener {
        void onSuccess(String message);

        void onFailure(String message);
    }
}

