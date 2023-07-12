package com.will.dslist.services;

import com.will.dslist.dto.GameDTO;
import com.will.dslist.dto.GameListDTO;
import com.will.dslist.dto.GameMinDTO;
import com.will.dslist.entities.Game;
import com.will.dslist.entities.GameList;
import com.will.dslist.repositories.GameListRepository;
import com.will.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
