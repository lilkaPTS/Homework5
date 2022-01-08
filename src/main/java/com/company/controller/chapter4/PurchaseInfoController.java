package com.company.controller.chapter4;

import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/info")
public class PurchaseInfoController {


    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/purchases/a")
    public List<String> getPurchasesInfoA(){
        return purchaseRepository.getInfoA();
    }

    @GetMapping("/purchases/b")
    public List<String> getPurchasesInfoB(){
        return purchaseRepository.getInfoB();
    }
}
