package com.demoParsing.items.service;

import com.demoParsing.Iteam.dto.IteamDto;

import java.util.List;

public interface IteamService {
    IteamDto createIteam(IteamDto iteamDto);
    List<IteamDto> getAllItems();
    IteamDto getItemById(Long id);
    IteamDto updateItem(Long id, IteamDto iteamDto);
    void deleteItem(Long id);
}
