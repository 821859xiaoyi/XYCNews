package com.xiaoyi.xycnews.adapter;

import android.content.Context;

import com.xiaoyi.xycnews.bean.RobotMSGBean;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class RobotAdapter extends MultiItemTypeAdapter<RobotMSGBean> {
    private Context context;
    private List<RobotMSGBean> datas;
    public RobotAdapter(Context context, List<RobotMSGBean> datas) {
        super(context, datas);
        this.context = context;
        this.datas = datas;
    }

    public void addDataToAdapter(RobotMSGBean bean){
        if (datas != null){
            datas.add(bean);
        }
    }
}
