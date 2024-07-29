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
    <title>Sản phẩm</title>
</head>

<body>
<div class="notify_among">
    <span class="text-notify_among"></span>
    <div class="control_notify"></div>
</div>
<div class="wrap hiden-center">
    <div class="center_product " id="product-details">
        <div class="center_product-dentail">
            <form action="" id="formOrder" method="post">
            <div class="top-teaMilk">
                <input type="hidden"  name="idProduct" id="idProduct"/>
                <input type="hidden"  name="currentPrice" id="currentPrice"/>
                <div class="top-teaMilk-img">
                    <img id="img_center-sp" src="" alt="">
                </div>
                <div class="top-teaMilk-infor">
                        <div class="name_product-title">
                            <h3 id="name_center-sp"></h3>
                            <div class="close_dentail">
                                <i class="fa-solid fa-xmark"></i>
                            </div>
                        </div>
                        <div class="price_product">
                            <span id="price_center-sp"></span>
                        </div>
                        <div class="both-quantity">
                            <div class="quantity_product">
                                <div class="quantity_product-mul" >
                                    <i class="fa-solid fa-minus"></i>
                                </div>
                                <div class="quantity_product-get">
                                        <input type="text"   name="quantity" id="quantity_product-show" >
                                </div>
                                <div class="quantity_product-plus">
                                    <i class="fa-solid fa-plus"></i>
                                </div>
                            </div>
                            <div class="add_product">
                                <input readonly name="totalCurrent"  class="add_product-click width_total" type="text" id="total-price">
                            </div>
                        </div>
                        <div class="total_price-center">
                            <div class="add-option--now">
                                <button class="add-cart hover_button-red" name="product-option"  id="addCart" onclick="addCart(e)">Thêm vào giỏ hàng</button>
                            </div>
                            <div class="add-option--now">
                                <button class="buy-now-click hover_button-red" name="product-option" value="buy-now" id="buyNow">Mua ngay</button>
                            </div>
                        </div>
                </div>
            </div>
            <div class="control_pointer">
                <div class="size_product">
                    <h3>Chọn size</h3>
                    <div class="size_product-pick" id="show-price-size">
                        <div class="size_product-pick--name list-size">
                            <input class="option-size" type="radio" id="radio1" name="price-option" value="size_m" />
                            <label for="radio1">Size M</label>
                        </div>
                        <div class="size_product-pick--name list-size">
                            <input class="option-size" type="radio"  name="price-option" value="size_l" />
                            <label for="radio1">Size L</label>
                        </div>
                    </div>
                </div>
                <div class="size_product">
                    <h3>Chọn đường</h3>
                    <div class="size_product-pick">
                        <c:forEach var="item" items="${sugarList}" >
                            <div class="size_product-pick--name">
                                <input class="option-sugar option-size" value="${item.key}" type="radio" id="radio3" name="sugar" />
                                <label for="radio3">${item.value}</label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="size_product">
                    <h3>Chọn topping</h3>
                    <c:forEach var="item" items="${toppingList}" >
                        <div class="size_product-pick font_more-price">
                            <div class="three_pick-more">
                                <div class="size_product-pick--name">
                                    <input class="option-topping option-size" value="${item.price}" type="checkbox" id="radio_${item.id}" name="toppingList" />
                                    <label for="radio_${item.id}">${item.name}</label>
                                </div>
                            </div>
                            <p class="priceShow" data-price="${item.price}"></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
         </form>
        </div>
    </div>
    <div class="title_center text_center background_boddy">
        <div class="category">
            <h3>Danh mục</h3>
            <ul class="category_list">
                <a href="#">
                    <li class="category_list-item">
                        <p>Món nổi bật</p>
                    </li>
                </a>
                <c:forEach var="item" items="${categoryDTOList}" >
                     <li class="category_list-item menu_ts">
                        <div class="show_category-both">
                            <p>${item.name}</p>
                            <div class="round-round">
                                <i class="fa-solid fa-chevron-down"></i>
                            </div>
                        </div>
                        <div class="list-dentail" >
                            <ul>
                                <a href="#">
                                    <li class="list-dentail--item">Trà sữa trân châu</li>
                                </a>
                                <li class="list-dentail--item">Trà sữa trân châu</li>
                                <li class="list-dentail--item">Trà sữa trân châu</li>
                            </ul>
                        </div>
                     </li>
                </c:forEach>
            </ul>
        </div>
        <div class="show_product">
            <div class="wrap_show wrap_show-break">
                <c:forEach var="item" items="${productDTOList}" >

                    <a class="a_dentail-product"  onclick="showProductDetails('${item.name}','${item.priceM}','${item.priceL}','${item.image}','${item.id}')">
                        <div class="wrap_show-all length_cart">
                            <div class="wrap_show-list width-category">
                                <img src="./img/${item.image}" alt="">
                            </div>
                            <div class="wrap_show-information plus_coversition">
                                <span href="#" class="wrap_show-name--product">${item.name}</span>
                                <div class="wrap_show-price flex_cart">
                                    <p class="priceShow" data-price="${ item.priceM != 0 ? item.priceM : item.priceL}"></p>
                                    <div class="border_circle">
                                        <i class="fa-solid fa-plus"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>

        </div>
        <div class="cart-show">
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    //format vnd
    var priceElements = document.querySelectorAll('.priceShow');
    priceElements.forEach(function(priceElement) {
        var price = parseFloat(priceElement.getAttribute('data-price'));
        var formattedPrice = price.toLocaleString('vi-VN') + ' đ';
        priceElement.textContent = formattedPrice;
    });
    //id:formOrder
    //id:id submit
    //buyNow,addCart
    function addCart(){
        var data = {};
        var selectedSugar = $("input[name='sugar']:checked").val();
        var selectedToppings = [];
        $("input[name='toppingList']:checked").each(function(){
            selectedToppings.push($(this).attr('id').split('_')[1]);
        });
        var idProduct = $("input[name='idProduct']").val();
        var quantity = $("input[name='quantity']").val();
        var totalCurrent = $("input[name='totalCurrent']").val();
        var currentPrice = $("input[name='currentPrice']").val();
        data['sugar']= selectedSugar;
        data['toppingList'] = selectedToppings
        data['idProduct'] = idProduct
        data['quantity'] = quantity
        data['totalCurrent'] = totalCurrent
        data['currentPrice'] = currentPrice
        console.log(data)
        $.ajax({
            type: "POST",
            url: "api/add-cart",
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
        $('#addCart').click(function(event) {
            event.preventDefault();
            addCart();
        });
    });
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
                window.location.href = "/store";
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