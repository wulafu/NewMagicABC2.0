package cn.com.magicabc.ui.register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.util.DeviceUtils;
import cn.com.magicabc.widget.ClearEditText;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;

/**
 * Created by hellohome on 18/3/6.
 */

public class RegisterInfoActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.et_name)
    ClearEditText mEtName;
    @BindView(R.id.tv_birday)
    TextView mTvBirday;
    @BindView(R.id.tv_sex)
    TextView mTvSex;
    @BindView(R.id.tv_next)
    TextView mTvNext;
    @BindView(R.id.ll_login)
    LinearLayout mLlLogin;
private boolean is_name;
private boolean is_sex;
private boolean is_img;
private boolean is_date;
    private String imgUrl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_info;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        mIvBack.setVisibility(View.GONE);
        mTvTitle.setText("注册");
    }



    @OnClick({R.id.iv_back, R.id.ll_login, R.id.tv_next, R.id.tv_birday,R.id.tv_sex,R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                DeviceUtils.hideSoftInput(this);
                onBackPressed();
                break;
            case R.id.iv_head:

                break;
            case R.id.tv_birday:
                final DatePicker picker = new DatePicker(this);
//                picker.setTextColor(getResources().getColor(R.color.green));
//                picker.setShadowColor(getResources().getColor(R.color.green));
//
//                picker.setDividerColor(getResources().getColor(R.color.green));
                picker.setCanceledOnTouchOutside(false);
                picker.setUseWeight(true);
                picker.setTopPadding(ConvertUtils.toPx(this, 10));
                picker.setRangeEnd(2111, 1, 11);
                picker.setRangeStart(2000, 1, 1);
                picker.setSelectedItem(2050, 10, 14);
                picker.setResetWhileWheel(false);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        mTvBirday.setText(year + "-" +month + "-" + day);
                        is_date=true;
                    }
                });
                picker.setOnWheelListener(new DatePicker.OnWheelListener() {
                    @Override
                    public void onYearWheeled(int index, String year) {
                        mTvBirday.setText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onMonthWheeled(int index, String month) {
                        mTvBirday.setText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onDayWheeled(int index, String day) {
                        mTvBirday.setText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
                    }
                });
                picker.show();
                break;
            case R.id.tv_sex:
                OptionPicker picker1 = new OptionPicker(this, new String[]{
                        "男", "女"
                });
//                picker1.setShadowColor(getResources().getColor(R.color.green));
//                picker1.setTextColor(getResources().getColor(R.color.green));
//                picker1.setDividerColor(getResources().getColor(R.color.green));
                picker1.setCanceledOnTouchOutside(false);
                picker1.setDividerRatio(WheelView.DividerConfig.FILL);
                picker1.setShadowColor(Color.RED, 40);
                picker1.setSelectedIndex(1);
                picker1.setCycleDisable(true);
                picker1.setTextSize(11);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int index, String item) {
                        mTvSex.setText(item);
                        is_sex=true;
                    }
                });
                picker1.show();
                break;
            case R.id.tv_next:
                Intent intent = new Intent();
                intent.setClass(this, RegisterActivity.class);
                 intent.putExtra("date",mTvBirday.getText().toString());
                 intent.putExtra("sex",mTvSex.getText().toString());
                 intent.putExtra("name",mEtName.getText().toString());
                 intent.putExtra("imageUrl",imgUrl);


                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;

        }
    }

}
