package com.connor.runnerz.run;

import java.time.LocalDateTime;

// these are immutable. That means the values can't be changed with setters.
// comes with ToString
// comes with equals and hashcode

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
        ) {}
