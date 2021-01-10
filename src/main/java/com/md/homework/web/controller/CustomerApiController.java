package com.md.homework.web.controller;

import com.md.homework.service.CustomerService;
import com.md.homework.web.dto.CustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerApiController {

    private final CustomerService customerService;

    @GetMapping("/api/customer/list")
    public List<CustomerResponseDto> findAll() {
        return customerService.findAll();
    }

}
