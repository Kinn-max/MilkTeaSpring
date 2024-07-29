<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
</head>
<body>
<div class="wrap">
    <div class="title_center ">
        <div class="option_checkout">
            <div class="option_checkout-here">
                <h3>Thông tin giao hàng</h3>
                <div class="information_client">
                    <i class="fa-solid fa-user"></i>
                    <input  type="text" name="" id="" placeholder="Tên người nhận">
                </div>
                <div class="information_client">
                    <i class="fa-solid fa-phone"></i>
                    <input  type="text" name="" id="" placeholder="Số điện thoại người nhận">
                </div>
                <div class="delivery">Giao đến</div>
                <div class="information_client">
                    <i class="fa-solid fa-location-dot"></i>
                    <input  type="text" name="" id="" placeholder="Địa chỉ">
                </div>
                <div class="information_client">
                    <i class="fa-solid fa-note-sticky"></i>
                    <input  type="text" name="" id="" placeholder="Ghi chú thêm (địa chỉ, lời nhắn...)">
                </div>
                <div class="option_pay">
                    <div class="option_pay-text">Phương thức thanh toán</div>
                    <div class="option_pay-pick">
                        <div class="size_product-pick--name">
                            <input class="option-size" type="radio" id="radio1" name="group-radio" />
                            <label for="radio1">Thanh toán khi nhận hàng</label>
                        </div>
                        <div class="size_product-pick--name">
                            <input class="option-size" type="radio" id="radio2" name="group-radio" />
                            <label for="radio2">Thanh toán bằng momo</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="option_checkout-store">
                <div class="both-title--delivery">
                    <h3>Thông tin đơn hàng</h3>
                    <a href="#">Xóa tất cả</a>
                </div>
                <div class="all_delivery">
                    <div class="delivery_both">
                        <div class="delivery_both-img">
                            <img src="./img/trasua/img1.jpg" alt="">
                        </div>
                        <div class="delivery_both-texxt">
                            <span>Ô Long Sữa Trân Châu Ngũ Cốc + (size)</span>
                            <p>Topping: Trân châu, thạch</p>
                            <div class="dentail_tmp">
                                35.000 x 1 = 35,000d
                            </div>
                        </div>
                    </div>
                    <div class="delivery_both">
                        <div class="delivery_both-img">
                            <img src="./img/trasua/img1.jpg" alt="">
                        </div>
                        <div class="delivery_both-texxt">
                            <span>Ô Long Sữa Trân Châu Ngũ Cốc + (size)</span>
                            <p>Topping: Trân châu, thạch</p>
                            <div class="dentail_tmp">
                                35.000 x 1 = 35,000d
                            </div>
                        </div>
                    </div>


                </div>
                <div class="quantity_all-glass">
                    <div class="quantity_and_price">
                        <div class="quantity_total">
                            Số lượng cốc : <span>3 cốc</span>
                        </div>
                        <div class="price_total">
                            Tổng cộng : <span>80,000đ</span>
                        </div>
                    </div>
                    <div class="order_now add-option--now ">
                        <span><a href="/success.html">ĐẶT HÀNG</a></span>
                    </div>
                    <div class="add-option--now continue_buy-product ">
                        <span><a href="/store.html">TIẾP TỤC MUA HÀNG</a></span>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>
