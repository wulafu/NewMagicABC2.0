package cn.com.magicabc.ui.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.com.magicabc.R;
import cn.com.magicabc.ui.word.WorkListBean;

/**
 * Created by WuXiaolong
 * on 2015/7/2.
 */
public class WordLessonRecyclerViewAdapter extends RecyclerView.Adapter<WordLessonRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {


    private Context mContext;
    private HashMap<Integer, List<WorkListBean>> dataList = new HashMap<>();

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int data);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void addAllData(HashMap<Integer, List<WorkListBean>> dataList) {
        clearData();
        this.dataList=dataList;
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public WordLessonRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv1;
        public ImageView iv2;
        public ImageView iv3;
        public ImageView iv4;
        public ImageView iv5;
        public ImageView iv6;
        public ImageView iv_line1;
        public ImageView iv_line2;
        public ImageView iv_line3;
        public ImageView iv_line4;
        public ImageView iv_line5;
        public ImageView iv_line6;
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public TextView tv4;
        public TextView tv5;
        public TextView tv6;
        public SimpleRatingBar srb_1;
        public SimpleRatingBar srb_2;
        public SimpleRatingBar srb_3;
        public SimpleRatingBar srb_4;
        public SimpleRatingBar srb_5;
        public SimpleRatingBar srb_6;
        private ArrayList<ImageView> ivs=new ArrayList<>();
        private ArrayList<ImageView> ivLines=new ArrayList<>();
        private ArrayList<TextView> tvs=new ArrayList<>();
        private ArrayList<SimpleRatingBar> srbs=new ArrayList<>();




        public ViewHolder(View itemView) {
            super(itemView);
           iv1 = (ImageView) itemView.findViewById(R.id.iv1);
           iv2 = (ImageView) itemView.findViewById(R.id.iv2);
           iv3 = (ImageView) itemView.findViewById(R.id.iv3);
           iv4 = (ImageView) itemView.findViewById(R.id.iv4);
           iv5 = (ImageView) itemView.findViewById(R.id.iv5);
           iv6 = (ImageView) itemView.findViewById(R.id.iv6);
           srb_1 = (SimpleRatingBar) itemView.findViewById(R.id.srb_1);
           srb_2 = (SimpleRatingBar) itemView.findViewById(R.id.srb_2);
           srb_3 = (SimpleRatingBar) itemView.findViewById(R.id.srb_3);
           srb_4 = (SimpleRatingBar) itemView.findViewById(R.id.srb_4);
           srb_5 = (SimpleRatingBar) itemView.findViewById(R.id.srb_5);
           srb_6 = (SimpleRatingBar) itemView.findViewById(R.id.srb_6);
           iv_line1 = (ImageView) itemView.findViewById(R.id.iv_line1);
           iv_line2 = (ImageView) itemView.findViewById(R.id.iv_line2);
           iv_line3 = (ImageView) itemView.findViewById(R.id.iv_line3);
           iv_line4 = (ImageView) itemView.findViewById(R.id.iv_line4);
           iv_line5 = (ImageView) itemView.findViewById(R.id.iv_line5);
           iv_line6 = (ImageView) itemView.findViewById(R.id.iv_line6);
           tv1 = (TextView) itemView.findViewById(R.id.tv_1);
           tv2 = (TextView) itemView.findViewById(R.id.tv_2);
           tv3 = (TextView) itemView.findViewById(R.id.tv_3);
           tv4 = (TextView) itemView.findViewById(R.id.tv_4);
           tv5 = (TextView) itemView.findViewById(R.id.tv_5);
           tv6 = (TextView) itemView.findViewById(R.id.tv_6);
ivs.add(iv1);
ivs.add(iv2);
ivs.add(iv3);
ivs.add(iv4);
ivs.add(iv5);
ivs.add(iv6);


            tvs.add(tv1);
            tvs.add(tv2);
            tvs.add(tv3);
            tvs.add(tv4);
            tvs.add(tv5);
            tvs.add(tv6);

            srbs.add(srb_1);
            srbs.add(srb_2);
            srbs.add(srb_3);
            srbs.add(srb_4);
            srbs.add(srb_5);
            srbs.add(srb_6);


            ivLines.add(iv_line1);
            ivLines.add(iv_line2);
            ivLines.add(iv_line3);
            ivLines.add(iv_line4);
            ivLines.add(iv_line5);
            ivLines.add(iv_line6);
          //  tv1 = (TextView) itemView.findViewById(R.id.tv1);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_lesson_item, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      holder.setIsRecyclable(false);
//        ToastUtils.showShort(  dataList.get(0).get(0).getLesson());
//        ToastUtils.showShort(  dataList.get(1).get(0).getLesson());
//        ToastUtils.showShort(  dataList.get(2).get(0).getLesson());
//        ToastUtils.showShort(  dataList.get(3).get(0).getLesson());
//        ToastUtils.showShort(  dataList.get(4).get(0).getLesson());







//
//if(position==dataList.size()-1){
//
//    if (dataList.get(position).size() % 6 == 1) {
//        holder.tv2.setVisibility(View.INVISIBLE);
//        holder.iv2.setVisibility(View.INVISIBLE);
//        holder.tv3.setVisibility(View.INVISIBLE);
//        holder.iv3.setVisibility(View.INVISIBLE);
//        holder.tv4.setVisibility(View.INVISIBLE);
//        holder.iv4.setVisibility(View.INVISIBLE);
//        holder.tv5.setVisibility(View.INVISIBLE);
//        holder.iv5.setVisibility(View.INVISIBLE);
//        holder.tv6.setVisibility(View.INVISIBLE);
//        holder.iv6.setVisibility(View.INVISIBLE);
//        holder.srb_2.setVisibility(View.INVISIBLE);
//        holder.srb_3.setVisibility(View.INVISIBLE);
//        holder.srb_4.setVisibility(View.INVISIBLE);
//        holder.srb_5.setVisibility(View.INVISIBLE);
//        holder.srb_6.setVisibility(View.INVISIBLE);
//        holder.iv_line1.setVisibility(View.INVISIBLE);
//        holder.iv_line2.setVisibility(View.INVISIBLE);
//        holder.iv_line3.setVisibility(View.INVISIBLE);
//        holder.iv_line4.setVisibility(View.INVISIBLE);
//        holder.iv_line5.setVisibility(View.INVISIBLE);
//        holder.iv_line6.setVisibility(View.INVISIBLE);
//
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("测试");
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//
//
//    } else if (dataList.get(position).size() % 6 == 2) {
//
//        holder.tv3.setVisibility(View.INVISIBLE);
//        holder.iv3.setVisibility(View.INVISIBLE);
//        holder.tv4.setVisibility(View.INVISIBLE);
//        holder.iv4.setVisibility(View.INVISIBLE);
//        holder.tv5.setVisibility(View.INVISIBLE);
//        holder.iv5.setVisibility(View.INVISIBLE);
//        holder.tv6.setVisibility(View.INVISIBLE);
//        holder.iv6.setVisibility(View.INVISIBLE);
//
//        holder.srb_3.setVisibility(View.INVISIBLE);
//        holder.srb_4.setVisibility(View.INVISIBLE);
//        holder.srb_5.setVisibility(View.INVISIBLE);
//        holder.srb_6.setVisibility(View.INVISIBLE);
//
//        holder.iv_line2.setVisibility(View.INVISIBLE);
//        holder.iv_line3.setVisibility(View.INVISIBLE);
//        holder.iv_line4.setVisibility(View.INVISIBLE);
//        holder.iv_line5.setVisibility(View.INVISIBLE);
//        holder.iv_line6.setVisibility(View.INVISIBLE);
//
//
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv1.setText("测试");
//            holder.srb_1.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv2.setText("测试");
//            holder.srb_2.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        }else if("LW".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.baoxiang);
//            holder.srb_2.setVisibility(View.GONE);
//            holder.tv2.setText("");
//        }
//
//    } else if (dataList.get(position).size() % 6 == 3) {
//
//        holder.tv4.setVisibility(View.INVISIBLE);
//        holder.iv4.setVisibility(View.INVISIBLE);
//        holder.tv5.setVisibility(View.INVISIBLE);
//        holder.iv5.setVisibility(View.INVISIBLE);
//        holder.tv6.setVisibility(View.INVISIBLE);
//        holder.iv6.setVisibility(View.INVISIBLE);
//
//        holder.srb_4.setVisibility(View.INVISIBLE);
//        holder.srb_5.setVisibility(View.INVISIBLE);
//        holder.srb_6.setVisibility(View.INVISIBLE);
//
//        holder.iv_line3.setVisibility(View.INVISIBLE);
//        holder.iv_line4.setVisibility(View.INVISIBLE);
//        holder.iv_line5.setVisibility(View.INVISIBLE);
//        holder.iv_line6.setVisibility(View.INVISIBLE);
//
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv1.setText("测试");
//            holder.srb_1.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv2.setText("测试");
//            holder.srb_2.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        }else if("LW".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.baoxiang);
//            holder.srb_2.setVisibility(View.GONE);
//            holder.tv2.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv3.setText("测试");
//            holder.srb_3.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(2).getType())){
//            holder.tv3.setText(dataList.get(position).get(2).getLesson());
//            holder.iv3.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.baoxiang);
//            holder.srb_3.setVisibility(View.GONE);
//            holder.tv3.setText("");
//        }
//
//
//    } else if (dataList.get(position).size() % 6 == 4) {
//
//        holder.tv5.setVisibility(View.INVISIBLE);
//        holder.iv5.setVisibility(View.INVISIBLE);
//        holder.tv6.setVisibility(View.INVISIBLE);
//        holder.iv6.setVisibility(View.INVISIBLE);
//
//
//        holder.srb_5.setVisibility(View.INVISIBLE);
//        holder.srb_6.setVisibility(View.INVISIBLE);
//        holder.iv_line4.setVisibility(View.INVISIBLE);
//        holder.iv_line5.setVisibility(View.INVISIBLE);
//        holder.iv_line6.setVisibility(View.INVISIBLE);
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv1.setText("测试");
//            holder.srb_1.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv2.setText("测试");
//            holder.srb_2.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        }else if("LW".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.baoxiang);
//            holder.srb_2.setVisibility(View.GONE);
//            holder.tv2.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv3.setText("测试");
//            holder.srb_3.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(2).getType())){
//            holder.tv3.setText(dataList.get(position).get(2).getLesson());
//            holder.iv3.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.baoxiang);
//            holder.srb_3.setVisibility(View.GONE);
//            holder.tv3.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv4.setText("测试");
//            holder.srb_4.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(3).getType())){
//            holder.tv4.setText(dataList.get(position).get(3).getLesson());
//            holder.iv4.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.baoxiang);
//            holder.srb_4.setVisibility(View.GONE);
//            holder.tv4.setText("");
//        }
//
//    } else if (dataList.get(position).size() % 6 == 5) {
//
//        holder.tv6.setVisibility(View.INVISIBLE);
//        holder.iv6.setVisibility(View.INVISIBLE);
//        holder.srb_6.setVisibility(View.INVISIBLE);
//        holder.iv_line5.setVisibility(View.INVISIBLE);
//        holder.iv_line6.setVisibility(View.INVISIBLE);
//
//
//
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv1.setText("测试");
//            holder.srb_1.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv2.setText("测试");
//            holder.srb_2.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        }else if("LW".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.baoxiang);
//            holder.srb_2.setVisibility(View.GONE);
//            holder.tv2.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv3.setText("测试");
//            holder.srb_3.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(2).getType())){
//            holder.tv3.setText(dataList.get(position).get(2).getLesson());
//            holder.iv3.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.baoxiang);
//            holder.srb_3.setVisibility(View.GONE);
//            holder.tv3.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv4.setText("测试");
//            holder.srb_4.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(3).getType())){
//            holder.tv4.setText(dataList.get(position).get(3).getLesson());
//            holder.iv4.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.baoxiang);
//            holder.srb_4.setVisibility(View.GONE);
//            holder.tv4.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(4).getType())){
//            holder.iv5.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv5.setText("测试");
//            holder.srb_5.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(4).getType())){
//            holder.tv5.setText(dataList.get(position).get(4).getLesson());
//            holder.iv5.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(4).getType())){
//            holder.iv5.setImageResource(R.drawable.baoxiang);
//            holder.srb_5.setVisibility(View.GONE);
//            holder.tv5.setText("");
//
//        }
//
//
//    }else {
//        holder.tv1.setVisibility(View.VISIBLE);
//        holder.iv1.setVisibility(View.VISIBLE);
//        holder.tv2.setVisibility(View.VISIBLE);
//        holder.iv2.setVisibility(View.VISIBLE);
//        holder.tv3.setVisibility(View.VISIBLE);
//        holder.iv3.setVisibility(View.VISIBLE);
//        holder.tv4.setVisibility(View.VISIBLE);
//        holder.iv4.setVisibility(View.VISIBLE);
//        holder.tv5.setVisibility(View.VISIBLE);
//        holder.iv5.setVisibility(View.VISIBLE);
//        holder.tv6.setVisibility(View.VISIBLE);
//        holder.iv6.setVisibility(View.VISIBLE);
//
//        holder.iv_line1.setVisibility(View.VISIBLE);
//        holder.iv_line2.setVisibility(View.VISIBLE);
//        holder.iv_line3.setVisibility(View.VISIBLE);
//        holder.iv_line4.setVisibility(View.VISIBLE);
//        holder.iv_line5.setVisibility(View.VISIBLE);
//        holder.iv_line6.setVisibility(View.VISIBLE);
//        holder.srb_1.setVisibility(View.VISIBLE);
//        holder.srb_2.setVisibility(View.VISIBLE);
//        holder.srb_3.setVisibility(View.VISIBLE);
//        holder.srb_4.setVisibility(View.VISIBLE);
//        holder.srb_5.setVisibility(View.VISIBLE);
//        holder.srb_6.setVisibility(View.VISIBLE);
//        holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        holder.tv3.setText(dataList.get(position).get(2).getLesson());
//        holder.tv4.setText(dataList.get(position).get(3).getLesson());
//        holder.tv5.setText(dataList.get(position).get(4).getLesson());
//        holder.tv6.setText(dataList.get(position).get(5).getLesson());
//
//        if("CS".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv1.setText("测试");
//            holder.srb_1.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv1.setText(dataList.get(position).get(0).getLesson());
//        }else if("LW".equals(dataList.get(position).get(0).getType())){
//            holder.iv1.setImageResource(R.drawable.baoxiang);
//            holder.srb_1.setVisibility(View.GONE);
//            holder.tv1.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv2.setText("测试");
//            holder.srb_2.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//            holder.tv2.setText(dataList.get(position).get(1).getLesson());
//        }else if("LW".equals(dataList.get(position).get(1).getType())){
//            holder.iv2.setImageResource(R.drawable.baoxiang);
//            holder.srb_2.setVisibility(View.GONE);
//            holder.tv2.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv3.setText("测试");
//            holder.srb_3.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(2).getType())){
//            holder.tv3.setText(dataList.get(position).get(2).getLesson());
//            holder.iv3.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(2).getType())){
//            holder.iv3.setImageResource(R.drawable.baoxiang);
//            holder.srb_3.setVisibility(View.GONE);
//            holder.tv3.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv4.setText("测试");
//            holder.srb_4.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(3).getType())){
//            holder.tv4.setText(dataList.get(position).get(3).getLesson());
//            holder.iv4.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(3).getType())){
//            holder.iv4.setImageResource(R.drawable.baoxiang);
//            holder.srb_4.setVisibility(View.GONE);
//            holder.tv4.setText("");
//        }
//
//        if("CS".equals(dataList.get(position).get(4).getType())){
//            holder.iv5.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.tv5.setText("测试");
//            holder.srb_5.setVisibility(View.GONE);
//        }else if("ZY".equals(dataList.get(position).get(4).getType())){
//            holder.tv5.setText(dataList.get(position).get(4).getLesson());
//            holder.iv5.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(4).getType())){
//            holder.iv5.setImageResource(R.drawable.baoxiang);
//            holder.srb_5.setVisibility(View.GONE);
//            holder.tv5.setText("");
//
//        }
//
//        if("CS".equals(dataList.get(position).get(5).getType())){
//            holder.iv6.setImageResource(R.drawable.icon_ceshixxhdpi);
//            holder.srb_6.setVisibility(View.GONE);
//            holder.tv6.setText("测试");
//        }else if("ZY".equals(dataList.get(position).get(5).getType())){
//            holder.tv6.setText(dataList.get(position).get(5).getLesson());
//            holder.iv6.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        }else if("LW".equals(dataList.get(position).get(5).getType())){
//            holder.iv6.setImageResource(R.drawable.baoxiang);
//            holder.srb_6.setVisibility(View.GONE);
//            holder.tv6.setText("");
//        }
//
//
//        holder.srb_1.setRating(TextUtils.isEmpty(dataList.get(position).get(0).getRank())?0f:Float.parseFloat(dataList.get(position).get(0).getRank()));
//        holder.srb_2.setRating(TextUtils.isEmpty(dataList.get(position).get(1).getRank())?0f:Float.parseFloat(dataList.get(position).get(1).getRank()));
//        holder.srb_3.setRating(TextUtils.isEmpty(dataList.get(position).get(2).getRank())?0f:Float.parseFloat(dataList.get(position).get(2).getRank()));
//        holder.srb_4.setRating(TextUtils.isEmpty(dataList.get(position).get(3).getRank())?0f:Float.parseFloat(dataList.get(position).get(3).getRank()));
//        holder.srb_5.setRating(TextUtils.isEmpty(dataList.get(position).get(4).getRank())?0f:Float.parseFloat(dataList.get(position).get(4).getRank()));
//        holder.srb_6.setRating(TextUtils.isEmpty(dataList.get(position).get(5).getRank())?0f:Float.parseFloat(dataList.get(position).get(5).getRank()));
//    }
//
//
//}else{


//    for(int i=0;i<dataList.get(position).size();i++){
//
//
//        if(i<dataList.get(position).size()){
//
//        }else{
//
//
//
//
//        }
//
//        if(dataList.get(position).size()==1){
//
//        }else if(dataList.get(position).size()==2){
//
//        }else if(dataList.get(position).size()==3){
//
//        }else if(dataList.get(position).size()==4){
//
//        }else if(dataList.get(position).size()==5){
//
//        }else {
//            if(dataList.get(position).get(i).getIsImpower()==0){
//                holder.ivs.get(i).setVisibility(View.VISIBLE);
//                holder.ivLines.get(i).setVisibility(View.VISIBLE);
//                holder.srbs.get(i).setVisibility(View.VISIBLE);
//                holder.tvs.get(i).setVisibility(View.VISIBLE);
//                holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
//                holder.srbs.get(i).setRating(TextUtils.isEmpty(dataList.get(position).get(i).getRank())?0f:Float.parseFloat(dataList.get(position).get(i).getRank()));
//                //无权限，都为暗色
//                if("CS".equals(dataList.get(position).get(i).getType())){
//                    holder.ivs.get(i).setImageResource(R.drawable.aoce);
//                    holder.tvs.get(i).setText("测试");
//                    holder.srbs.get(i).setVisibility(View.GONE);
//                }else if("ZY".equals(dataList.get(position).get(i).getType())){
//                    holder.ivs.get(i).setImageResource(R.drawable.aoce);
//                    holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
//                    holder.srbs.get(i).setVisibility(View.GONE);
//                }else if("LW".equals(dataList.get(position).get(i).getType())){
//                    holder.ivs.get(i).setImageResource(R.drawable.anbao);
//                    holder.tvs.get(i).setText("");
//                    holder.srbs.get(i).setVisibility(View.GONE);
//                }
//            }else{
//                //有权限
//                if(dataList.get(position).get(i).getIsLock()==0){
//                    //亮
//                    if(dataList.get(position).get(i).getIsEnd()==0){
//                        //做完，
//                        if("CS".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_ceshixxhdpi);
//                            holder.tvs.get(i).setText("测试");
//                            holder.srbs.get(i).setVisibility(View.VISIBLE);
//                        }else if("ZY".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//                            holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
//                            holder.srbs.get(i).setVisibility(View.VISIBLE);
//                        }else if("LW".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_geren_baogaoxxhdpi);
//                            holder.tvs.get(i).setText("");
//                            holder.srbs.get(i).setVisibility(View.VISIBLE);
//                        }
//                    }else{
//                        //未做完，未做，
//                        if("CS".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_ceshixxhdpi);
//                            holder.tvs.get(i).setText("测试");
//                            holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                        }else if("ZY".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//                            holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
//                            holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                        }else if("LW".equals(dataList.get(position).get(i).getType())){
//                            holder.ivs.get(i).setImageResource(R.drawable.icon_geren_baogaoxxhdpi);
//                            holder.tvs.get(i).setText("");
//                            holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                        }
//                    }
//                }else{
//                    //不亮
//                    if("CS".equals(dataList.get(position).get(i).getType())){
//                        holder.ivs.get(i).setImageResource(R.drawable.aoce);
//                        holder.tvs.get(i).setText("测试");
//                        holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                    }else if("ZY".equals(dataList.get(position).get(i).getType())){
//                        holder.ivs.get(i).setImageResource(R.drawable.aoce);
//                        holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
//                        holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                    }else if("LW".equals(dataList.get(position).get(i).getType())){
//                        holder.ivs.get(i).setImageResource(R.drawable.anbao);
//                        holder.tvs.get(i).setText("");
//                        holder.srbs.get(i).setVisibility(View.INVISIBLE);
//                    }
//                }
//            }
//        }
//
//    }


        for(int i=0;i<6;i++){

            holder.ivs.get(i).setVisibility(View.INVISIBLE);
            holder.ivLines.get(i).setVisibility(View.INVISIBLE);
            holder.srbs.get(i).setVisibility(View.INVISIBLE);
            holder.tvs.get(i).setVisibility(View.INVISIBLE);

            if(dataList.get(position).size()==1){
                if(i<1){
                    holder.ivs.get(i).setVisibility(View.VISIBLE);
                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                    holder.tvs.get(i).setVisibility(View.VISIBLE);
                }

            }else if(dataList.get(position).size()==2){
                if(i<1){
                    holder.ivLines.get(i).setVisibility(View.VISIBLE);
                }
                if(i<2){
                    holder.ivs.get(i).setVisibility(View.VISIBLE);

                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                    holder.tvs.get(i).setVisibility(View.VISIBLE);
                }

            }else if(dataList.get(position).size()==3){
                if(i<2){
                    holder.ivLines.get(i).setVisibility(View.VISIBLE);
                }
                if(i<3){
                    holder.ivs.get(i).setVisibility(View.VISIBLE);

                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                    holder.tvs.get(i).setVisibility(View.VISIBLE);
                }
            }else if(dataList.get(position).size()==4){
                if(i<3){
                    holder.ivLines.get(i).setVisibility(View.VISIBLE);
                }
                if(i<4){
                    holder.ivs.get(i).setVisibility(View.VISIBLE);

                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                    holder.tvs.get(i).setVisibility(View.VISIBLE);
                }
            }else if(dataList.get(position).size()==5){
                if(i<4){
                    holder.ivLines.get(i).setVisibility(View.VISIBLE);
                }
                if(i<5){
                    holder.ivs.get(i).setVisibility(View.VISIBLE);
                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                    holder.tvs.get(i).setVisibility(View.VISIBLE);
                }
            }else{
                holder.ivs.get(i).setVisibility(View.VISIBLE);
                holder.ivLines.get(i).setVisibility(View.VISIBLE);
                holder.srbs.get(i).setVisibility(View.VISIBLE);
                holder.tvs.get(i).setVisibility(View.VISIBLE);
            }
if(dataList.get(position).size()>i) {
    if (dataList.get(position).get(i).getIsImpower() == 0) {

        holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
        holder.srbs.get(i).setRating(TextUtils.isEmpty(dataList.get(position).get(i).getRank()) ? 0f : Float.parseFloat(dataList.get(position).get(i).getRank()));
        //无权限，都为暗色
        if ("CS".equals(dataList.get(position).get(i).getType())) {
            holder.ivs.get(i).setImageResource(R.drawable.aoce);
            holder.tvs.get(i).setText("测试");
            holder.srbs.get(i).setVisibility(View.GONE);
        } else if ("ZY".equals(dataList.get(position).get(i).getType())) {
            holder.ivs.get(i).setImageResource(R.drawable.aoce);
            holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
            holder.srbs.get(i).setVisibility(View.GONE);
        } else if ("LW".equals(dataList.get(position).get(i).getType())) {
            holder.ivs.get(i).setImageResource(R.drawable.anbao);
            holder.tvs.get(i).setText("");
            holder.srbs.get(i).setVisibility(View.GONE);
        }
    } else {
        //有权限
        if (dataList.get(position).get(i).getIsLock() == 0) {
            //亮
            if (dataList.get(position).get(i).getIsEnd() == 0) {
                //做完，
                if ("CS".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_ceshixxhdpi);
                    holder.tvs.get(i).setText("测试");
                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                } else if ("ZY".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
                    holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                } else if ("LW".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_geren_baogaoxxhdpi);
                    holder.tvs.get(i).setText("");
                    holder.srbs.get(i).setVisibility(View.VISIBLE);
                }
            } else {
                //未做完，未做，
                if ("CS".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_ceshixxhdpi);
                    holder.tvs.get(i).setText("测试");
                    holder.srbs.get(i).setVisibility(View.INVISIBLE);
                } else if ("ZY".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
                    holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
                    holder.srbs.get(i).setVisibility(View.INVISIBLE);
                } else if ("LW".equals(dataList.get(position).get(i).getType())) {
                    holder.ivs.get(i).setImageResource(R.drawable.icon_geren_baogaoxxhdpi);
                    holder.tvs.get(i).setText("");
                    holder.srbs.get(i).setVisibility(View.INVISIBLE);
                }
            }
        } else {
            //不亮
            if ("CS".equals(dataList.get(position).get(i).getType())) {
                holder.ivs.get(i).setImageResource(R.drawable.aoce);
                holder.tvs.get(i).setText("测试");
                holder.srbs.get(i).setVisibility(View.INVISIBLE);
            } else if ("ZY".equals(dataList.get(position).get(i).getType())) {
                holder.ivs.get(i).setImageResource(R.drawable.aoce);
                holder.tvs.get(i).setText(dataList.get(position).get(i).getLesson());
                holder.srbs.get(i).setVisibility(View.INVISIBLE);
            } else if ("LW".equals(dataList.get(position).get(i).getType())) {
                holder.ivs.get(i).setImageResource(R.drawable.anbao);
                holder.tvs.get(i).setText("");
                holder.srbs.get(i).setVisibility(View.INVISIBLE);
            }
        }

    }
}



  //  }









