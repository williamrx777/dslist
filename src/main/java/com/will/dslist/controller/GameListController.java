package com.will.dslist.controller;


import com.will.dslist.dto.GameListDTO;

import com.will.dslist.dto.GameMinDTO;
import com.will.dslist.dto.ReplacementDTO;
import com.will.dslist.services.GameListService;

import com.will.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId,body.getSourceIndex(),body.getDestinationIndex());
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
