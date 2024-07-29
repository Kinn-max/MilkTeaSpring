<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Danh sách người dùng
    </title>
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
                Cập nhật người dùng
            </div>
            <div class="close_dentail">
                <i class="fa-solid fa-xmark"></i>
            </div>
        </div>
        <div class="table_add width-add-option">
                <form:form  id="formUserEdit" modelAttribute="userResponse"  >
                  <form:hidden path="id" value="${userResponse.id}" id="id-user" />
                    <div class="both-label--input">
                        <label for="">Họ và tên:</label><br>
                       <form:input  type="text" path="fullName" class="width-input" value="${userResponse.fullName}" />
                    </div>
                    <div class="both-label--input">
                        <label for="">Tên đăng nhập:</label><br>
                       <form:input  type="text" path="nameUser" class="width-input" value="${userResponse.nameUser}" />
                    </div>
                     <div class="both-label--input">
                        <label for="">Email:</label><br>
                       <form:input  type="text" path="email" class="width-input" value="${userResponse.email}" />
                    </div>
                     <div class="both-label--input">
                        <label for="">Mật khẩu:</label><br>
                       <form:input  type="text" path="passWord" class="width-input" value="${userResponse.passWord}" />
                    </div>
                     <div class="both-label--input">
                        <label for="">Số điện thoại:</label><br>
                       <form:input  type="text" path="phoneNumber" class="width-input" value="${userResponse.phoneNumber}" />
                    </div>
                    <div class="both-label--input">
                        <label for="">Địa chỉ:</label><br>
                       <form:input  type="text" path="address" class="width-input" value="${userResponse.address}" />
                    </div>
                    <div class="form-button" style="display: flex;justify-content: center;">
                        <button class="add-cart max-width  add-cart--ad " id="addEdit" >Cập nhật người dùng</button>
                    </div>
                </form:form>
        </div>

    </div>
</div>
<div class="menu_show menu_show-ad">
    <div class="table_add">
        <div class="add-category--new">
            <div class="add-title">Thêm tài khoản</div>
            <i class="fa-solid fa-plus"></i>
        </div>
        <table>
            <tr>
                <th>STT</th>
                <th>Tên người dùng</th>
                <th>Email</th>
                <th>Ngày tạo</th>
                <th>Khóa</th>
                <th>Ủy quyền</th>
                <th>Tùy chọn</th>
            </tr>
            <c:forEach var="item" items="${listUser}" >
                 <tr>
                    <td>${item.id}</td>
                    <td>${item.fullName}</td>
                    <td>${item.email}</td>
                    <td>${item.createDate}</td>
                     <td>
                        <label class="switch">
                            <input type="checkbox" >
                            <span class="slider"></span>
                        </label>
                    </td>
                    <td>${item.email}</td>
                    <td>
                        <div class="three-item">
                            <div class="option-user--fix" title="Chỉnh sửa" onclick="nextPage(${item.id})">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </div>
                            <div class="option-user-role" title="Ủy quyền">
                                <i class="fa-solid fa-check"></i>
                            </div>
                            <div class="option-user-delete" title="Xóa">
                                <i class="fas fa-trash"></i>
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

    function nextPage(id){
        window.location.href = "/admin/user-edit-"+id+"?action=edit";
    }
    var notifyAmongValue = "";
    function addEdit() {
        var data = {};
        var formData = $('#formUserEdit').serializeArray();
        $.each(formData,function(i,v){
            data[""+v.name+""] = v.value
        })
        if(data['userName'] != "" && data['fullName'] != "" && data['email'] != ""){
            callApiSaveUser(data)
        }else {
            window.location.href ="/admin/user-list"
        }

    }


    function callApiSaveUser(data) {
        $.ajax({
            type: "POST",
            url: "/api/user",
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
        $('#addEdit').click(function(event) {
            event.preventDefault();
            addEdit();
        });
    });
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
                window.location.href = "/admin/user-list";
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