package com.md.homework.service;

import com.md.homework.domain.Answer;
import com.md.homework.domain.MovingType;
import com.md.homework.domain.SatisfyDegree;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.customer.CustomerRepository;
import com.md.homework.domain.feedback.CustomerFeedback;
import com.md.homework.domain.feedback.CustomerFeedbackRepository;
import com.md.homework.domain.moveCompany.MoveCompany;
import com.md.homework.domain.moveCompany.MoveCompanyRepository;
import com.md.homework.web.dto.CustomerFeedBackSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerFeedbackServiceTest {

    @Autowired
    CustomerFeedbackRepository customerFeedbackRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MoveCompanyRepository moveCompanyRepository;

    @Test
    public void 피드백_남기기_테스트(){

    //given
        //회원정보 삽입
        String name="김자바";
        String contact="01077778888";
        Answer is_term_agree = Answer.Y;
        Answer is_personal_submit_agree = Answer.N;
        Answer is_marketing_receive_agree = Answer.N;

        Customer savedCustomer = customerRepository.save(Customer.builder().name(name).contact(contact)
                .is_term_agree(is_term_agree)
                .is_personal_submit_agree(is_personal_submit_agree)
                .is_marketing_receive_agree(is_marketing_receive_agree)
                .build());
        int saved_customer_id = savedCustomer.getId();

        //회사정보 삽입
        MoveCompany moveCompany = MoveCompany.builder().name("생명의말씀")
                .company_number("11022032")
                .ceo("김공감")
                .contact("0233334444")
                .address("서울시 강남구 강남동")
                .address_detail("위워크 14층 101호")
                .company_opened_at(LocalDateTime.of(2019, 6, 4, 0, 0, 0))
                .employee_count(120)
                .is_match_available(Answer.Y).build();

        MoveCompany savedMoveCompany = moveCompanyRepository.save(moveCompany);

        int saved_move_company_id = savedMoveCompany.getId();
        //피드백 리퀘스트 dto
        String content="최고에요";
        CustomerFeedBackSaveRequestDto customerFeedBackSaveRequestDto = CustomerFeedBackSaveRequestDto.builder()
                .customer_id(saved_customer_id)
                .move_company_id(saved_move_company_id)
                .feed_content(content)
                .moving_type(MovingType.HOUSE)
                .is_info_open_agree(Answer.Y)
                .price_satisfy_degree(SatisfyDegree.NORMAL.getValue())
                .kindness_degree(SatisfyDegree.GOOD.getValue())
                .professional_satisfy_degree(SatisfyDegree.VERY_GOOD.getValue())
                .revisit_will(Answer.Y)
                .price(100000)
                .moving_at(LocalDateTime.now().plusDays(30))
                .build();

        //when
        CustomerFeedback savedCustomerFeedback = customerFeedbackRepository.save(customerFeedBackSaveRequestDto.toEntity(savedCustomer, savedMoveCompany));

        //then
        assertThat(savedCustomerFeedback.getFeed_content()).isEqualTo(content);

    }
}
