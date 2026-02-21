package org.example.giaback.repository;

import org.example.giaback.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    List<Material> findAllByName(String name);
    Material findByName(String name);

}
