package com.javaweb.converter;

import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Category;
import com.javaweb.entity.PriceOfSize;
import com.javaweb.entity.Product;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.service.CategoryService;
import com.javaweb.service.PriceOfSizeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    @Autowired
    private PriceOfSizeService priceOfSizeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    public ProductDTO toProductDTO(Product products) {
        ProductDTO productDTO = modelMapper.map(products,ProductDTO.class);
        productDTO.setPriceM(products.getPriceOfSize().getSizeM());
        productDTO.setPriceL(products.getPriceOfSize().getSizeL());
        productDTO.setNameCategory(products.getCategory().getName());
        return productDTO;
    }
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setImage(productDTO.getImage());
        //
        PriceOfSize priceOfSize = new PriceOfSize();
        priceOfSize.setSizeM(productDTO.getPriceM());
        priceOfSize.setSizeL(productDTO.getPriceL());
        priceOfSizeService.savePriceOfSize(priceOfSize);
        //
        Category category = categoryService.findCategoryById(Long.valueOf(productDTO.getNameCategory()));
        product.setCategory(category);
        product.setPriceOfSize(priceOfSize);
        return product;
    }
    public ProductDTO toProductDTOForm(Product products) {
        ProductDTO productDTO = modelMapper.map(products,ProductDTO.class);
        productDTO.setPriceM(products.getPriceOfSize().getSizeM());
        productDTO.setPriceL(products.getPriceOfSize().getSizeL());
        productDTO.setNameCategory(products.getCategory().getId()+"");
        return productDTO;
    }
}
