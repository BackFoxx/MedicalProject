package com.backfoxx.MedicalProject.Service;

import com.backfoxx.MedicalProject.Persistence.PartRepository;
import com.backfoxx.MedicalProject.model.PartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;

    public String testservice() {
        //Entity 생성
        PartEntity entity = PartEntity.builder().part("가슴").symptom("지끈거림").intensity(9).build();
        //Entity 저장
        partRepository.save(entity);
        //Entity 검색
        PartEntity savedEntity = partRepository.findById(entity.getId()).get();
        return savedEntity.getPart();
    }
}
