package com.mingyuechunqiu.roundcornerdialoghelper.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingyuechunqiu.roundcornerdialoghelper.bean.RCDHTextOption;
import com.mingyuechunqiu.roundcornerdialoghelper.bean.RoundCornerDialogHelperOption;
import com.mingyuechunqiu.roundcornerdialoghelper.util.ScreenUtils;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/12/15
 *     desc   : 默认的配置信息处理的代理类
 *     version: 1.0
 * </pre>
 */
public class RCDHOptionDelegate implements RCDHOptionDelegateable {

    private WeakReference<Context> mContextRef;
    private RoundCornerDialogHelperOption mOption;

    public RCDHOptionDelegate(@NonNull Context context, @NonNull RoundCornerDialogHelperOption option) {
        mContextRef = new WeakReference<>(context);
        mOption = option;
    }

    @Override
    public void release() {
        mContextRef = null;
        mOption = null;
    }

    /**
     * 设置文本配置项
     *
     * @param v      文本控件
     * @param option 文本配置信息对象
     */
    @Override
    public void setTextOption(@NonNull TextView v, @NonNull RCDHTextOption option) {
        if (mContextRef.get() == null) {
            return;
        }
        Resources resources = mContextRef.get().getResources();
        if (option.getGravity() != 0) {
            v.setGravity(option.getGravity());
        }
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            if (option.getMargin() > 0) {
                int margin = (int) ScreenUtils.getPxFromDp(resources, option.getMargin());
                ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).setMargins(margin, margin, margin, margin);
            } else if (option.getLeftMargin() > 0 || option.getTopMargin() > 0 ||
                    option.getRightMargin() > 0 || option.getBottomMargin() > 0) {
                int left = 0, top = 0, right = 0, bottom = 0;
                if (option.getLeftMargin() > 0) {
                    left = (int) ScreenUtils.getPxFromDp(resources, option.getLeftMargin());
                }
                if (option.getTopMargin() > 0) {
                    top = (int) ScreenUtils.getPxFromDp(resources, option.getTopMargin());
                }
                if (option.getRightMargin() > 0) {
                    right = (int) ScreenUtils.getPxFromDp(resources, option.getRightMargin());
                }
                if (option.getBottomMargin() > 0) {
                    bottom = (int) ScreenUtils.getPxFromDp(resources, option.getBottomMargin());
                }
                ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).setMargins(left, top, right, bottom);
            }
        }
        if (option.getPadding() > 0) {
            int padding = (int) ScreenUtils.getPxFromDp(resources, option.getPadding());
            v.setPadding(padding, padding, padding, padding);
        } else if (option.getLeftPadding() > 0 || option.getTopPadding() > 0 ||
                option.getRightPadding() > 0 || option.getBottomPadding() > 0) {
            int top = 0, bottom = 0, left = 0, right = 0;
            if (option.getLeftPadding() > 0) {
                left = (int) ScreenUtils.getPxFromDp(resources, option.getLeftPadding());
            }
            if (option.getTopPadding() > 0) {
                top = (int) ScreenUtils.getPxFromDp(resources, option.getTopPadding());
            }
            if (option.getRightPadding() > 0) {
                right = (int) ScreenUtils.getPxFromDp(resources, option.getRightPadding());
            }
            if (option.getBottomPadding() > 0) {
                bottom = (int) ScreenUtils.getPxFromDp(resources, option.getBottomPadding());
            }
            v.setPadding(left, top, right, bottom);
        }
        if (!TextUtils.isEmpty(option.getText())) {
            v.setText(option.getText());
        }
        if (option.getTextAppearanceResId() != 0) {
            v.setTextAppearance(mContextRef.get(), option.getTextAppearanceResId());
        }
        if (option.getTextColor() != 0) {
            v.setTextColor(option.getTextColor());
        }
        if (option.getTextSize() > 0) {
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, option.getTextSize());
        }
    }

    /**
     * 设置标题背景颜色处理
     *
     * @param v 标题控件
     */
    @Override
    public void setTitleBgColor(@NonNull TextView v) {
        //CornerRadius被设置过，则统一采用CornerRadius
        float leftTopRadius = getCornerRadius(mOption.getLeftTopCornerRadius());
        float rightTopRadius = getCornerRadius(mOption.getRightTopCornerRadius());
        float leftBottomRadius = 0, rightBottomRadius = 0;
        if (!mOption.isContentVisible() &&
                mOption.getOnRCDHClickLeftButtonListener() == null &&
                mOption.getOnRCDHClickMiddleButtonListener() == null &&
                mOption.getOnRCDHClickRightButtonListener() == null) {
            leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
            rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
        }
        float[] titleRadius = new float[]{leftTopRadius, leftTopRadius,
                rightTopRadius, rightTopRadius,
                rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        v.setBackground(getBgDrawable(mOption.getTitleBgColor(), titleRadius));
    }

    /**
     * 设置内容背景颜色处理
     *
     * @param v 内容控件
     */
    @Override
    public void setContentBgColor(@NonNull TextView v) {
        //CornerRadius被设置过，则统一采用CornerRadius
        float leftTopRadius = 0, rightTopRadius = 0, leftBottomRadius = 0, rightBottomRadius = 0;
        if (!mOption.isTitleVisible()) {
            leftTopRadius = getCornerRadius(mOption.getLeftTopCornerRadius());
            rightTopRadius = getCornerRadius(mOption.getRightTopCornerRadius());
        }
        if (mOption.getOnRCDHClickLeftButtonListener() == null &&
                mOption.getOnRCDHClickMiddleButtonListener() == null &&
                mOption.getOnRCDHClickRightButtonListener() == null) {
            leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
            rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
        }
        float[] contentRadius = new float[]{leftTopRadius, leftTopRadius,
                rightTopRadius, rightTopRadius,
                rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        v.setBackground(getBgDrawable(mOption.getContentBgColor(), contentRadius));
    }

    /**
     * 设置左边按钮背景颜色处理
     *
     * @param v 左边按钮控件
     */
    @Override
    public void setLeftButtonBgColor(@NonNull TextView v) {
        float leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
        float rightBottomRadius = 0;
        //CornerRadius被设置过，则统一采用CornerRadius
        if (mOption.getOnRCDHClickMiddleButtonListener() == null &&
                mOption.getOnRCDHClickRightButtonListener() == null) {
            rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
        }
        float[] leftRadius = new float[]{0, 0, 0, 0,
                rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        v.setBackground(getBgDrawable(mOption.getLeftButtonBgColor(), leftRadius));
    }

    /**
     * 设置中间按钮背景颜色处理
     *
     * @param v 中间按钮控件
     */
    @Override
    public void setMiddleButtonBgColor(@NonNull TextView v) {
        float leftBottomRadius = 0, rightBottomRadius = 0;
        if (mOption.getOnRCDHClickLeftButtonListener() == null) {
            leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
        }
        if (mOption.getOnRCDHClickRightButtonListener() == null) {
            rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
        }
        float[] middleRadius = new float[]{0, 0, 0, 0,
                rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        v.setBackground(getBgDrawable(mOption.getMiddleButtonBgColor(), middleRadius));
    }

    /**
     * 设置右边按钮颜色处理
     *
     * @param v 右边按钮控件
     */
    @Override
    public void setRightButtonBgColor(@NonNull TextView v) {
        float leftBottomRadius = 0;
        float rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
        if (mOption.getOnRCDHClickMiddleButtonListener() == null &&
                mOption.getOnRCDHClickLeftButtonListener() == null) {
            leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
        }
        float[] leftRadius = new float[]{0, 0, 0, 0,
                rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        v.setBackground(getBgDrawable(mOption.getRightButtonBgColor(), leftRadius));
    }

    /**
     * 检测是否没有按钮
     *
     * @return 如果没有按钮返回true，否则返回false
     */
    @Override
    public boolean checkIsButtonsEmpty() {
        return mOption == null ||
                (mOption.getOnRCDHClickLeftButtonListener() == null &&
                        mOption.getOnRCDHClickMiddleButtonListener() == null &&
                        mOption.getOnRCDHClickRightButtonListener() == null);
    }

    /**
     * 获取背景Drawable
     *
     * @param bgColor 背景颜色
     * @param radius  圆角半径数组
     * @return 返回生成的背景Drawable
     */
    private GradientDrawable getBgDrawable(int bgColor, float[] radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(bgColor);
        drawable.setCornerRadii(radius);
        return drawable;
    }

    /**
     * 获取判断后真实的圆角半径
     *
     * @param radius 指定要判断的圆角半径
     * @return 返回判断后实际的圆角半径
     */
    private float getCornerRadius(float radius) {
        if (mOption.getCornerRadius() > 0) {
            return ScreenUtils.getPxFromDp(mContextRef.get().getResources(), mOption.getCornerRadius());
        } else {
            return ScreenUtils.getPxFromDp(mContextRef.get().getResources(), radius);
        }
    }
}
