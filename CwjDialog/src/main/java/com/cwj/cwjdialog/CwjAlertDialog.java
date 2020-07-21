package com.cwj.cwjdialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 仿ios弹框，各种弹框
 * 作者：ChenWenJie
 * 邮箱：1181620038@qq.com
 */
public class CwjAlertDialog extends Dialog {


    public CwjAlertDialog(@NonNull Context context) {
        super(context);
    }

    public CwjAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CwjAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        CwjAlertDialog cwjAlertDialog;
        private Context context;
        private int dialogType = 0;//类型 0 默认 有标题，内容确认取消， 1,无标题，有内容确认取消，2，有标题有内容，只有一个按钮（默认确认按钮） 4，有标题，无内容，一个按钮
        //标题
        private String titleText = "设置标题";
        //标题大小 默认20
        private int titleSize = 16;
        //标题颜色 默认黑色
        private int titleColor = R.color.dialog_title_font_b_color;
        //内容
        private String contentText = "设置内容";
        //内容大小
        private int contentSize = 14;
        //内容颜色
        private int contentColor = R.color.dialog_title_font_b_color;
        //确认按钮字体大小
        private int yesSize = 18;
        //确认按钮颜色
        private int yesColor = R.color.blue;
        //确认按钮文字
        private String yesText = "确认";
        //确认按钮样式<flag name="normal" value="0" /> 默认
        //        <flag name="bold" value="1" /> 加粗
        //        <flag name="italic" value="2" /> 斜体
        //        <flag name="italic——bold" value="3" /> 斜体
        private int yesStyle = 0;
        //取消按钮颜色
        private int noColor = R.color.blue;
        //取消按钮文本
        private String noText = "取消";
        //取消按钮大小
        private int noSize = 18;
        //取消按钮样式 一般加粗
        private int noStyle = 0;
        //背景
        private int bgDrawable = R.drawable.dialog_bg_share_title_ios;
        //是否允许 点击窗体外取消，默认true  可以点击取消，
        private boolean isCanceled = true;
        //输入框的类型  参考系统设置  默认是文本。
        private int inputType = InputType.TYPE_CLASS_TEXT;
        /**
         * 设置窗体是否可以点击
         *
         * @param isCanceled
         * @return
         */

        private View.OnClickListener yesOnClickListener;//确定事件
        private View.OnClickListener noOnClickListener;//取消
        private MyEditTextChangeListener addTextChangedListener;//输入框传值

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setYesOnClickListener(View.OnClickListener yesOnClickListener) {
            this.yesOnClickListener = yesOnClickListener;
            return this;
        }

        public Builder setNoOnClickListener(View.OnClickListener noOnClickListener) {
            this.noOnClickListener = noOnClickListener;
            return this;
        }

        public Builder addTextChangedListener(MyEditTextChangeListener addTextChangedListener) {
            this.addTextChangedListener = addTextChangedListener;
            return this;
        }


        public Builder setDialogType(int dialogType) {
            this.dialogType = dialogType;
            return this;
        }

