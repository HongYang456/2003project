package com.example.a2003project.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;

import java.util.ArrayList;


public class ThreeAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channel;    //上一个组件是否加载出来
    private String name;    //修改，复用
    public ThreeAdapter(Context context, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.ChannelDTO> channel,String name) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.channel=channel;
        this.name=name;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.producer, parent, false);
        return new VhThree(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhThree vhThree= (VhThree) holder;
        vhThree.biaohang.setText(name);
    }

    @Override
    public int getItemCount() {
        if (channel.size()>0){
            return 1;
        }else {
            return 0;
        }
    }
    class VhThree extends RecyclerView.ViewHolder{
        TextView biaohang;
        public VhThree(@NonNull View itemView) {
            super(itemView);
            biaohang=itemView.findViewById(R.id.produce_tex);
        }
    }
}
