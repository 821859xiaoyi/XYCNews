package com.xiaoyi.xycnews.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.bean.JokeBean;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class JokeAdapter extends BaseQuickAdapter<JokeBean.ResultBean.DataBean, BaseViewHolder> {

    public JokeAdapter() {
        super(R.layout.item_joke);
    }

    @Override
    protected void convert(BaseViewHolder helper, JokeBean.ResultBean.DataBean item) {
        helper.setText(R.id.tv_joke_content, item.getContent());
        helper.setText(R.id.tv_joke_date, item.getUpdatetime());
        helper.getConvertView().setOnClickListener(null);
    }

}