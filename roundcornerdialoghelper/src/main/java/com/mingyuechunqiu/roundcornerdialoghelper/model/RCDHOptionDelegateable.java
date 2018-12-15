package com.mingyuechunqiu.roundcornerdialoghelper.model;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.mingyuechunqiu.roundcornerdialoghelper.bean.RCDHTextOption;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/12/15
 *     desc   : 配置信息处理的代理类标准接口
 *     version: 1.0
 * </pre>
 */
public interface RCDHOptionDelegateable {

    void release();

    /**
     * 设置文本配置项
     *
     * @param v      文本控件
     * @param option 文本配置信息对象
     */
    void setTextOption(@NonNull TextView v, @NonNull RCDHTextOption option);

    /**
     * 设置标题背景颜色处理
     *
     * @param v 标题控件
     */
    void setTitleBgColor(@NonNull TextView v);

    /**
     * 设置内容背景颜色处理
     *
     * @param v 内容控件
     */
    void setContentBgColor(@NonNull TextView v);

    /**
     * 设置左边按钮背景颜色处理
     *
     * @param v 左边按钮控件
     */
    void setLeftButtonBgColor(@NonNull TextView v);

    /**
     * 设置中间按钮背景颜色处理
     *
     * @param v 中间按钮控件
     */
    void setMiddleButtonBgColor(@NonNull TextView v);

    /**
     * 设置右边按钮颜色处理
     *
     * @param v 右边按钮控件
     */
    void setRightButtonBgColor(@NonNull TextView v);

    /**
     * 检测是否没有按钮
     *
     * @return 如果没有按钮返回true，否则返回false
     */
    boolean checkIsButtonsEmpty();
}
