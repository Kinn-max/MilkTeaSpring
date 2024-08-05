package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum OptionOrderActive {
    WAIT_FOR_CONFIRM("Đợi xác nhận"),
    DELIVERING("Đang giao hàng"),
    CANCELLED("Hủy đơn hàng"),
    DELIVERED("Đã giao hàng");
    private  final String optionOrder;
    public String getOptionOrder() {
        return optionOrder;
    }
    OptionOrderActive(String optionOrder) {
        this.optionOrder = optionOrder;
    }
    public static Map<String,String> type(){
        Map<String,String> options = new TreeMap<>();
        for(OptionOrderActive optionOrderActive : values()){
            options.put(optionOrderActive.toString(),optionOrderActive.optionOrder);
        }
        return options;
    }


}
