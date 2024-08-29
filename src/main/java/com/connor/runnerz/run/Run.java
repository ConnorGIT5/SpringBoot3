package com.connor.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

// these are immutable. That means the values can't be changed with setters.
// comes with ToString
// comes with equals and hashcode

public record Run(
        // @Id to mark it's the identifier
        //@Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        // '@Positive' means the value must be positive
        @Positive
        Integer miles,
        Location location
        // '@Version' is Used to track if there's a new row or an existing row
        //@Version
        //Integer version

        ) {

        // constructor for the record
        public Run {
                if (!completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("Impossible to complete a run before you start it.");
                }
        }
}
