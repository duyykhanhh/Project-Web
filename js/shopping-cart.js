// let minus_btn = document.getElementByCl("minus");
// let plus_btn = document.getElementById("plus");


// function minusQuantity() {

// let value = document.getElementById("cart-quantity-input").value;
// if(parseInt(value)<2){
//     return document.getElementById("cart-quantity-input").value=1;
// }
// else {
//     document.getElementById("cart-quantity-input").value = parseInt(value) - 1;
// }

//     let value = document.getElementsByClassName("cart-quantity-input");
//     let len = value.length;
//     for (let i = 0; i < length ; i++) {
//         if(parseInt(value.item(i).innerHTML)>98){
//             return document.getElementsByClassName("cart-quantity-input")[i] = 99;
//         }
//         else{
//             return document.getElementsByClassName("cart-quantity-input")[i] = parseInt(value[i])-1;
//         }
//     }
// }

// function plusQuantity() {
// let value = document.getElementById("cart-quantity-input").value;
// if(parseInt(value)>98){
//     return document.getElementById("cart-quantity-input").value=99;
// }
// document.getElementById("cart-quantity-input").value = parseInt(value) + 1;
//     let value = document.getElementsByClassName("cart-quantity-input");
//     let len = value.length;
//     for (let i = 0; i < length ; i++) {
//         if(parseInt(value.item(i).innerHTML)<2){
//             return document.getElementsByClassName("cart-quantity-input")[i] = 1;
//         }
//         else{
//             return document.getElementsByClassName("cart-quantity-input")[i] = parseInt(value[i])+1;
//         }
//     }
//
// }

// minus_btn.addEventListener("click", minusQuantity);
// plus_btn.addEventListener("click", plusQuantity);
let minus_btn = document.getElementsByClassName('minus');
let plus_btn = document.getElementsByClassName('plus');

let minus_leng = minus_btn.length;
let plus_leng = plus_btn.length;
for (i = 0; i < minus_leng; i++) {
    let button = minus_btn.item(i);
    button.addEventListener('click', function (event) {
        var buttonClicked = event.target;
        // console.log(buttonClicked);
        var input = buttonClicked.parentElement.children[1];
        // console.log(input)
        var inputValue = input.value;
        // console.log(inputValue);
        if (inputValue < 2) {
            input.value = 1;
        } else {
            input.value = parseInt(inputValue) - 1;
        }
        updateCart();
    })
}
;

for (i = 0; i < plus_leng; i++) {
    let button = plus_btn.item(i);
    button.addEventListener('click', function (event) {
        var buttonClicked = event.target;
        // console.log(buttonClicked);
        var input = buttonClicked.parentElement.children[1];
        // console.log(input)
        var inputValue = input.value;
        // console.log(inputValue);
        if (inputValue > 98) {
            input.value = 99;
        } else {
            input.value = parseInt(inputValue) + 1;
        }
        updateCart();
    })
}
;

let delete_btn = document.getElementsByClassName('delete-btn');
for (let i = 0; i < delete_btn.length; i++) {
    let button = delete_btn.item(i);
    button.addEventListener('click', function (event) {
        button.parentElement.parentElement.parentElement.parentElement.remove();
        updateCart()

    })

}

function updateCart() {
    let cart_items = document.getElementsByClassName("cart-items")[0];
    let cart_rows = cart_items.getElementsByClassName("cart-row");
    let total = 0;
    for (let i = 0; i < cart_rows.length; i++) {
        let cart_row = cart_rows[i];
        let price_item = cart_row.getElementsByClassName("cart-price")[0].getElementsByClassName("cart-price-content")[0];
        let quantity_item = cart_row.getElementsByClassName("cart-quantity-input")[0];
        let price = parseInt(price_item.innerText);
        let quantity = parseInt(quantity_item.innerText);
        total = total + (price * quantity);
    }
    document.getElementById("product-price-total-value").innerText= total + 'đ';

}

