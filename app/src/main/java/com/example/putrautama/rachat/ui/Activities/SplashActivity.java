package com.example.putrautama.rachat.ui.Activities;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.ImageView;

import com.example.putrautama.rachat.R;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by ASUS ROG on 15/12/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_MS = 2000;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView logoImage = findViewById(R.id.logo);

        mHandler = new Handler();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                // check if user is already logged in or not
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    // if logged in redirect the user to user listing activity
                    UserListingActivity.startActivity(SplashActivity.this);
                } else {
                    // otherwise redirect the user to login activity

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        String transitionName = "my-transition";
                        logoImage.setTransitionName(transitionName);
                        ActivityOptionsCompat options =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this,
                                        (View) logoImage,
                                        transitionName);
                        LoginActivity.startIntent(SplashActivity.this, options);

                    } else {

                        LoginActivity.startIntent(SplashActivity.this);
                    }
                }
                //finish();
            }
        };

        mHandler.postDelayed(mRunnable, SPLASH_TIME_MS);
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, SPLASH_TIME_MS);
    }*/
}
