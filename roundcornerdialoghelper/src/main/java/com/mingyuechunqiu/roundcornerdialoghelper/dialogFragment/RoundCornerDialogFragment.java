package com.mingyuechunqiu.roundcornerdialoghelper.dialogFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mingyuechunqiu.roundcornerdialoghelper.R;
import com.mingyuechunqiu.roundcornerdialoghelper.bean.RoundCornerDialogHelperOption;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickLeftButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickMiddleButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickRightButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.util.ScreenUtils;
import com.mingyuechunqiu.roundcornerdialoghelper.view.CustomButtonContainerViewable;
import com.mingyuechunqiu.roundcornerdialoghelper.view.DefaultButtonContainerView;

/**
 * <pre>
 *     author : 明月春秋
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/24
 *     desc   : 仿IOS的圆角对话框
 *              继承自BaseDialogFragment
 *     version: 1.0
 * </pre>
 */
public class RoundCornerDialogFragment extends DialogFragment implements View.OnClickListener {

    private RoundCornerDialogHelperOption mOption;
    private CustomButtonContainerViewable mBtnContainerViewable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //放在onCreateView里无效
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //去掉对话框的背景，以便设置自已样式的背景
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        View view = inflater.inflate(R.layout.rcdh_dialog_fragment_round_corner, container, false);
        setOption(inflater, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mOption = null;
        mBtnContainerViewable = null;
    }

