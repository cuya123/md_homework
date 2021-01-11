package com.md.homework.service;

import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.domain.feedback.CustomerFeedbackRepository;
import com.md.homework.domain.moveCompany.MoveCompany;
import com.md.homework.domain.moveCompany.MoveCompanyRepository;
import com.md.homework.web.dto.CustomerFeedBackSaveRequestDto;
import com.md.homework.web.dto.CustomerResponseDto;
import com.md.homework.web.dto.MoveCompanyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    /*모든 고객 불러오기*/
    @Transactional(readOnly = true)
    public List<CustomerResponseDto> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerResponseDto::new)
                .collect(Collectors.toList());
    }

}
