﻿//document.write('<link rel="stylesheet" type="text/css" href="//csstools.chinaz.com/common/styles/loginpopup.css?v=20190718">');


var m = {
    ct: 0,
    vu: "",
    limit: 5,
    authUrl: "/ajaxseo.aspx?t=authuser",
    authType: "page",
    login: function (h) {
        if (document.cookie.indexOf("bbsmax_user") < 0) {
            var link = encodeURI(h ? h : document.location.href);
            var html = "<div class=\"p-cont\">" +
                "<div class=\"p-state1\">您还未登录</div>" +
                "<p class=\"p-state2\">您好，登录后可进行更多操作</p></div>" +
                "<p class=\"p-hint1\">第三方账号直接登录（免注册）</p>" +
                "<div class=\"btnlogin clearfix\">" +
                "<a href=\"//my.chinaz.com/OAuth/QQLogin2?returnurl=" + link + "\"  class=\"btn qql\"><i></i><span>QQ登录</span></a>" +
                "<a href=\"//my.chinaz.com/OAuth/WexinLogin?Returnurl=" + link + "\" class=\"btn wxl\"><i></i><span>微信登录</span></a>" +
                "</div>" +
                "<p class=\"p-hint2\"><a href=\"//my.chinaz.com/Login/Index?returnurl=" + link + "\">站长账号登录</a></p>";
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                shadeClose: true,
                area: ['435px', '260px'],
                content: html
            });
            return false;
        }
        return true;
    },
    auth: function (idx, href, event) {
        if (idx > m.limit) {
            m.authTo(href, idx, event);
        } else {
            if (event) {
                event(idx);
                return true;
            }
            if (href) {
                document.location.href = href;
                return true;
            }
            if (m.page.url)
                document.location.href = m.page.url + idx;
            return true;
        }
    },
    authTo: function (href, idx, event) {
        jQuery.ajax({
            type: "POST",
            url: m.authUrl,
            dataType: 'jsonp',
            data: "i=" + idx + "&c=" + m.authType + "&ct=" + m.ct,
            async: false,
            success: function (data) {
                m.authEv(data, href, idx, event);
            }
        });
    },
    authToData: function (href, idx, type, event) {
        jQuery.ajax({
            type: "POST",
            url: m.authUrl,
            dataType: 'jsonp',
            data: "i=" + idx + "&c=" + type + "&ct=" + m.ct,
            async: false,
            success: function (data) {
                m.authEv(data, href, idx, event);
            }
        });
    },
    authEv: function (data, href, idx, e) {
        if (data.result == -1) {
            layer.alert('请求超时,请稍后再重试', { title: "提示", icon: 0 });
            event.stopPropagation();
            return false;
        }
        if (data.result == 0) {
            m.login();
            event.stopPropagation();
            return false;
        }
        if (data.result == 1) {
            layer.open({
                title: "升级VIP会员",
                type: 2,
                shadeClose: true,
                content: "//my.chinaz.com/ToolMember/Member/MemberVip?url=" + m.vu,
                area: ['480px', '555px']
            });
            event.stopPropagation();
            return false;
        }
        if (e) {
            e();
            return true;
        }
        if (href) {
            document.location.href = href;
            return true;
        }
        if (m.page.url)
            document.location.href = m.page.url + idx;
        return true;
    },
    page: {
        url: "",
        goto: function (idx, href, event) {
            m.auth(idx, href, event);
        }
    },
    data: function (href, idx, event) {
        if (m.login(href)) {
            return m.authTo(href, idx, event);
        }
        return false;
    },
    pay: function (ele) {
        if (m.login()) {
            layer.open({
                title: "数据下载",
                type: 2,
                shadeClose: true,
                content: ele.attr("export"),
                area: ['525px', '580px']
            });
        }
    },
    init: function (type, limitPage, pagingUrl) {
        m.ct = type | 0;
        if (limitPage) {
            m.limit = limitPage;
        }
        m.page.url = pagingUrl;
        $("[export]").each(function (i, e) {
            $(e).on("click", function () {
                m.pay($(e));
            });
        });
        $("#gotoPage").click(function () {
            var pn = $("#pn").val();
            if (pn) {
                m.page.goto(pn, pagingUrl + pn);
            }
        });
        document.onkeydown = function (e) {
            e = e || window.Event;
            if ((e.keyCode || e.which) == 13) {
                if (e && e.stopPropagation) {
                    e.stopPropagation();  //其它浏览器下阻止冒泡
                } else {
                    window.event.cancelBubble = true;  //ie下阻止冒泡
                }
                var ele = document.activeElement.id;
                if (ele) {
                    if ($("#" + ele).attr("bind-event")) {
                        var bindEle = $("#" + ele).attr("bind-event");
                        $(bindEle).click();
                        return false;
                    }
                    if ($("#" + ele).attr("data-type") === "no-form") {
                        $(".layui-layer-close2").click();
                        m.page.goto($("#" + ele).val());
                        return false;
                    }
                }
                $("#submit").click();
            }
        };
    }
};

function encodeURI(barurl) {
    if (!barurl) return barurl;
    barurl = barurl.replace(/\+/g, "%2B");
    barurl = barurl.replace(/\&/g, "%26");
    barurl = barurl.replace(/\#/g, "%23");
    return barurl;
}