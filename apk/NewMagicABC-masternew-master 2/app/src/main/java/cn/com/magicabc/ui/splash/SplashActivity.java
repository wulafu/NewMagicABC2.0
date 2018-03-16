package cn.com.magicabc.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import cn.com.magicabc.MainActivity;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.ui.guide.GuideActivity;
import cn.com.magicabc.util.CountDownUtils;
import cn.com.magicabc.util.LogUtils;
import cn.com.magicabc.util.SharePrefUtil;
import cn.com.magicabc.widget.CirclePercentView;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * 欢迎界面
 */
public class SplashActivity extends BaseActivity {

  public static String TAG = "splashActivity";
  @BindView(R.id.tv_copyright)
  TextView tv_copyright;
  //@BindView(R.id.count_down) TextView count_down;
  @BindView(R.id.circleView)

  CirclePercentView circleView;


  @Override
  protected int getLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  protected void afterCreate(Bundle savedInstanceState) {



    int year = Calendar.getInstance().get(Calendar.YEAR);
    tv_copyright.setText(getString(R.string.copyright, year));
    //  开启广告倒计时
    CountDownUtils.countDown(1).doOnSubscribe(new Action0() {
      @Override
      public void call() {
        // 初始化工作
        LogUtils.e(TAG, "倒计时开始");
        circleView.dodo(100);
      }
    }).subscribe(new Subscriber<Integer>() {
      @Override
      public void onCompleted() {
        LogUtils.e(TAG, "完成");
        startMainActivity();
      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(Integer integer) {
        LogUtils.e(TAG, "当前时间" + integer);
        circleView.setSelfText(integer + "秒");
      }
    });
  }


  /**
   * 调到mainactivity
   */
  private void startMainActivity() {
    if(SharePrefUtil.getBoolean(SplashActivity.this,"is_first",true)){


    Intent intent = new Intent();
    intent.setClass(this, GuideActivity.class);
    intent.putExtras(getIntent());
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    startActivity(intent);
    }else{
      Intent intent = new Intent();
      intent.setClass(this, MainActivity.class);
      intent.putExtras(getIntent());
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
      startActivity(intent);
    }
  }
}
