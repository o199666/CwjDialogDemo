package com.cwj.cwjdialog;

import android.text.Editable;
import android.text.TextWatcher;

public class MyEditTextChangeListener implements TextWatcher {
    /**
     * 编辑框的内容发生改变之前的回调方法
     */
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /**
     * 编辑框的内容正在发生改变时的回调方法 >>用户正在输入
     *      * 我们可以在这里实时地 通过搜索匹配用户的输入
     * @param s
     * @param start
     * @param before
     * @param count
     */


      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      /**
     * 编辑框的内容改变以后,用户没有继续输入时 的回调方法
     */
    @Override
    public void afterTextChanged(Editable s) {

    }
}
