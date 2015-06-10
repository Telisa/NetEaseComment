package com.bupt.telis.neteasecomment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Telis on 2015/6/9.
 */
public class ExtraView extends LinearLayout {
    public static final int PADDING = 5;
    private final Drawable drawable;
    private Context context;
    //    private View view;
    //    private TextView idTextView;
    //    private TextView countTextView;
    //    private TextView contentTextView;

    public ExtraView(Context context) {
        this(context, null);

    }

    public ExtraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOrientation(VERTICAL);
        drawable = context.getResources().getDrawable(R.drawable.biankuang);
    }

    public void setComments(List<BriefComment> comments) {
        //remove this method induces a bug.
        removeAllViews();
        for (int i = 0; i < comments.size(); i++) {
            addView(getView(comments.get(i), i, comments.size()));
        }
    }


    private View getView(BriefComment comment, int index, int count) {
        View view = LayoutInflater.from(context).inflate(R.layout.extra_comment, null);
        TextView idTextView = (TextView) view.findViewById(R.id.brief_id);
        TextView countTextView = (TextView) view.findViewById(R.id.brief_count);
        TextView contentTextView = (TextView) view.findViewById(R.id.brief_content);
        idTextView.setText(comment.getName());
        countTextView.setText(String.valueOf(index + 1));
        contentTextView.setText(comment.getContent());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = (count - index) * PADDING;
        params.setMargins(margin, 0, margin, 0);
        view.setLayoutParams(params);
        return view;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
/*
        在FloorView绘制子控件前先绘制层叠的背景图片
         */
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View view = getChildAt(i);
            int top = getChildAt(0).getTop() + (getChildCount() - i) * PADDING;
            drawable.setBounds(view.getLeft(), top, view.getRight(), view
                    .getBottom());
            drawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }
}