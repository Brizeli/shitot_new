<%@page contentType="text/html" pageEncoding="UTF-8" %>

<li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext.response.locale}<b class="caret"></b></a>
    <ul class="dropdown-menu">
        <li><a onclick="show('en')">English</a></li>
        <li><a onclick="show('he')">עברית</a></li>
    </ul>
</li>
<script type="text/javascript">
    function show(lang) {
        var nLang = 'lang=' + lang;
        var url = window.location.href;
        if (url.indexOf('lang') > -1) url = url.replace(/lang=../, nLang);
        else {
            var uri = url.split('?')[0];
            var pars = url.split('?')[1];
            if (pars) pars += '&' + nLang;
            else pars = nLang;
            url = uri + '?' + pars;
        }
        window.location.href = url;// + (url[1] ? '&' + url[1] : '');
    }
</script>