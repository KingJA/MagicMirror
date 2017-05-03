# MagicMirror 

中文 | [English](README.md)

提供多种常用形状，基于蒙版图的任意形状及常用滤镜的自定义ImageView。如果对您有用，请点STAR。

## Features
* 基本形状
    * rect
    * circle
    * roundRect
    * oval
    * polygon
* 蒙版形状
* 滤镜
    * gray
    * oldPicture
    * saturation
    

## Preview

| **基本形状**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/rect.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/circle.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/round_rect.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/oval.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/polygon.png)|
|rect|circle|roundRect|oval|polygon|

| **蒙版形状**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_beauty.png)|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/beauty.png)|
|heart.png|apple.png|tag.png|lemon.png|beauty.png|

| **滤镜**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/original.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/gray.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/old_picture.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/saturation.png)||
|original |gray|oldPicture|saturation||

## 自定义属性
| attribute | format | belong  |ps  |
| :------------- |:-------------| :-----|:-----|
| mirrorSharp | enum      | ALL |rect circle roundRect oval polygon any|
| mirrorSides | int      | polygon|边数大于2|
| mirrorCorner | dimension      | roundRect ||
| mirrorBorderWidth | dimension      | !any ||
| mirrorBorderColor | color/reference     | !any ||
| mirrorAnySharp | reference     | polygon |蒙版图片须放在drawable文件夹下|
| mirrorFilter | enum     | ALL |oldPicture gray saturation|


## Gradle
```gradle
 compile 'com.kingja.magicmirror:magicmirror:1.2.0'
```

## Usage
* 基本形状
```xml
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/jared_leto"
            app:mirrorSharp="roundRect"
            app:mirrorBorderWidth="2dp"
            app:mirrorBorderColor="#bfbfbf"
            app:mirrorCorner="10dp"/>
```
* 蒙版形状 (蒙版图片须放在drawable文件夹下)
```xml
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/megan"
            app:mirrorAnySharp="@drawable/lemon"
            app:mirrorSharp="any"/>
```
* 滤镜
```xml
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/taylor"
            app:mirrorFilter="oldPicture"/>
```
* 自定义形状

你可以通过继承 Mirror类复写getMirrorPath()方法来定制自己的形状。

## Changelog

**v1.2.0**
- add filter
**v1.1.1**
- Initial release

## Contact me
Any questions,Welcome to contact me.
* email:kingjavip@gmail.com
* QQ:87049319
* Weixin:darabbbit
* [My blog](https://kingja.github.io)

## License

    Copyright 2017 KingJA

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
