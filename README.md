![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/logo_magicmirror.png)

English | [中文](README-ch.md)

It's a little bit different from other image shape library,
it supports multiple shapes for ImageView,and also some most common filter. CLICK THE ***STAR***  if it's useful to you.

## Features
* Basic Shape : some most common shapes.
    * rect
    * circle
    * roundRect
    * oval
    * polygon
* Mask Shape : any shapes based on mask picture.
* Filter : some most common filters.
    * gray
    * oldPicture
    * saturation
    

## Preview

| **Basic Shape**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/rect.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/circle.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/round_rect.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/oval.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/polygon.png)|
|rect|circle|roundRect|oval|polygon|

| **Mask Shape**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/bg_beauty.png)|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/heart.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/apple.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/tag.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/lemon.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/beauty.png)|
|heart.png|apple.png|tag.png|lemon.png|beauty.png|

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
| mirrorMaskRes | reference     | polygon |res must be put in drawable folder|
| mirrorFilter | enum     | ALL |oldPicture gray saturation|


## Gradle
```gradle
 compile 'com.kingja.magicmirror:magicmirror:1.2.0'
```

## Usage
* Basic Sharp
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

* Mask Sharp (the res of mirrorMaskRes must be put in res/drawable)
```xml
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/megan"
            app:mirrorMaskRes="@drawable/lemon"
            app:mirrorSharp="any"/>
```
* Filter
```xml
<com.kingja.magicmirror.MagicMirrorView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/taylor"
            app:mirrorFilter="oldPicture"/>
```
* Custom Shape

You also can customize your shape by extending the Mirror and overriding the method `getMirrorPath()`.

## Changelog

**v1.2.0**
* add filter

**v1.1.1**
* Initial release


## Contact me
Any questions:Welcome to contact me.
* Email:kingjavip@gmail.com

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
