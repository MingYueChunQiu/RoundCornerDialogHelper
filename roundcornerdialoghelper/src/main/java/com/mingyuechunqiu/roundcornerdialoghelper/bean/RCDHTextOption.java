package com.mingyuechunqiu.roundcornerdialoghelper.bean;

import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.StyleRes;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/12/15
 *     desc   : 文本选项配置信息类
 *     version: 1.0
 * </pre>
 */
public class RCDHTextOption {

    private int gravity;//对齐方式
    private int topMargin;//上外边距
    private int bottomMargin;//下外边距
    private int leftMargin;//左外边距
    private int rightMargin;//右外边距
    private int margin;//外边距（其余外边距失效）
    private int topPadding;//上内边距
    private int bottomPadding;//下内边距
    private int leftPadding;//左内边距
    private int rightPadding;//右内边距
    private int padding;//内边距（其余内边距失效）
    private String text;//文本
    private int textColor;//文本颜色
    private int textSize;//文本大小
    private int textAppearanceResId;//文本样式资源ID（先设置样式，单独设置的颜色大小会覆盖掉样式中内容）

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(@Dimension int topMargin) {
        this.topMargin = topMargin;
    }

    public int getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(@Dimension int bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    public int getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(@Dimension int leftMargin) {
        this.leftMargin = leftMargin;
    }

    public int getRightMargin() {
        return rightMargin;
    }

    public void setRightMargin(@Dimension int rightMargin) {
        this.rightMargin = rightMargin;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(@Dimension int margin) {
        this.margin = margin;
    }

    public int getTopPadding() {
        return topPadding;
    }

    public void setTopPadding(@Dimension int topPadding) {
        this.topPadding = topPadding;
    }

    public int getBottomPadding() {
        return bottomPadding;
    }

    public void setBottomPadding(@Dimension int bottomPadding) {
        this.bottomPadding = bottomPadding;
    }

    public int getLeftPadding() {
        return leftPadding;
    }

    public void setLeftPadding(@Dimension int leftPadding) {
        this.leftPadding = leftPadding;
    }

    public int getRightPadding() {
        return rightPadding;
    }

    public void setRightPadding(@Dimension int rightPadding) {
        this.rightPadding = rightPadding;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(@Dimension int padding) {
        this.padding = padding;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(@Dimension int textSize) {
        this.textSize = textSize;
    }

    public int getTextAppearanceResId() {
        return textAppearanceResId;
    }

    public void setTextAppearanceResId(@StyleRes int textAppearanceResId) {
        this.textAppearanceResId = textAppearanceResId;
    }

    /**
     * 链式调用
     */
    public static class Builder {

        private RCDHTextOption mOption;

        public Builder() {
            mOption = new RCDHTextOption();
        }

        public RCDHTextOption build() {
            return mOption;
        }

        public int getGravity() {
            return mOption.gravity;
        }

        public Builder setGravity(int gravity) {
            mOption.gravity = gravity;
            return this;
        }

        public int getTopMargin() {
            return mOption.topMargin;
        }

        public Builder setTopMargin(@Dimension int topMargin) {
            mOption.topMargin = topMargin;
            return this;
        }

        public int getBottomMargin() {
            return mOption.bottomMargin;
        }

        public Builder setBottomMargin(@Dimension int bottomMargin) {
            mOption.bottomMargin = bottomMargin;
            return this;
        }

        public int getLeftMargin() {
            return mOption.leftMargin;
        }

        public Builder setLeftMargin(@Dimension int leftMargin) {
            mOption.leftMargin = leftMargin;
            return this;
        }

        public int getRightMargin() {
            return mOption.rightMargin;
        }

        public Builder setRightMargin(@Dimension int rightMargin) {
            mOption.rightMargin = rightMargin;
            return this;
        }

        public int getMargin() {
            return mOption.margin;
        }

        public Builder setMargin(@Dimension int margin) {
            mOption.margin = margin;
            return this;
        }

        public int getTopPadding() {
            return mOption.topPadding;
        }

        public Builder setTopPadding(@Dimension int topPadding) {
            mOption.topPadding = topPadding;
            return this;
        }

        public int getBottomPadding() {
            return mOption.bottomPadding;
        }

        public Builder setBottomPadding(@Dimension int bottomPadding) {
            mOption.bottomPadding = bottomPadding;
            return this;
        }

        public int getLeftPadding() {
            return mOption.leftPadding;
        }

        public Builder setLeftPadding(@Dimension int leftPadding) {
            mOption.leftPadding = leftPadding;
            return this;
        }

        public int getRightPadding() {
            return mOption.rightPadding;
        }

        public Builder setRightPadding(@Dimension int rightPadding) {
            mOption.rightPadding = rightPadding;
            return this;
        }

        public int getPadding() {
            return mOption.padding;
        }

        public Builder setPadding(@Dimension int padding) {
            mOption.padding = padding;
            return this;
        }

        public String getText() {
            return mOption.text;
        }

        public Builder setText(String text) {
            mOption.text = text;
            return this;
        }

        public int getTextColor() {
            return mOption.textColor;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            mOption.textColor = textColor;
            return this;
        }

        public int getTextSize() {
            return mOption.textSize;
        }

        public Builder setTextSize(@Dimension int textSize) {
            mOption.textSize = textSize;
            return this;
        }

        public int getTextAppearanceResId() {
            return mOption.textAppearanceResId;
        }

        public Builder setTextAppearanceResId(@StyleRes int textAppearanceResId) {
            mOption.textAppearanceResId = textAppearanceResId;
            return this;
        }
    }
}
