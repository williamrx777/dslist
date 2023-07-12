package com.will.dslist.controller;

import com.will.dslist.dto.GameMinDTO;
import com.will.dslist.entities.Game;
import com.will.dslist.repositories.GameRepository;
import com.will.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
       List<GameMinDTO> result = gameService.findAll();
       return result;

    }

}
