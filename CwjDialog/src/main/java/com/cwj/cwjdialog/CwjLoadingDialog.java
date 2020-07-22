package com.cwj.cwjdialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;


/**
 * 默认对话框 等待提示框。
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CwjLoadingDialog extends Dialog {

    public CwjLoadingDialog(@NonNull Context context) {
        super(context);
    }

    public CwjLoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CwjLoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    dialog.dismiss();
                }
            }
        };
        private Context context;
        //提示信息
        private String dialogMsg = "加载中。。。";
        //自定义图片 ，默认使用系统图
        private int dialogImage = DialogState.LOADING_BLACK; //默认 黒背景，白色框;
        private int dialogType = DialogState.PROCESS;//对话框类型
        /**
         * 选择提示框类型。 默认 加载中。 这里加这个标识 主要是方便控制不同图片的加载动画。;
         */
        //设置字体颜色，默认白色
        private int fontColor = R.color.dialog_font_color;
        //设置字体大小
        private int fontSize = 14;
        //图片颜色
        private int imagColor = 0;
        /**
         * 默认
         */
        private int bgDrawable = DialogState.BG_BLACK;////默认 黒背景，白色框
        //状态框是否需要抖动动画
        private boolean isAnim = false;
        //给状态框设置自定义动画,默认抖动
        //是否允许 点击窗体外取消，默认true  可以点击取消，
        private boolean isCanceled = true;
        /**
         * 设置自动关闭的时间
         */
        private int dismissTimes = 0;

        public Builder setDismissTimes(int dismissTimes) {
            this.dismissTimes = dismissTimes;
            return this;
        }

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置名字
         *
         * @param dialogMsg
         * @return
         */
        public Builder setDialogMsg(String dialogMsg) {

            this.dialogMsg = dialogMsg;
            return this;
        }

        public Builder isAnim(boolean isAnim) {

            this.isAnim = isAnim;
            return this;
        }

        /**
         * 修改图片颜色
         *
         * @param imagColor
         * @return
         */
        public Builder setDialogImageColor(int imagColor) {
            this.imagColor = imagColor;
            return this;
        }

        /**
         * 设置窗体是否可以点击
         *
         * @param isCanceled
         * @return
         */
        public Builder isCanceled(boolean isCanceled) {
            this.isCanceled = isCanceled;
            return this;
        }

        /**
         * 设置 是对框框还是状态框
         *
         * @param
         * @return
         */
        public Builder setDialogType(int dialogType) {

            this.dialogType = dialogType;

            return this;
        }

        /**
         * 设置图片
         *
         * @param dialogImage
         * @return
         */
        public Builder setDialogImage(int dialogImage) {

            this.dialogImage = dialogImage;

            return this;
        }


        /**
         * 设置字体颜色
         *
         * @param fontColor
         * @return
         */
        public Builder setDialogFontColor(int fontColor) {
            this.fontColor = fontColor;
            return this;
        }

        /**
         * 设置字体大小
         *
         * @param fontSize
         * @return
         */
        public Builder setDialogFontSize(int fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        /**
         * 设置背景
         *
         * @param bgDrawable
         * @return
         */
        public Builder setDialogBgImage(int bgDrawable) {
            this.bgDrawable = bgDrawable;
            return this;
        }

        /**
         * 左右抖动动画 对应错误 和警告
         */
        public int duration = 3000;

        public void setShake(View view) {
            Animation rotateAnimation = new RotateAnimation(0, 10, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setInterpolator(new CycleInterpolator(10));
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(duration);
            view.setAnimation(rotateAnimation);
            rotateAnimation.start();
        }

        /**
         * 旋转动画
         *
         * @param
         */

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * 抖动动画
         *
         * @param view
         */
        public void setRotation(View view) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0, 359);
            objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
            objectAnimator.setDuration(duration);
            objectAnimator.setInterpolator(new LinearInterpolator());
            objectAnimator.start();
        }

        /**
         * 修改颜色
         * @param colorId
         */
        public Drawable setSvgColor(Drawable imageId, int colorId) {
            Drawable wrappedDrawable = DrawableCompat.wrap(imageId);
            DrawableCompat.setTint(wrappedDrawable, colorId);
            return wrappedDrawable;
//            VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.ic_loading_b,null);
//                        return vectorDrawableCompat;

        }




        CwjLoadingDialog dialog;

        @RequiresApi(api = Build.VERSION_CODES.M)
        public CwjLoadingDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            dialog = new CwjLoadingDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.layout_def_loading, null);
            //添加页面到Dialog
            dialog.addContentView(layout, new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            TextView tvMsg = ((TextView) layout.findViewById(R.id.loading_tv));
            ImageView imageView = ((ImageView) layout.findViewById(R.id.loading_iv));
            LinearLayout dialog_layout = ((LinearLayout) layout.findViewById(R.id.dialog_layout));
            dialog.setContentView(layout);


            /**
             * 选择 黑色还是白色背景，
             */
            dialog_layout.setBackground(context.getResources().getDrawable(bgDrawable));

            imageView.setImageDrawable(context.getResources().getDrawable(dialogImage));
            //改变颜色 默认 0 如果不写就不改变。
            if (imagColor!=0){
                imageView.setColorFilter(context.getResources().getColor(imagColor));
            }
//            imageView.setImageDrawable(context.getResources().getDrawable(dialogImage));
            /**
             * 选择是 进度条还是状态栏
             */
            if (dialogType == DialogState.PROCESS) {
                setRotation(imageView);
            } else {
                //状态栏加动画
                if (isAnim == true) {
                    setShake(imageView);
                }
            }
            //默认 可以取消
            dialog.setCanceledOnTouchOutside(isCanceled);
            //设置文本信息
            tvMsg.setText(dialogMsg);
            //设置文字颜色
            tvMsg.setTextColor(context.getResources().getColor(fontColor));
            //设置文字大小
            tvMsg.setTextSize(fontSize);
            //不设置
            if (dismissTimes != 0) {
                Message message = Message.obtain();
                message.what = 1;
                handler.sendMessageDelayed(message, dismissTimes);
            }

            return dialog;
        }

        /**
         * 修改 SVG 颜色
         */


    }


}
