package com.md.homework.domain.moveCompany;

import com.md.homework.domain.moveCompany.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository  extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByMoveCompany_Id(int move_company_id);
}
