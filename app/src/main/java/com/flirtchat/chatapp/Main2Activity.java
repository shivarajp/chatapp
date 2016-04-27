package com.flirtchat.chatapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.flirtchat.chatapp.adapters.ChatAdapter;
import com.flirtchat.chatapp.models.MessagesModel;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    private String url = "https://flirtchat.firebaseio.com/data/";
    private Firebase mFirebase;
    private LinearLayout llchat;
    private ListView lvConversation;
    private ChatAdapter adapter;
    private ImageView ivSend;
    private EditText etNewMsg;
    private ArrayList<MessagesModel> messages = new ArrayList<MessagesModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);
        mFirebase = new Firebase(url);

        lvConversation = (ListView) findViewById(R.id.lvConversation);
        llchat = (LinearLayout) findViewById(R.id.rlchat);
        ivSend = (ImageView) findViewById(R.id.ivSend);
        etNewMsg = (EditText) findViewById(R.id.etNewMsg);
        adapter = new ChatAdapter(this,messages);
        lvConversation.setAdapter(adapter);


        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessagesModel msg = new MessagesModel();
                msg.setName("Shivaraj");
                msg.setMessage(etNewMsg.getText().toString());
                mFirebase.push().setValue(msg);
                Snackbar.make(view, "Message Sent", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                MessagesModel model = dataSnapshot.getValue(MessagesModel.class);

                messages.add(model);
                adapter.notifyDataSetChanged();

                lvConversation.post(new Runnable() {
                    @Override
                    public void run() {
                        lvConversation.smoothScrollToPosition(adapter.getCount() - 1);
                    }
                });

                Snackbar.make(llchat, "Message got", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}
