package com.orderSystem.order.controllers.buyers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.orderSystem.order.dtos.ProductInfoDTO;
import com.orderSystem.order.dtos.ProductListDTO;
import com.orderSystem.order.dtos.ResultDTO;
import com.orderSystem.order.entities.ProductCategory;
import com.orderSystem.order.entities.ProductInfo;
import com.orderSystem.order.enums.ProductStatusEnum;
import com.orderSystem.order.services.ProductCategoryService;
import com.orderSystem.order.services.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class BuyerProductController {
    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * @return Result<List < ProductListDTO>>
     * @description: 各项产品及类目
     * @param: None
     */
    @GetMapping("/list")
    public ResultDTO getList() {
        logger.info("BuyerProductController.getList");
        ResultDTO<List<ProductListDTO>> result = new ResultDTO<>();
        try {
            List<ProductInfo> onSalesProductInfos = productInfoService.findByProductStatus(ProductStatusEnum.UP.getCode());
            List<Integer> productCategoryTypes = onSalesProductInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
            List<ProductCategory> productCategories = productCategoryService.findByCategoryTypeIn(productCategoryTypes);
            List<ProductListDTO> productListDTOS = new ArrayList<>();
            for (ProductCategory category : productCategories) {
                //product list
                ProductListDTO productListDTO = new ProductListDTO();
                productListDTO.setCategoryName(category.getCategoryName());
                productListDTO.setCategoryType(category.getCategoryType());
                List<ProductInfoDTO> productInfoDTOS = new ArrayList<>();
                // product info
                for (ProductInfo productInfo : onSalesProductInfos) {
                    if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                        BeanUtils.copyProperties(productInfo, productInfoDTO);
                        productInfoDTOS.add(productInfoDTO);
                    }
                }
                productListDTO.setProductDTOS(productInfoDTOS);
                productListDTOS.add(productListDTO);
            }
            result.setCode(0);
            result.setData(productListDTOS);
            logger.info(result.toString());
        } catch (Exception e) {
            logger.info("BuyerProductController.getList");
            logger.error(e.getMessage());
            result.setCode(1);
            result.setMsg("BuyerProductController.getList failed.");
        }
        return result;
    }

    /**
     * @return ResultDTO<ProductListDTO></>
     * @description: 产品搜索
     * @param: Map<String, String> search
     */
    @ResponseBody
    @PostMapping("/search")
    public ResultDTO search(@RequestBody Map<String, String> search) {
        logger.info("BuyerProductController.search");
        ResultDTO<ProductListDTO> resultDTO = new ResultDTO<>();
        try {
            String searchString = search.get("searchProduct");
            List<ProductInfo> productInfos = productInfoService.findByProductNameContains(searchString);
            ProductListDTO productListDTO = new ProductListDTO();
            List<ProductInfoDTO> productInfoDTOS = new ArrayList<>();
            productListDTO.setProductDTOS(productInfoDTOS);
            for (ProductInfo productInfo : productInfos) {
                ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                BeanUtils.copyProperties(productInfo, productInfoDTO);
                productInfoDTOS.add(productInfoDTO);
            }
            resultDTO.setCode(0);
            resultDTO.setData(productListDTO);
        } catch (Exception e) {
            logger.info("BuyerProductController.search");
            logger.error(e.getMessage());
            resultDTO.setCode(1);
            resultDTO.setMsg("BuyerProductController.search failed.");
        }
        return resultDTO;
    }
    /**
    * @description: 具体产品详情
    * @param:
    *
    */
    @PostMapping("/{productId}")
    public ResultDTO getProduct(@PathVariable String productId,@RequestBody ProductInfoDTO productInfoDTO){
        ResultDTO<ProductInfoDTO> resultDTO = new ResultDTO<>();
        logger.info("BuyerProductController.getProduct");
        if(productInfoDTO!=null&&productInfoDTO.getProductId()!=null){
            resultDTO.setData(productInfoDTO);
            resultDTO.setCode(0);
            return resultDTO;
        }else{
            try{
                ProductInfo productInfo = productInfoService.findByProductId(productId);
                ProductInfoDTO productDTO = new ProductInfoDTO();
                BeanUtils.copyProperties(productInfo, productDTO);
                resultDTO.setData(productDTO);
                resultDTO.setCode(0);
            }catch (Exception e){
                logger.error(e.getMessage());
                resultDTO.setCode(1);
                resultDTO.setMsg("BuyerProductController.getProduct failed");
            }
        }
        return resultDTO;
    }
}
