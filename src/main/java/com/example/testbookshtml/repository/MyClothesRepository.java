package com.example.testbookshtml.repository;

import com.example.testbookshtml.model.MyClothesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyClothesRepository extends JpaRepository<MyClothesList,Long> {
}
