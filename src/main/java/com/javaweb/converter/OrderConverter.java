package com.javaweb.converter;

import com.javaweb.dto.OrderDTO;
import com.javaweb.entity.Order;
import com.javaweb.entity.Product;
import com.javaweb.entity.Topping;
import com.javaweb.service.OrderService;
import com.javaweb.service.ProductService;
import com.javaweb.service.ToppingService;
import com.javaweb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {
    @Autowired
    private UserService userService;

    @Autowired
    private ToppingService toppingService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;
    public Order toOrder(OrderDTO orderDTO){
        Order order = modelMapper.map(orderDTO, Order.class);
        List<Topping> toppingList = new ArrayList<>();
        for(Long id : orderDTO.getToppingList()){
            Topping topping = toppingService.findToppingById(id);
            toppingList.add(topping);
        }
        Product product = productService.getProductById(orderDTO.getIdProduct());
        order.setProduct(product);
        order.setToppingList(toppingList);
        return order;
    }
}
