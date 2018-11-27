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
import android.view.Gravity;
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

    @Nullable
    public AppCompatTextView getLeftButtonView() {
        return mBtnContainerViewable.getLeftButton();
    }

    @Nullable
    public AppCompatTextView getMiddleButtonView() {
        return mBtnContainerViewable.getMiddleButton();
    }

    @Nullable
    public AppCompatTextView getRightButtonView() {
        return mBtnContainerViewable.getRightButton();
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
        setContainerView(inflater, view);
        setButtonContainerView(view);
    }

    /**
     * 设置按钮上方容器view
     *
     * @param inflater 布局填充器
     * @param view     父布局view
     */
    private void setContainerView(@NonNull LayoutInflater inflater, View view) {
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
                    if (checkIsButtonsEmpty()) {
                        radius = new float[]{dpRadius, dpRadius, dpRadius, dpRadius,
                                dpRadius, dpRadius, dpRadius, dpRadius};
                    } else {
                        radius = new float[]{dpRadius, dpRadius, dpRadius, dpRadius, 0, 0, 0, 0};
                    }
                } else if (mOption.getLeftTopCornerRadius() > 0 ||
                        mOption.getRightTopCornerRadius() > 0) {
                    float dpLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftTopCornerRadius());
                    float dpRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightTopCornerRadius());
                    if (checkIsButtonsEmpty() && (mOption.getLeftBottomCornerRadius() > 0 ||
                            mOption.getRightBottomCornerRadius() > 0)) {
                        float dpBottomLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftBottomCornerRadius());
                        float dpBottomRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightBottomCornerRadius());
                        radius = new float[]{dpLeftRadius, dpLeftRadius, dpRightRadius, dpRightRadius,
                                dpBottomRightRadius, dpBottomRightRadius, dpBottomLeftRadius, dpBottomLeftRadius};
                    } else {
                        radius = new float[]{dpLeftRadius, dpLeftRadius, dpRightRadius, dpRightRadius, 0, 0, 0, 0};
                    }
                } else {
                    if (checkIsButtonsEmpty() && (mOption.getLeftBottomCornerRadius() > 0 ||
                            mOption.getRightBottomCornerRadius() > 0)) {
                        float dpBottomLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftBottomCornerRadius());
                        float dpBottomRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightBottomCornerRadius());
                        radius = new float[]{0, 0, 0, 0, dpBottomRightRadius, dpBottomRightRadius,
                                dpBottomLeftRadius, dpBottomLeftRadius};
                    } else {
                        radius = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
                    }
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
                }
                if (mOption.getTitleTextAppearance() != 0) {
                    actvTitle.setTextAppearance(getContext(), mOption.getTitleTextAppearance());
                } else {
                    if (mOption.getTitleTextColor() != 0) {
                        actvTitle.setTextColor(mOption.getTitleTextColor());
                    }
                    if (mOption.getTitleTextSize() > 0) {
                        actvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getTitleTextSize());
                    }
                }
                if (mOption.getTitlePadding() > 0) {
                    int padding = (int) ScreenUtils.getPxFromDp(getResources(), mOption.getTitlePadding());
                    actvTitle.setPadding(padding, padding, padding, padding);
                }
                if (mOption.getTitleBgColor() != 0) {
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
                    actvTitle.setBackground(getBgDrawable(mOption.getTitleBgColor(), titleRadius));
                }
                if (mOption.getTitleGravity() != 0) {
                    actvTitle.setGravity(mOption.getTitleGravity());
                }
            } else {
                actvTitle.setVisibility(View.GONE);
            }
            AppCompatTextView actvContent = defaultView.findViewById(R.id.tv_rcdh_content);
            if (mOption.isContentVisible()) {
                if (!TextUtils.isEmpty(mOption.getContentText())) {
                    actvContent.setText(mOption.getContentText());
                }
                if (mOption.getContentTextAppearance() != 0) {
                    actvContent.setTextAppearance(getContext(), mOption.getContentTextAppearance());
                } else {
                    if (mOption.getContentTextColor() != 0) {
                        actvContent.setTextColor(mOption.getContentTextColor());
                    }
                    if (mOption.getContentTextSize() > 0) {
                        actvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getContentTextSize());
                    }
                }
                if (mOption.getContentPadding() > 0) {
                    int padding = (int) ScreenUtils.getPxFromDp(getResources(), mOption.getContentPadding());
                    actvContent.setPadding(padding, padding, padding, padding);
                }
                if (mOption.getContentBgColor() != 0) {
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
                    actvContent.setBackground(getBgDrawable(mOption.getContentBgColor(), contentRadius));
                }
                if (mOption.getContentGravity() != 0) {
                    actvContent.setGravity(mOption.getContentGravity());
                }
            } else {
                actvContent.setVisibility(View.GONE);
            }
        }
        View vDivider = view.findViewById(R.id.v_rcdh_divider);
        if (checkIsButtonsEmpty()) {
            //INVISIBLE而不是GONE,撑开对话框
            vDivider.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 设置按钮容器view
     *
     * @param view 父布局view
     */
    private void setButtonContainerView(View view) {
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
            if (mOption.getLeftButtonTextAppearance() != 0) {
                actvLeft.setTextAppearance(getContext(), mOption.getLeftButtonTextAppearance());
            } else {
                if (mOption.getLeftButtonTextColor() != 0) {
                    actvLeft.setTextColor(mOption.getLeftButtonTextColor());
                }
                if (mOption.getLeftButtonTextSize() > 0) {
                    actvLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getLeftButtonTextSize());
                }
            }
            if (mOption.getLeftButtonPadding() > 0) {
                int padding = (int) ScreenUtils.getPxFromDp(getResources(), mOption.getLeftButtonPadding());
                actvLeft.setPadding(padding, padding, padding, padding);
            }
            if (mOption.getLeftButtonBgColor() != 0) {
                float leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
                float rightBottomRadius = 0;
                //CornerRadius被设置过，则统一采用CornerRadius
                if (mOption.getOnRCDHClickMiddleButtonListener() == null &&
                        mOption.getOnRCDHClickRightButtonListener() == null) {
                    rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
                }
                float[] leftRadius = new float[]{0, 0, 0, 0,
                        rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
                actvLeft.setBackground(getBgDrawable(mOption.getLeftButtonBgColor(), leftRadius));
            }
            if (mOption.getLeftButtonGravity() != 0) {
                actvLeft.setGravity(mOption.getLeftButtonGravity());
            }
            actvLeft.setOnClickListener(this);
        } else {
            actvLeft.setVisibility(View.GONE);
        }
        if (mOption.getOnRCDHClickMiddleButtonListener() != null) {
            if (!TextUtils.isEmpty(mOption.getMiddleButtonText())) {
                actvMiddle.setText(mOption.getMiddleButtonText());
            }
            if (mOption.getMiddleButtonTextAppearance() != 0) {
                actvMiddle.setTextAppearance(getContext(), mOption.getMiddleButtonTextAppearance());
            } else {
                if (mOption.getMiddleButtonTextColor() != 0) {
                    actvMiddle.setTextColor(mOption.getMiddleButtonTextColor());
                }
                if (mOption.getMiddleButtonTextSize() > 0) {
                    actvMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getMiddleButtonTextSize());
                }
            }
            if (mOption.getMiddleButtonPadding() > 0) {
                int padding = (int) ScreenUtils.getPxFromDp(getResources(), mOption.getMiddleButtonPadding());
                actvMiddle.setPadding(padding, padding, padding, padding);
            }
            if (mOption.getMiddleButtonBgColor() != 0) {
                float leftBottomRadius = 0, rightBottomRadius = 0;
                if (mOption.getOnRCDHClickLeftButtonListener() == null) {
                    leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
                }
                if (mOption.getOnRCDHClickRightButtonListener() == null) {
                    rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
                }
                float[] middleRadius = new float[]{0, 0, 0, 0,
                        rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
                actvMiddle.setBackground(getBgDrawable(mOption.getMiddleButtonBgColor(), middleRadius));
            }
            if (mOption.getMiddleButtonGravity() != 0) {
                actvMiddle.setGravity(mOption.getMiddleButtonGravity());
            }
            actvMiddle.setOnClickListener(this);
        } else {
            actvMiddle.setVisibility(View.GONE);
        }
        if (mOption.getOnRCDHClickRightButtonListener() != null) {
            if (!TextUtils.isEmpty(mOption.getRightButtonText())) {
                actvRight.setText(mOption.getRightButtonText());
            }
            if (mOption.getRightButtonTextAppearance() != 0) {
                actvRight.setTextAppearance(getContext(), mOption.getRightButtonTextAppearance());
            } else {
                if (mOption.getRightButtonTextColor() != 0) {
                    actvRight.setTextColor(mOption.getRightButtonTextColor());
                }
                if (mOption.getRightButtonTextSize() > 0) {
                    actvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOption.getRightButtonTextSize());
                }
            }
            if (mOption.getRightButtonPadding() > 0) {
                int padding = (int) ScreenUtils.getPxFromDp(getResources(), mOption.getRightButtonPadding());
                actvRight.setPadding(padding, padding, padding, padding);
            }
            if (mOption.getRightButtonBgColor() != 0) {
                float leftBottomRadius = 0;
                float rightBottomRadius = getCornerRadius(mOption.getRightBottomCornerRadius());
                if (mOption.getOnRCDHClickMiddleButtonListener() == null &&
                        mOption.getOnRCDHClickLeftButtonListener() == null) {
                    leftBottomRadius = getCornerRadius(mOption.getLeftBottomCornerRadius());
                }
                float[] leftRadius = new float[]{0, 0, 0, 0,
                        rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
                actvRight.setBackground(getBgDrawable(mOption.getRightButtonBgColor(), leftRadius));
            }
            if (mOption.getRightButtonGravity() != 0) {
                actvRight.setGravity(mOption.getRightButtonGravity());
            }
            actvRight.setOnClickListener(this);
        } else {
            actvRight.setVisibility(View.GONE);
        }
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

    /**
     * 检测是否没有按钮
     *
     * @return 如果没有按钮返回true，否则返回false
     */
    private boolean checkIsButtonsEmpty() {
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
            return ScreenUtils.getPxFromDp(getResources(), mOption.getCornerRadius());
        } else {
            return ScreenUtils.getPxFromDp(getResources(), radius);
        }
    }
}
