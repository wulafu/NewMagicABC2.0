package com.baidai.baidaitravel.ui.comment.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidai.baidaitravel.R;
import com.baidai.baidaitravel.ui.base.adapter.BaseRecyclerAdapter;
import com.baidai.baidaitravel.ui.base.adapter.SimpleViewPagerAdapter;
import com.baidai.baidaitravel.ui.comment.activity.ReplyCommentActivity;
import com.baidai.baidaitravel.ui.comment.bean.CommentBean;
import com.baidai.baidaitravel.ui.comment.bean.CommentDetailBean;
import com.baidai.baidaitravel.ui.contact.utils.StringUtil;
import com.baidai.baidaitravel.ui.scenicspot.adapter.ScenicsPotListRVAdapter;
import com.baidai.baidaitravel.utils.BDTextUtils;
import com.baidai.baidaitravel.utils.Constant;
import com.baidai.baidaitravel.utils.DeviceUtils;
import com.baidai.baidaitravel.utils.InvokeStartActivityUtils;
import com.baidai.baidaitravel.utils.LogUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengbei on 2016/3/10.
 */
public class CommentAdapter extends BaseRecyclerAdapter<CommentBean>
    implements View.OnClickListener {
  private int mArticleId;
  /**
   * 分隔线宽度
   */
  int deviceWidth;
  /**
   * 单击监听
   */
  private ScenicsPotListRVAdapter.OnItemListener mOnItemClickListener = null;
  // 拼接回复详情
  StringBuilder sb;

  /**
   * 构造函数
   */
  public CommentAdapter(Context context, int articleId) {
    super(context);
    //此处初始化 防止空指针
    mArticleId = articleId;
    //deviceWidth = DeviceUtils.getScreenWidth(context);
    sb = new StringBuilder();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_comment_info_new, parent, false);
    view.setOnClickListener(this);
    CommentInfoViewHolder holder = new CommentInfoViewHolder(view);
    view.setTag(holder);
    return holder;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    List<CommentBean> beanList = getList();
    CommentBean bean = beanList.get(position);
    if (bean == null) return;
    CommentInfoViewHolder commentInfoViewHolder = (CommentInfoViewHolder) holder;
    if (!TextUtils.isEmpty(bean.getIcon())) {
      //HttpImageUtils.loadRoundingImg(commentInfoViewHolder.userIcon, bean.getIcon(), commentInfoViewHolder.userIcon.getContext(), HttpImageUtils.RoundRadius.ROUND_RADIUS_0, true, 40, 40);
      commentInfoViewHolder.userIcon.setImageURI(Uri.parse(bean.getIcon()));
    } else {
      commentInfoViewHolder.userIcon.setImageURI(Uri.EMPTY);
    }
    commentInfoViewHolder.userName.setText(bean.getNickName());
    commentInfoViewHolder.ratingBar.setRating(bean.getCommentLevel());
    commentInfoViewHolder.ratingBar.setRating(bean.getCommentLevel());
    commentInfoViewHolder.commentBrief.setText(bean.getContent());
    commentInfoViewHolder.commentTime.setText(bean.getCommentTime());
    commentInfoViewHolder.position = position;

    // 添加评论回复

    if (bean.getReplyCount() > 0) {
      if (bean.getReplyCount() < 100) {
        commentInfoViewHolder.replyView.setText(bean.getReplyCount() + " 回复");
      } else {
        commentInfoViewHolder.replyView.setText("99+回复");
      }
      if (bean.getReplyCount() > 3) {
        //commentInfoViewHolder.tvCommentMore.setVisibility(View.VISIBLE);
        commentInfoViewHolder.tvCommentMore.setText(
            String.format(mContext.getResources().getString(R.string.commentact_more_comment),
                bean.getReplyCount() + ""));//   查看更多回复
        //commentInfoViewHolder.tvCommentMoreLine.setVisibility(View.VISIBLE);
      } else {
        commentInfoViewHolder.tvCommentMore.setVisibility(View.GONE);
        commentInfoViewHolder.tvCommentMore.setVisibility(View.GONE);
        commentInfoViewHolder.tvCommentMoreLine.setVisibility(View.GONE);
      }
    } else {
      commentInfoViewHolder.replyView.setText("回复");
      commentInfoViewHolder.tvCommentMore.setVisibility(View.GONE);
      commentInfoViewHolder.tvCommentMoreLine.setVisibility(View.GONE);
    }
    addCommentView(commentInfoViewHolder, bean.getReplyList());
  }

  @Override public void onClick(View view) {
    if (view instanceof TextView) {
      Bundle bundle = new Bundle();
      int position = (int) view.getTag();
      bundle.putInt(Constant.REPLYCOMMENT_ACTIVITY_ARTICLE_KEY,
          getList().get(position).getArticleId());
      bundle.putInt(Constant.REPLYCOMMENT_ACTIVITY_COMMENT_ID_KEY,
          getList().get(position).getCommentId());
      bundle.putBoolean(Constant.REPLYCOMMENT_ACTIVITY_COMMENT_SHOWKEYBOARD, true);
      InvokeStartActivityUtils.startActivity(view.getContext(), ReplyCommentActivity.class, bundle,
          false);
    } else {
      if (mOnItemClickListener != null) {
        mOnItemClickListener.onItemClick(view, ((CommentInfoViewHolder) view.getTag()).position);
      }
    }
  }

  public void setmOnItemClickListener(ScenicsPotListRVAdapter.OnItemListener mOnItemClickListener) {
    this.mOnItemClickListener = mOnItemClickListener;
  }

  public class CommentInfoViewHolder extends RecyclerView.ViewHolder {
    private TextView tvCommentMoreLine;
    private TextView tvCommentMore;
    LinearLayout llReplyContent;
    /**
     * item的位置
     */
    int position;
    /**
     * 头像
     */
    SimpleDraweeView userIcon;
    /**
     * 昵称
     */
    TextView userName;
    /**
     * 评分
     */
    RatingBar ratingBar;
    /**
     * 描述
     */
    TextView commentBrief;
    /**
     * 提交时间
     */
    TextView commentTime;
    /**
     * 回复按钮
     */
    TextView replyView;

    public CommentInfoViewHolder(View itemView) {
      super(itemView);
      userIcon = (SimpleDraweeView) itemView.findViewById(R.id.iv_usericon);
      userName = (TextView) itemView.findViewById(R.id.tv_user_name);
      ratingBar = (RatingBar) itemView.findViewById(R.id.commetn_ratingBar_item);
      commentBrief = (TextView) itemView.findViewById(R.id.comment_brief);
      commentTime = (TextView) itemView.findViewById(R.id.tv_comment_time);
      replyView = (TextView) itemView.findViewById(R.id.tv_comment_reply);
      llReplyContent = (LinearLayout) itemView.findViewById(R.id.ll_reply_content);
      tvCommentMore = (TextView) itemView.findViewById(R.id.tv_comment_more);
      tvCommentMoreLine = (TextView) itemView.findViewById(R.id.tv_comment_more_line);
      //replyView.setOnClickListener(CommentAdapter.this);
    }
  }

  /**
   * 动态添加评论回复view
   */
  public void addCommentView(CommentInfoViewHolder vh,
      final ArrayList<CommentBean.replyList> replyLists) {
    vh.llReplyContent.removeAllViews();
    if (null != replyLists && replyLists.size() > 0) {
      vh.llReplyContent.setVisibility(View.VISIBLE);
      for (int i = 0; i < (replyLists.size() - 3 > 0 ? 3 : replyLists.size()); i++) {
        View itemView =
            LayoutInflater.from(mContext).inflate(R.layout.item_comment_reply_new, null, false);
        // 评论模块的标题
        TextView title = (TextView) itemView.findViewById(R.id.tv_user_name);
        title.setText(replyLists.get(i).getNickName());
        // 评论模块的头像
        SimpleDraweeView imageView = (SimpleDraweeView) itemView.findViewById(R.id.iv_usericon);
        if (!TextUtils.isEmpty(replyLists.get(i).getIcon())) {
          imageView.setImageURI(Uri.parse(replyLists.get(i).getIcon()));
        } else {
          imageView.setImageURI(Uri.EMPTY);
        }
        // 评论模块的内容
        TextView textViewBrief = (TextView) itemView.findViewById(R.id.comment_brief);

        // 拼接回复内容
        if (!TextUtils.isEmpty(replyLists.get(i).getReplayNickName())) {
          sb.append("回复");
          sb.append(replyLists.get(i).getReplayNickName());
          sb.append("：");
        }
        if (!TextUtils.isEmpty(replyLists.get(i).getReplyContent())) {
          sb.append(replyLists.get(i).getReplyContent());
        }
        //  设置  回复XXX：+内容
        BDTextUtils.setPartTextColor(textViewBrief, sb.toString(), 2,
            2 + replyLists.get(i).getReplayNickName().length(),
            mContext.getResources().getColor(R.color.rgbfc592a));
        //  隐藏回复按钮
        final int commentId = replyLists.get(i).getCommentId();
        final String replyId = String.valueOf(replyLists.get(i).getReplyId());
        final String replyNickName = String.valueOf(replyLists.get(i).getNickName());
        vh.llReplyContent.addView(itemView);
        sb.setLength(0);//   清除之前的数据
        //  点击评论条目 跳转到评论想请
        itemView.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            Bundle goToReply = new Bundle();
            goToReply.putInt(Constant.REPLYCOMMENT_ACTIVITY_ARTICLE_KEY, mArticleId);
            goToReply.putInt(Constant.REPLYCOMMENT_ACTIVITY_COMMENT_ID_KEY, commentId);
            goToReply.putBoolean(Constant.REPLYCOMMENT_ACTIVITY_COMMENT_SHOWKEYBOARD, true);
            goToReply.putString(Constant.REPLYCOMMENTREPLYID, replyId);
            goToReply.putString(Constant.REPLYCOMMENTREPLYNAME, replyNickName);
            InvokeStartActivityUtils.startActivity(mContext, ReplyCommentActivity.class, goToReply,
                false);
          }
        });
      }
    }
  }
}
