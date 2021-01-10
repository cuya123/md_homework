package com.md.homework.web.controller;


import com.md.homework.service.MoveCompanyService;
import com.md.homework.web.dto.MoveCompanyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class MoveCompanyApiController {

    private final MoveCompanyService moveCompanyService;

    @GetMapping("/api/move-company/list")
    public List<MoveCompanyResponseDto> findAll() {
        return moveCompanyService.findAll();
    }

}
