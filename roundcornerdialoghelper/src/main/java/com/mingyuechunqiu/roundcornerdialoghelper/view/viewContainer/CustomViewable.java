package com.mingyuechunqiu.roundcornerdialoghelper.view.viewContainer;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

/**
 * <pre>
 *     author : xyj
 *     Github : https://github.com/MingYueChunQiu
 *     e-mail : yujie.xi@ehailuo.com
 *     time   : 2018/11/27
 *     desc   : 所有自定义view容器的父接口
 *     version: 1.0
 * </pre>
 */
public interface CustomViewable {

    @NonNull
    View getContainer();

    AppCompatTextView getTitleView();

    AppCompatTextView getContentView();
}
