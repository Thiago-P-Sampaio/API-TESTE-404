package com.archive404tester.project.Service;

import com.archive404tester.project.DTO.GamesDTO;
import com.archive404tester.project.Entity.Games;
import com.archive404tester.project.Repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    @Autowired
    GamesRepository repository;

    public GamesDTO inserir(GamesDTO dto){
        Games novoJogo = new Games();
        novoJogo.setDescricao(dto.getDescricao());
        novoJogo.setDesenvolvedora(dto.getDesenvolvedora());
        novoJogo.setImg(dto.getImg());
        novoJogo.setLancamento(dto.getLancamento());
        novoJogo.setGenero(dto.getGenero());
        novoJogo.setNome(dto.getNome());
        novoJogo = repository.save(novoJogo);

        return  new GamesDTO(novoJogo);
    }


    public List<Games> buscarJogos(){
        return  repository.findAll();
    }

    public boolean deletarGame(Long id){
        Optional<Games> game = repository.findById(id);
        if(game.isPresent()){
            repository.deleteById(id);
            return true;
        } else return false;
    }


    public GamesDTO atualizarJogo(GamesDTO dto, Long id){
        Optional<Games> jogo = repository.findById(id);
        if(jogo.isPresent()){
            Games game = jogo.get();
            game.setNome(dto.getNome());
            game.setGenero(dto.getGenero());
            game.setImg(dto.getImg());
            game.setLancamento(dto.getLancamento());
            game.setDesenvolvedora(dto.getDesenvolvedora());
            game.setDescricao(dto.getDescricao());
            game = repository.save(game);
            return  new GamesDTO(game);
        } else return null;
    }
}
