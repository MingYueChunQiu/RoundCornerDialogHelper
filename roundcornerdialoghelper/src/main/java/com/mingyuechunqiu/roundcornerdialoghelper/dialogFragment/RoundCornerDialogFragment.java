package com.mingyuechunqiu.roundcornerdialoghelper.dialogFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mingyuechunqiu.roundcornerdialoghelper.R;
import com.mingyuechunqiu.roundcornerdialoghelper.bean.RCDHTextOption;
import com.mingyuechunqiu.roundcornerdialoghelper.bean.RoundCornerDialogHelperOption;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickLeftButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickMiddleButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickRightButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.model.RCDHOptionDelegate;
import com.mingyuechunqiu.roundcornerdialoghelper.model.RCDHOptionDelegateable;
import com.mingyuechunqiu.roundcornerdialoghelper.util.ScreenUtils;
import com.mingyuechunqiu.roundcornerdialoghelper.view.buttonContainer.CustomButtonContainerViewable;
import com.mingyuechunqiu.roundcornerdialoghelper.view.buttonContainer.DefaultButtonContainerView;
import com.mingyuechunqiu.roundcornerdialoghelper.view.viewContainer.CustomViewable;
import com.mingyuechunqiu.roundcornerdialoghelper.view.viewContainer.DefaultView;

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
    private CustomViewable mCustomViewable;
    private CustomButtonContainerViewable mBtnContainerViewable;
    private RCDHOptionDelegateable mDelegate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //放在onCreateView里无效
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mOption == null) {
            mOption = getDefaultOption();
        }
        setCancelable(mOption.isCancelable());
        //去掉对话框的背景，以便设置自已样式的背景
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().setWindowAnimations(mOption.getWindowAnimationStyleResId());
        }
        View view = inflater.inflate(R.layout.rcdh_dialog_fragment_round_corner, container, false);
        if (getContext() != null) {
            if (mOption.getRCDHOptionDelegateable() == null) {
                mDelegate = new RCDHOptionDelegate(getContext(), mOption);
            } else {
                mDelegate = mOption.getRCDHOptionDelegateable();
            }
            setOption(view);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(mOption.getWidth(), mOption.getHeight());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mOption = null;
        mCustomViewable = null;
        mBtnContainerViewable = null;
        if (mDelegate != null) {
            mDelegate.release();
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

    @Nullable
    public TextView getTitleView() {
        return mCustomViewable.getTitleView();
    }

    @Nullable
    public TextView getContentView() {
        return mCustomViewable.getContentView();
    }

    @Nullable
    public TextView getLeftButtonView() {
        return mBtnContainerViewable.getLeftButton();
    }

    @Nullable
    public TextView getMiddleButtonView() {
        return mBtnContainerViewable.getMiddleButton();
    }

    @Nullable
    public TextView getRightButtonView() {
        return mBtnContainerViewable.getRightButton();
    }

    /**
     * 设置对话框配置
     *
     * @param view 最外层布局view
     */
    private void setOption(View view) {
        setContainerView(view);
        setButtonContainerView(view);
    }

    /**
     * 设置按钮上方容器view
     *
     * @param view 父布局view
     */
    private void setContainerView(@NonNull View view) {
        FrameLayout flContainer = view.findViewById(R.id.fl_rcdh_view_container);
        if (mOption.getCustomViewable() == null) {
            mCustomViewable = new DefaultView(getContext(), (ViewGroup) view);
        } else {
            mCustomViewable = mOption.getCustomViewable();
        }
        flContainer.addView(mCustomViewable.getContainer());
        Drawable drawable;
        if (mOption.getBgDrawable() != null) {
            drawable = mOption.getBgDrawable();
        } else {
            GradientDrawable viewDrawable = new GradientDrawable();
            drawable = viewDrawable;
            float[] radius;
            if (mOption.getCornerRadius() > 0) {
                float dpRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getCornerRadius());
                if (mDelegate.checkIsButtonsEmpty()) {
                    radius = new float[]{dpRadius, dpRadius, dpRadius, dpRadius,
                            dpRadius, dpRadius, dpRadius, dpRadius};
                } else {
                    radius = new float[]{dpRadius, dpRadius, dpRadius, dpRadius, 0, 0, 0, 0};
                }
            } else if (mOption.getLeftTopCornerRadius() > 0 ||
                    mOption.getRightTopCornerRadius() > 0) {
                float dpLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftTopCornerRadius());
                float dpRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightTopCornerRadius());
                if (mDelegate.checkIsButtonsEmpty() && (mOption.getLeftBottomCornerRadius() > 0 ||
                        mOption.getRightBottomCornerRadius() > 0)) {
                    float dpBottomLeftRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getLeftBottomCornerRadius());
                    float dpBottomRightRadius = ScreenUtils.getPxFromDp(getResources(), mOption.getRightBottomCornerRadius());
                    radius = new float[]{dpLeftRadius, dpLeftRadius, dpRightRadius, dpRightRadius,
                            dpBottomRightRadius, dpBottomRightRadius, dpBottomLeftRadius, dpBottomLeftRadius};
                } else {
                    radius = new float[]{dpLeftRadius, dpLeftRadius, dpRightRadius, dpRightRadius, 0, 0, 0, 0};
                }
            } else {
                if (mDelegate.checkIsButtonsEmpty() && (mOption.getLeftBottomCornerRadius() > 0 ||
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
        mCustomViewable.getContainer().setBackground(drawable);
        TextView tvTitle = mCustomViewable.getTitleView();
        if (tvTitle != null && mOption.isTitleVisible()) {
            RCDHTextOption option = new RCDHTextOption();
            if (mOption.getTitleTextOption() != null) {
                option = mOption.getTitleTextOption();
            }
            if (!TextUtils.isEmpty(mOption.getTitleText())) {
                option.setText(mOption.getTitleText());
            }
            if (mOption.getTitleTextAppearance() != 0) {
                option.setTextAppearanceResId(mOption.getTitleTextAppearance());
            }
            if (mOption.getTitleTextColor() != 0) {
                option.setTextColor(mOption.getTitleTextColor());
            }
            if (mOption.getTitleTextSize() > 0) {
                option.setTextSize(mOption.getTitleTextSize());
            }
            if (mOption.getTitlePadding() > 0) {
                option.setPadding(mOption.getTitlePadding());
            }
            if (mOption.getTitleBgColor() != 0) {
                mDelegate.setTitleBgColor(tvTitle);
            }
            if (mOption.getTitleGravity() != 0) {
                option.setGravity(mOption.getTitleGravity());
            }
            mDelegate.setTextOption(tvTitle, option);
        } else {
            if (tvTitle != null) {
                tvTitle.setVisibility(View.GONE);
            }
        }
        TextView tvContent = mCustomViewable.getContentView();
        if (tvContent != null && mOption.isContentVisible()) {
            RCDHTextOption option = new RCDHTextOption();
            if (mOption.getContentTextOption() != null) {
                option = mOption.getContentTextOption();
            }
            if (!TextUtils.isEmpty(mOption.getContentText())) {
                option.setText(mOption.getContentText());
            }
            if (mOption.getContentTextAppearance() != 0) {
                option.setTextAppearanceResId(mOption.getContentTextAppearance());
            }
            if (mOption.getContentTextColor() != 0) {
                option.setTextColor(mOption.getContentTextColor());
            }
            if (mOption.getContentTextSize() > 0) {
                option.setTextSize(mOption.getContentTextSize());
            }
            if (mOption.getContentPadding() > 0) {
                option.setPadding(mOption.getContentPadding());
            }
            if (mOption.getContentBgColor() != 0) {
                mDelegate.setContentBgColor(tvContent);
            }
            if (mOption.getContentGravity() != 0) {
                option.setGravity(mOption.getContentGravity());
            }
            mDelegate.setTextOption(tvContent, option);
        } else {
            if (tvContent != null) {
                tvContent.setVisibility(View.GONE);
            }
        }
        View vDivider = view.findViewById(R.id.v_rcdh_divider);
        if (mDelegate.checkIsButtonsEmpty()) {
            //INVISIBLE而不是GONE,撑开对话框
            vDivider.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 设置按钮容器view
     *
     * @param view 父布局view
     */
    private void setButtonContainerView(@NonNull View view) {
        FrameLayout flButtonViewContainer = view.findViewById(R.id.fl_rcdh_button_container);
        TextView tvLeft, tvMiddle, tvRight;
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
        tvLeft = mBtnContainerViewable.getLeftButton();
        tvMiddle = mBtnContainerViewable.getMiddleButton();
        tvRight = mBtnContainerViewable.getRightButton();
        if (tvLeft != null && mOption.getOnRCDHClickLeftButtonListener() != null) {
            RCDHTextOption option = new RCDHTextOption();
            if (mOption.getLeftButtonTextOption() != null) {
                option = mOption.getLeftButtonTextOption();
            }
            if (!TextUtils.isEmpty(mOption.getLeftButtonText())) {
                option.setText(mOption.getLeftButtonText());
            }
            if (mOption.getLeftButtonTextAppearance() != 0) {
                option.setTextAppearanceResId(mOption.getLeftButtonTextAppearance());
            }
            if (mOption.getLeftButtonTextColor() != 0) {
                option.setTextColor(mOption.getLeftButtonTextColor());
            }
            if (mOption.getLeftButtonTextSize() > 0) {
                option.setTextSize(mOption.getLeftButtonTextSize());
            }
            if (mOption.getLeftButtonPadding() > 0) {
                option.setPadding(mOption.getLeftButtonPadding());
            }
            if (mOption.getLeftButtonBgColor() != 0) {
                mDelegate.setLeftButtonBgColor(tvLeft);
            }
            if (mOption.getLeftButtonGravity() != 0) {
                option.setGravity(mOption.getLeftButtonGravity());
            }
            mDelegate.setTextOption(tvLeft, option);
            tvLeft.setOnClickListener(this);
        } else {
            if (tvLeft != null) {
                tvLeft.setVisibility(View.GONE);
            }
        }
        if (tvMiddle != null && mOption.getOnRCDHClickMiddleButtonListener() != null) {
            RCDHTextOption option = new RCDHTextOption();
            if (mOption.getMiddleButtonTextOption() != null) {
                option = mOption.getMiddleButtonTextOption();
            }
            if (!TextUtils.isEmpty(mOption.getMiddleButtonText())) {
                option.setText(mOption.getMiddleButtonText());
            }
            if (mOption.getMiddleButtonTextAppearance() != 0) {
                option.setTextAppearanceResId(mOption.getMiddleButtonTextAppearance());
            }
            if (mOption.getMiddleButtonTextColor() != 0) {
                option.setTextColor(mOption.getMiddleButtonTextColor());
            }
            if (mOption.getMiddleButtonTextSize() > 0) {
                option.setTextSize(mOption.getMiddleButtonTextSize());
            }
            if (mOption.getMiddleButtonPadding() > 0) {
                option.setPadding(mOption.getMiddleButtonPadding());
            }
            if (mOption.getMiddleButtonBgColor() != 0) {
                mDelegate.setMiddleButtonBgColor(tvMiddle);
            }
            if (mOption.getMiddleButtonGravity() != 0) {
                option.setGravity(mOption.getMiddleButtonGravity());
            }
            mDelegate.setTextOption(tvMiddle, option);
            tvMiddle.setOnClickListener(this);
        } else {
            if (tvMiddle != null) {
                tvMiddle.setVisibility(View.GONE);
            }
        }
        if (tvRight != null && mOption.getOnRCDHClickRightButtonListener() != null) {
            RCDHTextOption option = new RCDHTextOption();
            if (mOption.getRightButtonTextOption() != null) {
                option = mOption.getRightButtonTextOption();
            }
            if (!TextUtils.isEmpty(mOption.getRightButtonText())) {
                option.setText(mOption.getRightButtonText());
            }
            if (mOption.getRightButtonTextAppearance() != 0) {
                option.setTextAppearanceResId(mOption.getRightButtonTextAppearance());
            }
            if (mOption.getRightButtonTextColor() != 0) {
                option.setTextColor(mOption.getRightButtonTextColor());
            }
            if (mOption.getRightButtonTextSize() > 0) {
                option.setTextSize(mOption.getRightButtonTextSize());
            }
            if (mOption.getRightButtonPadding() > 0) {
                option.setPadding(mOption.getRightButtonPadding());
            }
            if (mOption.getRightButtonBgColor() != 0) {
                mDelegate.setRightButtonBgColor(tvRight);
            }
            if (mOption.getRightButtonGravity() != 0) {
                option.setGravity(mOption.getRightButtonGravity());
            }
            mDelegate.setTextOption(tvRight, option);
            tvRight.setOnClickListener(this);
        } else {
            if (tvRight != null) {
                tvRight.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 获取默认的配置对象
     */
    private RoundCornerDialogHelperOption getDefaultOption() {
        return new RoundCornerDialogHelperOption.Builder()
                .setBgColor(Color.WHITE)
                .setCornerRadius(10)
                .setTitleVisible(true)
                .setContentVisible(true)
                .setOnRCDHClickLeftButtonListener(new OnRCDHClickLeftButtonListener() {
                    @Override
                    public void onClickLeftButton(RoundCornerDialogFragment fragment, TextView v) {
                    }
                })
                .setOnRCDHClickMiddleButtonListener(new OnRCDHClickMiddleButtonListener() {
                    @Override
                    public void onClickMiddleButton(RoundCornerDialogFragment fragment, TextView v) {
                    }
                })
                .setOnRCDHClickRightButtonListener(new OnRCDHClickRightButtonListener() {
                    @Override
                    public void onClickRightButton(RoundCornerDialogFragment fragment, TextView v) {
                    }
                })
                .build();
    }
}
