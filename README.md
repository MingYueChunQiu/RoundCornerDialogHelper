# RoundCornerDialogHelper
圆角仿iOS风格对话框
因为项目需要，所以写了一个圆角对话框，可以自定义圆角半径，view和按钮显示。
### 1.效果截图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018112512061853.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181127103858948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NsMjAxOGdvZA==,size_16,color_FFFFFF,t_70)
### 版本更新
1.修改标题和内容文本默认可见
2.增加文本TextAppearance样式设置
3.增加按钮背景设置功能
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
		implementation 'com.github.MingYueChunQiu:RoundCornerDialogHelper:0.1.2'
	}
```
### 3.项目使用
1.创建对话框

```
RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance();
fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
```
2.设置各项配置信息

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
