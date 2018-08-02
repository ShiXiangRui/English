<html>

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RuiLeXiong</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css"/>

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/grayscale.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="">首页</a>
        <span>您好,会员${pageContext.session.getAttribute("SPRING_SECURITY_CONTEXT").getAuthentication().getName()}</span>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="/logout">注销</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#movie">看美剧</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#signup">发音基础</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="">联系我们</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">英语学习网站</h1>
            <h2 class="text-white-50 mx-auto mt-2 mb-5">一款免费学习英语的网站</h2>
            <a href="/WEB-INF/jsp/index.jsp" class="btn btn-primary js-scroll-trigger">Welcome to ruiLeXiong!</a>
        </div>
    </div>
</header>

<!-- movie Section -->
<section id="movie" class="about-section text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2 class="text-white mb-4">看美剧学英语</h2>
                <p class="text-white-50">美剧代表作展示
                    <a href="http://startbootstrap.com/template-overviews/grayscale/">不同图片跳转不同导向</a>. 研究中</p>
            </div>
        </div>
        <img src="/img/ipad.png" class="img-fluid" alt="">
    </div>
</section>

<!-- Projects Section -->
<section id="projects" class="projects-section bg-light">
    <div class="container">

        <%--<!-- Featured Project Row -->--%>
        <div class="row align-items-center no-gutters mb-4 mb-lg-5">
            <div class="col-xl-8 col-lg-7">
                <img class="img-fluid mb-3 mb-lg-0" src="/img/bg-masthead.jpg" alt="">
            </div>
            <div class="col-xl-4 col-lg-5">
                <div class="featured-text text-center text-lg-left">
                    <h4>Shoreline</h4>
                    <p class="text-black-50 mb-0">空闲待添加功能!</p>
                </div>
            </div>
        </div>

    </div>
</section>

<%--<!-- Signup Section -->--%>
<section id="signup" class="signup-section">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto text-center">

                <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                <h2 class="text-white mb-5">学习基础发音</h2>
                <form class="form-inline d-flex">
                    <input type="words" class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0" id="inputWord"
                           placeholder="Enter key words...">
                    <button type="submit" class="btn btn-primary mx-auto">查询</button>
                </form>
            </div>
        </div>
    </div>
</section>



<!-- Footer -->
<footer class="bg-black small text-center text-white-50">
    <div class="container">
        Copyright &copy; RuiLeXiong 2018.07.27
    </div>
</footer>
<!-- Bootstrap core JavaScript -->
<script src="/webjars/jquery/3.0.0/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<!-- Custom scripts for this template -->
<script src="/js/grayscale.min.js"></script>

</body>

</html>

<%--<!-- Contact Section -->--%>
<%--<section class="contact-section bg-black">--%>
<%--<div class="container">--%>

<%--<div class="row">--%>

<%--<div class="col-md-4 mb-3 mb-md-0">--%>
<%--<div class="card py-4 h-100">--%>
<%--<div class="card-body text-center">--%>
<%--<i class="fas fa-map-marked-alt text-primary mb-2"></i>--%>
<%--<h4 class="text-uppercase m-0">Address</h4>--%>
<%--<hr class="my-4">--%>
<%--<div class="small text-black-50">4923 Market Street, Orlando FL</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="col-md-4 mb-3 mb-md-0">--%>
<%--<div class="card py-4 h-100">--%>
<%--<div class="card-body text-center">--%>
<%--<i class="fas fa-envelope text-primary mb-2"></i>--%>
<%--<h4 class="text-uppercase m-0">Email</h4>--%>
<%--<hr class="my-4">--%>
<%--<div class="small text-black-50">--%>
<%--<a href="#">hello@yourdomain.com</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="col-md-4 mb-3 mb-md-0">--%>
<%--<div class="card py-4 h-100">--%>
<%--<div class="card-body text-center">--%>
<%--<i class="fas fa-mobile-alt text-primary mb-2"></i>--%>
<%--<h4 class="text-uppercase m-0">Phone</h4>--%>
<%--<hr class="my-4">--%>
<%--<div class="small text-black-50">+1 (555) 902-8832</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="social d-flex justify-content-center">--%>
<%--<a href="#" class="mx-2">--%>
<%--<i class="fab fa-twitter"></i>--%>
<%--</a>--%>
<%--<a href="#" class="mx-2">--%>
<%--<i class="fab fa-facebook-f"></i>--%>
<%--</a>--%>
<%--<a href="#" class="mx-2">--%>
<%--<i class="fab fa-github"></i>--%>
<%--</a>--%>
<%--</div>--%>

<%--</div>--%>
<%--</section>--%>