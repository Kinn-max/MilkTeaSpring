var menu_ts = document.querySelectorAll('.category_list-item.menu_ts');

menu_ts.forEach((menuItem) => {
    var dentail = menuItem.querySelector('.list-dentail');
    var round_round = menuItem.querySelector('.round-round');

    menuItem.addEventListener('click', () => {
        var all_none = document.querySelectorAll('.list-dentail');
        var transform_none = document.querySelectorAll('.round-round')
        for (var i = 0; i < all_none.length; i++) {
            if (all_none[i] !== dentail) {
                all_none[i].classList.remove('toggle-auto');
                transform_none[i].classList.remove('transform-deg');
            }
        }
        
        dentail.classList.toggle('toggle-auto');
        round_round.classList.toggle('transform-deg');
    });
});


var close_dentail = document.querySelector('.close_dentail')
close_dentail.addEventListener('click', (e) =>{
    var center_product = document.querySelector('.center_product')
    center_product.style.display = 'none'
})




function showProductDetails(name, priceM, priceL, image,id) {
    var priceM = parseFloat(priceM);
    var priceL = parseFloat(priceL);
    document.getElementById("idProduct").value = parseFloat(id);
    var productShow = document.getElementById("product-details");
    var nameProduct = document.getElementById("name_center-sp");
    var nameDefault = document.getElementById("price_center-sp");
    var imageMain = document.getElementById("img_center-sp");
    var quantity_show = document.getElementById('quantity_product-show');
    var threeSugar = document.querySelectorAll(".option-sugar.option-size");
    var totalPrice = document.getElementById("total-price");
    var currentPrice= document.getElementById("currentPrice");
    var quantity = 1;
    var checkboxes = document.querySelectorAll('input[name="toppingList"]');
    var optionSizePrice = document.querySelectorAll('input[name="price-option"]');
    var listOptionPrice = document.querySelectorAll(".size_product-pick--name.list-size");
    var priceTopping = 0;
    var priceProduct = (priceM !== 0) ? priceM : priceL;
    var priceProductContent = (priceM !== 0) ? priceM.toLocaleString('vi-VN') + ' đ' : priceL.toLocaleString('vi-VN') + ' đ';
    currentPrice.value =(priceM !== 0) ? priceM : priceL;
    threeSugar[1].checked = true;

    function reset() {
        listOptionPrice.forEach(function(option) {
            option.style.display = "block";
        });
        for(var i = 0 ;i < checkboxes.length;i++){
            checkboxes[i].checked = false
        }
        priceTopping = 0;
        quantity = 1;
    }

    reset();

    // Gán tên, ảnh, giá
    quantity_show.value= quantity
    optionSizePrice[0].value = priceM;
    optionSizePrice[1].value = priceL;
    if (priceM !== 0) {
        optionSizePrice[0].checked = true;
    } else {
        optionSizePrice[1].checked = true;
    }

    nameProduct.textContent = name;
    updateTotalPrice();
    nameDefault.textContent = priceProductContent;
    imageMain.src = "./img/" + image;
    productShow.style.display = 'flex';

    var quantity_minus = document.querySelector('.quantity_product-mul');
    var quantity_plus = document.querySelector('.quantity_product-plus');

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('click', function() {
            if (checkbox.checked) {
                priceTopping += parseFloat(checkbox.value);
            } else {
                priceTopping -= parseFloat(checkbox.value);
            }
            updateTotalPrice();
        });
    });

    if (priceM === 0) {
        listOptionPrice[0].style.display = "none";
    }
    if (priceL === 0) {
        listOptionPrice[1].style.display = "none";
    }

    optionSizePrice.forEach(function(optionSize) {
        optionSize.addEventListener('click', function() {
            if (optionSize.checked) {
                priceProduct = parseFloat(optionSize.value);
                currentPrice.value = parseFloat(optionSize.value);
                nameDefault.textContent = parseFloat(optionSize.value).toLocaleString('vi-VN') + ' đ';
                updateTotalPrice();
            }
        });
    });

    function changeQuantity(tmp) {
        return function() {
            if (tmp === 1) {
                quantity++;
            } else if (tmp === -1 && quantity > 1) {
                quantity--;
            }
            quantity_show.value = quantity;
            updateTotalPrice();
        };
    }

    function updateTotalPrice() {
        totalPrice.value = (quantity * (priceProduct + priceTopping)).toFixed(2);
    }

    quantity_plus.addEventListener('click', changeQuantity(1));
    quantity_minus.addEventListener('click', changeQuantity(-1));
}





