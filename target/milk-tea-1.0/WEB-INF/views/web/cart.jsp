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
        <form:form id="formDetailOrder" modelAttribute="userResponseDTO">
        <div class="option_checkout">
            <div class="option_checkout-here">
                <h3>Thông tin giao hàng</h3>
                <div class="information_client">
                    <i class="fa-solid fa-user"></i>
                    <input  type="text" name="receiver" value="${userResponseDTO.fullName}" laceholder="Tên người nhận">
                </div>
                <div class="information_client">
                    <i class="fa-solid fa-phone"></i>
                    <input  type="text" name="phoneReceiver" value="${userResponseDTO.phoneNumber}"  placeholder="Số điện thoại người nhận">
                </div>
                <div class="delivery">Giao đến</div>
                <div class="information_client">
                    <i class="fa-solid fa-location-dot"></i>
                    <input  type="text" name="addressReceiver" value="${userResponseDTO.address}" placeholder="Địa chỉ">
                </div>
                <div class="information_client">
                    <i class="fa-solid fa-note-sticky"></i>
                    <input  type="text" name="note"  placeholder="Ghi chú thêm (địa chỉ, lời nhắn...)">
                </div>
                <div class="option_pay">
                    <div class="option_pay-text">Phương thức thanh toán</div>
                    <div class="option_pay-pick">
                        <div class="size_product-pick--name">
                            <input class="option-size" type="radio" id="radio1" checked value="afterReceive" name="payment" />
                            <label for="radio1">Thanh toán khi nhận hàng</label>
                        </div>
                        <div class="size_product-pick--name">
                            <input class="option-size" type="radio" id="radio2" value="beforeReceive" name="payment" />
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
                     <c:forEach var="item" items="${orderList}" >
                         <div class="delivery_both">
                            <div class="delivery_both-img">
                                <img src="./img/${item.product.image}" alt="">
                            </div>
                            <div class="delivery_both-texxt">
                                <span>${item.product.name} + (size ${item.product.priceL == item.currentPrice ? "L" : "M"})</span>
                                <p>Topping: ${item.nameTopping}</p>
                                <div class="dentail_tmp formatPrice" total-price="${item.totalCurrent}" quantity="${item.quantity}" data-price="${item.currentPrice}">

                                </div>
                            </div>
                        </div>
                     </c:forEach>
                </div>
                <div class="quantity_all-glass">
                    <div class="quantity_and_price">
                        <c:set var="totalCup" value="0" />
                        <c:forEach var="item" items="${orderList}">
                            <c:set var="totalCup" value="${totalCup + item.quantity}" />
                        </c:forEach>
                        <div class="quantity_total">
                            Số lượng cốc : <span>${totalCup} cốc</span>
                            <input type="hidden"  name="quantityProduct" value="${totalCup}"/>
                        </div>
                        <c:set var="totalPriceDetails" value="0" />
                        <c:forEach var="item" items="${orderList}">
                            <c:set var="totalPriceDetails" value="${totalPriceDetails + item.totalCurrent}" />
                        </c:forEach>
                        <div class="price_total">
                            Tổng cộng : <span>${totalPriceDetails}</span>
                            <input type="hidden"  name="totalPrice" value="${totalPriceDetails}"/>
                        </div>
                    </div>
                    <div class="order_now add-option--now ">
                        <button class="buy-now-click hover_button-red"  id="addDetailOrder">Đặt hàng ngay</button>
                    </div>
                    <div class="add-option--now continue_buy-product ">
                        <span><a href="/store" style="color: white">TIẾP TỤC MUA HÀNG</a></span>
                    </div>
                </div>
            </div>
        </div>
        </form:form>

    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // format vnd
    var priceElements = document.querySelectorAll('.formatPrice');
    priceElements.forEach(function(priceElement) {
        var s = ""
        var price = parseFloat(priceElement.getAttribute('data-price'));
        var quantity  = parseFloat(priceElement.getAttribute('quantity'));
        var totalPrice = parseFloat(priceElement.getAttribute('total-price'))
        s += price.toLocaleString('vi-VN') + ' đ  x  '+quantity+" = ";
        s += totalPrice.toLocaleString('vi-VN') + ' đ';
        priceElement.textContent = s;
    });
    // call api
    var notifyAmongValue = "";
    function addDetailOrder(){
        var data = {}
        var formData = $('#formDetailOrder').serializeArray();
        $.each(formData,function(i,v){
            if(v.name != 'payment'){
                data[""+v.name+""] = v.value
            }
        })
        var selectedPayment = $('input[name="payment"]:checked').val();
        data["payment"] = selectedPayment
        $.ajax({
            type: "POST",
            url: "api/buy-now",
            data: JSON.stringify(data),
            contentType: "application/json", // định dạng khi gửi đến máy chủ
            dataType: "JSON", // khi be gửi về
            success: function(response) {
                console.log(response.message);
                notifyAmongValue += response.message + "";
                updateNotification();
            },
            error: function(response) {
                console.log("error");
                console.log(response);
            }
        });
    }
    $(document).ready(function() {
        $('#addDetailOrder').click(function(event) {
            event.preventDefault();
            addDetailOrder();
        });
    });

</script>
</body>
</html>
