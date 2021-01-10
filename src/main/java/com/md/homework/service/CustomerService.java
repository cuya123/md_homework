package com.md.homework.service;

import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.domain.feedback.CustomerFeedbackRepository;
import com.md.homework.domain.moveCompany.MoveCompany;
import com.md.homework.domain.moveCompany.MoveCompanyRepository;
import com.md.homework.web.dto.CustomerFeedBackSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerFeedbackRepository customerFeedbackRepository;
    private final CustomerRepository customerRepository;
    private final MoveCompanyRepository moveCompanyRepository;

    @Transactional
    public int createFeedback(CustomerFeedBackSaveRequestDto feedBackSaveRequestDto){
        //고객정보
        Customer customer = customerRepository.findById(feedBackSaveRequestDto.getCustomer_id()).orElseThrow(()->new IllegalArgumentException("고객 정보가 없습니다"));

        //이사 업체정보
        MoveCompany moveCompany = moveCompanyRepository.findById(feedBackSaveRequestDto.getMove_company_id()).orElseThrow(()->new IllegalArgumentException("회사 정보가 없습니다"));;

        //save
        return customerFeedbackRepository.save(feedBackSaveRequestDto.toEntity(customer, moveCompany)).getId();
    }


}
