package org.example.pr06vmapi;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    public static List<Product> productList = new ArrayList<>();

    @GetMapping("/all") //상품 추가
    public List<Product> All() {
//        System.out.println(productList);
        return productList;
    }
    @PostMapping("/add") //상품 추가
    public void Add(@RequestBody ReqDTO reqDTO) {
        Product product = Product.builder()
                .name(reqDTO.getName())
                .price(reqDTO.getPrice())
                .limit_date(LocalDate.parse(reqDTO.getLimit_date())).build();
        productList.add(product);
    }

    @PostMapping("/edit") //상품 추가
    public void Edit(@RequestBody EditReqDTO editReqDTO) {
        Product product = ApiController.productList.get(editReqDTO.getId());
        product.setName(editReqDTO.getName());
        product.setPrice(editReqDTO.getPrice());
        product.setLimit_date(LocalDate.parse(editReqDTO.getLimit_date()));
    }

    @PostMapping("/delete") //상품 삭제
    public void Delete(@RequestBody EditReqDTO editReqDTO) {
        ApiController.productList.remove(editReqDTO.getId());
    }
}
