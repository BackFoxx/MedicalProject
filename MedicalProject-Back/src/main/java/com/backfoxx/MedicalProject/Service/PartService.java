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

    public List<PartEntity> retrive(final String userId) {
        return partRepository.findByUserId(userId);
    }

    public List<PartEntity> create(final PartEntity entity) {
        valiate(entity);

        partRepository.save(entity);
        log.info("Entity Id : {} is saved", entity.getId());

        return partRepository.findByUserId(entity.getUserId());
    }

    public List<PartEntity> delete(final PartEntity entity) {
        valiate(entity);
        try {
            partRepository.delete(entity);
        } catch (Exception e) {
            log.error("데이터 삭제 중 에러 발생: ", entity.getId(), e);
            throw new RuntimeException("데이터 삭제 중 에러 발생: " + entity.getId());
        }

        return retrive(entity.getUserId());
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
