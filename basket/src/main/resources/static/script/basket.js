
clearBasket();

// Test product
const product1 = { id:1, name: "Product1", stock: 3 }
const product2 = { id: 2, name: "Product2", stock: 5 }
const product3  = { id: 3, name: "Product3", stock: 2 }

addToBasket(product1);
addToBasket(product3);
addToBasket(product2);

showBasket();

function showBasket() {

    const basket = getBasket();

    const table = document.createElement("table");
    basket.forEach(item => {
        const row = document.createElement("tr");
        const product = document.createElement("td");
        product.textContent = JSON.stringify(item);
        row.appendChild(product);
        table.appendChild(row);
    })

    document.getElementById("items").appendChild(table);
}

function addToBasket (product)
{
    let basket = JSON.parse(localStorage.getItem("basket")) || [];
    basket.push(product);
    localStorage.setItem("basket", JSON.stringify(basket));
}

function getBasket () {
    let basket = JSON.parse(localStorage.getItem("basket")) || [];
    console.log(basket);
    return basket;
}

function removeFromBasket (index) {
    let basket = JSON.parse(localStorage.getItem("basket")) || [];
    basket.slice(index, 1);
    localStorage.setItem("basket", JSON.stringify(basket));
}

function clearBasket () {
    localStorage.removeItem("basket");
}






