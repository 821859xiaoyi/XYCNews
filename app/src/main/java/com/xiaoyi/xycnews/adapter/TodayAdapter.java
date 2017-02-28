package com.xiaoyi.xycnews.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaoyi.xycnews.R;
import com.xiaoyi.xycnews.bean.TodayOfHistoryBean;

/**
 * Created by 徐宜程 on 2017/2/28.
 */
public class TodayAdapter extends BaseQuickAdapter<TodayOfHistoryBean.ResultBean, BaseViewHolder> {


    public TodayAdapter() {
        super(R.layout.item_today);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodayOfHistoryBean.ResultBean item) {
        helper.setText(R.id.tv_today_title, item.getTitle());
        helper.setText(R.id.tv_today_date, item.getDate());
        helper.addOnClickListener(R.id.ll_today_detail);
    }

//    private Context context;
//
//    public TodayAdapter(Context context, List<TodayOfHistoryBean.ResultBean> datas) {
//        super(context, R.layout.item_today, datas);
//        this.context = context;
//    }
//
//    @Override
//    protected void convert(ViewHolder holder, final TodayOfHistoryBean.ResultBean todayBean, int position) {
//
//        holder.setText(R.id.tv_today_title, todayBean.getTitle());
//        holder.setText(R.id.tv_today_date, todayBean.getDate());
//        holder.setOnClickListener(R.id.ll_today_detail, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, TodayDetailActivity.class);
//                intent.putExtra("e_id", todayBean.getE_id());
//                context.startActivity(intent);
//            }
//        });
//    }
}