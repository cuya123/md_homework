package com.md.homework.web.dto;

import com.md.homework.domain.moveCompany.VehicleType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveCompanyUpdateRequestDto {

    private int move_company_id;

    private VehicleType ONE_POINT_FIVE;
    private int one_point_five_count;

    private VehicleType TWO_POINT_FIVE;
    private int two_point_five_count;

    private VehicleType ETC;
    private int etc_count;

    @Builder
    public MoveCompanyUpdateRequestDto(int move_company_id, VehicleType ONE_POINT_FIVE, int one_point_five_count, VehicleType TWO_POINT_FIVE, int two_point_five_count, VehicleType ETC, int etc_count) {
        this.move_company_id = move_company_id;
        this.ONE_POINT_FIVE = ONE_POINT_FIVE;
        this.one_point_five_count = one_point_five_count;
        this.TWO_POINT_FIVE = TWO_POINT_FIVE;
        this.two_point_five_count = two_point_five_count;
        this.ETC = ETC;
        this.etc_count = etc_count;
    }
}
