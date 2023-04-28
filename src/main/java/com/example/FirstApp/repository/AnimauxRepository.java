package com.example.FirstApp.repository;

import com.example.FirstApp.model.Animaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimauxRepository extends JpaRepository<Animaux, Long> {
    @Query("FROM Animaux a WHERE a.nom=?1 ")
    public List<Animaux> getByNom(String nom);

}
