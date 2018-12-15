package com.mingyuechunqiu.roundcornerdialoghelper.view.buttonContainer;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

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

    @NonNull
    View getContainer();

    TextView getLeftButton();

    TextView getMiddleButton();

    TextView getRightButton();
}
