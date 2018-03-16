package cn.com.magicabc.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cn.com.magicabc.BabyApplication;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.ui.login.LoginActivity;
import cn.com.magicabc.util.DeviceUtils;
import cn.com.magicabc.util.NetworkUtils;
import cn.com.magicabc.util.RegexUtils;
import cn.com.magicabc.util.ToastUtils;
import cn.com.magicabc.widget.ClearEditText;

/**
 * Created by hellohome on 18/3/6.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.RegiterView {

    @Inject
    RegisterPresenter mPresenter;
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
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.ll_userfile)
    LinearLayout mLlUserfile;
    @BindView(R.id.ll_login)
    LinearLayout mLlLogin;
    private boolean isFillPhone;
    private boolean isFillPpwd;
    private boolean isFillCode;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        DaggerRegisterComponent.builder()
                .applicationComponent(BabyApplication.getApplication().getApplicationComponent())
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);
        DeviceUtils.hideSoftInput(RegisterActivity.this);
         mTvTitle.setText("注册");
        mTvRegister.setBackgroundResource(R.drawable.btn_background_noinpput);
        mTvRegister.setTextColor(getResources().getColor(R.color.grey888));
        mTvRegister.setEnabled(false);
      //  mEtCode.setClearIconVisible(false);
    }
    @OnTextChanged(R.id.et_phoneNum)
    void onTextChanged(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillPhone = true;
        } else {
            isFillPhone = false;
        }
        if (isFillPpwd && isFillPhone&&isFillCode) {
            mTvRegister.setEnabled(true);
            mTvRegister.setBackgroundResource(R.drawable.btn_background_login);
            mTvRegister.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvRegister.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvRegister.setTextColor(getResources().getColor(R.color.grey888));
            mTvRegister.setEnabled(false);
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
            mTvRegister.setEnabled(true);
            mTvRegister.setBackgroundResource(R.drawable.btn_background_login);
            mTvRegister.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvRegister.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvRegister.setTextColor(getResources().getColor(R.color.grey888));
            mTvRegister.setEnabled(false);
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
            mTvRegister.setEnabled(true);
            mTvRegister.setBackgroundResource(R.drawable.btn_background_login);
            mTvRegister.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvRegister.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvRegister.setTextColor(getResources().getColor(R.color.grey888));
            mTvRegister.setEnabled(false);
        }
    }


    @OnClick({R.id.tv_register, R.id.iv_back, R.id.tv_getcode,R.id.ll_userfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
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
                 mPresenter.registerAction(getUserphone(mEtPhoneNum),getUserphone(mEtPassword),getUserphone(mEtCode));
                }else{
                    ToastUtils.showShort("请检查您的网络！");
                }
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.ll_userfile:
                onBackPressed();
                break;
            case R.id.ll_login:
               startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.tv_getcode:
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
                    mPresenter.getCodeAction(getUserphone(mEtPhoneNum), "86");
                }else{
                    ToastUtils.showShort("请检查您的网络！");
                }
                break;

        }
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {

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
    public void registerSucess() {
        Intent intent = new Intent();
        intent.setClass(this, RegisterInfoActivity.class);
        intent.putExtras(getIntent());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void registerError(String message) {

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
       countDown();
    }
    /**
     * 发送验证码倒计时
     */
    /**
     * 发送验证码倒计时
     */
    public void countDown() {
        CountDownTimer timer = new CountDownTimer(1000 * 60, 1000) {
            @Override public void onTick(long millisUntilFinished) {
                if (mTvGetcode != null) {
                    mTvGetcode.setText((millisUntilFinished / 1000)+"");
                    mTvGetcode.setEnabled(false);
                }
            }

            @Override public void onFinish() {
                if (mTvGetcode != null) {
                    mTvGetcode.setText("获取验证码");
                    mTvGetcode.setEnabled(true);
                }
            }
        };
        timer.start();
    }

}
