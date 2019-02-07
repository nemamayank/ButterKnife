package com.mayank.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneDirectory extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<ContactsDirectory> listContacts = new ArrayList<>();
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        // binding the view
        ButterKnife.bind(this);

        initialize();
    }

    private void initialize() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_phone_directory);

        initContactAdapter();
    }

    private void initContactAdapter() {
        mAdapter = new ContactsAdapter(listContacts,PhoneDirectory.this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareContacts();
    }

    private void prepareContacts() {
        listContacts.add(new ContactsDirectory("flacons","9989"));
        listContacts.add(new ContactsDirectory("metallophone","66567"));
        listContacts.add(new ContactsDirectory("amoebean","4547"));
        listContacts.add(new ContactsDirectory("prattler","9089"));
        listContacts.add(new ContactsDirectory("estamene","5413"));
        listContacts.add(new ContactsDirectory("lorem","0961"));
        listContacts.add(new ContactsDirectory("ipsum","2690"));
        listContacts.add(new ContactsDirectory("somiani","2389"));

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
