<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>



<div class="category category-ad">
    <div class="both_first">
        <h3>Danh mục</h3>
        <div class="click_option">
            <i class="fa-solid fa-bars"></i>
        </div>
    </div>
    <ul class="category_list">
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <div class="both_icon">
                    <i class="fa-solid fa-bell"></i>
                    <p>Đơn hàng hôm nay</p>
                </div>
                <div class="round-round">
                    <i class="fa-solid fa-chevron-down"></i>
                </div>
            </div>
            <div class="list-dentail" >
                <ul>
                    <a href="">
                        <li class="list-dentail--item">Đã đặt hàng</li>
                    </a>
                    <li class="list-dentail--item">Đã bán</li>
                    <li class="list-dentail--item">Đã hủy</li>
                </ul>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <div class="both_icon">
                    <i class="fa-solid fa-calendar-week"></i>
                    <p>Tùy chọn danh mục</p>
                </div>
                <div class="round-round">
                    <i class="fa-solid fa-chevron-down"></i>
                </div>
            </div>
            <div class="list-dentail" >
                <ul>
                    <a href="/admin/category-list">
                        <li class="list-dentail--item">Thêm danh mục</li>
                    </a>
                </ul>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <div class="both_icon">
                    <i class="fa-solid fa-layer-group"></i>
                    <p>Tùy chọn sản phẩm</p>
                </div>
                <div class="round-round">
                    <i class="fa-solid fa-chevron-down"></i>
                </div>
            </div>
            <div class="list-dentail" >
                <ul>
                    <a href="/admin/product-list">
                        <li class="list-dentail--item">Thêm sản phẩm</li>
                    </a>
                </ul>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <a href="/admin/order">
                    <div class="both_icon">
                        <i class="fa-solid fa-square"></i>
                        <p>Order</p>
                    </div>
                </a>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <a href="/admin/topping-list">
                    <div class="both_icon">
                        <i class="fa-solid fa-ranking-star"></i>
                        <p>Tùy chọn topping</p>
                    </div>
                </a>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <a href="">
                    <div class="both_icon">
                        <i class="fa-solid fa-sliders"></i>
                        <p>Sửa slide</p>
                    </div>
                </a>
            </div>
        </li>
        <li class="category_list-item menu_ts">
            <div class="show_category-both">
                <div class="both_icon">
                    <div class="both_icon">
                        <i class="fa-solid fa-users"></i>
                        <p>Quản lý khách hàng</p>
                    </div>
                </div>
                <div class="round-round">
                    <i class="fa-solid fa-chevron-down"></i>
                </div>
            </div>
            <div class="list-dentail" >
                <ul>
                    <a href="/admin/user-list">
                        <li class="list-dentail--item">Xóa hoặc chỉnh sửa khách hàng</li>
                    </a>
                </ul>
            </div>
        </li>
    </ul>
    <div class="bottom_menu">
        <div class="both_icon">
            <i class="fa-solid fa-house"></i>
        </div>
        <a href="/home">
            <span>Giao diện web</span>
        </a>
    </div>
</div>