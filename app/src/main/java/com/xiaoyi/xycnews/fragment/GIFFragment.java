package com.xiaoyi.xycnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.adapter.GifAdapter;
import com.xiaoyi.xycnews.bean.GIFBean;
import com.xiaoyi.xycnews.net.QNewsCallback;
import com.xiaoyi.xycnews.net.QNewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class GIFFragment extends Fragment {

    @BindView(R.id.rv_gif)
    RecyclerView rvGif;

    private GifAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gif, null);
        ButterKnife.bind(this, view);

        rvGif.setLayoutManager(new LinearLayoutManager(getActivity()));
        QNewsClient.getInstance().GetGIFRandomData(new QNewsCallback<GIFBean>() {
            @Override
            public void onSuccess(GIFBean response, int id) {
                List<GIFBean.ResultBean> result = response.getResult();
                adapter = new GifAdapter(getActivity(), result);
                rvGif.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Exception e, int id) {

            }
        });

        return view;
    }
}
