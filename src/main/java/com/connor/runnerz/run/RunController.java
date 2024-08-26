package com.connor.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

// We expect the response body to be in json when we use @RestController
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // 200 status is 'ok'
    @GetMapping("")
    List<Run> finalAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {

        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    // 201 means the post has been completed
    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }

    // 204 means update has been completed
    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    // 204 no content: record is probably deleted
    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }


}
