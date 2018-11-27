# RoundCornerDialogHelper
圆角仿iOS风格对话框
因为项目需要，所以写了一个圆角对话框，可以自定义圆角半径，view和按钮显示。
### 1.效果截图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018112512061853.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181127103858948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
### 新版本更新：
1.修改标题和内容文本默认可见
2.增加文本TextAppearance样式设置
3.增加按钮背景设置功能
4.增加标题和内容背景设置
5.文本对齐方式设置
6.提供按钮控件获取
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
		implementation 'com.github.MingYueChunQiu:RoundCornerDialogHelper:0.1.4'
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
```

2.创建对话框

```
RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance();
fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
```
3.设置各项配置信息

```
RoundCornerDialogHelperOption option = new RoundCornerDialogHelperOption.Builder()
                       .setCornerRadius(20)
                       .setBgColor(Color.RED)
                       .setTitleTextSize(24)
                       .setTitlePadding(30)
                       .setTitleTextAppearance(R.style.AppCompatTextView_BOLD_ITALIC)
                       .setLeftButtonTextColor(Color.GREEN)
                       .setLeftButtonBgColor(Color.BLUE)
                       .setRightButtonBgColor(Color.YELLOW)
                       .setOnRCDHClickLeftButtonListener(new OnRCDHClickLeftButtonListener() {
                            @Override
                            public void onClickLeftButton(RoundCornerDialogFragment fragment, AppCompatTextView v) {
                                Toast.makeText(MainActivity.this, "左边", Toast.LENGTH_SHORT).show();
                            }
                        })
                       .setOnRCDHClickRightButtonListener(new OnRCDHClickRightButtonListener() {
                            @Override
                            public void onClickRightButton(RoundCornerDialogFragment fragment, AppCompatTextView v) {
                                Toast.makeText(MainActivity.this, "右边", Toast.LENGTH_SHORT).show();
                            }
                        })
                       .build();
                RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance(option);
                fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
```
### 4.总结
具体的项目框架可以到GitHub上查看，https://github.com/MingYueChunQiu/RoundCornerDialogHelper.git ，如果有任何意见或建议，欢迎反馈，谢谢！
