# 红岩期中考核

开始时间：2022/4/29

第一次commit时间：2022/5/1



>写这里的时候已经完成了最后一次commit，这次开发耗时3天不到，真正的”敏捷“开发，你问我敏捷在哪里？
>
>敏捷在判空/doge，这次代码里面很少有判空，基本无脑 !! 这是很不好的，但是这次时间有限，也是被逼无奈😔



## 页面展示

<img src="C:\Users\Administrator\OneDrive\文档\Tencent Files\2058109198\FileRecv\MobileFile\Screenshot_20220503_033520_com.example.redrockmte.jpg" alt="Screenshot_20220503_033520_com.example.redrockmte" style="zoom:25%;" />



<img src="C:\Users\Administrator\OneDrive\文档\Tencent Files\2058109198\FileRecv\MobileFile\Screenshot_20220503_033543_com.example.redrockmte.jpg" alt="Screenshot_20220503_033543_com.example.redrockmte" style="zoom:25%;" />



这里只展示了部分内容，详细内容可以下载app查看

## API接口

[用到的API接口](https://documenter.getpostman.com/view/13758437/UyrBjGDG#75de6229-b638-44f7-9e1a-39a16c32519d)

## 实现的功能

* 首页的下拉查看菜单
* 色谱的大部分功能
* 灵感的大部分功能
* 收藏中的侧滑删除功能

## 用到的技术

* 协程
* MVVM架构
* 自定义view（当然由于时间限制，都不是复杂）

ps：本来想使用retrofit+flow+协程，但是在实际操作中遇到了一些以我目前水平不难短时间解决的问题，所以放弃了这个组合，直接使用了协程

>这次开发让我有一个最深的体会是，不管做什么事情，都要做好万全的调查之后再上手，例如这次有个8边形，我想都没想直接自定义view，结果发现有官方的控件可以实现这个效果，很让我难受（
>
>还有一点是，找到了自己在一些技术上的不足之处，很多地方似懂非懂，导致在这写地方花了很多时间