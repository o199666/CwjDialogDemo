# CwjDialogDemo
android 通用进度条，提示框，底部弹出框仿IOS


效果图：   [效果图地址](http://note.youdao.com/noteshare?id=f365a1a2ea7cdeac4be207086a1db1f4&sub=WEB979d812a15be206c4cf17970bdc806e1 "效果图地址点击查看。"). 

一，使用方法
  

##Kotlin---


```javascript
   //默认的
        open_btn.setOnClickListener {
            CwjLoadingDialog.Builder(this).setDialogMsg("默认请求中")
                .create().show()
        }
        //白色的
        close_btn.setOnClickListener {
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(DialogState.BG_WHITE)//设置背景类型 黑白
                .setDialogImage(DialogState.LOADING_WHITE)//图片跟着换
                .setDialogImageColor(R.color.colorPrimaryDark)//修改图片颜色
                .setDialogMsg("加载中")//设置提示信息
                .setDuration(2000)//设置旋转速度。值越大，转的越慢 默认3000
                .setDialogFontColor(R.color.dialog_font_b_color) //字颜色
                .setDialogFontSize(14) //字号
                .create()
            dalog.show()
        }
        success_btn.setOnClickListener {
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(DialogState.BG_WHITE)//设置背景类型 黑白
                .setDialogType(DialogState.RESULT)// 这个必填，结果状态框 默认是加载框 设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogMsg("加载中")//设置提示信息

                .setDialogImage(DialogState.SUCCEED)//设置对应的图片
                .isAnim(true) //是否设置动画，默认无。设置了就是抖动
                .setDialogFontColor(R.color.dialog_font_b_color)
                .create()
            dalog.show()
        }


        error_btn.setOnClickListener {
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(DialogState.BG_BLACK)//设置背景类型 黑白
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogImage(DialogState.ERROR)//设置对应的图片
                .setDialogMsg("请求失败！")//设置提示信息
                .setDialogFontColor(R.color.dialog_font_b_color)
                .isCanceled(true)//是否允许点击，窗口外取消，默认true 不可以点击可以设置flase
                .create()
            dalog.show()
        }

        waring_btn.setOnClickListener {
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(DialogState.BG_WHITE)//设置背景类型 黑白
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogImage(DialogState.WARING)//设置对应的图片
                .setDialogMsg("网络有误！")//设置提示信息
                .isAnim(true) //是否设置动画，默认无。设置了就是抖动
                .setDialogFontColor(R.color.dialog_font_b_color)
                .create()
            dalog.show()
        }
        time_btn.setOnClickListener {
            //默认什么都不设置
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogMsg("进度框会在两秒后关闭！")//设置提示信息
                .setDismissTimes(2000)
                .create()
            dalog.show()
        }
        time1_btn.setOnClickListener {
            //默认什么都不设置
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(DialogState.BG_WHITE)//设置背景类型 黑白
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogImage(DialogState.WARING)//设置对应的图片
                .setDialogMsg("状态框会在两秒后关闭！")//设置提示信息
                .isAnim(true) //是否设置动画，默认无。设置了就是抖动
                .setDialogFontColor(R.color.dialog_font_b_color)
                .setDismissTimes(2000)//设置关闭时间2000毫秒。默认不设置没有
                .create()
            dalog.show()
        }
        coustom_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            var dalog = CwjLoadingDialog.Builder(this)
                .setDialogBgImage(R.drawable.dialog_bg_share_custom)//设置背景类型 黑白 自己写的
                .setDialogImage(R.drawable.ic_loading_1)// 可以用自带的: ①:ic_loading_1 ②:ic_loading_2 ③:ic_loading_3  也可以自己找图片
                .setDialogImageColor(R.color.white)
                .setDuration(1000)
                .setDialogMsg("自定义进度1").create()
            dalog.show()

        }
        coustom3_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            CwjLoadingDialog.Builder(this)
                .setDialogBgImage(R.drawable.dialog_bg_share_custom)//设置背景类型 黑白 自己写的
                .setDialogImage(R.drawable.ic_loading_2)// 同上 自己找图片
                .setDialogImageColor(R.color.red)
                .setDialogMsg("自定义进度2").create().show()

        }
        coustom4_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            CwjLoadingDialog.Builder(this)
                .setDialogBgImage(R.drawable.dialog_bg_share_black)//①：dialog_bg_share_black ②：dialog_bg_share_white  设置背景类型 黑白 自己写的
                .setDialogImage(R.drawable.ic_loading_3)//  ①:ic_loading_1 ②:ic_loading_2 ③:ic_loading_3 自己找图片
                .setDialogImageColor(R.color.green)
                .setDialogMsg("自定义状态3").create().show()

        }
        coustom1_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            CwjLoadingDialog.Builder(this)
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载  RESULT:状态框:成功 失败 警告，
                .setDialogBgImage(R.drawable.dialog_bg_share_black)
                .setDialogImage(R.drawable.ic_succes_1)//
                .setDialogImageColor(R.color.blue)//
                .setDialogFontColor(R.color.blue)
                .setDialogMsg("自定义状态1").create().show()

        }
        coustom11_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            CwjLoadingDialog.Builder(this)
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogBgImage(R.drawable.dialog_bg_share_custom)//设置背景类型 黑白 自己写的
                .setDialogImage(R.drawable.ic_error_1)// 自己找图片
                .setDialogImageColor(R.color.red)
                .setDialogFontColor(R.color.red)
                .isAnim(true)//是否启用动画
                .setDuration(4000)
                .setDialogMsg("自定义状态2").create().show()

        }
        coustom12_btn.setOnClickListener {
            /**
             * 自定义一个，使用自己的素材 主要就是 背景 和 图片。
             */
            CwjLoadingDialog.Builder(this)
                .setDialogType(DialogState.RESULT)//设置对话框类型 PROCESS：加载框  RESULT:状态框
                .setDialogBgImage(R.drawable.dialog_bg_share_white)//设置背景类型 黑白 自己写的
                .setDialogImage(R.drawable.ic_waring_1)// 自己找图片
                .setDialogImageColor(R.color.yellow)// 自己找图片
                .setDialogFontColor(R.color.yellow)
                .isAnim(true)//是否启用动画
                .setDuration(1000)
                .setDialogMsg("自定义抖动状态3").create().show()
        }


        /**
         * 带有确定取消标题栏内容提示框
         *
         *类型 0 默认 有标题，内容确认取消， 1,无标题，有内容确认取消，2，无标题有内容，只有一个按钮（默认确认按钮）3,有标题有内容 只有一个按钮
         */
        /**
         * 默认全面的。
         */
        tip_btn.setOnClickListener {
            CwjAlertDialog.Builder(this).apply {
                this.setTitleText("需要重新启动")
                    .setTitleSize(16)//提示标题大小，不填 默认16
                    .setTitleColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color)//标题颜色 默认黒色
                    .setContentColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color) // 内容文字 不填 默认黒色
                    .setContentText("请重新启动iphone以应用改变") //提示内容
                    .setContentSize(14)   //内容大小 不填 默认14
                    .setDialogType(0)//弹框 类型，默认 0
                    .setYesStyle(1)//设置是否加粗
                    .setYesText("重新启动")// 默认 确认
                    .setNoText("以后")   // 默认取消
                    .setNoColor(R.color.red)//设置取消按钮的颜色
                    .setNoOnClickListener {

                        Toast.makeText(this@KotlinActivity, "取消了", Toast.LENGTH_SHORT).show()
                        this.dismissDialog()//关闭当前弹窗
                    }
                    .setYesColor(com.cwj.cwjdialog.R.color.blue)// 确定按钮的颜色 默认蓝色
                    .setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "确定", Toast.LENGTH_SHORT).show()

                    }
                    .setBgDrawable(com.cwj.cwjdialog.R.drawable.dialog_bg_share_title_ios)//弹窗的白色背景，不喜欢可以自己定义
                    .create()
                    .show()
            }


        }


        tip1_btn.setOnClickListener {
            //  无标题的弹窗，有
            CwjAlertDialog.Builder(this).apply {
                this.setTitleText("是否确认关闭当前的弹窗")
                    .setTitleSize(16)//提示标题大小，不填 默认16
                    .setTitleColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color)//标题颜色 默认黒色
                    .setContentColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color) // 内容文字 不填 默认黒色
                    .setContentText("如果您要关闭当前弹窗，就会取消当前就会取消当前操作哦操作哦！") //提示内容
                    .setContentSize(14)   //内容大小 不填 默认14
                    .setDialogType(1)//弹框 类型，默认 0
                    .setYesStyle(1)//设置是否加粗
                    .setYesText("确认")
                    .setNoColor(R.color.font_color_text)//设置取消按钮的颜色
                    .setNoOnClickListener {
                        Toast.makeText(this@KotlinActivity, "取消", Toast.LENGTH_SHORT).show()

                        this.dismissDialog()//关闭当前弹窗
                    }
                    .setYesColor(com.cwj.cwjdialog.R.color.blue)// 确定按钮的颜色 默认蓝色
                    .setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "确定", Toast.LENGTH_SHORT).show()


                    }
                    .setBgDrawable(com.cwj.cwjdialog.R.drawable.dialog_bg_share_title_ios)//弹窗的白色背景，不喜欢可以自己定义
                    .create()
                    .show()
            }
        }

        //  只有一个按钮

        tip2_btn.setOnClickListener {
            //这是用kotlin
            CwjAlertDialog.Builder(this).apply {
                this.setTitleText("是否确认关闭当前的弹窗")
                    .setTitleSize(16)//提示标题大小，不填 默认16
                    .setTitleColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color)//标题颜色 默认黒色
                    .setContentColor(com.cwj.cwjdialog.R.color.dialog_title_font_b_color) // 内容文字 不填 默认黒色
                    .setContentText("如果您要关闭当前弹窗，就会取消当前就会取消当前操作哦操作哦！") //提示内容
                    .setContentSize(14)   //内容大小 不填 默认14
                    .setDialogType(2)//弹框 类型，默认 0
                    .setYesStyle(1)//设置是否加粗
                    .setYesText("确认")
                    .setYesColor(com.cwj.cwjdialog.R.color.blue)// 确定按钮的颜色 默认蓝色
                    .setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "确定", Toast.LENGTH_SHORT).show()
                    }
                    .setBgDrawable(com.cwj.cwjdialog.R.drawable.dialog_bg_share_title_ios)//弹窗的白色背景，不喜欢可以自己定义
                    .create()
                    .show()
            }
        }
        //有内容无标题 一个按钮
        tip3_btn.setOnClickListener {
            //这是用kotlin
            CwjAlertDialog.Builder(this).apply {
                this.setDialogType(3)
                    .setNoOnClickListener {
                        Toast.makeText(this@KotlinActivity, "取消", Toast.LENGTH_SHORT).show()

                        this.dismissDialog()
                    }.setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "确定", Toast.LENGTH_SHORT).show()

                    }
                    .create()
                    .show()
            }

        }
        //    有标题  无内容 一个按钮
        tip4_btn.setOnClickListener {
            //这是用kotlin
            CwjAlertDialog.Builder(this).apply {
                this.setDialogType(4)
                    .setTitleText("现有新的IOS更新可用，请从iOS 12 bate 版进行更新")
                    .setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "关闭", Toast.LENGTH_SHORT).show()

                        this.dismissDialog()
                    }
                    .create()
                    .show()
            }

        }
        var msg: String = ""
        //带有输入框
        tip5_btn.setOnClickListener {
            //这是用kotlin
            CwjAlertDialog.Builder(this).apply {
                this.setDialogType(5)
                    .setTitleText("登录iCloud")
                    .setContentText("请输入“卡卡西”的Apple ID 密码。")
                    .setInputType(InputType.TYPE_CLASS_TEXT)//默认 系统 参考系统
                    .setYesOnClickListener {
                        Toast.makeText(this@KotlinActivity, "1当前输入的是:$msg", Toast.LENGTH_SHORT)
                            .show()

                    }
                    .addTextChangedListener(object : MyEditTextChangeListener() {
                        override fun afterTextChanged(s: Editable?) {
                            super.afterTextChanged(s)
                            msg = s.toString()
                        }
                    })
                    .create()
                    .show()
            }
        }

        /**
         * 底部弹框
         */
        tip6_btn.setOnClickListener {
            //准备数据
            val numbers = listOf("打开相机", "打开相册", "打开抖音")
            CwjBottomDialog.Builder(this, numbers)//传入 列表数据
                .setOkColor(R.color.red)// 底部确认按钮的颜色 默认蓝色
                .setOkName("取消")//文字 默认取消
                .setOkSize(18)//大小 默认18
                .setTitleName("请选择操作")//标题
                .setTitleSize(16)//默认16
                .setItemColor(R.color.blue)// 子item 的颜色 默认蓝色
                .setItemSize(18)//默认18
                .setTitleColor(R.color.font_color_text)//默认蓝色
                .apply {
                    //点击
                    this.setOnClickListener {
                        dismissDialog()
                    }
                    //item
                    this.setOnItemClickListener { _, position ->
                        when (position) {
                            0 -> Toast.makeText(this@KotlinActivity, "点击了第1条", Toast.LENGTH_SHORT)
                                .show()
                            1 -> Toast.makeText(this@KotlinActivity, "点击了第2条", Toast.LENGTH_SHORT)
                                .show()
                            2 -> Toast.makeText(this@KotlinActivity, "点击了第3条", Toast.LENGTH_SHORT)
                                .show()

                        }
                    }
                }
                .create().show()
        }
```
