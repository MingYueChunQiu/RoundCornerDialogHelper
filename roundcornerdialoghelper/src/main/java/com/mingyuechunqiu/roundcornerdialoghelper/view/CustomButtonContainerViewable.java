package com.mingyuechunqiu.roundcornerdialoghelper.view;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/24
 *     desc   : 所有自定义Button容器类的父接口
 *     version: 1.0
 * </pre>
 */
public interface CustomButtonContainerViewable {

    View getContainer();

    AppCompatTextView getLeftButton();

    AppCompatTextView getMiddleButton();

    AppCompatTextView getRightButton();
}
