package com.md.homework.service;

import com.md.homework.domain.moveCompany.MoveCompany;
import com.md.homework.domain.moveCompany.MoveCompanyRepository;
import com.md.homework.domain.moveCompany.Vehicle;
import com.md.homework.domain.moveCompany.VehicleRepository;
import com.md.homework.web.dto.MoveCompanyResponseDto;
import com.md.homework.web.dto.MoveCompanyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MoveCompanyService {

    private final VehicleRepository vehicleRepository;
    private final MoveCompanyRepository moveCompanyRepository;

    /*모든 사업체 불러오기*/
    @Transactional(readOnly = true)
    public List<MoveCompanyResponseDto> findAll() {
        return moveCompanyRepository.findAll().stream()
                .map(MoveCompanyResponseDto::new)
                .collect(Collectors.toList());
    }


    /*업체 차량 정보 업데이트*/
    @Transactional
    public void updateCompanyInfo(MoveCompanyUpdateRequestDto moveCompanyUpdateRequestDto){

        List<Vehicle> vehicles = vehicleRepository.findByMoveCompany_Id(moveCompanyUpdateRequestDto.getMove_company_id());

        for (Vehicle vehicle : vehicles){
            if(vehicle.getVehicle_type().name().equals(moveCompanyUpdateRequestDto.getONE_POINT_FIVE().name())){
                vehicle.updateCount(moveCompanyUpdateRequestDto.getOne_point_five_count());
            }
            else if(vehicle.getVehicle_type().name().equals(moveCompanyUpdateRequestDto.getTWO_POINT_FIVE().name())){
                vehicle.updateCount(moveCompanyUpdateRequestDto.getTwo_point_five_count());
            }
            else if(vehicle.getVehicle_type().name().equals(moveCompanyUpdateRequestDto.getETC().name())){
                vehicle.updateCount(moveCompanyUpdateRequestDto.getEtc_count());
            }
        }
    }

}
