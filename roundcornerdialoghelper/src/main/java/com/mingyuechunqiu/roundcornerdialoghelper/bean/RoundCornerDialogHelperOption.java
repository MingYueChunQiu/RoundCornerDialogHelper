package com.mingyuechunqiu.roundcornerdialoghelper.bean;

import android.graphics.drawable.Drawable;

import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickLeftButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickMiddleButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickRightButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.view.buttonContainer.CustomButtonContainerViewable;
import com.mingyuechunqiu.roundcornerdialoghelper.view.viewContainer.CustomViewable;

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

    private float leftTopCornerRadius;//左上圆角半径
    private float rightTopCornerRadius;//右上圆角半径
    private float leftBottomCornerRadius;//左下圆角半径
    private float rightBottomCornerRadius;//右下圆角半径
    private float cornerRadius;//圆角半径
    private int bgColor;//背景颜色
    private Drawable bgDrawable;//背景图片
    private String titleText;//标题文本
    private int titleTextColor;//标题文本颜色
    private int titleTextSize;//标题文本大小
    private int titlePadding;//标题内边距
    private int titleTextAppearance;//标题文本样式（设置后颜色、大小属性将无效）
    private int titleBgColor;//标题背景颜色
    private int titleGravity;//标题对齐方式
    private String contentText;//内容文本
    private int contentTextColor;//内容文本颜色
    private int contentTextSize;//内容文本大熊啊
    private int contentPadding;//内容内边距
    private int contentTextAppearance;//内容文本样式（设置后颜色、大小属性将无效）
    private int contentBgColor;//内容背景颜色
    private int contentGravity;//内容文本对齐方式
    private String leftButtonText;//左边按钮文本
    private int leftButtonTextColor;//左边按钮文本颜色
    private int leftButtonTextSize;//左边按钮文本大小
    private int leftButtonPadding;//左边按钮内边距
    private int leftButtonTextAppearance;//左边按钮文本样式（设置后颜色、大小属性将无效）
    private int leftButtonBgColor;//左边按钮背景颜色
    private int leftButtonGravity;//左边按钮对齐方式
    private String middleButtonText;//中间按钮文本
    private int middleButtonTextColor;//中间按钮文本颜色
    private int middleButtonTextSize;//中间按钮文本大小
    private int middleButtonPadding;//中间按钮内边距
    private int middleButtonTextAppearance;//中间按钮文本样式（设置后颜色、大小属性将无效）
    private int middleButtonBgColor;//中间按钮背景颜色
    private int middleButtonGravity;//中间按钮对齐方式
    private String rightButtonText;//右边按钮文本
    private int rightButtonTextColor;//右边按钮文本颜色
    private int rightButtonTextSize;//右边按钮文本大小
    private int rightButtonPadding;//右边按钮内边距
    private int rightButtonTextAppearance;//右边按钮文本样式（设置后颜色、大小属性将无效）
    private int rightButtonBgColor;//右边按钮背景颜色
    private int rightButtonGravity;//右边按钮对齐方式
    private boolean isTitleVisible = true;//标题是否可见
    private boolean isContentVisible = true;//内容是否可见
    private CustomViewable customViewable;//自定义显示view
    private CustomButtonContainerViewable customButtonContainerView;//自定义按钮容器类
    //点击左边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickLeftButtonListener onRCDHClickLeftButtonListener;
    //点击中间按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickMiddleButtonListener onRCDHClickMiddleButtonListener;
    //点击右边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickRightButtonListener onRCDHClickRightButtonListener;

    public float getLeftTopCornerRadius() {
        return leftTopCornerRadius;
    }

    public void setLeftTopCornerRadius(float leftTopCornerRadius) {
        this.leftTopCornerRadius = leftTopCornerRadius;
    }

    public float getRightTopCornerRadius() {
        return rightTopCornerRadius;
    }

    public void setRightTopCornerRadius(float rightTopCornerRadius) {
        this.rightTopCornerRadius = rightTopCornerRadius;
    }

    public float getLeftBottomCornerRadius() {
        return leftBottomCornerRadius;
    }

    public void setLeftBottomCornerRadius(float leftBottomCornerRadius) {
        this.leftBottomCornerRadius = leftBottomCornerRadius;
    }

    public float getRightBottomCornerRadius() {
        return rightBottomCornerRadius;
    }

    public void setRightBottomCornerRadius(float rightBottomCornerRadius) {
        this.rightBottomCornerRadius = rightBottomCornerRadius;
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
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

    public int getTitlePadding() {
        return titlePadding;
    }

    public void setTitlePadding(int titlePadding) {
        this.titlePadding = titlePadding;
    }

    public int getTitleTextAppearance() {
        return titleTextAppearance;
    }

    public void setTitleTextAppearance(int titleTextAppearance) {
        this.titleTextAppearance = titleTextAppearance;
    }

    public int getTitleBgColor() {
        return titleBgColor;
    }

    public void setTitleBgColor(int titleBgColor) {
        this.titleBgColor = titleBgColor;
    }

    public int getTitleGravity() {
        return titleGravity;
    }

    public void setTitleGravity(int titleGravity) {
        this.titleGravity = titleGravity;
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

    public int getContentPadding() {
        return contentPadding;
    }

    public void setContentPadding(int contentPadding) {
        this.contentPadding = contentPadding;
    }

    public int getContentTextAppearance() {
        return contentTextAppearance;
    }

    public void setContentTextAppearance(int contentTextAppearance) {
        this.contentTextAppearance = contentTextAppearance;
    }

    public int getContentBgColor() {
        return contentBgColor;
    }

    public void setContentBgColor(int contentBgColor) {
        this.contentBgColor = contentBgColor;
    }

    public int getContentGravity() {
        return contentGravity;
    }

    public void setContentGravity(int contentGravity) {
        this.contentGravity = contentGravity;
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

    public int getLeftButtonPadding() {
        return leftButtonPadding;
    }

    public void setLeftButtonPadding(int leftButtonPadding) {
        this.leftButtonPadding = leftButtonPadding;
    }

    public int getLeftButtonTextAppearance() {
        return leftButtonTextAppearance;
    }

    public void setLeftButtonTextAppearance(int leftButtonTextAppearance) {
        this.leftButtonTextAppearance = leftButtonTextAppearance;
    }

    public int getLeftButtonBgColor() {
        return leftButtonBgColor;
    }

    public void setLeftButtonBgColor(int leftButtonBgColor) {
        this.leftButtonBgColor = leftButtonBgColor;
    }

    public int getLeftButtonGravity() {
        return leftButtonGravity;
    }

    public void setLeftButtonGravity(int leftButtonGravity) {
        this.leftButtonGravity = leftButtonGravity;
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

    public int getMiddleButtonPadding() {
        return middleButtonPadding;
    }

    public void setMiddleButtonPadding(int middleButtonPadding) {
        this.middleButtonPadding = middleButtonPadding;
    }

    public int getMiddleButtonTextAppearance() {
        return middleButtonTextAppearance;
    }

    public void setMiddleButtonTextAppearance(int middleButtonTextAppearance) {
        this.middleButtonTextAppearance = middleButtonTextAppearance;
    }

    public int getMiddleButtonBgColor() {
        return middleButtonBgColor;
    }

    public void setMiddleButtonBgColor(int middleButtonBgColor) {
        this.middleButtonBgColor = middleButtonBgColor;
    }

    public int getMiddleButtonGravity() {
        return middleButtonGravity;
    }

    public void setMiddleButtonGravity(int middleButtonGravity) {
        this.middleButtonGravity = middleButtonGravity;
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

    public int getRightButtonPadding() {
        return rightButtonPadding;
    }

    public void setRightButtonPadding(int rightButtonPadding) {
        this.rightButtonPadding = rightButtonPadding;
    }

    public int getRightButtonTextAppearance() {
        return rightButtonTextAppearance;
    }

    public void setRightButtonTextAppearance(int rightButtonTextAppearance) {
        this.rightButtonTextAppearance = rightButtonTextAppearance;
    }

    public int getRightButtonBgColor() {
        return rightButtonBgColor;
    }

    public void setRightButtonBgColor(int rightButtonBgColor) {
        this.rightButtonBgColor = rightButtonBgColor;
    }

    public int getRightButtonGravity() {
        return rightButtonGravity;
    }

    public void setRightButtonGravity(int rightButtonGravity) {
        this.rightButtonGravity = rightButtonGravity;
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

    public CustomViewable getCustomViewable() {
        return customViewable;
    }

    public void setCustomViewable(CustomViewable customViewable) {
        this.customViewable = customViewable;
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

        public float getLeftTopCornerRadius() {
            return mOption.leftTopCornerRadius;
        }

        public Builder setLeftTopCornerRadius(float leftTopCornerRadius) {
            mOption.leftTopCornerRadius = leftTopCornerRadius;
            return this;
        }

        public float getRightTopCornerRadius() {
            return mOption.rightTopCornerRadius;
        }

        public Builder setRightTopCornerRadius(float rightTopCornerRadius) {
            mOption.rightTopCornerRadius = rightTopCornerRadius;
            return this;
        }

        public float getLeftBottomCornerRadius() {
            return mOption.leftBottomCornerRadius;
        }

        public Builder setLeftBottomCornerRadius(float leftBottomCornerRadius) {
            mOption.leftBottomCornerRadius = leftBottomCornerRadius;
            return this;
        }

        public float getRightBottomCornerRadius() {
            return mOption.rightBottomCornerRadius;
        }

        public Builder setRightBottomCornerRadius(float rightBottomCornerRadius) {
            mOption.rightBottomCornerRadius = rightBottomCornerRadius;
            return this;
        }

        public float getCornerRadius() {
            return mOption.cornerRadius;
        }

        public Builder setCornerRadius(float cornerRadius) {
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

        public int getTitlePadding() {
            return mOption.titlePadding;
        }

        public Builder setTitlePadding(int titlePadding) {
            mOption.titlePadding = titlePadding;
            return this;
        }

        public int getTitleTextAppearance() {
            return mOption.titleTextAppearance;
        }

        public Builder setTitleTextAppearance(int titleTextAppearance) {
            mOption.titleTextAppearance = titleTextAppearance;
            return this;
        }

        public int getTitleBgColor() {
            return mOption.titleBgColor;
        }

        public Builder setTitleBgColor(int titleBgColor) {
            mOption.titleBgColor = titleBgColor;
            return this;
        }

        public int getTitleGravity() {
            return mOption.titleGravity;
        }

        public Builder setTitleGravity(int titleGravity) {
            mOption.titleGravity = titleGravity;
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

        public int getContentPadding() {
            return mOption.contentPadding;
        }

        public Builder setContentPadding(int contentPadding) {
            mOption.contentPadding = contentPadding;
            return this;
        }

        public int getContentTextAppearance() {
            return mOption.contentTextAppearance;
        }

        public Builder setContentTextAppearance(int contentTextAppearance) {
            mOption.contentTextAppearance = contentTextAppearance;
            return this;
        }

        public int getContentBgColor() {
            return mOption.contentBgColor;
        }

        public Builder setContentBgColor(int contentBgColor) {
            mOption.contentBgColor = contentBgColor;
            return this;
        }

        public int getContentGravity() {
            return mOption.contentGravity;
        }

        public Builder setContentGravity(int contentGravity) {
            mOption.contentGravity = contentGravity;
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

        public int getLeftButtonPadding() {
            return mOption.leftButtonPadding;
        }

        public Builder setLeftButtonPadding(int leftButtonPadding) {
            mOption.leftButtonPadding = leftButtonPadding;
            return this;
        }

        public int getLeftButtonTextAppearance() {
            return mOption.leftButtonTextAppearance;
        }

        public Builder setLeftButtonTextAppearance(int leftButtonTextAppearance) {
            mOption.leftButtonTextAppearance = leftButtonTextAppearance;
            return this;
        }

        public int getLeftButtonBgColor() {
            return mOption.leftButtonBgColor;
        }

        public Builder setLeftButtonBgColor(int leftButtonBgColor) {
            mOption.leftButtonBgColor = leftButtonBgColor;
            return this;
        }

        public int getLeftButtonGravity() {
            return mOption.leftButtonGravity;
        }

        public Builder setLeftButtonGravity(int leftButtonGravity) {
            mOption.leftButtonGravity = leftButtonGravity;
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

        public int getMiddleButtonPadding() {
            return mOption.middleButtonPadding;
        }

        public Builder setMiddleButtonPadding(int middleButtonPadding) {
            mOption.middleButtonPadding = middleButtonPadding;
            return this;
        }

        public int getMiddleButtonTextAppearance() {
            return mOption.middleButtonTextAppearance;
        }

        public Builder setMiddleButtonTextAppearance(int middleButtonTextAppearance) {
            mOption.middleButtonTextAppearance = middleButtonTextAppearance;
            return this;
        }

        public int getMiddleButtonBgColor() {
            return mOption.middleButtonBgColor;
        }

        public Builder setMiddleButtonBgColor(int middleButtonBgColor) {
            mOption.middleButtonBgColor = middleButtonBgColor;
            return this;
        }

        public int getMiddleButtonGravity() {
            return mOption.middleButtonGravity;
        }

        public Builder setMiddleButtonGravity(int middleButtonGravity) {
            mOption.middleButtonGravity = middleButtonGravity;
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

        public int getRightButtonPadding() {
            return mOption.rightButtonPadding;
        }

        public Builder setRightButtonPadding(int rightButtonPadding) {
            mOption.rightButtonPadding = rightButtonPadding;
            return this;
        }

        public int getRightButtonTextAppearance() {
            return mOption.rightButtonTextAppearance;
        }

        public Builder setRightButtonTextAppearance(int rightButtonTextAppearance) {
            mOption.rightButtonTextAppearance = rightButtonTextAppearance;
            return this;
        }

        public int getRightButtonBgColor() {
            return mOption.rightButtonBgColor;
        }

        public Builder setRightButtonBgColor(int rightButtonBgColor) {
            mOption.rightButtonBgColor = rightButtonBgColor;
            return this;
        }

        public int getRightButtonGravity() {
            return mOption.rightButtonGravity;
        }

        public Builder setRightButtonGravity(int rightButtonGravity) {
            mOption.rightButtonGravity = rightButtonGravity;
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

        public CustomViewable getCustomViewable() {
            return mOption.customViewable;
        }

        public Builder setCustomViewable(CustomViewable customViewable) {
            mOption.customViewable = customViewable;
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
