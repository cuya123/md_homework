package com.md.homework.service;

import com.md.homework.domain.applyHouse.ApplyHouseRepository;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.web.dto.ApplyHouseResponseDto;
import com.md.homework.web.dto.ApplyHouseSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplyHouseService {

    private final CustomerRepository customerRepository;
    private final ApplyHouseRepository applyHouseRepository;



    /*모든신청서 불러오기*/
    @Transactional(readOnly = true)
    public List<ApplyHouseResponseDto> findAll() {
        return applyHouseRepository.findAll().stream()
                .map(ApplyHouseResponseDto::new)
                .collect(Collectors.toList());
    }


    /*이사 신청*/
    @Transactional
    public int saveHouseApply(ApplyHouseSaveDto applyHouseSaveDto){

        Customer customer = customerRepository.findById(applyHouseSaveDto.getCustomer_id()).orElseThrow(()-> new IllegalArgumentException("회원을 찾을수 없습니다"));

        return applyHouseRepository.save(applyHouseSaveDto.toEntity(customer)).getId();
    }
}
