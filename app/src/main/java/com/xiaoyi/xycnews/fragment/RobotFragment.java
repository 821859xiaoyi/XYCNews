package com.xiaoyi.xycnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.adapter.MsgReceivedtemDelagate;
import com.xiaoyi.xycnews.adapter.MsgSendItemDelagate;
import com.xiaoyi.xycnews.adapter.RobotAdapter;
import com.xiaoyi.xycnews.bean.RobotMSGBean;
import com.xiaoyi.xycnews.commons.ActivityUtils;
import com.xiaoyi.xycnews.net.QNewsCallback;
import com.xiaoyi.xycnews.net.QNewsClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class RobotFragment extends Fragment {

    @BindView(R.id.tb_robot)
    Toolbar tbRobot;
    @BindView(R.id.rv_robot)
    RecyclerView rvRobot;
    @BindView(R.id.et_input)
    EditText etInput;

    private RobotAdapter adapter;

    private List<RobotMSGBean> datas = new ArrayList<>();

    private ActivityUtils utils;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robot, null);
        ButterKnife.bind(this, view);

        utils = new ActivityUtils(getActivity());

        adapter = new RobotAdapter(getActivity(), datas);
        adapter.addItemViewDelegate(new MsgReceivedtemDelagate());
        adapter.addItemViewDelegate(new MsgSendItemDelagate());

        rvRobot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRobot.setAdapter(adapter);

        RobotMSGBean receiverBean = new RobotMSGBean();
        receiverBean.setMsg("您好！我是图灵机器人，有什么可以帮助您吗？");
        receiverBean.setType(RobotMSGBean.MSG_RECEIVED);
        adapter.addDataToAdapter(receiverBean);
        adapter.notifyDataSetChanged();
        rvRobot.smoothScrollToPosition(adapter.getItemCount() - 1);

        return view;
    }


    @OnClick(R.id.bt_send)
    public void onClick(View view) {
        String msg = etInput.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            etInput.setError("内容不能为空");
            return;
        }

        RobotMSGBean sendBean = new RobotMSGBean();
        sendBean.setMsg(msg);
        sendBean.setType(RobotMSGBean.MSG_SEND);
        etInput.setText("");
        adapter.addDataToAdapter(sendBean);
        adapter.notifyDataSetChanged();


        QNewsClient.getInstance().GetQARobotData(msg, new QNewsCallback<String>() {
            @Override
            public void onSuccess(String response, int id) {

                RobotMSGBean receiverBean = new RobotMSGBean();
                receiverBean.setMsg(response);
                receiverBean.setType(RobotMSGBean.MSG_RECEIVED);
                adapter.addDataToAdapter(receiverBean);
                adapter.notifyDataSetChanged();
                rvRobot.smoothScrollToPosition(adapter.getItemCount() - 1);

            }

            @Override
            public void onError(Exception e, int id) {

            }
        });
    }
}

