package com.example.FirstApp.service;

import com.example.FirstApp.model.Animaux;
import com.example.FirstApp.repository.AnimauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimauxServiceImpl implements AnimauxService{
    @Autowired
    private AnimauxRepository animauxRepository;

    @Override
    public List<Animaux> getAll() {
        return animauxRepository.findAll();
    }

    @Override
    public Animaux ajouter(Animaux animaux) {
        return animauxRepository.save(animaux);
    }

    @Override
    public void supprimer(Long id) {
     animauxRepository.deleteById(id);
    }

    @Override
    public Animaux getbyid(Long id) {
        Optional<Animaux> animauxOptional = animauxRepository.findById(id);

        if(animauxOptional.isEmpty()){
            return null;
        }else{
           return animauxOptional.get();
        }
    }

    @Override
    public Animaux modifier(Long id, Animaux animaux) {
        Animaux existingAnimaux = getbyid(id);
        existingAnimaux.setNom(animaux.getNom());
        existingAnimaux.setFamille(animaux.getFamille());
        return animauxRepository.save(existingAnimaux);
    }

    @Override
    public List<Animaux> getByNom(String nom) {
        return animauxRepository.getByNom(nom);
    }
}
