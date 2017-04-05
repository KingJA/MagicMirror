# MagicMirror 

[中文文档](README-ch.md)

A MagicMirror,support multiple shape ImageView. CLICK THE ***STAR***  if it's useful for you.

## Preview

| **Basic Sharp**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/rect.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/circle.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/round_rect.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/oval.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/polygon.png)|
|rect|circle|roundRect|oval|polygon|

| **Mask Sharp**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_beauty.png)|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/beauty.png)|
|heart|apple|tag|lemon|beauty|

| **Filter**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/original.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/gray.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/old_picture.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/saturation.png)||
|original |gray|oldPicture|saturation||

## Custom attribute
| attribute | format | belong  |ps  |
| :------------- |:-------------| :-----|:-----|
| mirrorSharp | enum      | ALL |rect circle roundRect oval polygon any|
| mirrorSides | int      | polygon|>2|
| mirrorCorner | dimension      | roundRect ||
| mirrorBorderWidth | dimension      | !any ||
| mirrorBorderColor | color/reference     | !any ||
| mirrorAnySharp | reference     | polygon |res must be put in drawable folder|
| mirrorFilter | enum     | ALL |oldPicture gray saturation|


## Gradle
```java
 compile 'com.kingja.magicmirror:magicmirror:1.1.1'
```

## Usage
Basic Sharp
```java
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/jared_leto"
            app:mirrorSharp="roundRect"
            app:mirrorBorderWidth="2dp"
            app:mirrorBorderColor="#bfbfbf"
            app:mirrorCorner="10dp"/>
```
Mask Sharp
```java
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/megan"
            app:mirrorAnySharp="@drawable/lemon"
            app:mirrorSharp="any"/>
```
Filter
```java
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/taylor"
            app:mirrorFilter="oldPicture"/>
```
## Changelog

**v1.1.1**
- Initial release 

## TODO

* fix README.md

## Contact me
Any questions,Welcome to contact me.
* email:kingjavip@gmail.com
* QQ:87049319
* Weixin:darabbbit
* [My blog](https://kingja.github.io)

## License

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
