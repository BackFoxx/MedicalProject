package com.backfoxx.MedicalProject.Controller;

import com.backfoxx.MedicalProject.DTO.ResponseDTO;
import com.backfoxx.MedicalProject.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private PartService partService;

    @GetMapping("/todo")
    public ResponseEntity<?> test() {
        String str = partService.testservice();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
}
