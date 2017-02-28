package com.xiaoyi.xycnews.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.bean.GIFBean;
import com.xiaoyi.xycnews.commons.LogUtils;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class GifAdapter extends CommonAdapter<GIFBean.ResultBean> {
    private Context context;

    public GifAdapter(Context context, List<GIFBean.ResultBean> datas) {
        super(context, R.layout.item_gif, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, GIFBean.ResultBean gifBean, int position) {
        holder.setText(R.id.tv_gif_title, gifBean.getContent());
        String url = gifBean.getUrl();
        LogUtils.i("url?:" + url);
        if (url.endsWith("f")){
            Glide.with(context)
                    .load(gifBean.getUrl())
                    .asGif()
                    .placeholder(R.mipmap.ic_error)
                    .into((ImageView) holder.getView(R.id.iv_gif));
        }else {
            Glide.with(context)
                    .load(gifBean.getUrl())
                    .placeholder(R.mipmap.ic_error)
                    .into((ImageView) holder.getView(R.id.iv_gif));
        }
    }
}
