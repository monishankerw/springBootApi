package com.demoParsing.items.service.impl;

import com.demoParsing.Iteam.dto.IteamDto;

import com.demoParsing.items.entity.Iteam;
import com.demoParsing.items.respository.IteamRepository;
import com.demoParsing.items.service.IteamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IteamServiceImpl implements IteamService {

    @Autowired
    private IteamRepository iteamRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public IteamDto createIteam(IteamDto iteamDto) {
        Iteam iteam = objectMapper.convertValue(iteamDto, Iteam.class);
        Iteam savedIteam = iteamRepository.save(iteam);
        return objectMapper.convertValue(savedIteam, IteamDto.class);
    }

    @Override
    public List<IteamDto> getAllItems() {
        List<Iteam> items = iteamRepository.findAll();
        return items.stream()
                .map(item -> objectMapper.convertValue(item, IteamDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public IteamDto getItemById(Long id) {
        Optional<Iteam> iteam = iteamRepository.findById(id);
        return iteam.map(value -> objectMapper.convertValue(value, IteamDto.class)).orElse(null);
    }

    @Override
    public IteamDto updateItem(Long id, IteamDto iteamDto) {
        Optional<Iteam> existingIteam = iteamRepository.findById(id);
        if (existingIteam.isPresent()) {
            Iteam updatedIteam = objectMapper.convertValue(iteamDto, Iteam.class);
            updatedIteam.setId(id); // Ensure the ID remains the same
            Iteam savedIteam = iteamRepository.save(updatedIteam);
            return objectMapper.convertValue(savedIteam, IteamDto.class);
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        iteamRepository.deleteById(id);
    }
}
