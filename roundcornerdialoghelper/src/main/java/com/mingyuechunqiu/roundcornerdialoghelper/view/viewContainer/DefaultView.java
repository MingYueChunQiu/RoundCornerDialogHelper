package com.mingyuechunqiu.roundcornerdialoghelper.view.viewContainer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingyuechunqiu.roundcornerdialoghelper.R;

/**
 * <pre>
 *     author : xyj
 *     Github : https://github.com/MingYueChunQiu
 *     e-mail : yujie.xi@ehailuo.com
 *     time   : 2018/11/27
 *     desc   : 默认view容器
 *              实现CustomViewable
 *     version: 1.0
 * </pre>
 */
public class DefaultView implements CustomViewable {

    private View vContainer;

    public DefaultView(Context context, ViewGroup container) {
        vContainer = LayoutInflater.from(context).inflate(
                R.layout.rcdh_layout_default_view_container, container, false);
    }

    @NonNull
    @Override
    public View getContainer() {
        return vContainer;
    }

    @Override
    public TextView getTitleView() {
        return vContainer.findViewById(R.id.tv_rcdh_title);
    }

    @Override
    public TextView getContentView() {
        return vContainer.findViewById(R.id.tv_rcdh_content);
    }
}
