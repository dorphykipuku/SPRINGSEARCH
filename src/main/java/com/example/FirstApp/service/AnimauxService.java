package com.example.FirstApp.service;

import com.example.FirstApp.model.Animaux;

import java.util.List;

public interface AnimauxService {

    //methodes basiques
    List<Animaux> getAll();
    Animaux ajouter(Animaux animaux);
    void supprimer(Long id);
    Animaux getbyid(Long id);
    Animaux modifier(Long id, Animaux animaux);

    //methodes avancées
    public List<Animaux> getByNom(String nom);


}
