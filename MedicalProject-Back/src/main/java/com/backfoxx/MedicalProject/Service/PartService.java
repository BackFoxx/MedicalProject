package com.backfoxx.MedicalProject.Service;

import com.backfoxx.MedicalProject.Persistence.PartRepository;
import com.backfoxx.MedicalProject.model.PartEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;

    public PartEntity testservice() {
        //Entity 생성
        PartEntity entity = PartEntity.builder().day(20211216).part("가슴").symptom("지끈거림").intensity(9).build();
        //Entity 저장
        partRepository.save(entity);
        //Entity 검색
        PartEntity savedEntity = partRepository.findById(entity.getId()).get();
        return savedEntity;
    }

    public List<PartEntity> create(final PartEntity entity) {
        valiate(entity);

        partRepository.save(entity);
        log.info("Entity Id : {} is saved", entity.getId());

        return partRepository.findByUserId(entity.getUserId());
    }

    private void valiate(final PartEntity entity) {
        if(entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }

        if(entity.getUserId() == null) {
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }
}
