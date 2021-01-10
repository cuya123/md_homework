package com.md.homework.web.controller;

import com.md.homework.service.ApplyHouseService;
import com.md.homework.web.dto.ApplyHouseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ApplyHouseApiController {

    private final ApplyHouseService applyService;

    @GetMapping("/api/house-apply/list")
    public Map<String,Object> findAll() {

        List<ApplyHouseResponseDto> list = applyService.findAll();

        Map<String,Object> map = new HashMap<>();
        map.put("total_data_count", list.size());
        map.put("result", list);

        return map;
    }
}
