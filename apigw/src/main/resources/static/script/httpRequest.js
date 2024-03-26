/**  Post Product **/
// Post brand
document.getElementById("brand-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var brandFormData = {
        name: document.getElementById("brand-name").value,
    };

    postDataWithJsonForm('/api/v1/production/brand', brandFormData);
});

// Post category
document.getElementById("category-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var categoryFormData = {
        name: document.getElementById("category-name").value,
    };

    postDataWithJsonForm('/api/v1/production/category', categoryFormData);
});

// Post color
document.getElementById("color-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var colorFormData = {
        name: document.getElementById("color-name").value,
    };

    postDataWithJsonForm('/api/v1/production/color', colorFormData);
});

// Post size
document.getElementById("size-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var sizeFormData = {
        name: document.getElementById("size-name").value,
    };

    postDataWithJsonForm('/api/v1/production/size', sizeFormData);
});

// Post product
document.getElementById("product-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var productFormData = {
        name: document.getElementById("product-name").value,
        detail: document.getElementById("product-detail" ).value,
        brandId: document.getElementById("brand-id").value,
        categoryId: document.getElementById("category-id").value
    };

    postDataWithJsonForm('/api/v1/production/product', productFormData);
});

// Post productVariant
document.getElementById("product-variant-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var productVariantFormData = {
        productId: document.getElementById("product-id-in-product-variant").value,
        colorId: document.getElementById("color-id").value,
        sizeId: document.getElementById("size-id").value,
        price: document.getElementById("price").value,
        stock: document.getElementById("stock").value
    };

    postDataWithJsonForm('/api/v1/production/product_variant', productVariantFormData);
});

// Post productImage
document.getElementById("image-registration").addEventListener("submit", function (event) {
    event.preventDefault();
    console.log("Submit");

    var imageFormData = {
        productVariantId: document.getElementById("product-variant-id-in-image-post").value,
        imgURL: document.getElementById("image-url").value,
    }

    postDataWithJsonForm('/api/v1/production/product_image', imageFormData);
})


// TODO: Post Order

/** Post customer **/
document.getElementById("customer-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var customerFormData = {
        email: document.getElementById("customer-email").value,
        firstName: document.getElementById("customer-firstname" ).value,
        lastName: document.getElementById("customer-lastname").value,
        phone: document.getElementById("customer-phone").value
    };

    postDataWithJsonForm('/api/v1/customer', customerFormData);
});

/** Post review **/
document.getElementById("review-registration").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit");

    var reviewFormData = {
        grade: document.getElementById("review-grade").value,
        detail: document.getElementById("review-detail").value,
        imgURL: document.getElementById("review-img").value,
        productId: document.getElementById("review-product").value,
        customerId: document.getElementById("review-customer").value
    }

    postDataWithJsonForm('/api/v1/customer/review', reviewFormData);
})

