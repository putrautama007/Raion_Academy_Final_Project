package com.example.putrautama.rachat.ui.Activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.widget.ImageView;

import com.example.putrautama.rachat.R;
import com.example.putrautama.rachat.ui.Fragment.LoginFragment;


public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void startIntent(Context context, int flags) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }

    public static void startIntent(Activity activity, ActivityOptionsCompat options) {
        Context context = activity;
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent, options.toBundle());
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();

        // Do nothing (disable back button)
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        init();

        supportPostponeEnterTransition();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            getWindow().setReenterTransition(new Explode());
            getWindow().setEnterTransition(new Explode());
        }
    }

    private void bindViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {
        // set the toolbar
        setSupportActionBar(mToolbar);

        LoginFragment loginFragment = LoginFragment.newInstance();

        // set the login screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout_content_login, loginFragment,
                LoginFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}

