package com.archive404tester.project.Controller;


import com.archive404tester.project.DTO.GamesDTO;
import com.archive404tester.project.Entity.Games;
import com.archive404tester.project.Service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // LEMBRA DO CORS PO!
@RequestMapping ("/games")
public class GamesController {

    @Autowired
    GamesService service;

    @PostMapping("/add")
    public ResponseEntity<?> novoJogo(@RequestBody GamesDTO dto){
        dto = service.inserir(dto);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarJogos(){
        return ResponseEntity.ok(service.buscarJogos());
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> deletarJogo(@PathVariable Long id){
        boolean deletar = service.deletarGame(id);
        if(deletar){
           return  ResponseEntity.ok("Jogo deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/updt/{id}")
    public ResponseEntity<?> atualizarJogo(@RequestBody GamesDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(service.atualizarJogo(dto, id));
    }


}