/** Get product **/
// Get all brand
document.getElementById("brand-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");

    // Before adding, remove previous data
    document.getElementById("brand-all").innerHTML = '';

    getData("/api/v1/production/brand")
        .then(data => {
            for (var key in data) {
                if(data.hasOwnProperty(key)) {
                    var span = document.createElement('span');
                    span.textContent = `${JSON.stringify(data[key])}`;
                    document.getElementById("brand-all").appendChild(span);
                    document.getElementById("brand-all").appendChild(document.createElement('br'));
                }
            }
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get all category
document.getElementById("category-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit attempted");

    // Before adding, remove previous data
    document.getElementById("category-all").innerHTML = '';

    getData("/api/v1/production/category")
        .then(data => {
            for (var key in data) {
                if(data.hasOwnProperty(key)) {
                    var span = document.createElement('span');
                    span.textContent = `${JSON.stringify(data[key])}`;
                    document.getElementById("category-all").appendChild(span);
                    document.getElementById("category-all").appendChild(document.createElement('br'));
                }
            }
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get all color
document.getElementById("color-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit attempted");

    // Before adding, remove previous data
    document.getElementById("color-all").innerHTML = '';

    getData("/api/v1/production/color")
        .then(data => {
            for (var key in data) {
                if(data.hasOwnProperty(key)) {
                    var span = document.createElement('span');
                    span.textContent = `${JSON.stringify(data[key])}`;
                    document.getElementById("color-all").appendChild(span);
                    document.getElementById("color-all").appendChild(document.createElement('br'));
                }
            }
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get all size
document.getElementById("size-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("Submit attempted");

    // Before adding, remove previous data
    document.getElementById("size-all").innerHTML = '';

    getData("/api/v1/production/size")
        .then(data => {
            for (var key in data) {
                if(data.hasOwnProperty(key)) {
                    var span = document.createElement('span');
                    span.textContent = `${JSON.stringify(data[key])}`;
                    document.getElementById("size-all").appendChild(span);
                    document.getElementById("size-all").appendChild(document.createElement('br'));
                }
            }
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get product by Id
document.getElementById("product-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");
    const productId = document.getElementById("product-id").value;
    const uri = `/api/v1/production/product/${productId}`;

    getData(uri)
        .then(data => {
            console.log(data);
            // Update the inner HTML with the retrieved data
            document.getElementById("product-by-id").textContent = JSON.stringify(data);
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get product variant by Id
document.getElementById("product-variant-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");
    const productVariantId = document.getElementById("product-variant-id").value;
    const uri = `/api/v1/production/product_variant/${productVariantId}`;

    getData(uri)
        .then(data => {
            console.log(data);
            // Update the inner HTML with the retrieved data
            document.getElementById("product-variant-by-id").textContent = JSON.stringify(data);
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// Get product image by product variant Id
document.getElementById("image-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");
    const productVariantId = document.getElementById("product-variant-id-in-image-get").value;
    const uri = `/api/v1/production/product_image/${productVariantId}`;

    // Before adding, remove previous data
    document.getElementById("product-image-all-by-product-variant").innerHTML = '';

    getData(uri)
        .then(data => {
            for (var key in data) {
                if(data.hasOwnProperty(key)) {
                    var span = document.createElement('span');
                    span.textContent = `${JSON.stringify(data[key])}`;
                    document.getElementById("product-image-all-by-product-variant").appendChild(span);
                    document.getElementById("product-image-all-by-product-variant").appendChild(document.createElement('br'));
                }
            }
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

// TODO: Get Order

/** Get customer **/
document.getElementById("customer-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");
    const customerId = document.getElementById("customer-id").value;
    const uri = `/api/v1/customer/${customerId}`;

    getData(uri)
        .then(data => {
            console.log(data);
            // Update the inner HTML with the retrieved data
            document.getElementById("customer-by-id").textContent = JSON.stringify(data);
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})

/** Get Review **/
document.getElementById("review-get").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log("First submit attempt");
    const reviewId = document.getElementById("review-id").value;
    const uri = `/api/v1/customer/review/${reviewId}`;

    getData(uri)
        .then(data => {
            console.log(data);
            document.getElementById("review-by-id").textContent = JSON.stringify(data);
        })
        .catch(error => {
            console.error("Error: ", error);
        });
})


/** Helper functions **/
function postDataWithJsonForm (uri, formData ) {
        fetch(uri, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if(!response.ok) {
                    throw new Error("Network response was not ok: " + response.statusText);
                }

                const contentType = response.headers.get('content-type');
                if(contentType && contentType.includes('application/json')) {
                    return response.json();
                }

                return response.text();
            })
            .then(data => {
                console.log('Success',data);
                // Handle success
            })
            .catch(error => {
                console.log('Error',error);
            })
}

function getData(uri) {
    // Return the fetch Promise
    return fetch(uri)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok: " + response.statusText);
            }

            const contentType = response.headers.get('content-type');
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            }

            return response.text();
        })
        .then(data => {
            console.log("Success", data);
            return data; // Return the parsed data
        })
        .catch(error => {
            console.log("Error: ", error);
            throw error; // Re-throw the error for further handling
        });
}

