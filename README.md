# RoundCornerDialogHelper
圆角仿iOS风格对话框
因为项目需要，所以写了一个圆角对话框库，可以自定义圆角半径，view和按钮显示等内容。
### 1.效果截图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018112512061853.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181127103858948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
### 新版本更新：
1.增加RCDHTextOption进行更丰富的文本控件属性配置
2.增加对话框setCancelable属性设置
3.增加对话框入场出场动画、大小设置
4.优化项目框架，提供代理类配置
5.解耦代码逻辑，优化处理效果
### 2.添加依赖
1.Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
2.Add the dependency

```
dependencies {
		implementation 'com.github.MingYueChunQiu:RoundCornerDialogHelper:0.2.2'
	}
```
### 3.项目使用
1.配置属性

```
    private float leftTopCornerRadius;//左上圆角半径
    private float rightTopCornerRadius;//右上圆角半径
    private float leftBottomCornerRadius;//左下圆角半径
    private float rightBottomCornerRadius;//右下圆角半径
    private float cornerRadius;//圆角半径
    private int bgColor = Color.WHITE;//背景颜色（默认为白色）
    private Drawable bgDrawable;//背景图片
    private String titleText;//标题文本
    private int titleTextColor;//标题文本颜色
    private int titleTextSize;//标题文本大小
    private int titlePadding;//标题内边距
    private int titleTextAppearance;//标题文本样式（默认先使用样式，单独设置的颜色大小会覆盖掉样式中内容）
    private int titleBgColor;//标题背景颜色
    private int titleGravity;//标题对齐方式
    private String contentText;//内容文本
    private int contentTextColor;//内容文本颜色
    private int contentTextSize;//内容文本大熊啊
    private int contentPadding;//内容内边距
    private int contentTextAppearance;//内容文本样式（默认先使用样式，单独设置的颜色大小会覆盖掉样式中内容）
    private int contentBgColor;//内容背景颜色
    private int contentGravity;//内容文本对齐方式
    private String leftButtonText;//左边按钮文本
    private int leftButtonTextColor;//左边按钮文本颜色
    private int leftButtonTextSize;//左边按钮文本大小
    private int leftButtonPadding;//左边按钮内边距
    private int leftButtonTextAppearance;//左边按钮文本样式（默认先使用样式，单独设置的颜色大小会覆盖掉样式中内容）
    private int leftButtonBgColor;//左边按钮背景颜色
    private int leftButtonGravity;//左边按钮对齐方式
    private String middleButtonText;//中间按钮文本
    private int middleButtonTextColor;//中间按钮文本颜色
    private int middleButtonTextSize;//中间按钮文本大小
    private int middleButtonPadding;//中间按钮内边距
    private int middleButtonTextAppearance;//中间按钮文本样式（默认先使用样式，单独设置的颜色大小会覆盖掉样式中内容）
    private int middleButtonBgColor;//中间按钮背景颜色
    private int middleButtonGravity;//中间按钮对齐方式
    private String rightButtonText;//右边按钮文本
    private int rightButtonTextColor;//右边按钮文本颜色
    private int rightButtonTextSize;//右边按钮文本大小
    private int rightButtonPadding;//右边按钮内边距
    private int rightButtonTextAppearance;//右边按钮文本样式（默认先使用样式，单独设置的颜色大小会覆盖掉样式中内容）
    private int rightButtonBgColor;//右边按钮背景颜色
    private int rightButtonGravity;//右边按钮对齐方式
    private boolean isTitleVisible = true;//标题是否可见
    private boolean isContentVisible = true;//内容是否可见
    private RCDHTextOption titleTextOption;//标题文本配置项（推荐，默认先使用，单独设置的属性会覆盖TextOption）
    private RCDHTextOption contentTextOption;//内容文本配置项（推荐，默认先使用，单独设置的属性会覆盖TextOption）
    private RCDHTextOption leftButtonTextOption;//左边按钮文本配置项（推荐，默认先使用，单独设置的属性会覆盖TextOption）
    private RCDHTextOption middleButtonTextOption;//中间按钮文本配置项（推荐，默认先使用，单独设置的属性会覆盖TextOption）
    private RCDHTextOption rightButtonTextOption;//右边按钮文本配置项（推荐，默认先使用，单独设置的属性会覆盖TextOption）
    private CustomViewable customViewable;//自定义显示view
    private CustomButtonContainerViewable customButtonContainerView;//自定义按钮容器类
    //点击左边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickLeftButtonListener onRCDHClickLeftButtonListener;
    //点击中间按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickMiddleButtonListener onRCDHClickMiddleButtonListener;
    //点击右边按钮监听器,设置监听器后按钮才会显示
    private OnRCDHClickRightButtonListener onRCDHClickRightButtonListener;
    private int width;//对话框宽
    private int height;//对话框高
    private boolean isCancelable = true;//标记是否可以外部点击取消对话框
    private int windowAnimationStyleResId;//窗口动画样式
    private RCDHOptionDelegateable delegate;//配置信息处理的代理类
```
2.文本配置信息类

```
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
```

3.创建对话框
```
RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance();
fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
```
4.设置各项配置信息

```
RCDHTextOption textOption = new RCDHTextOption.Builder()
                        .setTextColor(Color.RED)
                        .setGravity(Gravity.RIGHT)
                        .setTextSize(20)
                        .build();
                RoundCornerDialogHelperOption option = new RoundCornerDialogHelperOption.Builder()
                        .setCornerRadius(20)
                        .setBgColor(Color.RED)
                        .setTitleTextSize(24)
                        .setTitlePadding(30)
                        .setTitleTextAppearance(R.style.AppCompatTextView_BOLD_ITALIC)
                        .setTitleBgColor(Color.GRAY)
                        .setContentBgColor(Color.GREEN)
                        .setLeftButtonTextColor(Color.GREEN)
                        .setLeftButtonBgColor(Color.BLUE)
                        .setRightButtonTextOption(textOption)
                        .setRightButtonTextColor(Color.BLACK)
                        .setWidth(getResources().getDisplayMetrics().widthPixels)
                        .setHeight(getResources().getDisplayMetrics().heightPixels)
                        .setCancelable(false)
                        .setWindowAnimationStyleResId(R.style.Dialog_Animation)
                        .setOnRCDHClickLeftButtonListener(new OnRCDHClickLeftButtonListener() {
                            @Override
                            public void onClickLeftButton(RoundCornerDialogFragment fragment, TextView v) {
                                Toast.makeText(MainActivity.this, "左边", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnRCDHClickRightButtonListener(new OnRCDHClickRightButtonListener() {
                            @Override
                            public void onClickRightButton(RoundCornerDialogFragment fragment, TextView v) {
                                Toast.makeText(MainActivity.this, "右边", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
                RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance(option);
                fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
```
### 4.总结
具体的项目框架可以到GitHub上查看，https://github.com/MingYueChunQiu/RoundCornerDialogHelper.git ，码云地址：https://gitee.com/MingYueChunQiu/RoundCornerDialogHelper.git ，如果有任何意见或建议，欢迎反馈，觉得可以的话，帮忙点个star，谢谢！
