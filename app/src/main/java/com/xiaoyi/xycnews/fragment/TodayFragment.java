package com.xiaoyi.xycnews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.activity.TodayDetailActivity;
import com.xiaoyi.xycnews.adapter.TodayAdapter;
import com.xiaoyi.xycnews.bean.TodayOfHistoryBean;
import com.xiaoyi.xycnews.net.QNewsCallback;
import com.xiaoyi.xycnews.net.QNewsClient;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 历史上的今天fragment
 *
 * Created by 徐宜程 on 2017/2/28.
 */
public class TodayFragment extends Fragment {


    @BindView(R.id.tb_today)
    Toolbar tbToday;
    @BindView(R.id.rv_today)
    RecyclerView rvToday;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    //历史上今天的适配器
    private TodayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, null);
        ButterKnife.bind(this, view);

        adapter = new TodayAdapter();
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //悬浮按钮设置点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rvToday != null) {
                    rvToday.scrollToPosition(0);
                }
            }
        });

        //recyclerView初始化
        rvToday.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvToday.setAdapter(adapter);
        rvToday.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), TodayDetailActivity.class);
                intent.putExtra("e_id", ((TodayOfHistoryBean.ResultBean)adapter.getItem(position)).getE_id());
                getActivity().startActivity(intent);
            }
        });

        //获得当前的日期
        Calendar calendar = Calendar.getInstance();
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        tbToday.setTitle("历史上的今天 (" + month + "月" + day + "日)");

        //初次加载数据
        QNewsClient.getInstance().GetTodayOfHistoryData(month, day,
                new QNewsCallback<TodayOfHistoryBean>() {
                    @Override
                    public void onSuccess(TodayOfHistoryBean response, int id) {
                        List<TodayOfHistoryBean.ResultBean> result = response.getResult();
                        adapter.addData(result);
                    }

                    @Override
                    public void onError(Exception e, int id) {

                    }
                });

        return view;
    }
}
