package com.sudipseucse.recyclerviewwithdatabinding.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sudipseucse.recyclerviewwithdatabinding.BR;
import com.sudipseucse.recyclerviewwithdatabinding.R;
import com.sudipseucse.recyclerviewwithdatabinding.databinding.ListItemBinding;
import com.sudipseucse.recyclerviewwithdatabinding.model.CustomClickListener;
import com.sudipseucse.recyclerviewwithdatabinding.model.Version;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements CustomClickListener {

    private List<Version> versionList;
    private Context context;

    public RecyclerViewAdapter(List<Version> versionList, Context context) {
        this.versionList = versionList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Version version = versionList.get(position);

        // Sending data to xml for binding
        holder.listItemBinding.setVersion(version);
        holder.bind(version);
        holder.listItemBinding.setItemClickListener(this);
    }


    @Override
    public int getItemCount() {
        return versionList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemBinding listItemBinding;

        public ViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }

        public void bind(Object obj) {
            listItemBinding.setVariable(BR.version, obj);
            listItemBinding.executePendingBindings();
        }
    }

    public void cardClicked(Version version) {
        Toast.makeText(context, "You've clicked: " + version.androidName,
                Toast.LENGTH_LONG).show();
    }
}


