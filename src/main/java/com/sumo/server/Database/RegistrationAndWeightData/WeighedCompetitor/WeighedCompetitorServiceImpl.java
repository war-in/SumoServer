package com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WeighedCompetitorServiceImpl implements WeighedCompetitorService {

    final WeighedCompetitorRepository weighedCompetitorRepository;

    @Override
    public WeighedCompetitor saveWeighedCompetitor(WeighedCompetitor weighedCompetitor) {
        weighedCompetitor.setDate(LocalDate.now());
        return weighedCompetitorRepository.save(weighedCompetitor);
    }

    @Override
    public List<WeighedCompetitor> getAllWeighedCompetitors() {
        return weighedCompetitorRepository.findAllBy();
    }
}
