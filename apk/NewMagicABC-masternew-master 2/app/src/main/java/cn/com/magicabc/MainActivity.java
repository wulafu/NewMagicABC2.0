package cn.com.magicabc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.magicabc.http.HttpFactory;
import cn.com.magicabc.http.HttpResult;
import cn.com.magicabc.http.HttpTransformer;
import cn.com.magicabc.ui.activity.MessageActivity;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.ui.bean.UserBean;
import cn.com.magicabc.ui.homework.HomeWorkListActivity;
import cn.com.magicabc.ui.me.MeActivity;
import cn.com.magicabc.ui.word.WordActivity;
import cn.com.magicabc.util.PermissionListener;
import cn.com.magicabc.util.SharePrefUtil;
import cn.com.magicabc.util.ToastUtils;
import q.rorbin.badgeview.QBadgeView;
import rx.Subscriber;
import rx.functions.Action0;


public class MainActivity extends BaseActivity implements PermissionListener {

    private static final String TAG = "main";

    @BindView(R.id.rl_me)
    RelativeLayout mRlme;
    @BindView(R.id.iv_menu)
    ImageView mIvMenu;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.iv_huiben)
    ImageView mIvHuiben;
    @BindView(R.id.iv_word)
    ImageView mIvWord;
    @BindView(R.id.iv_start)
    ImageView mIvStart;
    @BindView(R.id.rl_bomtom)
    RelativeLayout mRlBomtom;
    @BindView(R.id.tv_fen)
    TextView mTvFen;
UserBean mUserBean;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_include;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

      QBadgeView badge = new QBadgeView(MainActivity.this);
        badge.bindTarget(ivSearch).setBadgeNumber(2);
        badge.setBadgeGravity(Gravity.END | Gravity.TOP);
        badge.setBadgePadding(0, true);
        badge.setBadgeTextSize(8, true);
        badge.setGravityOffset(0, 0, true);
        badge.setBadgeTextSize(8, true);
        HttpFactory.getHttpApiSingleton()
                .queryUser(SharePrefUtil.getString(MainActivity.this,"userphone",""))
                .compose(new HttpTransformer<HttpResult<UserBean>, UserBean>())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .subscribe(new Subscriber<UserBean>() {
                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onNext(UserBean userBean) {

                    if(userBean!=null){

                        mUserBean=userBean;
                        if (TextUtils.isEmpty(userBean.getHeadimagepath())) {
                            mIvMenu.setImageResource(R.drawable.iv_default);
                        } else {
                            Glide.with(MainActivity.this).load(userBean.getHeadimagepath()).asBitmap().centerCrop().placeholder(R.drawable.iv_default).into(new BitmapImageViewTarget(mIvMenu) {
                                @Override
                                protected void setResource(Bitmap resource) {
                                    RoundedBitmapDrawable circularBitmapDrawable =
                                            RoundedBitmapDrawableFactory.create(getResources(), resource);
                                    circularBitmapDrawable.setCircular(true);
                                    mIvMenu.setImageDrawable(circularBitmapDrawable);
                                }
                            });
                        }
                        ToastUtils.showShort(userBean.getIntegral()+","+userBean.getGrades().size());
                        mTvFen.setText(userBean.getIntegral()+"");
                        if (userBean.getGrades().size() == 0) {
                            mIvStart.setVisibility(View.VISIBLE);
                            mViewPager.setVisibility(View.GONE);
                        } else {
                            mIvStart.setVisibility(View.GONE);
                            mViewPager.setVisibility(View.VISIBLE);
                            MyPagerAdapter adapter = new MyPagerAdapter(userBean);
                            mViewPager.setAdapter(adapter);
                            mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                @Override
                                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                }

                                @Override
                                public void onPageSelected(int position) {

                                }

                                @Override
                                public void onPageScrollStateChanged(int state) {

                                }
                            });
                        }


                    }
                    }
                });




//        //requestPermissions(new String[]{Manifest.permission.CALL_PHONE},this);
//        DaggerHomeComponent.builder()
//                .applicationComponent(BabyApplication.getApplication().getApplicationComponent())
//                .homeModule(new HomeModule(this))
//                .build()
//                .inject(this);

    }

    @OnClick({R.id.rl_me, R.id.iv_search, R.id.iv_huiben, R.id.iv_word})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {

            case R.id.rl_me:
                //drawerLayout.openDrawer(GravityCompat.START);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, mIvMenu, mIvMenu.getTransitionName());
                  intent=  new Intent(MainActivity.this, MeActivity.class);
                    intent.putExtra("userbean",mUserBean);
                    startActivity(intent, activityOptionsCompat.toBundle());
                } else {
                    intent=  new Intent(MainActivity.this, MeActivity.class);
                    intent.putExtra("userbean",mUserBean);
                    startActivity(intent);
                }
                break;
            case R.id.iv_search:
                //drawerLayout.openDrawer(GravityCompat.START);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, ivSearch, ivSearch.getTransitionName());
                    startActivity(new Intent(MainActivity.this, MessageActivity.class), activityOptionsCompat.toBundle());
                } else {
                    startActivity(new Intent(MainActivity.this, MessageActivity.class));
                }
                break;
            case R.id.iv_huiben:
                //drawerLayout.openDrawer(GravityCompat.START);

                startActivity(new Intent(MainActivity.this, HomeWorkListActivity.class));

                break;
            case R.id.iv_word:
                //drawerLayout.openDrawer(GravityCompat.START);

                startActivity(new Intent(MainActivity.this, WordActivity.class));

                break;

        }
    }

    @Override
    public void onGranted() {
        //ToastUtils.showLong("kepyi");


    }

    @Override
    public void onDenied(List<String> deniedPermissions) {

    }


    class MyPagerAdapter extends PagerAdapter {
        UserBean mUserBean;

        public MyPagerAdapter(UserBean userBean) {
            mUserBean = userBean;

        }

        @Override
        public int getCount() {
            return mUserBean.getGrades().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            //   ImageView imageView = images.get(position);
            View inflate = View.inflate(MainActivity.this, R.layout.fragment_item, null);
            ImageView iv = (ImageView) inflate.findViewById(R.id.iv);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, WordActivity.class);
                    intent.putExtra("grade",mUserBean.getGrades().get(position));
                    startActivity(intent);

                }
            });
            TextView tvGrade = (TextView) inflate.findViewById(R.id.tv_grade);
            tvGrade.setText(mUserBean.getGrades().get(position));
            container.addView(inflate);
            return inflate;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

//HttpFactory.getHttpApiSingleton()
//    .getCategoryData("Android", 10, 1)
//    .compose(new HttpTransformer<HttpResult<List<GankEntity>>, List<GankEntity>>())
//    .doOnSubscribe(new Action0() {
//      @Override public void call() {
//        showLoadingView();
//      }
//    })
//    .subscribe(new Subscriber<List<GankEntity>>() {
//      @Override public void onCompleted() {
//        LogUtils.d(TAG, "Completed");
//        showContentView();
//      }
//
//      @Override public void onError(Throwable e) {
//        LogUtils.d(TAG, "OnError, Error is " + e.toString());
//        showErrorView();
//      }
//
//      @Override public void onNext(List<GankEntity> gankEntities) {
//
//      }
//    });
