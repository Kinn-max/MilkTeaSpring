<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaweb.Security.utils.SecurityUtils" %>
<header>
    <nav class="title">
        <div class="title_center">
            <div class="title_center-all">
                <a href="/home">
                    <div class="img_shop">
                        <img src="img/logo.png" alt="" class="img_shop-picture">
                    </div>
                </a>
                <ul class="title_list">
                    <li class="title_list-item">
                        <a href="/home" class="title_list-new">TRANG CHỦ</a>
                    </li>
                    <li class="title_list-item">
                        <a href="#" class="title_list-new">GIỚI THIỆU</a>
                    </li>
                    <li class="title_list-item item_product-all">
                        <a href="/store" class="title_list-new">SẢN PHẨM</a>
                        <div class="title_list-product">
                            <div class="title_list-item--product">
                                <a href="">Trà sữa</a></div>
                            <div class="title_list-item--product">
                                <a href="">Trà giải nhiệt</a></div>
                            <div class="title_list-item--product">
                                <a href="">Giày dép</a></div>
                            <div class="title_list-item--product">
                                <a href="">Giày dép</a></div>
                        </div>

                    </li>
                    <li class="title_list-item">
                        <a href="" class="title_list-new">TIN TỨC</a>
                    </li>
                </ul>
                <div class="both_right">
                    <div class="title_search">
                        <input type="text" class="title_search-ip" placeholder="Tìm kiếm!" >
                        <div class="title_search-glass">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </div>
                    </div>
                    <div class="title_signCart">
                        <div class="title_signCart-user">
                            <security:authorize access = "isAuthenticated()">
                                <span class="text_name-user">Xin chao, <%=SecurityUtils.getPrincipal().getUsername()%></span>
                            </security:authorize>
                            <i class="fa-solid fa-user"></i>
                            <ul class="title_user-list">
                            <security:authorize access = "isAuthenticated()">
                                 <li class="title_user-list-li">
                                        <a  href="<c:url value='#'/>">Thay doi mat khau</a>
                                 </li>
                                <li class="title_user-list-li">
                                        <a  href="<c:url value='#'/>">Kiem tra don hang</a>
                                </li>
                                <li class="title_user-list-li">
                                        <a  href="<c:url value='#'/>">Cap nhat thong tin</a>
                                </li>
                                <li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>">Thoát</a></li>
                            </security:authorize>
                             <security:authorize access = "isAnonymous()">
                                 <li class="title_user-list-li">
                                    <a  href="<c:url value='/register'/>">Đăng ký</a>
                                </li>
                                <li class="title_user-list-li">
                                    <a  href="<c:url value='/sign-in'/>">Đăng nhập</a>
                                </li>
                            </security:authorize>
                            </ul>
                        </div>
                        <div class="title_signCart-cart">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <ul class="title_cart-list">
                            <security:authorize access = "isAnonymous()">
                                <li class="title_cart-list--all">
                                        <div class="title_cart-list--name">
                                            <p style="text-align: center;width: 100%;">Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng</p>
                                        </div>
                                </li>
                            </security:authorize>
                            <security:authorize access = "isAuthenticated()">
                             <c:forEach var="item" items="${}" >
                                 ${item})
                             </c:forEach>
                                <li class="title_cart-list--all">
                                    <div class="title_cart-list--img">
                                        <img src="img/logo.png" alt="">
                                    </div>
                                    <div class="title_cart-list--name">
                                        <p>Đây là tên của ảnh</p>
                                    </div>
                                </li>
                                <li class="title_cart-list--all">
                                    <div class="title_cart-list--img">
                                        <img src="img/img_big/img1.jpg" alt="">
                                    </div>
                                    <div class="title_cart-list--name">
                                        <p>Đây là tên của ảnh</p>
                                    </div>
                                </li>
                                <div class="title_cart-list--more">
                                    <a href="">Xem thêm</a>
                                </div>
                            </security:authorize>
                            </ul>
                        </div>
                        <div class="title_signCart-bar">
                            <i class="fa-solid fa-bars"></i>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </nav>

</header>