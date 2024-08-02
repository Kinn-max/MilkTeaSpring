package com.javaweb.converter;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.constants.SystemConstant;
import com.javaweb.dto.MyUserDetail;
import com.javaweb.dto.OrderDTO;
import com.javaweb.dto.OrderResponseDTO;
import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Order;
import com.javaweb.entity.Product;
import com.javaweb.entity.Topping;
import com.javaweb.entity.User;
import com.javaweb.repository.ProductRepository;
import com.javaweb.repository.UserRepository;
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
    private UserRepository userRepository;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    public Order toOrder(OrderDTO orderDTO){
        Order order = modelMapper.map(orderDTO, Order.class);
        User user =userRepository.findById(SecurityUtils.getMyUser().getId()).get();
        Product product = productRepository.findById(orderDTO.getIdProduct()).get();
        order.setProduct(product);
        order.setUserId(user);
        order.setStatus(false);
        return order;
    }
    public OrderResponseDTO toOrderResponseDTO(Order order){
        OrderResponseDTO orderResponseDTO = modelMapper.map(order, OrderResponseDTO.class);
        List<Topping> listTopping = order.getToppingList();
        String nameTopping = "";
        if (listTopping.size() > 0){
            for (int i = 0; i < listTopping.size(); i++) {
                nameTopping += listTopping.get(i).getName();
                if (i < listTopping.size() - 1) {
                    nameTopping += ",";
                }
            }
        }else {
            nameTopping = "Không có!";
        }
        orderResponseDTO.setNameTopping(nameTopping);
        ProductDTO productDTO = productConverter.toProductDTO(order.getProduct());
        orderResponseDTO.setProduct(productDTO);
        return orderResponseDTO;
    }
}
