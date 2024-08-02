package com.javaweb.converter;

import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Category;
import com.javaweb.entity.Product;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO toProductDTO(Product products) {
        ProductDTO productDTO = modelMapper.map(products,ProductDTO.class);
        productDTO.setPriceM(products.getPriceM());
        productDTO.setPriceL(products.getPriceL());
        productDTO.setNameCategory(products.getCategory().getName());
        return productDTO;
    }
    public Product toProduct(ProductDTO productDTO) {
        Product product =  modelMapper.map(productDTO,Product.class);
        Category category = categoryRepository.findById(Long.valueOf(productDTO.getNameCategory())).get();
        product.setCategory(category);
        return product;
    }
    public ProductDTO toProductDTOForm(Product products) {
        ProductDTO productDTO = modelMapper.map(products,ProductDTO.class);
        productDTO.setPriceM(products.getPriceM());
        productDTO.setPriceL(products.getPriceL());
        productDTO.setNameCategory(products.getCategory().getId()+"");
        return productDTO;
    }
}
