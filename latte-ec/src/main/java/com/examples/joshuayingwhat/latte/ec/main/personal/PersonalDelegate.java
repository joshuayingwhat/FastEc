package com.examples.joshuayingwhat.latte.ec.main.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.examples.joshuayingwhat.latte.delegates.bottom.BottomItemDelegate;
import com.examples.joshuayingwhat.latte.ec.R;
import com.examples.joshuayingwhat.latte.ec.R2;
import com.examples.joshuayingwhat.latte.ec.main.personal.list.ListAdapter;
import com.examples.joshuayingwhat.latte.ec.main.personal.list.ListBean;
import com.examples.joshuayingwhat.latte.ec.main.personal.list.ListItemType;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 个人中心页
 *
 * @author joshuayingwhat
 */
public class PersonalDelegate extends BottomItemDelegate {
    @BindView(R2.id.img_user_avatar)
    CircleImageView imgUserAvatar;
    @BindView(R2.id.tv_all_order)
    TextView tvAllOrder;
    @BindView(R2.id.tv_all_account_arrow)
    IconTextView tvAllAccountArrow;
    @BindView(R2.id.ll_pay)
    LinearLayout llPay;
    @BindView(R2.id.textView)
    TextView textView;
    @BindView(R2.id.ll_receive)
    LinearLayout llReceive;
    @BindView(R2.id.ll_evaluate)
    LinearLayout llEvaluate;
    @BindView(R2.id.ll_after_market)
    LinearLayout llAfterMarket;
    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRvSettings;

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //模拟网络请求
        ListBean address = new ListBean.Builder()
                .setmItemType(ListItemType.ITEM_NORAL)
                .setmId(1)
                .setmText("收货地址")
                .build();

        ListBean system = new ListBean.Builder()
                .setmItemType(ListItemType.ITEM_NORAL)
                .setmId(2)
                .setmText("系统设置")
                .build();

        final List<ListBean> data = new ArrayList<>();

        data.add(address);
        data.add(system);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRvSettings.setAdapter(adapter);
    }
}