package com.retail.session;

import com.retail.session.entities.*;
import com.retail.session.requests.*;
import com.retail.session.services.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/production")
@AllArgsConstructor
public class ProductController {

    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ColorService colorService;
    private final SizeService sizeService;
    private final ProductImageService productImageService;
    private final ProductService productService;
    private final ProductVariantService productVariantService;

    @PostMapping("/brand")
    public void registerBrand (@RequestBody BrandRegistrationRequest brandRegistrationRequest) {
        log.info("new brand registration {}", brandRegistrationRequest);
        brandService.registerBrand(brandRegistrationRequest);
    }

    @PostMapping("/category")
    public void registerCategory (@RequestBody CategoryRegistrationRequest categoryRegistrationRequest) {
        log.info("new category registration {}", categoryRegistrationRequest);
        categoryService.registerCategory(categoryRegistrationRequest);
    }

    @PostMapping("/color")
    public void registerColor (@RequestBody ColorRegistrationRequest colorRegistrationRequest) {
        log.info("new color registration {}", colorRegistrationRequest);
        colorService.registerColor(colorRegistrationRequest);
    }

    @PostMapping("/size")
    public void registerSize (@RequestBody SizeRegistrationRequest sizeRegistrationRequest) {
        log.info("new size registration {}", sizeRegistrationRequest);
        sizeService.registerSize(sizeRegistrationRequest);
    }

    @PostMapping("/product_image")
    public void registerProductImage (@RequestBody ProductImageRegistrationRequest productImageRegistrationRequest) {
        log.info("new image url registration {}", productImageRegistrationRequest);
        productImageService.registerProductImage(productImageRegistrationRequest);
    }

    @PostMapping("/product")
    public void registerProduct (@RequestBody ProductRegistrationRequest productRegistrationRequest) {
        log.info("new product registration {}", productRegistrationRequest);
        productService.registerProduct(productRegistrationRequest);
    }

    @PostMapping("/product_variant")
    public void registerProductVariant(@RequestBody ProductVariantRegistrationRequest productVariantRegistrationRequest) {
        log.info("new product variant registration {}", productVariantRegistrationRequest);
        productVariantService.registerProductVariant(productVariantRegistrationRequest);
    }

    @GetMapping("/brand")
    public List<Brand> getBrand () { return brandService.getBrand(); }

    @GetMapping("/category")
    public List<Category> getCategory() { return categoryService.getCategory(); }

    @GetMapping("/color")
    public List<Color> getColor() { return colorService.getColor(); }

    @GetMapping("/size")
    public List<Size> getSize() { return sizeService.getSize(); }

    @GetMapping("/product_image")
    public List<ProductImage> getProductImage() { return productImageService.getProductImage(); }

    @GetMapping("/product_image/{productVariantId}")
    public List<ProductImage> getProductImageByProductVariantId(@PathVariable("productVariantId") Long productVariantId) {
        return productImageService.getProductImageByProductVariantId(productVariantId);
    }

    @GetMapping("/product")
    public List<Product> getProduct() { return productService.getProduct(); }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) throws EntityTypeException {
        Optional<Product> productOptional = productService.getProductById(productId);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
    }

    @GetMapping("/product_variant")
    public List<ProductVariant> getProductVariant() { return productVariantService.getProductVariant(); }

    @GetMapping("/product_variant/{productVariantId}")
    public ProductVariant getProductVariantById(@PathVariable("productVariantId") Long productVariantId) throws EntityTypeException {
        Optional<ProductVariant> productVariantOptional = productVariantService.getProductVariantById(productVariantId);
        if(productVariantOptional.isPresent()) {
            return productVariantOptional.get();
        }
         else {
             throw new EntityNotFoundException("Product variant not found with id: " + productVariantId);
        }
    }
}
