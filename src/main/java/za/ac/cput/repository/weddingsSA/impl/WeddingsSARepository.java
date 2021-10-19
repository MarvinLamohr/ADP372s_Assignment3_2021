package za.ac.cput.repository.weddingsSA.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.WeddingsSA;


@Repository
public interface WeddingsSARepository   extends JpaRepository<WeddingsSA, String> {


}
