package com.itsupport.repository;

import com.itsupport.model.EquipmentBreakdown;
import com.itsupport.model.EquipmentBreakdownKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EquipmentBreakdownRepository extends JpaRepository<EquipmentBreakdown, EquipmentBreakdownKey> {


    List<EquipmentBreakdown> findAllByEquipmentId(Long id);
}