//    if("CS".equals(dataList.get(position).get(0).getType())){
//        holder.iv1.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.tv1.setText("测试");
//        holder.srb_1.setVisibility(View.GONE);
//    }else if("ZY".equals(dataList.get(position).get(0).getType())){
//        holder.iv1.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        holder.tv1.setText(dataList.get(position).get(0).getLesson());
//    }else if("LW".equals(dataList.get(position).get(0).getType())){
//        holder.iv1.setImageResource(R.drawable.baoxiang);
//        holder.srb_1.setVisibility(View.GONE);
//        holder.tv1.setText("");
//    }
//
//    if("CS".equals(dataList.get(position).get(1).getType())){
//        holder.iv2.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.tv2.setText("测试");
//        holder.srb_2.setVisibility(View.GONE);
//    }else if("ZY".equals(dataList.get(position).get(1).getType())){
//        holder.iv2.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//        holder.tv2.setText(dataList.get(position).get(1).getLesson());
//    }else if("LW".equals(dataList.get(position).get(1).getType())){
//        holder.iv2.setImageResource(R.drawable.baoxiang);
//        holder.srb_2.setVisibility(View.GONE);
//        holder.tv2.setText("");
//    }
//
//    if("CS".equals(dataList.get(position).get(2).getType())){
//        holder.iv3.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.tv3.setText("测试");
//        holder.srb_3.setVisibility(View.GONE);
//    }else if("ZY".equals(dataList.get(position).get(2).getType())){
//        holder.tv3.setText(dataList.get(position).get(2).getLesson());
//        holder.iv3.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//    }else if("LW".equals(dataList.get(position).get(2).getType())){
//        holder.iv3.setImageResource(R.drawable.baoxiang);
//        holder.srb_3.setVisibility(View.GONE);
//        holder.tv3.setText("");
//    }
//
//    if("CS".equals(dataList.get(position).get(3).getType())){
//        holder.iv4.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.tv4.setText("测试");
//        holder.srb_4.setVisibility(View.GONE);
//    }else if("ZY".equals(dataList.get(position).get(3).getType())){
//        holder.tv4.setText(dataList.get(position).get(3).getLesson());
//        holder.iv4.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//    }else if("LW".equals(dataList.get(position).get(3).getType())){
//        holder.iv4.setImageResource(R.drawable.baoxiang);
//        holder.srb_4.setVisibility(View.GONE);
//        holder.tv4.setText("");
//    }
//
//    if("CS".equals(dataList.get(position).get(4).getType())){
//        holder.iv5.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.tv5.setText("测试");
//        holder.srb_5.setVisibility(View.GONE);
//    }else if("ZY".equals(dataList.get(position).get(4).getType())){
//        holder.tv5.setText(dataList.get(position).get(4).getLesson());
//        holder.iv5.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//    }else if("LW".equals(dataList.get(position).get(4).getType())){
//        holder.iv5.setImageResource(R.drawable.baoxiang);
//        holder.srb_5.setVisibility(View.GONE);
//        holder.tv5.setText("");
//
//    }
//
//    if("CS".equals(dataList.get(position).get(5).getType())){
//        holder.iv6.setImageResource(R.drawable.icon_ceshixxhdpi);
//        holder.srb_6.setVisibility(View.GONE);
//        holder.tv6.setText("测试");
//    }else if("ZY".equals(dataList.get(position).get(5).getType())){
//        holder.tv6.setText(dataList.get(position).get(5).getLesson());
//        holder.iv6.setImageResource(R.drawable.icon_zuoye_yikaitongxxhdpi);
//    }else if("LW".equals(dataList.get(position).get(5).getType())){
//        holder.iv6.setImageResource(R.drawable.baoxiang);
//        holder.srb_6.setVisibility(View.GONE);
//     holder.tv6.setText("");
//    }

