package com.backfoxx.MedicalProject.Controller;

import com.backfoxx.MedicalProject.DTO.PartDTO;
import com.backfoxx.MedicalProject.DTO.ResponseDTO;
import com.backfoxx.MedicalProject.Service.PartService;
import com.backfoxx.MedicalProject.model.PartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")
public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping
    public ResponseEntity<?> test() {
        PartEntity str = partService.testservice();
        List<PartEntity> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<PartEntity> response = ResponseDTO.<PartEntity>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createPart(@RequestBody PartDTO dto) {
        try {
            String temporaryuserid = "temporary";
            PartEntity entity = PartDTO.toEntity(dto);
            entity.setId(null);
            entity.setUserId(temporaryuserid);
            List<PartEntity> list = partService.create(entity);
            List<PartDTO> dtos = list.stream().map(PartDTO::new).collect(Collectors.toList());
            ResponseDTO<PartDTO> response = ResponseDTO.<PartDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String error = e.getMessage();
            ResponseDTO<PartDTO> response = ResponseDTO.<PartDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
