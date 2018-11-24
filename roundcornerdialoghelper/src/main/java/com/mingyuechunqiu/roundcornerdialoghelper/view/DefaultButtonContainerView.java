package com.mingyuechunqiu.roundcornerdialoghelper.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mingyuechunqiu.roundcornerdialoghelper.R;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/24
 *     desc   : 默认的按钮容器
 *              实现CustomButtonContainerable
 *     version: 1.0
 * </pre>
 */
public class DefaultButtonContainerView implements CustomButtonContainerViewable {

    private View vContainer;

    public DefaultButtonContainerView(Context context, ViewGroup container) {
        vContainer = LayoutInflater.from(context).inflate(
                R.layout.rcdh_layout_default_button_view_container, container, false);
    }

    @Override
    public View getContainer() {
        return vContainer;
    }

    @Override
    public AppCompatTextView getLeftButton() {
        return vContainer.findViewById(R.id.tv_rcdh_left_button);
    }

    @Override
    public AppCompatTextView getMiddleButton() {
        return vContainer.findViewById(R.id.tv_rcdh_middle_button);
    }

    @Override
    public AppCompatTextView getRightButton() {
        return vContainer.findViewById(R.id.tv_rcdh_right_button);
    }
}
