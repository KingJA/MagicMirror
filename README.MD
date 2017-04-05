# MagicMirror
A MagicMirror,support multiple shape ImageView. CLICK THE ***STAR***  if it's useful for you.

## Preview
![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/preview.png)

| **Basic Sharp**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|
|`rect`|`circle`|`roundRect`|`oval`|`polygon`|

| **Any Sharp**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|

| **Filter**|||||
|:---:|:----:|:----:|:----:|:----:|
|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png) |![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|![](https://github.com/KingJA/MagicMirrorView/blob/master/readme/item.png)|
|oldPicture|gray|saturation|||

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

<!--![](https://github.com/KingJA/SwitchButton/blob/master/img/mark.png)-->
## Gradle
```java
 compile 'com.kingja.magicmirror:magicmirror:1.1.1'
```

## Usage
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
