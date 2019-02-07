package com.mayank.butterknife;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<ContactsModel> mContacts;
    private Context mContext;

    public ContactsAdapter(List<ContactsModel> contacts, Context context) {
        this.mContacts = contacts;
        this.mContext = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.number)
        TextView number;

        MyViewHolder(View view) {
            super(view);
            // binding view
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_contact, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ContactsModel contact = mContacts.get(position);
        holder.name.setText(mContext.getString(R.string.name) + contact.getName().toUpperCase());
        holder.number.setText(mContext.getString(R.string.number) + contact.getNumber());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
