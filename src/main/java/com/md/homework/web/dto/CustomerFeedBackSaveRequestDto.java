package com.md.homework.web.dto;

import com.md.homework.domain.Answer;
import com.md.homework.domain.MovingType;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.feedback.CustomerFeedback;
import com.md.homework.domain.moveCompany.MoveCompany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerFeedBackSaveRequestDto {

    private int customer_id;

    private int move_company_id;

    private String feed_content;

    private MovingType moving_type;

    private Answer is_info_open_agree;

    private int professional_satisfy_degree;

    private int price_satisfy_degree;

    private int kindness_degree;

    private Answer revisit_will;

    private int price;

    private LocalDateTime moving_at;

    @Builder
    public CustomerFeedBackSaveRequestDto(int customer_id, int move_company_id, String feed_content, MovingType moving_type, Answer is_info_open_agree, int professional_satisfy_degree, int price_satisfy_degree, int kindness_degree, Answer revisit_will, int price, LocalDateTime moving_at) {
        this.customer_id = customer_id;
        this.move_company_id = move_company_id;
        this.feed_content = feed_content;
        this.moving_type = moving_type;
        this.is_info_open_agree = is_info_open_agree;
        this.professional_satisfy_degree = professional_satisfy_degree;
        this.price_satisfy_degree = price_satisfy_degree;
        this.kindness_degree = kindness_degree;
        this.revisit_will = revisit_will;
        this.price = price;
        this.moving_at = moving_at;
    }

    public CustomerFeedback toEntity(Customer customer, MoveCompany moveCompany) {
        return CustomerFeedback.builder()
                .customer(customer)
                .moveCompany(moveCompany)
                .feed_content(feed_content)
                .moving_type(moving_type)
                .is_info_open_agree(is_info_open_agree)
                .professional_satisfy_degree(professional_satisfy_degree)
                .price_satisfy_degree(price_satisfy_degree)
                .kindness_degree(kindness_degree)
                .revisit_will(revisit_will)
                .price(price)
                .moving_at(moving_at)
                .build();
    }
}
