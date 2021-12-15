//데이터 저장소
package com.backfoxx.MedicalProject.Persistence;

import com.backfoxx.MedicalProject.model.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, String> {

}
