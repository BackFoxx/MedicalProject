
package com.backfoxx.MedicalProject.Persistence;

import com.backfoxx.MedicalProject.model.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, String> {
    List<PartEntity> findByUserId(String userId);
}
