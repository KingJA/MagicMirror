# MagicMirror
[English Document](README.md)
自定义图形控件，支持多种形状，边框，滤镜。如果对您有帮助，请点击Star.

## Preview

| **基本形状**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/rect.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/circle.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/round_rect.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/oval.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/polygon.png)|
|rect|circle|roundRect|oval|polygon|

| **蒙版形状**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_beauty.png)|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/beauty.png)|
|heart|apple|tag|lemon|beauty|

| **滤镜**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/original.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/gray.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/old_picture.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/saturation.png)||
|original |gray|oldPicture|saturation||

## 自定义属性
| 参数 | 格式 | 所属  |备注  |
| :------------- |:-------------| :-----|:-----|
| mirrorSharp | enum      | ALL |rect circle roundRect oval polygon any|
| mirrorSides | int      | polygon|>2|
| mirrorCorner | dimension      | roundRect ||
| mirrorBorderWidth | dimension      | !any ||
| mirrorBorderColor | color/reference     | !any ||
| mirrorAnySharp | reference     | polygon |res must be put in drawable folder|
| mirrorFilter | enum     | ALL |oldPicture gray saturation|

<!--![](https://github.com/KingJA/SwitchButton/blob/master/img/mark.png)-->
## Gradle
```java
 compile 'com.kingja.magicmirror:magicmirror:1.1.1'
```

## 使用
```java
 <com.kingja.magicmirror.MagicMirrorView
        app:mirrorSharp="roundRect"
        app:mirrorCorner="10dp"
        app:mirrorBorderWidth="1dp"
        app:mirrorBorderColor="#3957f7"
        android:layout_marginTop="8dp"
        android:src="@mipmap/country"
        android:layout_width="100dp"
        android:layout_height="80dp"/>
```

## 更新日志

**v1.1.1**
- Initial release 

## TODO

* fix README.md

## 联系我
如果有任何问题，欢迎联系。
* email:kingjavip@gmail.com
* QQ:87049319
* Weixin:darabbbit
* [My blog](https://kingja.github.io)

## 开源许可证

    Copyright 2016 KingJA

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
