package de.ait.hm15.service;

import de.ait.hm15.dto.ProgrammerResponseDto;
import de.ait.hm15.mappers.ProgrammerMapper;
import de.ait.hm15.model.Programmer;
import de.ait.hm15.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
       return mapper.toResponseDtoList (repository.findAll());
    }

}
