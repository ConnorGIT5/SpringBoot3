package com.connor.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

// these are immutable. That means the values can't be changed with setters.
// comes with ToString
// comes with equals and hashcode

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
        ) {

        // constructor for the record
        public Run {
                if (!completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("Impossible to complete a run before you start it.");
                }
        }
}
