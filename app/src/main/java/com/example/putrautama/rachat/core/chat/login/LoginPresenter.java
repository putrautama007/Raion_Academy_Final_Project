package com.example.putrautama.rachat.core.chat.login;

import android.app.Activity;

/**
 * Created by ASUS ROG on 15/12/2017.
 */

public class LoginPresenter implements LoginContract.Presenter, LoginContract.OnLoginListener {
    private LoginContract.View mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenter(LoginContract.View loginView) {
        this.mLoginView = loginView;
        mLoginInteractor = new LoginInteractor(this);
    }

    @Override
    public void login(Activity activity, String email, String password) {
        mLoginInteractor.performFirebaseLogin(activity, email, password);
    }

    @Override
    public void onSuccess(String message) {
        mLoginView.onLoginSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        mLoginView.onLoginFailure(message);
    }
}
