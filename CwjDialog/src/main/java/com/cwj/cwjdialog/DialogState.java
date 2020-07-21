package com.cwj.cwjdialog;

/**
 * 状态栏状态标识
 */
public final class DialogState {
    /**
     * 进度框
     */
    public static final int PROCESS = 1;
    /**
     * 其他框，eg: 成功，失败，警告
     */
    public static final int RESULT = 2;

    /**
     * 图片类型 进度，成功，失败，警告。四种 默认是图片类型。 设置不同的给
     */
    public static final int LOADING_BLACK = R.drawable.ic_loading_w;
    public static final int LOADING_WHITE = R.drawable.ic_loading_b;




    /**
     * 状态框类型
     */

    public static final int SUCCEED =R.drawable.ic_success;
    public static final int ERROR =  R.drawable.ic_error;
    public static final int WARING = R.drawable.ic_waring;

    public static final int CUSTOM = 9;



    /**
     *  背景，选择 默认提供 1 2
     */
    public static final int BG_BLACK = R.drawable.dialog_bg_share_black;
    public static final int BG_WHITE = R.drawable.dialog_bg_share_white;

    public static final int BG_CUSTOM =9;


}
