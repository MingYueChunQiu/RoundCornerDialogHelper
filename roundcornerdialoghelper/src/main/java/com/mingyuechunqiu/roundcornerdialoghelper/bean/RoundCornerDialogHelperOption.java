package com.mingyuechunqiu.roundcornerdialoghelper.bean;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickLeftButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickMiddleButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickRightButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.view.CustomButtonContainerViewable;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/24
 *     desc   : 所有配置项类
 *     version: 1.0
 * </pre>
 */
public class RoundCornerDialogHelperOption {

    private int leftTopCornerRadius;//左上圆角半径
    private int rightTopCornerRadius;//右上圆角半径
    private int leftBottomCornerRadius;//左下圆角半径
    private int rightBottomCornerRadius;//右下圆角半径\
    private int cornerRadius;//圆角半径
    private int bgColor;//背景颜色
    private Drawable bgDrawable;//背景图片
    private String titleText;//标题文本
    private int titleTextColor;//标题文本颜色
    private int titleTextSize;//标题文本大小
    private String contentText;//内容文本
    private int contentTextColor;//内容文本颜色
    private int contentTextSize;//内容文本大熊啊
    private String leftButtonText;//左边按钮文本
    private int leftButtonTextColor;//左边按钮文本颜色
    private int leftButtonTextSize;//左边按钮文本大小
    private String middleButtonText;//中间按钮文本
    private int middleButtonTextColor;//中间按钮文本颜色
    private int middleButtonTextSize;//中间按钮文本大小
    private String rightButtonText;//右边按钮文本
    private int rightButtonTextColor;//右边按钮文本颜色
    private int rightButtonTextSize;//右边按钮文本大小
    private boolean isTitleVisible;//标题是否可见
    private boolean isContentVisible;//内容是否可见
    private View customView;//自定义显示view
    private CustomButtonContainerViewable customButtonContainerView;//自定义按钮容器类
    //点击左边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickLeftButtonListener onRCDHClickLeftButtonListener;
    //点击中间按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickMiddleButtonListener onRCDHClickMiddleButtonListener;
    //点击右边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickRightButtonListener onRCDHClickRightButtonListener;

    public int getLeftTopCornerRadius() {
        return leftTopCornerRadius;
    }

    public void setLeftTopCornerRadius(int leftTopCornerRadius) {
        this.leftTopCornerRadius = leftTopCornerRadius;
    }

    public int getRightTopCornerRadius() {
        return rightTopCornerRadius;
    }

    public void setRightTopCornerRadius(int rightTopCornerRadius) {
        this.rightTopCornerRadius = rightTopCornerRadius;
    }

    public int getLeftBottomCornerRadius() {
        return leftBottomCornerRadius;
    }

    public void setLeftBottomCornerRadius(int leftBottomCornerRadius) {
        this.leftBottomCornerRadius = leftBottomCornerRadius;
    }

    public int getRightBottomCornerRadius() {
        return rightBottomCornerRadius;
    }

