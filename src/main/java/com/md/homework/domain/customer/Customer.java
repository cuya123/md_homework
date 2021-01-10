package com.md.homework.domain.customer;

import com.md.homework.domain.Answer;
import com.md.homework.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Customer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    @Enumerated(EnumType.STRING)
    private Answer is_term_agree;

    @Enumerated(EnumType.STRING)
    private Answer is_personal_submit_agree;

    @Enumerated(EnumType.STRING)
    private Answer is_marketing_receive_agree;

    @Builder
    public Customer(String name, String contact, Answer is_term_agree, Answer is_personal_submit_agree, Answer is_marketing_receive_agree) {
        this.name = name;
        this.contact = contact;
        this.is_term_agree = is_term_agree;
        this.is_personal_submit_agree = is_personal_submit_agree;
        this.is_marketing_receive_agree = is_marketing_receive_agree;
    }
}
