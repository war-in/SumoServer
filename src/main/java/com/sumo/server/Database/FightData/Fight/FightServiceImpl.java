package com.sumo.server.Database.FightData.Fight;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FightServiceImpl implements FightService {

    final FightRepository fightRepository;

    @Override
    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }

    @Override
    public void saveFight(Fight fight) {
        fightRepository.save(fight);
    }
}
