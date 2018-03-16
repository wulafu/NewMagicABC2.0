package cn.com.magicabc.ui.login;

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
import cn.com.magicabc.MainActivity;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.ui.forgetpasswd.ForgetPasswdActivity;
import cn.com.magicabc.ui.login.component.DaggerLoginComponent;
import cn.com.magicabc.ui.login.contract.LoginContract;
import cn.com.magicabc.ui.login.module.LoginModule;
import cn.com.magicabc.ui.login.persenter.LoginPresenter;
import cn.com.magicabc.ui.register.RegisterActivity;
import cn.com.magicabc.util.DeviceUtils;
import cn.com.magicabc.util.NetworkUtils;
import cn.com.magicabc.util.RegexUtils;
import cn.com.magicabc.util.SharePrefUtil;
import cn.com.magicabc.util.ToastUtils;
import cn.com.magicabc.widget.ClearEditText;

import static cn.com.magicabc.R.id.tv_title;

/**
 * Created by hellohome on 18/3/6.
 */

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(tv_title)
    TextView mTvTitle;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.et_phoneNum)
    ClearEditText mEtPhoneNum;
    @BindView(R.id.et_password)
    ClearEditText mEtPassword;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_forget)
    TextView mTvForget;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @Inject
    LoginPresenter mLoginPresenter;
    private boolean isFillPhone;
    private boolean isFillPpwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        mIvBack.setVisibility(View.GONE);
        mTvLogin.setBackgroundResource(R.drawable.btn_background_noinpput);
        mTvLogin.setTextColor(getResources().getColor(R.color.grey888));
        mTvLogin.setEnabled(false);
        mTvTitle.setText("登录");
        DaggerLoginComponent.builder()
                .applicationComponent(BabyApplication.getApplication().getApplicationComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

    }

    @OnTextChanged(R.id.et_phoneNum)
    void onTextChanged(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillPhone = true;
        } else {
            isFillPhone = false;
        }
        if (isFillPpwd && isFillPhone) {
            mTvLogin.setEnabled(true);
            mTvLogin.setBackgroundResource(R.drawable.btn_background_login);
            mTvLogin.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvLogin.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvLogin.setTextColor(getResources().getColor(R.color.grey888));
            mTvLogin.setEnabled(false);
        }

    }

    @OnTextChanged(R.id.et_password)
    void onTextChanged1(CharSequence text) {
        if (!TextUtils.isEmpty(text.toString())) {
            isFillPpwd = true;
        } else {
            isFillPpwd = false;
        }
        if (isFillPpwd && isFillPhone) {
            mTvLogin.setEnabled(true);
            mTvLogin.setBackgroundResource(R.drawable.btn_background_login);
            mTvLogin.setTextColor(getResources().getColor(R.color.white));
        } else {
            mTvLogin.setBackgroundResource(R.drawable.btn_background_noinpput);
            mTvLogin.setTextColor(getResources().getColor(R.color.grey888));
            mTvLogin.setEnabled(false);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_login, R.id.tv_forget, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                DeviceUtils.hideSoftInput(this);
                onBackPressed();
                break;
            case R.id.tv_forget:
                startForget();
                break;
            case R.id.tv_register:
                startRegister();
                break;
            case R.id.tv_login:
                if (NetworkUtils.isConnected()) {
                    if (TextUtils.isEmpty(getUserphone(mEtPhoneNum))) {
                        ToastUtils.showShort("用户名不能为空");
                        return;
                    }
                    if (!RegexUtils.isMobileExact(getUserphone(mEtPhoneNum))) {
                        ToastUtils.showShort("请检查您的用户名");
                        return;
                    }

                    if (TextUtils.isEmpty(getPwd(mEtPassword))) {
                        ToastUtils.showShort("密码不能为空");
                        return;
                    }
                    mLoginPresenter.onLogin(getUserphone(mEtPhoneNum), getPwd(mEtPassword));
                } else {
                    ToastUtils.showShort("请检查您的网络！");
                }
                break;

        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        //  mLoginPresenter=presenter;

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
    public void loginSucess(String userphone) {
        SharePrefUtil.saveBoolean(LoginActivity.this,"is_first",false);
        SharePrefUtil.saveString(LoginActivity.this,"userphone",userphone);
        ToastUtils.showLong("登录成功");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
       // intent.putExtra("userphone",userphone);
        startActivity(intent);
        finish();

    }

    @Override
    public void loginError(String message) {

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
    public void startForget() {
        Intent intent = new Intent(LoginActivity.this, ForgetPasswdActivity.class);
        startActivity(intent);
    }

    @Override
    public void startRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
