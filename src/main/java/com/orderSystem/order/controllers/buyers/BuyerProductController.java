package com.orderSystem.order.controllers.buyers;

import com.orderSystem.order.dtos.ProductListDTO;
import com.orderSystem.order.dtos.ResultDTO;
import com.orderSystem.order.services.ProductCategoryService;
import com.orderSystem.order.services.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultDTO getList(){
        ResultDTO<ProductListDTO> result = new ResultDTO();

        return result;
    }

}
