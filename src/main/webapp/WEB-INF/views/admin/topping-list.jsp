<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url value="/api/category" var="ApiCategory"/>
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
                Tùy chọn topping
            </div>
            <div class="close_dentail">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="table_add width-add-option">
            <form:form  id="formTopping" modelAttribute="toppingDTO"  >
                <div class="both-label--input">
                    <label for="">Tên topping:</label><br>
                   <form:input  type="text" path="name" class="width-input" value="${toppingDTO.name}" />
                </div>
                <div class="both-label--input">
                    <label for="">Giá topping:</label><br>
                   <form:input  type="number" path="price" class="width-input" value="${toppingDTO.price}" />
                </div>
                <div class="form-button" style="display: flex;justify-content: center;">
                    <button class="add-cart max-width  add-cart--ad " id="addTopping" >Thêm topping</button>
                </div>
            </form:form>
        </div>

    </div>
</div>
<div class="menu_show menu_show-ad">
    <div class="table_add">
        <div class="add-category--new">
            <div class="add-title">Thêm topping</div>
            <i class="fa-solid fa-plus"></i>
        </div>
        <table>
            <tr>
                <th>Mã topping</th>
                <th>Tên topping</th>
                <th>Giá topping</th>
                <th>Tùy chọn</th>
            </tr>

            <c:forEach var="item" items="${toppingList}" >
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>
                        <div class="three-item">
                            <div class="three-item">
                                <div class="option-user-role" title="Xóa" onclick="deteleTopping(${item.id})">
                                    <i class="fas fa-trash"></i>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <div class="paging">
            <ul class="pagination">
                <li class="pagination-item"><a href="javascript:void(0)">«</a></li>
                <li class="pagination-item"><a class="w3-red" href="javascript:void(0)">1</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">2</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">3</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">4</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">5</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">6</a></li>
                <li class="pagination-item"><a href="javascript:void(0)">»</a></li>
            </ul>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script >
    var notifyAmongValue = "";
    function deteleTopping(id){
        if(id != null){
           $.ajax({
            type: "Delete",
            url : "/api/topping/"+id,
            contentType: "application/json", // Định dạng khi gửi đến máy chủ
            dataType: "JSON", // Định dạng dữ liệu khi máy chủ gửi về
            success: function(response){
                console.log(response.message);
                notifyAmongValue += response.message + "";
                updateNotification();
            },
            error: function(response){
                console.log("error");
                console.log(response);
            }
            });
        }


    }
    function addTopping() {
        var data = {};
        var formData = $('#formTopping').serializeArray();
       $.each(formData,function(i,v){
           data[""+v.name+""] = v.value
        })
        if(data['name'] != "" && data['price'] != ""){
            callApiSaveTopping(data)
        }else {
             window.location.href ="/admin/topping-list"
        }

    }

    function callApiSaveTopping(data) {
        $.ajax({
            type: "POST",
            url: "/api/topping",
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
        $('#addTopping').click(function(event) {
            event.preventDefault();
            addTopping();
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
                    window.location.href = "/admin/topping-list";
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