    /**
     * 设置对话框配置
     *
     * @param inflater 布局填充器
     * @param view     最外层布局view
     */
    private void setOption(@NonNull LayoutInflater inflater, View view) {
        if (mOption == null) {
            getDefaultOption();
        }
        FrameLayout flContainer = view.findViewById(R.id.fl_rcdh_view_container);
        if (mOption.getCustomView() != null) {
            flContainer.addView(mOption.getCustomView());
        } else {
            View defaultView = inflater.inflate(R.layout.rcdh_layout_default_view_container, flContainer, false);
            flContainer.addView(defaultView);
            Drawable drawable;
            if (mOption.getBgDrawable() != null) {
                drawable = mOption.getBgDrawable();
            } else {
                GradientDrawable viewDrawable = new GradientDrawable();
                drawable = viewDrawable;
                float[] radius;
                if (mOption.getCornerRadius() > 0) {
                    float dpRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getCornerRadius());
                    radius = new float[]{dpRadius, dpRadius, dpRadius, dpRadius, 0, 0, 0, 0,};
                } else if (mOption.getLeftTopCornerRadius() > 0 ||
                        mOption.getRightTopCornerRadius() > 0) {
                    float dpLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftTopCornerRadius());
                    float dpRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightTopCornerRadius());
                    radius = new float[]{dpLeftRadius, dpLeftRadius, dpRightRadius, dpRightRadius, 0, 0, 0, 0};
                } else {
                    radius = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
                }
                viewDrawable.setCornerRadii(radius);
                if (mOption.getBgColor() != 0) {
                    viewDrawable.setColor(mOption.getBgColor());
                }
            }
            defaultView.setBackground(drawable);
            AppCompatTextView actvTitle = defaultView.findViewById(R.id.tv_rcdh_title);
            if (mOption.isTitleVisible()) {
                if (!TextUtils.isEmpty(mOption.getTitleText())) {
                    actvTitle.setText(mOption.getTitleText());
                    if (mOption.getTitleTextColor() != 0) {
                        actvTitle.setTextColor(mOption.getTitleTextColor());
                    }
                    if (mOption.getTitleTextSize() > 0) {
                        actvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getTitleTextSize());
                    }
                }
            } else {
                actvTitle.setVisibility(View.GONE);
            }
            AppCompatTextView actvContent = defaultView.findViewById(R.id.tv_rcdh_content);
            if (mOption.isContentVisible()) {
                if (!TextUtils.isEmpty(mOption.getContentText())) {
                    actvContent.setText(mOption.getContentText());
                    if (mOption.getContentTextColor() != 0) {
                        actvContent.setTextColor(mOption.getContentTextColor());
                    }
                    if (mOption.getContentTextSize() > 0) {
                        actvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getContentTextSize());
                    }
                }
            } else {
                actvContent.setVisibility(View.GONE);
            }
        }
        FrameLayout flButtonViewContainer = view.findViewById(R.id.fl_rcdh_button_container);
        AppCompatTextView actvLeft, actvMiddle, actvRight;
        if (mOption.getCustomButtonContainerView() == null) {
            mBtnContainerViewable = new DefaultButtonContainerView(getContext(), (ViewGroup) view);
        } else {
            mBtnContainerViewable = mOption.getCustomButtonContainerView();
        }
        GradientDrawable buttonDrawable = new GradientDrawable();
        float[] radius;
        if (mOption.getCornerRadius() > 0) {
            float dpRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getCornerRadius());
            radius = new float[]{0, 0, 0, 0, dpRadius, dpRadius, dpRadius, dpRadius};
        } else if (mOption.getLeftBottomCornerRadius() > 0 ||
                mOption.getRightBottomCornerRadius() > 0) {
            float dpRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightBottomCornerRadius());
            float dpLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftBottomCornerRadius());
            radius = new float[]{0, 0, 0, 0, dpRightRadius, dpRightRadius, dpLeftRadius, dpLeftRadius};
        } else {
            radius = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
        buttonDrawable.setCornerRadii(radius);
        buttonDrawable.setColor(Color.WHITE);
        mBtnContainerViewable.getContainer().setBackground(buttonDrawable);
        flButtonViewContainer.addView(mBtnContainerViewable.getContainer());
        actvLeft = mBtnContainerViewable.getLeftButton();
        actvMiddle = mBtnContainerViewable.getMiddleButton();
        actvRight = mBtnContainerViewable.getRightButton();
        if (mOption.getOnRCDHClickLeftButtonListener() != null) {
            if (!TextUtils.isEmpty(mOption.getLeftButtonText())) {
                actvLeft.setText(mOption.getLeftButtonText());
            }
            if (mOption.getLeftButtonTextColor() != 0) {
                actvLeft.setTextColor(mOption.getLeftButtonTextColor());
            }
            if (mOption.getLeftButtonTextSize() > 0) {
                actvLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getLeftButtonTextSize());
            }
            actvLeft.setOnClickListener(this);
        } else {
            actvLeft.setVisibility(View.GONE);
        }
        if (mOption.getOnRCDHClickMiddleButtonListener() != null) {
            if (!TextUtils.isEmpty(mOption.getMiddleButtonText())) {
                actvMiddle.setText(mOption.getMiddleButtonText());
            }
            if (mOption.getMiddleButtonTextColor() != 0) {
                actvMiddle.setTextColor(mOption.getMiddleButtonTextColor());
            }
            if (mOption.getMiddleButtonTextSize() > 0) {
                actvMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getMiddleButtonTextSize());
            }
            actvMiddle.setOnClickListener(this);
        } else {
            actvMiddle.setVisibility(View.GONE);
        }
        if (mOption.getOnRCDHClickRightButtonListener() != null) {
            if (!TextUtils.isEmpty(mOption.getRightButtonText())) {
                actvRight.setText(mOption.getRightButtonText());
            }
            if (mOption.getRightButtonTextColor() != 0) {
                actvRight.setTextColor(mOption.getRightButtonTextColor());
            }
            if (mOption.getRightButtonTextSize() > 0) {
                actvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getRightButtonTextSize());
            }
            actvRight.setOnClickListener(this);
        } else {
            actvRight.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (mBtnContainerViewable == null) {
            return;
        }
        if (v.getId() == mBtnContainerViewable.getLeftButton().getId()) {
            mOption.getOnRCDHClickLeftButtonListener().onClickLeftButton(this, mBtnContainerViewable.getLeftButton());
        } else if (v.getId() == mBtnContainerViewable.getMiddleButton().getId()) {
            mOption.getOnRCDHClickMiddleButtonListener().onClickMiddleButton(this, mBtnContainerViewable.getMiddleButton());
        } else if (v.getId() == mBtnContainerViewable.getRightButton().getId()) {
            mOption.getOnRCDHClickRightButtonListener().onClickRightButton(this, mBtnContainerViewable.getRightButton());
        }
        dismiss();
    }

    /**
     * 创建对话框实例
     *
     * @return 返回对话框实例
     */
    public static RoundCornerDialogFragment newInstance() {
        return newInstance(null);
    }

    /**
     * 创建对话框实例
     *
     * @param option 对话框配置项
     * @return 返回对话框实例
     */
    public static RoundCornerDialogFragment newInstance(RoundCornerDialogHelperOption option) {
        RoundCornerDialogFragment fragment = new RoundCornerDialogFragment();
        fragment.mOption = option;
        return fragment;
    }

    /**
     * 获取默认的配置对象
     */
    private void getDefaultOption() {
        mOption = new RoundCornerDialogHelperOption.Builder()
                .setBgColor(Color.WHITE)
                .setCornerRadius(10)
                .setTitleVisible(true)
                .setContentVisible(true)
                .setOnRCDHClickLeftButtonListener(new OnRCDHClickLeftButtonListener() {
                    @Override
                    public void onClickLeftButton(RoundCornerDialogFragment fragment, AppCompatTextView v) {

                    }
                })
                .setOnRCDHClickMiddleButtonListener(new OnRCDHClickMiddleButtonListener() {
                    @Override
                    public void onClickMiddleButton(RoundCornerDialogFragment fragment, AppCompatTextView v) {

                    }
                })
                .setOnRCDHClickRightButtonListener(new OnRCDHClickRightButtonListener() {
                    @Override
                    public void onClickRightButton(RoundCornerDialogFragment fragment, AppCompatTextView v) {

                    }
                })
                .build();
    }
}
