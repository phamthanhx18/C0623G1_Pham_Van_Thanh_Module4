package com.example.dictionary.service;

import com.example.dictionary.repository.IDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{

    @Autowired
    private IDictionaryRepo dictionaryService;
    @Override
    public String displayResultDictionary(String englishKey) {
        return dictionaryService.displayResultDictionary(englishKey);
    }
}
