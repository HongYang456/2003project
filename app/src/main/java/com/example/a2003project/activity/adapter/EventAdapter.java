package com.example.a2003project.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;


public class EventAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> categoryList;

    public EventAdapter(Context context, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.CategoryListDTO> categoryList) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.categoryList = categoryList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.envent, parent, false);
        return new VhEnventlast(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhEnventlast vhEnventlast= (VhEnventlast) holder;
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        vhEnventlast.rec.setLayoutManager(manager);
        HomeBean.DataDTO.CategoryListDTO categoryListBean = categoryList.get(position);
        List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = categoryListBean.getGoodsList();

        vhEnventlast.texName.setText(categoryListBean.getName());

        ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> beans = new ArrayList<>();
        if (categoryListBean.getGoodsList().size()>0){
            beans.addAll(goodsList);
            RecEventAdapter adapter = new RecEventAdapter(context, beans);
            vhEnventlast.rec.setAdapter(adapter);
        }
    }


    @Override
    public int getItemCount() {
        if (categoryList.size()>0){
            return categoryList.size();
        }else {
            return 0;
        }
    }
    class VhEnventlast extends RecyclerView.ViewHolder {
        RecyclerView rec;
        TextView texName;
        public VhEnventlast(@NonNull View itemView) {
            super(itemView);
            rec=itemView.findViewById(R.id.envent_rec);
            texName=itemView.findViewById(R.id.ev_item_name);
        }
    }
}
