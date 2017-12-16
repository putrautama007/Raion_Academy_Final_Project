package com.example.putrautama.rachat.ui.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.putrautama.rachat.R;
import com.example.putrautama.rachat.ui.Fragment.ChatFragment;
import com.example.putrautama.rachat.utils.Constants;

/**
 * Created by ASUS ROG on 15/12/2017.
 */

public class ChatActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startActivity(Context context, String receiver,
                                     String receiverUid, String firebaseToken){

        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(Constants.ARG_RECEIVER, receiver);
        intent.putExtra(Constants.ARG_RECEIVER_UID, receiverUid);
        intent.putExtra(Constants.ARG_FIREBASE_TOKEN, firebaseToken);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_chat);
        bindViews();
        init();
    }
    private void bindViews(){
        mToolbar= findViewById(R.id.toolbar);
    }

    private void init(){
        setSupportActionBar(mToolbar);

        mToolbar.setTitle(getIntent().getExtras().getString(Constants.ARG_RECEIVER));
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_chat ,
                ChatFragment.newInstance(getIntent().getExtras().getString(Constants.ARG_RECEIVER),
                        getIntent().getExtras().getString(Constants.ARG_RECEIVER_UID),
                        getIntent().getExtras().getString(Constants.ARG_FIREBASE_TOKEN))
                ,ChatFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

}
