package com.md.homework.service;

import com.md.homework.domain.Answer;
import com.md.homework.domain.moveCompany.*;
import com.md.homework.web.dto.MoveCompanyUpdateRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MoveCompanyServiceTest {

    @Autowired
    MoveCompanyService moveCompanyService;

    @Autowired
    MoveCompanyRepository moveCompanyRepository;
    @Autowired
    VehicleRepository vehicleRepository;


    @Test
    public void 차량정보_업데이트(){

        //given
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

        //차량정보 삽입
        Vehicle vehicle1 = Vehicle.builder()
                .moveCompany(savedMoveCompany)
                .vehicle_type(VehicleType.ONE_POINT_FIVE)
                .count(10).build() ;
        Vehicle vehicle2 = Vehicle.builder()
                .moveCompany(savedMoveCompany)
                .vehicle_type(VehicleType.TWO_POINT_FIVE)
                .count(10).build() ;
        Vehicle vehicle3 = Vehicle.builder()
                .moveCompany(savedMoveCompany)
                .vehicle_type(VehicleType.ETC)
                .count(10).build() ;

        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);


        //when
        //업데이트
        moveCompanyService.updateCompanyInfo(
                MoveCompanyUpdateRequestDto.builder()
                .move_company_id(saved_move_company_id)
                .ONE_POINT_FIVE(VehicleType.ONE_POINT_FIVE)
                .one_point_five_count(1)
                .TWO_POINT_FIVE(VehicleType.TWO_POINT_FIVE)
                .two_point_five_count(2)
                .ETC(VehicleType.ETC)
                .etc_count(3)
                .build());

        //then
        List<Vehicle> vehicles = vehicleRepository.findByMoveCompany_Id(saved_move_company_id);

        Vehicle testVehicle = null;
        for (Vehicle vehicle: vehicles) {
            if(vehicle.getVehicle_type().name().equals(VehicleType.ONE_POINT_FIVE.name())){
                testVehicle=vehicle;
            }
        }
        assertThat(testVehicle.getCount()).isEqualTo(1);


    }
}
