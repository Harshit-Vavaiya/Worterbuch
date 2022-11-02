package com.deutsche.Worterbuch.service;

import com.deutsche.Worterbuch.mapper.WordMapper;
import com.deutsche.Worterbuch.model.Wort;
import org.springframework.stereotype.Service;


@Service
public class WortService {
    private WordMapper wordMapper;

    public WortService(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    public Wort[] getWorts(){
        return wordMapper.selectWords();
    }

    public int addFood(Wort word){
        return wordMapper.insertWord(word);
    }
}
