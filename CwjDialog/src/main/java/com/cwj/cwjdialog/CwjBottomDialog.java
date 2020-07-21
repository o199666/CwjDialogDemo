package com.cwj.cwjdialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * author : ChenWenJie
 * email  : 1181620038@qq.com
 * date   : 2020/7/20
 * desc   : 底部弹出框
 */
public class CwjBottomDialog extends Dialog {
    public CwjBottomDialog(@NonNull Context context) {
        super(context);
    }

    public CwjBottomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CwjBottomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static class Builder {
        Context context;
        CwjBottomDialog dialog;
        List<String> arrayList;
        private int titleColor = R.color.blue;
        private int titleSize = 16;
        private String titleName = "默认标题";
        private int okColor = R.color.blue;
        private int okSize = 18;
        private String okName = "确定";

        private int itemColor = R.color.blue;
        private int itemSize = 16;

        public Builder setItemColor(int itemColor) {
            this.itemColor = itemColor;
            return this;
        }

        public Builder setItemSize(int itemSize) {
            this.itemSize = itemSize;
            return this;
        }

        public Builder setTitleName(String titleName) {
            this.titleName = titleName;
            return this;
        }

        public Builder setOkName(String okName) {
            this.okName = okName;
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setTitleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;
        }

        public Builder setOkColor(int okColor) {
            this.okColor = okColor;
            return this;
        }

        public Builder setOkSize(int okSize) {
            this.okSize = okSize;
            return this;
        }


        private BottomDialogAdapter.OnItemClickListener onItemClickListener;
        private View.OnClickListener okClickListener;

        public Builder(Context context, List<String> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        public Builder setOnItemClickListener(BottomDialogAdapter.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setOnClickListener(View.OnClickListener onClickListener) {
            this.okClickListener = onClickListener;
            return this;
        }

        public Builder dismissDialog() {
            dialog.dismiss();
            return this;
        }

        public CwjBottomDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            dialog = new CwjBottomDialog(context, R.style.ActionSheetDialogStyle);
            View layout = inflater.inflate(R.layout.layout_bottom_dialog, null);
            dialog.addContentView(layout, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //获取ID
            RecyclerView rlv = layout.findViewById(R.id.rlv);
            TextView ok_tv = layout.findViewById(R.id.ok_tv);
            TextView title_tv = layout.findViewById(R.id.title_tv);
            //获取屏幕宽高
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            int height = wm.getDefaultDisplay().getHeight();

            //设置宽高
            final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = width - 56;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(params);
            //获取当前Activity所在的窗体
            Window dialogWindow = dialog.getWindow();
            //设置Dialog从窗体底部弹出
            dialogWindow.setGravity(Gravity.BOTTOM);
            //获得窗体的属性 设置底部弹出的距离
            params.y = 20;
            //将属性设置给窗体
            dialogWindow.setAttributes(params);
            dialog.setContentView(layout);
            //设置适配器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            rlv.setLayoutManager(linearLayoutManager);
            rlv.setAdapter(new BottomDialogAdapter(arrayList, context, itemColor,itemSize,onItemClickListener));
            ok_tv.setOnClickListener(okClickListener);

            title_tv.setText(titleName);
            title_tv.setTextSize(titleSize);
            title_tv.setTextColor(context.getResources().getColor(titleColor));
            ok_tv.setText(okName);
            ok_tv.setTextSize(okSize);
            ok_tv.setTextColor(context.getResources().getColor(okColor));
            return dialog;
        }


    }


}
