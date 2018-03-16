package cn.com.magicabc.ui.forgetpasswd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cn.com.magicabc.BabyApplication;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.ui.login.LoginActivity;
import cn.com.magicabc.util.NetworkUtils;
import cn.com.magicabc.util.RegexUtils;
import cn.com.magicabc.util.ToastUtils;
import cn.com.magicabc.widget.ClearEditText;

/**
 * Created by hellohome on 18/3/6.
 */

public class ForgetPasswdActivity extends BaseActivity implements ForgetPwdContract.ForgetPwdView{

    @Inject
    ForgetPwdPresenter mPresenter;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.et_phoneNum)
    ClearEditText mEtPhoneNum;
    @BindView(R.id.et_password)
    ClearEditText mEtPassword;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.tv_getcode)
    TextView mTvGetcode;
    @BindView(R.id.tv_confirm)
    TextView mTvConfirm;
    private boolean isFillPhone;
    private boolean isFillPpwd;
    private boolean isFillCode;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetpasswd;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        DaggerForgetPwdCompopnent.builder()
                .applicationComponent(BabyApplication.getApplication().getApplicationComponent())
                .forgetPwdModule(new ForgetPwdModule(this))
                .build()
                .inject(this);
        mTvTitle.setText("忘记密码");
        mTvConfirm.setBackgroundResource(R.drawable.btn_background_noinpput);
        mTvConfirm.setTextColor(getResources().getColor(R.color.grey888));
        mTvConfirm.setEnabled(false);
    }

    @OnClick({R.id.tv_confirm, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:

                if (NetworkUtils.isConnected()) {
                    if(TextUtils.isEmpty(getUserphone(mEtPhoneNum))){
                        ToastUtils.showShort("用户名不能为空");
                        return;
                    }
                    if (!RegexUtils.isMobileExact(getUserphone(mEtPhoneNum))) {
                        ToastUtils.showShort("请检查您的用户名");
                        return;
                    }
                    if(TextUtils.isEmpty(getUserphone(mEtPassword))){
                        ToastUtils.showShort("密码不能为空");
                        return;
                    }
                    if(TextUtils.isEmpty(getUserphone(mEtCode))){
                        ToastUtils.showShort("验证码不能为空");
                        return;
                    }
                    mPresenter.forgetAction(getUserphone(mEtPhoneNum),getUserphone(mEtPassword),getUserphone(mEtCode));
                }else{
                    ToastUtils.showShort("请检查您的网络！");
                }



                break;
            case R.id.iv_back:
                onBackPressed();
                break;

        }
    }
    @OnTextChanged(R.id.et_phoneNum)
    void onTextChanged(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillPhone = true;
        } else {
            isFillPhone = false;
        }
        if (isFillPpwd && isFillPhone&&isFillCode) {
            mTvConfirm.setEnabled(true);
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_login);
            mTvConfirm.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvConfirm.setTextColor(getResources().getColor(R.color.grey888));
            mTvConfirm.setEnabled(false);
        }

    }
    @OnTextChanged(R.id.et_code)
    void onTextChanged2(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillCode = true;
        } else {
            isFillCode = false;
        }
        if (isFillPpwd && isFillPhone&&isFillCode) {
            mTvConfirm.setEnabled(true);
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_login);
            mTvConfirm.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvConfirm.setTextColor(getResources().getColor(R.color.grey888));
            mTvConfirm.setEnabled(false);
        }

    }

    @OnTextChanged(R.id.et_password)
    void onTextChanged1(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillPpwd = true;
        } else {
            isFillPpwd = false;
        }
        if (isFillPpwd && isFillPhone&&isFillCode) {
            mTvConfirm.setEnabled(true);
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_login);
            mTvConfirm.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvConfirm.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvConfirm.setTextColor(getResources().getColor(R.color.grey888));
            mTvConfirm.setEnabled(false);
        }
    }

    @Override
    public void setPresenter(ForgetPwdContract.Presenter presenter) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void updateSucess() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        intent.putExtras(getIntent());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void updateError(String message) {

    }

    @Override
    public String getUserphone(EditText et) {
        return et.getText().toString();
    }

    @Override
    public String getPwd(EditText et) {
        return et.getText().toString();
    }

    @Override
    public String getCode(EditText et) {
        return et.getText().toString();
    }

    @Override
    public void getOnlineCode() {

    }
}
