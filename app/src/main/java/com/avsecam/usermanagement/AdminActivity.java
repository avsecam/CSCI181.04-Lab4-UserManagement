package com.avsecam.usermanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class AdminActivity extends AppCompatActivity {

    @ViewById(R.id.recyclerViewUsers) RecyclerView usersList;

    @AfterViews
    protected void init() {
        Realm realm = Realm.getDefaultInstance();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        usersList.setLayoutManager(linearLayoutManager);

        RealmResults<User> allUsers = realm.where(User.class).findAll();
    }
}