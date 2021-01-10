package com.md.homework.service;

import com.md.homework.domain.applyHouse.ApplyHouseInfoRepository;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.web.dto.ApplyHouseSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final CustomerRepository customerRepository;
    private final ApplyHouseInfoRepository applyHouseInfoRepository;

    /*이사 신청*/
    public int saveHouseApply(ApplyHouseSaveDto applyHouseSaveDto){

        Customer customer = customerRepository.findById(applyHouseSaveDto.getCustomer_id()).orElseThrow(()-> new IllegalArgumentException("회원을 찾을수 없습니다"));

        return applyHouseInfoRepository.save(applyHouseSaveDto.toEntity(customer)).getId();
    }
}
