package com.example.FirstApp.controller;

import com.example.FirstApp.model.Animaux;
import com.example.FirstApp.service.AnimauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animaux")
@CrossOrigin("http://localhost:3000")
public class AnimauxController {

    @Autowired
    private AnimauxService animauxService;

    @GetMapping("get")
    public List<Animaux> tout() {
        return animauxService.getAll();
    }

    @PostMapping("pos")
    public String ajouter(@RequestBody Animaux animaux) {
        animauxService.ajouter(animaux);
        return "un animal ajouté";
    }

    @DeleteMapping("del/{id}")
    public String supprime(@PathVariable Long id) {
        animauxService.supprimer(id);
        return "un animal supprimé";
    }

    @GetMapping("get/{id}")
    public Animaux getbyid(@PathVariable Long id) {
        return animauxService.getbyid(id);
    }

    @PutMapping("put/{id}")
    public String modifier(@PathVariable Long id, @RequestBody Animaux animaux) {
        animauxService.modifier(id, animaux);
        return "un animal modifié";
    }

    @GetMapping("get/getByNom/{nom}")
    public List<Animaux> getByNom(@PathVariable ("nom") String nom){
        return animauxService.getByNom(nom);
    }

}
