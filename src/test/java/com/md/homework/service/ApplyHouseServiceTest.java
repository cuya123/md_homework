package com.md.homework.service;

import com.md.homework.domain.Answer;
import com.md.homework.domain.applyHouse.ApplyHouse;
import com.md.homework.domain.applyHouse.ApplyHouseRepository;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.web.dto.ApplyHouseSaveDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplyHouseServiceTest {

    @Autowired
    ApplyHouseService applyService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ApplyHouseRepository applyHouseRepository;

    @Test
    public void 신청서_작성_테스트() throws Exception{

        //given
        String name="김노드";
        String contact="010-2777-5885";
        Answer is_term_agree = Answer.Y;
        Answer is_personal_submit_agree = Answer.N;
        Answer is_marketing_receive_agree = Answer.N;

        Customer savedCustomer = customerRepository.save(Customer.builder().name(name).contact(contact)
                .is_term_agree(is_term_agree)
                .is_personal_submit_agree(is_personal_submit_agree)
                .is_marketing_receive_agree(is_marketing_receive_agree)
                .build());

        ApplyHouseSaveDto applyHouseSaveDto = ApplyHouseSaveDto.builder()
                .customer_id(savedCustomer.getId())
                .applicant(savedCustomer.getName())
                .contact(savedCustomer.getContact())
                .starting_point("서울시 동작구 문래동 ")
                .starting_point_floor(14)
                .destination("경기도 광주시 자이동")
                .destination_floor(1)
                .moving_at(LocalDateTime.now().plusDays(10))
                .is_storage_option(Answer.Y)
                .is_term_agree(Answer.Y)
                .is_personal_submit_agree(Answer.Y)
                .is_marketing_receive_agree(Answer.Y)
                .build();

        //when
        int applyId = applyService.saveHouseApply(applyHouseSaveDto);

        //then
        ApplyHouse applyHouseInfo = applyHouseRepository.findById(applyId).get();
        assertThat(applyHouseInfo.getApplicant()).isEqualTo(name);

    }
}