//


}





        if(position==dataList.size()-1){

            if (dataList.get(position).size() % 6 == 1) {

                holder.iv1.setTag(position);

                holder.iv1.setOnClickListener(this);


            } else if (dataList.get(position).size() % 6 == 2) {

                holder.iv1.setTag(position);
                holder.iv2.setTag(position);

                holder.iv1.setOnClickListener(this);
                holder.iv2.setOnClickListener(this);


            } else if (dataList.get(position).size() % 6 == 3) {
                holder.iv1.setTag(position);
                holder.iv2.setTag(position);
                holder.iv3.setTag(position);

                holder.iv1.setOnClickListener(this);
                holder.iv2.setOnClickListener(this);
                holder.iv3.setOnClickListener(this);


            } else if (dataList.get(position).size() % 6 == 4) {
                holder.iv1.setTag(position);
                holder.iv2.setTag(position);
                holder.iv3.setTag(position);
                holder.iv4.setTag(position);

                holder.iv1.setOnClickListener(this);
                holder.iv2.setOnClickListener(this);
                holder.iv3.setOnClickListener(this);
                holder.iv4.setOnClickListener(this);


            } else if (dataList.get(position).size() % 6 == 5) {

                holder.iv1.setTag(position);
                holder.iv2.setTag(position);
                holder.iv3.setTag(position);
                holder.iv4.setTag(position);
                holder.iv5.setTag(position);

                holder.iv1.setOnClickListener(this);
                holder.iv2.setOnClickListener(this);
                holder.iv3.setOnClickListener(this);
                holder.iv4.setOnClickListener(this);
                holder.iv5.setOnClickListener(this);



            }else{
                holder.iv1.setTag(position);
                holder.iv2.setTag(position);
                holder.iv3.setTag(position);
                holder.iv4.setTag(position);
                holder.iv5.setTag(position);
                holder.iv6.setTag(position);
                holder.iv1.setOnClickListener(this);
                holder.iv2.setOnClickListener(this);
                holder.iv3.setOnClickListener(this);
                holder.iv4.setOnClickListener(this);
                holder.iv5.setOnClickListener(this);
                holder.iv6.setOnClickListener(this);
            }


        }else{

            holder.iv1.setTag(position);
            holder.iv2.setTag(position);
            holder.iv3.setTag(position);
            holder.iv4.setTag(position);
            holder.iv5.setTag(position);
            holder.iv6.setTag(position);
            holder.iv1.setOnClickListener(this);
            holder.iv2.setOnClickListener(this);
            holder.iv3.setOnClickListener(this);
            holder.iv4.setOnClickListener(this);
            holder.iv5.setOnClickListener(this);
            holder.iv6.setOnClickListener(this);

        }



       // holder.tv.setText(dataList.get(position).getDesc());
       // holder.tv1.setText(dataList.get(position).getWho());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}