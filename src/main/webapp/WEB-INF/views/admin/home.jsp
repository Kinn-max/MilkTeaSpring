<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Trang chủ</title> -->
</head>
<body>
<div class="notify_among">
    <span class="text-notify_among"></span>
    <div class="control_notify"></div>
</div>
<div class="center_product " id="detail-options">
    <div class="center_product-dentail center_product-dentail-ad">
        <div class="both-context" style="font-size: 2rem; ">
            <div class="name-option">
                Chi tiết đơn hàng
            </div>
            <div class="close_dentail">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="table_add width-add-option">
            <div class="title-detail--wait">
                <div id="title-delivery" class="title-name-address" style="display: flex">


                </div>
            </div>
            <div class="content-detail-wait">
                <h3>Đơn hàng gồm có</h3>
                <div id="content-list-product" >

                </div>

            </div>
        </div>
    </div>
</div>
<div class="menu_show menu_show-ad">
    <div class="table_add">
        <div class="main-dashboard">
            <div class="main-dashboard--item">
                <div class="both-iconandcontent">
                    <div class="icon-dashboard">
                        <i class="fa-solid fa-money-bill"></i>
                    </div>
                    <div class="content-dashboard">
                        ĐƠN HÀNG
                        <span>9</span>
                    </div>
                </div>
                <div class="both-iconandcontent">
                    <div class="icon-dashboard icon-dashboard-2">
                        <i class="fa-solid fa-dollar-sign"></i>
                    </div>
                    <div class="content-dashboard">
                        TỔNG DOANH THU
                        <span>100,000,000 vnđ</span>
                    </div>
                </div>
                <div class="both-iconandcontent ">
                    <div class="icon-dashboard icon-dashboard-3">
                        <i class="fa-solid fa-feather"></i>
                    </div>
                    <div class="content-dashboard">
                        SẢN PHẨM
                        <span>9</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="order-active">
            <div class="order-show--list">
                <div style="font-size: 1.6rem; padding: 10px 0 10px 0;    border-bottom: 1px solid rgba(0, 0, 0, 0.15);">Đơn hàng chờ xác nhận</div>
                <table >
                    <tr>
                        <th>Tên khách hàng</th>
                        <th>Ngày, giờ đặt hàng</th>
                        <th>Số sản phẩm</th>
                        <th>Trạng thái</th>
                        <th>Thao tác</th>
                    </tr>
                    <c:forEach items="${orderDTOList}" var="item">

                        <tr>
                            <td>${item.receiver}</td>
                            <td>${item.createdDate}</td>
                            <td>${item.quantityProduct}</td>
                            <td>${item.status}</td>
                            <td>
                                <div class="three-item">
                                    <div  class="option-user--fix" onclick="callApiAndShowDetail(${item.id})" title="Xem chi tiết">
                                        <i class="fa-solid fa-eye"></i>
                                    </div>
                                    <div class="option-user-role"  onclick="callApiActiveDetailOrder(${item.id})">
                                        <i class="fa-solid fa-check"></i>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                </table>

            </div>
        </div>

    </div>

</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    var showDetail = document.querySelectorAll(".option-user--fix")
    var  notifyAmongValue = ""
    function  callApiActiveDetailOrder(id){
        $.ajax({
            type: "POST",
            url : "/api/detail-order/"+id,
            contentType: "application/json", // Định dạng khi gửi đến máy chủ
            dataType: "JSON",
            success: function(response){
                notifyAmongValue += response.message
                updateNotification()
            },
            error: function(response){

            }
        });
    }

    function callApiAndShowDetail(id){
        $.ajax({
            type: "GET",
            url : "/api/detail-order/"+id,
            contentType: "application/json", // Định dạng khi gửi đến máy chủ
            dataType: "JSON",
            success: function(response){
                console.log(response)
                var  titleDetail = "";
                titleDetail += "<ul>";
                titleDetail += "<li>Tên người nhận: "+response.receiver+"</li>";
                titleDetail += "<li>Số điện thoại : "+response.phoneReceiver+"</li>";
                titleDetail += "</ul>";
                titleDetail += "<ul>";
                titleDetail += "<li>Địa chỉ nhận: "+response.addressReceiver+"</li>";
                titleDetail += "</ul>";
                $("#title-delivery").html(titleDetail)
                var contentDetail = "";
                $.each(response.orderResponseDTOList, function(index, item) {
                    contentDetail += "<ul class='style-ul--detail'>";
                    contentDetail += "<li>" +"- Tên sản phẩm: "+item.product.name +" (size"+(item.currentPrice=== item.product.priceL? " L)" : " M)")+"</li>";
                    contentDetail +=  "<li>" +"- Số lượng: "+item.quantity +"</li>";
                    contentDetail +=  "<li>" +"- Topping: "+item.nameTopping +"</li>";
                    contentDetail +=  "<li>" +"- Hết: "+item.totalCurrent +"</li>";
                    contentDetail += "</ul>";
                });
                contentDetail +="<div>Tổng: "+response.totalPrice+ "</div>"
                $("#content-list-product").html(contentDetail)
                 document.getElementById("detail-options").style.display = "flex"

            },
            error: function(response){
                console.log("error");
                console.log(response);
            }
        });
    }

    var close_dentail = document.querySelector('.close_dentail')
    close_dentail.addEventListener('click', (e) =>{
        var center_product = document.querySelector('.center_product')
        center_product.style.display = 'none'
    })
    // create notify after edit
    function updateNotification() {
        const notifyAmong = document.querySelector(".notify_among");
        var textNotifyAmong = document.querySelector(".text-notify_among");
        var progressBar = document.querySelector(".control_notify");

        if(notifyAmongValue.length > 0){
            notifyAmong.classList.add("active-show");
            textNotifyAmong.innerHTML = notifyAmongValue;
            // Ẩn thông báo sau 3 giây
            setTimeout(function (){
                hideNotification()
                window.location.href = "/admin/home";
            }, 3000);
            var width = progressBar.clientWidth;
            var widthDele = width / 200;
            var interval = setInterval(function() {
                if (width <= 0) {
                    clearInterval(interval);
                } else {
                    width -= widthDele;
                    progressBar.style.width = width + "px";
                }
            }, 20);
        }
    }

    function hideNotification() {
        const notifyAmong = document.querySelector(".notify_among");
        notifyAmong.classList.remove("active-show");
    }

</script>
</body>
</html>