    public void setRightBottomCornerRadius(int rightBottomCornerRadius) {
        this.rightBottomCornerRadius = rightBottomCornerRadius;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public Drawable getBgDrawable() {
        return bgDrawable;
    }

    public void setBgDrawable(Drawable bgDrawable) {
        this.bgDrawable = bgDrawable;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public int getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public int getTitleTextSize() {
        return titleTextSize;
    }

    public void setTitleTextSize(int titleTextSize) {
        this.titleTextSize = titleTextSize;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public int getContentTextColor() {
        return contentTextColor;
    }

    public void setContentTextColor(int contentTextColor) {
        this.contentTextColor = contentTextColor;
    }

    public int getContentTextSize() {
        return contentTextSize;
    }

    public void setContentTextSize(int contentTextSize) {
        this.contentTextSize = contentTextSize;
    }

    public String getLeftButtonText() {
        return leftButtonText;
    }

    public void setLeftButtonText(String leftButtonText) {
        this.leftButtonText = leftButtonText;
    }

    public int getLeftButtonTextColor() {
        return leftButtonTextColor;
    }

    public void setLeftButtonTextColor(int leftButtonTextColor) {
        this.leftButtonTextColor = leftButtonTextColor;
    }

    public int getLeftButtonTextSize() {
        return leftButtonTextSize;
    }

    public void setLeftButtonTextSize(int leftButtonTextSize) {
        this.leftButtonTextSize = leftButtonTextSize;
    }

    public String getMiddleButtonText() {
        return middleButtonText;
    }

    public void setMiddleButtonText(String middleButtonText) {
        this.middleButtonText = middleButtonText;
    }

    public int getMiddleButtonTextColor() {
        return middleButtonTextColor;
    }

    public void setMiddleButtonTextColor(int middleButtonTextColor) {
        this.middleButtonTextColor = middleButtonTextColor;
    }

    public int getMiddleButtonTextSize() {
        return middleButtonTextSize;
    }

    public void setMiddleButtonTextSize(int middleButtonTextSize) {
        this.middleButtonTextSize = middleButtonTextSize;
    }

    public String getRightButtonText() {
        return rightButtonText;
    }

    public void setRightButtonText(String rightButtonText) {
        this.rightButtonText = rightButtonText;
    }

    public int getRightButtonTextColor() {
        return rightButtonTextColor;
    }

    public void setRightButtonTextColor(int rightButtonTextColor) {
        this.rightButtonTextColor = rightButtonTextColor;
    }

    public int getRightButtonTextSize() {
        return rightButtonTextSize;
    }

    public void setRightButtonTextSize(int rightButtonTextSize) {
        this.rightButtonTextSize = rightButtonTextSize;
    }

    public boolean isTitleVisible() {
        return isTitleVisible;
    }

    public void setTitleVisible(boolean titleVisible) {
        isTitleVisible = titleVisible;
    }

    public boolean isContentVisible() {
        return isContentVisible;
    }

    public void setContentVisible(boolean contentVisible) {
        isContentVisible = contentVisible;
    }

    public View getCustomView() {
        return customView;
    }

    public void setCustomView(View customView) {
        this.customView = customView;
    }

    public CustomButtonContainerViewable getCustomButtonContainerView() {
        return customButtonContainerView;
    }

    public void setCustomButtonContainerView(CustomButtonContainerViewable customButtonContainerView) {
        this.customButtonContainerView = customButtonContainerView;
    }

    public OnRCDHClickLeftButtonListener getOnRCDHClickLeftButtonListener() {
        return onRCDHClickLeftButtonListener;
    }

    public void setOnRCDHClickLeftButtonListener(OnRCDHClickLeftButtonListener onRCDHClickLeftButtonListener) {
        this.onRCDHClickLeftButtonListener = onRCDHClickLeftButtonListener;
    }

    public OnRCDHClickMiddleButtonListener getOnRCDHClickMiddleButtonListener() {
        return onRCDHClickMiddleButtonListener;
    }

    public void setOnRCDHClickMiddleButtonListener(OnRCDHClickMiddleButtonListener onRCDHClickMiddleButtonListener) {
        this.onRCDHClickMiddleButtonListener = onRCDHClickMiddleButtonListener;
    }

    public OnRCDHClickRightButtonListener getOnRCDHClickRightButtonListener() {
        return onRCDHClickRightButtonListener;
    }

    public void setOnRCDHClickRightButtonListener(OnRCDHClickRightButtonListener onRCDHClickRightButtonListener) {
        this.onRCDHClickRightButtonListener = onRCDHClickRightButtonListener;
    }

    /**
     * 链式调用
     */
    public static class Builder {

        private RoundCornerDialogHelperOption mOption;

        public Builder() {
            mOption = new RoundCornerDialogHelperOption();
        }

        public RoundCornerDialogHelperOption build() {
            return mOption;
        }

        public int getLeftTopCornerRadius() {
            return mOption.leftTopCornerRadius;
        }

        public Builder setLeftTopCornerRadius(int leftTopCornerRadius) {
            mOption.leftTopCornerRadius = leftTopCornerRadius;
            return this;
        }

        public int getRightTopCornerRadius() {
            return mOption.rightTopCornerRadius;
        }

        public Builder setRightTopCornerRadius(int rightTopCornerRadius) {
            mOption.rightTopCornerRadius = rightTopCornerRadius;
            return this;
        }

        public int getLeftBottomCornerRadius() {
            return mOption.leftBottomCornerRadius;
        }

        public Builder setLeftBottomCornerRadius(int leftBottomCornerRadius) {
            mOption.leftBottomCornerRadius = leftBottomCornerRadius;
            return this;
        }

        public int getRightBottomCornerRadius() {
            return mOption.rightBottomCornerRadius;
        }

        public Builder setRightBottomCornerRadius(int rightBottomCornerRadius) {
            mOption.rightBottomCornerRadius = rightBottomCornerRadius;
            return this;
        }

        public int getCornerRadius() {
            return mOption.cornerRadius;
        }

        public Builder setCornerRadius(int cornerRadius) {
            mOption.cornerRadius = cornerRadius;
            return this;
        }

        public int getBgColor() {
            return mOption.bgColor;
        }

        public Builder setBgColor(int bgColor) {
            mOption.bgColor = bgColor;
            return this;
        }

        public Drawable getBgDrawable() {
            return mOption.bgDrawable;
        }

        public Builder setBgDrawable(Drawable bgDrawable) {
            mOption.bgDrawable = bgDrawable;
            return this;
        }

        public String getTitleText() {
            return mOption.titleText;
        }

        public Builder setTitleText(String titleText) {
            mOption.titleText = titleText;
            return this;
        }

        public int getTitleTextColor() {
            return mOption.titleTextColor;
        }

        public Builder setTitleTextColor(int titleTextColor) {
            mOption.titleTextColor = titleTextColor;
            return this;
        }

        public int getTitleTextSize() {
            return mOption.titleTextSize;
        }

        public Builder setTitleTextSize(int titleTextSize) {
            mOption.titleTextSize = titleTextSize;
            return this;
        }

        public String getContentText() {
            return mOption.contentText;
        }

        public Builder setContentText(String contentText) {
            mOption.contentText = contentText;
            return this;
        }

        public int getContentTextColor() {
            return mOption.contentTextColor;
        }

        public Builder setContentTextColor(int contentTextColor) {
            mOption.contentTextColor = contentTextColor;
            return this;
        }

        public int getContentTextSize() {
            return mOption.contentTextSize;
        }

        public Builder setContentTextSize(int contentTextSize) {
            mOption.contentTextSize = contentTextSize;
            return this;
        }

        public String getLeftButtonText() {
            return mOption.leftButtonText;
        }

        public Builder setLeftButtonText(String leftButtonText) {
            mOption.leftButtonText = leftButtonText;
            return this;
        }

        public int getLeftButtonTextColor() {
            return mOption.leftButtonTextColor;
        }

        public Builder setLeftButtonTextColor(int leftButtonTextColor) {
            mOption.leftButtonTextColor = leftButtonTextColor;
            return this;
        }

        public int getLeftButtonTextSize() {
            return mOption.leftButtonTextSize;
        }

        public Builder setLeftButtonTextSize(int leftButtonTextSize) {
            mOption.leftButtonTextSize = leftButtonTextSize;
            return this;
        }

        public String getMiddleButtonText() {
            return mOption.middleButtonText;
        }

        public Builder setMiddleButtonText(String middleButtonText) {
            mOption.middleButtonText = middleButtonText;
            return this;
        }

        public int getMiddleButtonTextColor() {
            return mOption.middleButtonTextColor;
        }

        public Builder setMiddleButtonTextColor(int middleButtonTextColor) {
            mOption.middleButtonTextColor = middleButtonTextColor;
            return this;
        }

        public int getMiddleButtonTextSize() {
            return mOption.middleButtonTextSize;
        }

        public Builder setMiddleButtonTextSize(int middleButtonTextSize) {
            mOption.middleButtonTextSize = middleButtonTextSize;
            return this;
        }

        public String getRightButtonText() {
            return mOption.rightButtonText;
        }

        public Builder setRightButtonText(String rightButtonText) {
            mOption.rightButtonText = rightButtonText;
            return this;
        }

        public int getRightButtonTextColor() {
            return mOption.rightButtonTextColor;
        }

        public Builder setRightButtonTextColor(int rightButtonTextColor) {
            mOption.rightButtonTextColor = rightButtonTextColor;
            return this;
        }

        public int getRightButtonTextSize() {
            return mOption.rightButtonTextSize;
        }

        public Builder setRightButtonTextSize(int rightButtonTextSize) {
            mOption.rightButtonTextSize = rightButtonTextSize;
            return this;
        }

        public boolean isTitleVisible() {
            return mOption.isTitleVisible;
        }

        public Builder setTitleVisible(boolean titleVisible) {
            mOption.isTitleVisible = titleVisible;
            return this;
        }

        public boolean isContentVisible() {
            return mOption.isContentVisible;
        }

        public Builder setContentVisible(boolean contentVisible) {
            mOption.isContentVisible = contentVisible;
            return this;
        }

        public View getCustomView() {
            return mOption.customView;
        }

        public Builder setCustomView(View customView) {
            mOption.customView = customView;
            return this;
        }

        public CustomButtonContainerViewable getCustomButtonContainerView() {
            return mOption.customButtonContainerView;
        }

        public Builder setCustomButtonContainerView(CustomButtonContainerViewable customButtonContainerView) {
            mOption.customButtonContainerView = customButtonContainerView;
            return this;
        }

        public OnRCDHClickLeftButtonListener getOnRCDHClickLeftButtonListener() {
            return mOption.onRCDHClickLeftButtonListener;
        }

        public Builder setOnRCDHClickLeftButtonListener(OnRCDHClickLeftButtonListener onRCDHClickLeftButtonListener) {
            mOption.onRCDHClickLeftButtonListener = onRCDHClickLeftButtonListener;
            return this;
        }

        public OnRCDHClickMiddleButtonListener getOnRCDHClickMiddleButtonListener() {
            return mOption.onRCDHClickMiddleButtonListener;
        }

        public Builder setOnRCDHClickMiddleButtonListener(OnRCDHClickMiddleButtonListener onRCDHClickMiddleButtonListener) {
            mOption.onRCDHClickMiddleButtonListener = onRCDHClickMiddleButtonListener;
            return this;
        }

        public OnRCDHClickRightButtonListener getOnRCDHClickRightButtonListener() {
            return mOption.onRCDHClickRightButtonListener;
        }

        public Builder setOnRCDHClickRightButtonListener(OnRCDHClickRightButtonListener onRCDHClickRightButtonListener) {
            mOption.onRCDHClickRightButtonListener = onRCDHClickRightButtonListener;
            return this;
        }
    }
}
