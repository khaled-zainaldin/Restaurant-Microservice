package com.order.order.VO;

import lombok.Data;

@Data
public class MenuItem {

    private Long id;

    private String name;

    private String description;

    private Double price;
}
