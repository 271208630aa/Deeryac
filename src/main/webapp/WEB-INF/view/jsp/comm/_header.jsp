<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="Hui-header cl">
    <a class="Hui-logo l" title="校园足球成绩管理平台" href="javascript:location.replace(location.href);">校园足球成绩管理平台</a><span class="Hui-subtitle l">V0.1Beta</span>
    <nav class="mainnav cl" id="Hui-nav">
        <ul>
            <li class="dropDown dropDown_click">
                <a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                <ul class="dropDown-menu radius box-shadow">
                    <li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">
                        &#xe616;</i> 资讯</a></li>
                    <li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">
                        &#xe613;</i> 图片</a></li>
                    <li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">
                        &#xe620;</i> 产品</a></li>
                    <li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i
                            class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <ul class="Hui-userbar">
        <li>超级管理员</li>
        <li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">admin <i class="Hui-iconfont">
            &#xe6d5;</i></a>
            <ul class="dropDown-menu radius box-shadow">
                <li><a href="#">个人信息</a></li>
                <li><a href="#">切换账户</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </li>
        <li id="Hui-msg"><a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a></li>
        <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i
                class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
            <ul class="dropDown-menu radius box-shadow">
                <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
            </ul>
        </li>
    </ul>
    <a href="#" class="Hui-nav-toggle Hui-iconfont" aria-hidden="false">&#xe667;</a>
</header>