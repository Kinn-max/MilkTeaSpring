<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- <title>Trang chủ</title> -->
</head>
<body><div class="notify_among">
    <span class="text-notify_among"></span>
    <div class="control_notify"></div>
</div>
<div class="center_product " id="detail-options">
    <div class="center_product-dentail center_product-dentail-ad">
        <div class="both-context" style="font-size: 2rem; ">
            <div class="name-option">
                Tùy chọn sản phẩm
            </div>
            <div class="close_dentail">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="table_add width-add-option">
            <form:form  id="formProduct" modelAttribute="productDTO"  enctype="multipart/form-data" >
                   <form:hidden path="id" value="${productDTO.id}" id="id-product" />
                <div class="both-label--input">
                    <label for="namedanhmuc">Tên sản phẩm:</label><br>
                     <form:input  type="text" path="name" class="width-input" id="namedanhmuc" value="${productDTO.name}" />
                 </div>
                <div class="both-label--input">
                    <label for="">Giá size M:</label><br>
                   <form:input  type="number" path="priceM" class="width-input" value="${productDTO.priceM}" />
                </div>
                 <div class="both-label--input">
                    <label for="">Giá size L:</label><br>
                 <form:input  type="number" path="priceL" class="width-input" value="${productDTO.priceL}" />
                </div>
                <div class="both-label--input">
                    <label for="">Thuộc danh mục:</label><br>
                  <form:select class="width-input" path="nameCategory">
                        <form:option value="">--Danh mục--</form:option>
                        <form:options items="${categoryList}" itemValue="id" itemLabel="name" />
                   </form:select>
                </div>

                <div class="both-label--input file-show-center">
                    <label for="file-name" id="area-file">
                        <input type="file" hidden id="file-name"  name="file-product">
                        <div id="img-view">
                            <img src="../img/508-icon.png" alt="">
                            <p>Tải ảnh sản phẩm<br> lên ở đây</p>
                            <span>Chọn ảnh từ thư viện</span>
                        </div>
                    </label>
                </div>
                <div class="form-button" style="display: flex;justify-content: center;">
                    <button class="add-cart max-width  add-cart--ad " id="addOrUploadProduct" value="add-category" name="o">Thêm sản phẩm</button>
                </div>
            </form:form>
        </div>

    </div>
</div>
<div class="menu_show menu_show-ad">
    <div class="table_add">
        <div class="add-category--new">
            <div class="add-title">Thêm sản phẩm</div>
            <i class="fa-solid fa-plus"></i>
        </div>
        <table>
            <tr>
                <th>STT</th>
                <th>Mã sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Giá size M</th>
                <th>Giá size L</th>
                <th>Thuộc danh mục</th>
                <th>Ảnh sản phẩm</th>
                <th>Tùy chọn</th>
            </tr>
            <c:forEach items="${productList}" var="item">

                <tr>
                    <td>1</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td class="price" data-price="${item.priceM}"></td>
                    <td class="price" data-price="${item.priceL}"></td>
                    <td>${item.nameCategory}</td>
                    <td >
                        <img src="../img/${item.image}" alt="Girl" width="80" height="80">
                    </td>
                    <td>
                        <div class="three-item">
                            <div class="three-item">
                                <div class="option-user--fix" title="Chỉnh sửa" onclick="editProduct(${item.id})">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                </div>
                                <div class="option-user-role" title="Xóa" onclick="deteleProduct(${item.id})">
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
<script>
    // edit product
        function editProduct(id){
            window.location.href = "/admin/product-list-"+id+"?action=edit";
        }

    //format vnd
    var priceElements = document.querySelectorAll('.price');
    priceElements.forEach(function(priceElement) {
        var price = parseFloat(priceElement.getAttribute('data-price'));
        var formattedPrice = price.toLocaleString('vi-VN') + ' đ';
        priceElement.textContent = formattedPrice;
    });
    // delete product
      function deteleProduct(id){
            if(id != null){
                var type = "DELETE";
                callApiProduct(id,type)
            }
        }
    var notifyAmongValue = "";
    function addOrUploadProduct() {
        var formData = new FormData($('#formProduct')[0]); // Create a FormData object

        // Validate the necessary fields
        if ((formData.get('priceL') !== "" || formData.get('priceM') !== "") && formData.get('name') !== "") {
            callApiSaveProduct(formData);
        }
    }

    function callApiSaveProduct(formData) {
        $.ajax({
            type: "POST",
            url: "/api/product",
            enctype: "multipart/form-data",
            data: formData,
            processData: false, // Không xử lý dữ liệu
            contentType: false, // Không thiết lập tiêu đề contentType
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
        $('#addOrUploadProduct').click(function(event) {
            event.preventDefault();
            addOrUploadProduct();
        });
    });



    function callApiProduct(data,type){
            $.ajax({
                type: type+"",
                url : "/api/product/"+data,
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
                    window.location.href = "/admin/product-list";
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