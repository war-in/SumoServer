package com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor;

import java.util.List;

public interface WeighedCompetitorService {
    WeighedCompetitor saveWeighedCompetitor(WeighedCompetitor weighedCompetitor);

    List<WeighedCompetitor> getAllWeighedCompetitors();
}
