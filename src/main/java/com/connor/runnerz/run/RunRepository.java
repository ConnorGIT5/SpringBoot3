package com.connor.runnerz.run;

import org.springframework.data.repository.ListCrudRepository;

// the 'id' type of a run is an integer
public interface RunRepository extends ListCrudRepository <Run, Integer> {

}
