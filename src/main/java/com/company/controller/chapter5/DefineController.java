package com.company.controller.chapter5;

import com.company.controller.exeption.ResourceNotFoundException;
import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/rest/define")
public class DefineController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/{part}")
    public List<String> getPurchaseDefine(@PathVariable(value = "part") String part, final HttpServletResponse response) throws ResourceNotFoundException {
        if("a".equals(part)) {
            return purchaseRepository.getDefineA();
        } else if("b".equals(part)) {
            return purchaseRepository.getDefineB();
        } else if("c".equals(part)) {
            return purchaseRepository.getDefineC();
        } else if("d".equals(part)) {
            return purchaseRepository.getDefineD();
        } else {
           throw new ResourceNotFoundException("part - a, b, c or d");
        }
    }
}
