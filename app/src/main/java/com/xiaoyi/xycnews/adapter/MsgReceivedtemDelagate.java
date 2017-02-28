package com.xiaoyi.xycnews.adapter;

import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.bean.RobotMSGBean;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class MsgReceivedtemDelagate implements ItemViewDelegate<RobotMSGBean> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_robot_receiver;
    }

    @Override
    public boolean isForViewType(RobotMSGBean item, int position) {
        return item.getType() == RobotMSGBean.MSG_RECEIVED;
    }

    @Override
    public void convert(ViewHolder holder, RobotMSGBean robotMSGBean, int position) {
        holder.setText(R.id.tv_msg_left, robotMSGBean.getMsg());
    }
}