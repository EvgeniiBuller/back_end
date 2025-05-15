package de.ait.hm15.service;


import de.ait.hm15.dto.ProgrammerRequestDto;
import de.ait.hm15.dto.ProgrammerResponseDto;
import de.ait.hm15.mappers.ProgrammerMapper;
import de.ait.hm15.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return null;
    }

    @Override
    public ProgrammerResponseDto createTask(ProgrammerRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public ProgrammerResponseDto deleteTask(Long id) {
        return null;
    }
}