        public Builder setTitleText(String titleText) {
            this.titleText = titleText;
            return this;
        }
        public Builder setTitleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;

        }

        public Builder setInputType(int inputType) {
            this.inputType = inputType;
            return this;
        }

        public Builder isCanceled(boolean isCanceled) {
            this.isCanceled = isCanceled;
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;

        }

        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;

        }

        public Builder setContentSize(int contentSize) {
            this.contentSize = contentSize;
            return this;

        }

        public Builder setContentColor(int contentColor) {
            this.contentColor = contentColor;
            return this;

        }

        public Builder setYesSize(int yesSize) {
            this.yesSize = yesSize;
            return this;

        }

        public Builder setYesColor(int yesColor) {
            this.yesColor = yesColor;
            return this;
        }

        public Builder setYesText(String yesText) {
            this.yesText = yesText;
            return this;
        }

        /**
         * 设置样式
         *
         * @param yesStyle <flag name="bold" value="1" /> 加粗
         *                 //        <flag name="italic" value="2" /> 斜体
         *                 //        <flag name="italic——bold" value="3" /> 斜体
         * @return
         */
        public Builder setYesStyle(int yesStyle) {
            this.yesStyle = yesStyle;
            return this;

        }

        public Builder setNoColor(int noColor) {
            this.noColor = noColor;
            return this;

        }

        public Builder setNoText(String noText) {
            this.noText = noText;
            return this;

        }

        public Builder setNoSize(int noSize) {
            this.noSize = noSize;
            return this;

        }

        public Builder setNoStyle(int noStyle) {
            this.noStyle = noStyle;
            return this;

        }

        public Builder setBgDrawable(int bgDrawable) {
            this.bgDrawable = bgDrawable;
            return this;
        }

        public Builder dismissDialog() {

            cwjAlertDialog.dismiss();
            return this;
        }

        /**
         * 打开时放大
         */
        public void setScaleBig(View v) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(v, "scaleX", 0, 1, 1);
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(v, "scaleY", 0, 1, 1);
            //联合
            AnimatorSet animatorSet = new AnimatorSet();
            /**
             *              //after 先执行哪个
             *                 //before 后执行哪个
             *                 //with 同时执行
             */
            animatorSet.play(animator).with(animator1);
            animatorSet.setDuration(500);
            animatorSet.start();

        }

        /**
         * 关闭时 缩小
         *
         * @param v
         */
        public void setScaleSmall(View v) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(v, "scaleX", 1, 0.2f, 0);
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(v, "scaleY", 1, 0.2f, 0);
            //联合
            AnimatorSet animatorSet = new AnimatorSet();
            /**
             *              //after 先执行哪个
             *                 //before 后执行哪个
             *                 //with 同时执行
             */
            animatorSet.play(animator).with(animator1);
            animatorSet.setDuration(1000);
            animatorSet.start();

        }

        View layout;

        @SuppressLint("ResourceType")
        @RequiresApi(api = Build.VERSION_CODES.M)
        public CwjAlertDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cwjAlertDialog = new CwjAlertDialog(context, R.style.CwjTitleDialog);
            layout = inflater.inflate(R.layout.layout_title_dialog, null);
            cwjAlertDialog.addContentView(layout, new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //获取屏幕宽高
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            int height = wm.getDefaultDisplay().getHeight();

//            //设置宽高
            final WindowManager.LayoutParams params = cwjAlertDialog.getWindow().getAttributes();
            params.width = width - 200;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            cwjAlertDialog.getWindow().setAttributes(params);
            LinearLayout titleDialog = layout.findViewById(R.id.dialog_layout);
            TextView title_tv = layout.findViewById(R.id.title_tv);
            TextView content_tv = layout.findViewById(R.id.content_tv);
            TextView no_tv = layout.findViewById(R.id.no_tv);
            TextView yes_tv = layout.findViewById(R.id.yes_tv);
            View lin_v1 = layout.findViewById(R.id.lin_v1);
            EditText input_et = layout.findViewById(R.id.input_et);

            cwjAlertDialog.setContentView(layout);

            //给页面设置动画 进场动画
            setScaleBig(layout);

            titleDialog.setBackground(context.getResources().getDrawable(bgDrawable));
            //是否可以点击窗体外取消默认可以
            cwjAlertDialog.setCanceledOnTouchOutside(isCanceled);

            //     标题
            title_tv.setText(titleText);
//
            title_tv.setTextColor(context.getResources().getColor(titleColor));
            title_tv.setTextSize(titleSize);
            //      内容
            content_tv.setText(contentText);
            content_tv.setTextColor(context.getResources().getColor(contentColor));
            content_tv.setTextSize(contentSize);
            //      确认按钮
            yes_tv.setTextColor(context.getResources().getColor(yesColor));
            yes_tv.setTextSize(yesSize);
            yes_tv.setText(yesText);
            yes_tv.setTypeface(Typeface.defaultFromStyle(noStyle));
            yes_tv.setOnClickListener(yesOnClickListener);
            //      取消按钮
            no_tv.setTextColor(context.getResources().getColor(noColor));
            no_tv.setTextSize(noSize);
            no_tv.setText(noText);
            no_tv.setTypeface(Typeface.defaultFromStyle(noStyle));
            no_tv.setOnClickListener(noOnClickListener);
            //类型 0 默认 有标题，内容确认取消， 1,无标题，有内容确认取消，2，无标题有内容，只有一个按钮（默认确认按钮）3,有标题有内容 只有一个按钮
            if (dialogType == 1) {
                title_tv.setVisibility(View.GONE);
                input_et.setVisibility(View.GONE);
            } else if (dialogType == 2) {
                title_tv.setVisibility(View.GONE);
                no_tv.setVisibility(View.GONE);
                lin_v1.setVisibility(View.GONE);
                input_et.setVisibility(View.GONE);

            } else if (dialogType == 3) {
                no_tv.setVisibility(View.GONE);
                lin_v1.setVisibility(View.GONE);
                input_et.setVisibility(View.GONE);

            } else if (dialogType == 4) {
                no_tv.setVisibility(View.GONE);
                content_tv.setVisibility(View.GONE);
                input_et.setVisibility(View.GONE);

            } else if (dialogType == 5) {
                //5 显示对话框
                input_et.setVisibility(View.VISIBLE);
                input_et.setInputType(inputType);
                input_et.addTextChangedListener(addTextChangedListener);
                //赋值给 接口
            }
            return cwjAlertDialog;
        }

    }


}
