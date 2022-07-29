package com.sumo.server.Time;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;

public class TimeBean {
    public static ChronoLocalDate getCurrentChrono(){
        return ChronoLocalDate.from(Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public static LocalDate getCurrentLocalDate(){
        return Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate();
    }
}
