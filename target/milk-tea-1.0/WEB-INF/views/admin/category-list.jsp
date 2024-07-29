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
                Tùy chọn danh mục
            </div>
            <div class="close_dentail">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="table_add width-add-option">
            <form:form  id="formCategory"  enctype="multipart/form-data" >
                <div class="both-label--input">
                    <label for="namedanhmuc">Tên danh mục:</label><br>
                    <input type="text" class="width-input"  name="name-category" id="namedanhmuc" ><br>
                </div>
                <div class="both-label--input file-show-center">
                    <label for="file-name" id="area-file">
                        <input type="file" hidden id="file-name"  name="file-category">
                        <div id="img-view">
                            <img src="../img/508-icon.png" alt="">
                            <p>Tải ảnh danh mục<br> lên ở đây</p>
                            <span>Chọn ảnh từ thư viện</span>
                        </div>
                    </label>
                </div>
                <div class="form-button" style="display: flex;justify-content: center;">
                    <button class="add-cart max-width  add-cart--ad " id="addOrUploadCategory" value="add-category" name="o">Thêm danh mục</button>
                </div>
            </form:form>
        </div>

    </div>
</div>
<div class="menu_show menu_show-ad">
    <div class="table_add">
        <div class="add-category--new">
            <div class="add-title">Thêm danh mục</div>
            <i class="fa-solid fa-plus"></i>
        </div>
        <table>
            <tr>
                <th>Mã danh mục</th>
                <th>Tên danh mục</th>
                <th>Ảnh danh mục</th>
                <th>Tùy chọn</th>
            </tr>

            <c:forEach var="item" items="${categoryList}" >
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td >
                        <img src="../img/${item.image}" alt="Girl" width="80" height="80">
                    </td>
                    <td>
                        <div class="three-item">
                            <div class="three-item">
                                <div class="option-user-role" title="Xóa" onclick="deteleCategory(${item.id})">
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
        function deteleCategory(id){
            if(id != null){
                var type = "DELETE";
                callApiCategory(id,type)
            }
        }
        var notifyAmongValue = "";
      function addOrUploadCategory() {
             var formData = new FormData($("#formCategory")[0]);
             callApiSaveCategory(formData);
        }

        function callApiSaveCategory(formData) {
            $.ajax({
                type: "POST",
                url: "/api/category",
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

        $(document).ready(function(){
            $('#addOrUploadCategory').click(function(event){
                event.preventDefault(); // Ngăn chặn hành động mặc định của nút
                addOrUploadCategory();
            });
        });


        function callApiCategory(data,type){
            $.ajax({
                type: type+"",
                url : "/api/category/"+data,
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
                    window.location.href = "/admin/category-list";
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