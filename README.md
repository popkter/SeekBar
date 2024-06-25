# SeekBar
Android Volume &amp; Brightness Adjust SeekBar reference iOS


# 类iOS音量/亮度调节的SeekBar

## 效果

[<video src="C:\Users\PopCa\Desktop\popseekbar.mp4"></video>
](https://github.com/popkter/PopLib/assets/74968459/b098fd98-37b6-4668-a81f-a5a4409d81d4)

## 特性

1. 自定义进度阈值
2. 原生竖向支持
3. 平滑滚动
4. 过度滑动缩放
5. 自定义圆角
6. 自定义颜色
7. 自然过渡
8. 监听


## 使用

### 最大进度

使用类属性定义进度阈值

- **max**

- **min**

### 原生竖向支持

使用xml属性定义方向

- **orientation** -> 可取值 ``vertical/horizontal``
### 平滑滚动

```kotlin
fun setProgress(progress: Int, notifyListener: Boolean, animator: Boolean = false)
```

通过使用`setProgress`方法设置seekbar的进度，平滑滚动参数 `animator`默认为 `false`，设置为`true`开启平滑滚动

### 过度滑动

> 是否开启过度滑动后弹跳缩放效果

可通过xml或类属性设置是否开启弹跳效果，默认开启

- **overStretchEnable**

> 可定义过度滑动后，每一个步长对应view的尺寸变化距离及最大的尺寸改变距离

通过设置类属性自定义步长和最大距离

- **stretchStep**
- **maxStretchDistance**

### 自定义圆角

>  自定义圆角需要在xml中定义

通过设置属性

- **commonRadius**
- **progressRadius**
- **trackRadius**

可以分别定义通用圆角、进度条圆角、轨道背景的圆角。优先使用特定圆角。如定义了 `commonRadius`和`progressRadius`，进度条使用progressRadius，而背景会使用commonRadius

### 自定义颜色

> 目前仅支持线性渐变，自定义颜色需要在xml中定义

通过设置以下属性定义进度条颜色

- **progressSolidColor**  -> 进度条单色
- **progressStartSolidColor** -> 进度条渐变起始颜色
- **progressEndSolidColor** -> 进度条渐变结束颜色
- **progressGradientType** -> 进度条渐变类型，目前仅有Linear类型生效
- **progressGradientAngle** -> 进度条渐变方向，仅支持45的倍数

以下为背景颜色属性

- **trackSolidColor**  -> 进度条背景单色
- **trackStartSolidColor** -> 进度条背景渐变起始颜色
- **trackEndSolidColor** -> 进度条背景渐变结束颜色
- **trackGradientType** -> 进度条背景渐变类型，目前仅有Linear类型生效
- **trackGradientAngle** -> 进度条背景渐变方向，仅支持45的倍数

### 自然过渡

> 当进度条和背景均采用圆角时候，进度条长度少于圆角，如果使用默认圆角过度不自然，可以使用xml定义或编程控制


https://github.com/popkter/PopLib/assets/74968459/880bceb3-2e35-4365-8738-a272df1d3a8b


xml属性

- naturalProcess

类属性

- naturalProcess

### 点击事件

> 点击背景让进度条更新到此位置，默认关闭

类属性

- canResponseTouch

### 进度监听

> 类似原生seekbar监听进度条的更新

```kotlin

interface OnPopSeekBarChangeListener {
    fun onStartTrackingTouch(seekBar: PopSeekBar, mProgress: Int)
    fun onStopTrackingTouch(seekBar: PopSeekBar, mProgress: Int)
    fun onProgressChanged(seekBar: PopSeekBar, mProgress: Int, fromUser: Boolean)
}

```

### XML 属性一览

> There is a lot properties in popSeekBar

```xml
    <declare-styleable name="PopSeekBar">
        <attr name="progressSolidColor" format="color"/>
        <attr name="progressStartSolidColor" format="color"/>
        <attr name="progressEndSolidColor" format="color"/>
        <attr name="progressRadius" format="dimension"/>

        <attr name="trackSolidColor" format="color"/>
        <attr name="trackStartSolidColor" format="color"/>
        <attr name="trackEndSolidColor" format="color"/>
        <attr name="trackRadius" format="dimension"/>

        <attr name="naturalProcess" format="boolean"/>

        <attr name="commonRadius" format="dimension"/>

        <attr name="overStretchEnable" format="boolean"/>

        <attr name="orientation" format="integer">
            <enum name="horizontal" value="0"/>
            <enum name="vertical" value="1"/>
        </attr>

        <attr name="progressGradientType" format="integer">
            <enum name="Linear" value="0" />
            <enum name="Radial" value="1" />
        </attr>

        <attr name="progressGradientAngle" format="integer">
            <enum name="left2right" value="0" />
            <enum name="right2left" value="180" />
            <enum name="top2bottom" value="90" />
            <enum name="bottom2top" value="270" />
            <enum name="leftTop2rightBottom" value="45" />
            <enum name="rightTop2leftBottom" value="135" />
            <enum name="leftBottom2rightTop" value="225" />
            <enum name="rightBottom2leftTop" value="315" />
        </attr>

        <attr name="trackGradientType" format="integer">
            <enum name="Linear" value="0" />
            <enum name="Radial" value="1" />
        </attr>
        <attr name="trackGradientAngle" format="integer">
            <enum name="left2right" value="0" />
            <enum name="right2left" value="180" />
            <enum name="top2bottom" value="90" />
            <enum name="bottom2top" value="270" />
            <enum name="leftTop2rightBottom" value="45" />
            <enum name="rightTop2leftBottom" value="135" />
            <enum name="leftBottom2rightTop" value="225" />
            <enum name="rightBottom2leftTop" value="315" />
        </attr>
    </declare-styleable>
```



## 导入

**Step 1.** Add it in your root build.gradle at the end of repositories:

```groovy
	dependencyResolutionManagement {
		//...
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```groovy
	dependencies {
	        implementation 'com.github.popkter:SeekBar:0.1'
	}
```


## 其他

### 注意事项

- 过度滑动的弹跳效果会根据约束方向缩放

### Todo

1. xml属性抽象
2. 径向渐变，但做的可能性不大

### Power By

[![](https://jitpack.io/v/popkter/SeekBar.svg)](https://jitpack.io/#popkter/SeekBar)
