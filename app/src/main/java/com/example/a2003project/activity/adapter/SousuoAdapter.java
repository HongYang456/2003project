package com.example.a2003project.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.a2003project.R;

import java.time.Period;

import static com.example.a2003project.R.layout.search;

public class SousuoAdapter extends DelegateAdapter.Adapter {

    private LayoutHelper layoutHelper;
    private Context context;

    public SousuoAdapter(LayoutHelper layoutHelper, Context context) {
        this.layoutHelper = layoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent,false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class VH extends RecyclerView.ViewHolder {

        private final TextView sousuo;

        public VH(@NonNull View itemView) {
            super(itemView);
            sousuo = itemView.findViewById(R.id.sousuo);
        }
    }
}
