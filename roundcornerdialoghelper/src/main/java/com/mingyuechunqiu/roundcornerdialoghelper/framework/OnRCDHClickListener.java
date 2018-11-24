package com.mingyuechunqiu.roundcornerdialoghelper.framework;

import android.support.v7.widget.AppCompatTextView;

import com.mingyuechunqiu.roundcornerdialoghelper.dialogFragment.RoundCornerDialogFragment;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/24
 *     desc   : 点击事件监听器
 *     version: 1.0
 * </pre>
 */
public interface OnRCDHClickListener {

    void onClickLeftButton(RoundCornerDialogFragment fragment, AppCompatTextView v);

    void onClickMiddleButton(RoundCornerDialogFragment fragment, AppCompatTextView v);

    void onClickRightButton(RoundCornerDialogFragment fragment, AppCompatTextView v);
}
