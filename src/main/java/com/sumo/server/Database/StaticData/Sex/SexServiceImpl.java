package com.sumo.server.Database.StaticData.Sex;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SexServiceImpl implements SexService {

    final SexRepository sexRepository;

    @Override
    public List<Sex> getAll() {
        return sexRepository.getAllBy();
    }
}
