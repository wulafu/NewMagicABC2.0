package cn.com.magicabc.ui.word;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.com.magicabc.BabyApplication;
import cn.com.magicabc.R;
import cn.com.magicabc.ui.homework.HomeWorkListActivity;
import cn.com.magicabc.ui.activity.CommentAdapter;
import cn.com.magicabc.ui.activity.WordLessonRecyclerViewAdapter;
import cn.com.magicabc.ui.base.BaseActivity;
import cn.com.magicabc.util.PermissionListener;
import cn.com.magicabc.util.SharePrefUtil;
import cn.com.magicabc.util.ToastUtils;


public class WordActivity extends BaseActivity implements PermissionListener,WorkContract.WorkView {

    private static final String TAG = "main";
    CommentAdapter commentAdapter;
    WordLessonRecyclerViewAdapter wordLessonRecyclerViewAdapter;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    HashMap<Integer, List<WorkListBean>> hms;

    @Inject WorkListPresenter homePersenter;

    @Override protected int getLayoutId() {
        return R.layout.activity_word;
    }

    @Override protected void afterCreate(Bundle savedInstanceState) {

        String grade = getIntent().getStringExtra("grade");
        rv_list.setLayoutManager(new LinearLayoutManager(this));
      //  commentAdapter = new CommentAdapter(this);
        wordLessonRecyclerViewAdapter = new WordLessonRecyclerViewAdapter(this);
        rv_list.setAdapter(wordLessonRecyclerViewAdapter);

      //  requestPermissions(new String[]{Manifest.permission.CALL_PHONE},this);
        DaggerWordComponent.builder()
                .applicationComponent(BabyApplication.getApplication().getApplicationComponent())
                .wordModule(new WordModule(this))
                .build()
                .inject(this);
        homePersenter.loadDataAction(SharePrefUtil.getString(WordActivity.this,"userphone",""),grade);
        wordLessonRecyclerViewAdapter.setOnItemClickListener(new WordLessonRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent= new Intent(WordActivity.this, HomeWorkListActivity.class);
                switch (view.getId()){
                    case R.id.iv1:
                        if (hms.get(position).get(0).getIsImpower() == 0) {

                            ToastUtils.showShort("您还没有买壳");
                            //无权限，都为暗色
                            if ("CS".equals(hms.get(position).get(0).getType())) {

                            } else if ("ZY".equals(hms.get(position).get(0).getType())) {

                            } else if ("LW".equals(hms.get(position).get(0).getType())) {

                            }
                        } else {
                            //有权限
                            if (hms.get(position).get(0).getIsLock() == 0) {
                                ToastUtils.showShort("开课时间还没到");
                                //不亮
                                if ("CS".equals(hms.get(position).get(0).getType())) {

                                } else if ("ZY".equals(hms.get(position).get(0).getType())) {

                                } else if ("LW".equals(hms.get(position).get(0).getType())) {

                                }
                            } else {


                                //亮
                                if (hms.get(position).get(0).getIsEnd() == 0) {
                                    //未做完，未做，
                                    if ("CS".equals(hms.get(position).get(0).getType())) {

                                    } else if ("ZY".equals(hms.get(position).get(0).getType())) {
                                        ToastUtils.showShort(hms.get(position).get(0).getLesson());
                                        intent.putExtra("grade",hms.get(position).get(0).getGrade());
                                        intent.putExtra("lesson",hms.get(position).get(0).getLesson());
                                        intent.putExtra("classId",hms.get(position).get(0).getClassId());
                                        startActivity(intent);
                                    } else if ("LW".equals(hms.get(position).get(0).getType())) {

                                    }
                                } else {
                                    //做完，
                                    if ("CS".equals(hms.get(position).get(0).getType())) {

                                    } else if ("ZY".equals(hms.get(position).get(0).getType())) {
                                        ToastUtils.showShort(hms.get(position).get(0).getLesson());
                                        intent.putExtra("grade",hms.get(position).get(0).getGrade());
                                        intent.putExtra("lesson",hms.get(position).get(0).getLesson());
                                        intent.putExtra("classId",hms.get(position).get(0).getClassId());
                                        startActivity(intent);
                                    } else if ("LW".equals(hms.get(position).get(0).getType())) {

                                    }

                                }


                            }

                        }



                        break;
                    case R.id.iv2:
                        ToastUtils.showShort(hms.get(position).get(1).getLesson());
                        intent.putExtra("grade",hms.get(position).get(1).getGrade());
                        intent.putExtra("lesson",hms.get(position).get(1).getLesson());
                        startActivity(intent);
                        break;
                    case R.id.iv3:
                        intent.putExtra("grade",hms.get(position).get(2).getGrade());
                        intent.putExtra("lesson",hms.get(position).get(2).getLesson());
                        ToastUtils.showShort(hms.get(position).get(2).getLesson());
                        startActivity(intent);
                        break;
                    case R.id.iv4:
                        intent.putExtra("grade",hms.get(position).get(3).getGrade());
                        intent.putExtra("lesson",hms.get(position).get(3).getLesson());
                        ToastUtils.showShort(hms.get(position).get(3).getLesson());
                        startActivity(intent);
                        break;
                    case R.id.iv5:
                        intent.putExtra("grade",hms.get(position).get(4).getGrade());
                        intent.putExtra("lesson",hms.get(position).get(4).getLesson());
                        startActivity(intent);
                        ToastUtils.showShort(hms.get(position).get(4).getLesson());
                        break;
                    case R.id.iv6:
                        startActivity(intent);
                        intent.putExtra("grade",hms.get(position).get(5).getGrade());
                        intent.putExtra("lesson",hms.get(position).get(5).getLesson());
                        ToastUtils.showShort(hms.get(position).get(5).getLesson());
                        break;
                }

            }
        });
    }



    @Override
    public void onGranted() {
        //ToastUtils.showLong("kepyi");


    }

    @Override
    public void onDenied(List<String> deniedPermissions) {
       // ToastUtils.showLong("wwww");

    }

    @Override
    public void setPresenter(WorkContract.Presenter presenter) {

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
    public void workSucess(final HashMap<Integer, List<WorkListBean>> workListBean) {

        if(workListBean!=null&&workListBean.size()==0){
            showEmptyView();
        }else{
            hms=workListBean;
            wordLessonRecyclerViewAdapter.addAllData(workListBean);
        }









    }

    @Override
    public void workError(String message) {

    }


    @Override
    public void onNetworkViewRefresh() {
        super.onNetworkViewRefresh();
        homePersenter.subscribe();
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

