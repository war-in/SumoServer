package com.sumo.server.Time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;

public class TimeTranslator {
    public static ChronoLocalDate getCurrentChrono(){
        return ChronoLocalDate.from(Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public static LocalDate getCurrentLocalDate(){
        return Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate();
    }
}
