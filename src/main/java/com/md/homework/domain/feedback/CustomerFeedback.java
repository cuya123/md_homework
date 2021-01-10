package com.md.homework.domain.feedback;

import com.md.homework.domain.Answer;
import com.md.homework.domain.BaseTimeEntity;
import com.md.homework.domain.MovingType;
import com.md.homework.domain.customer.Customer;
import com.md.homework.domain.applyHouse.ApplyHouseInfo;
import com.md.homework.domain.moveCompany.MoveCompany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class CustomerFeedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "move_company_id")
    private MoveCompany moveCompany;

    @Column(nullable = false)
    private String feed_content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovingType moving_type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_info_open_agree;

    private int professional_satisfy_degree;

    private int price_satisfy_degree;

    private int kindness_degree;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer revisit_will;

    private int price;

    private LocalDateTime moving_at;

    @Builder
    public CustomerFeedback(Customer customer, MoveCompany moveCompany, String feed_content, MovingType moving_type, Answer is_info_open_agree, int professional_satisfy_degree, int price_satisfy_degree, int kindness_degree, Answer revisit_will, int price, LocalDateTime moving_at) {
        this.customer = customer;
        this.moveCompany = moveCompany;
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
}
