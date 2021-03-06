package ro.johann.thoughts.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.service.ThoughtService;
import ro.johann.thoughts.transfer.ListOutput;
import ro.johann.thoughts.transfer.ThoughtCreateInput;
import ro.johann.thoughts.transfer.ThoughtOutput;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/thoughts-api/v1/thoughts")
public class ThoughtController {

    private final ThoughtService thoughtService;

    public ThoughtController(ThoughtService thoughtService) {
        this.thoughtService = thoughtService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ThoughtOutput create(@RequestBody ThoughtCreateInput input) {
        log.info("create >> input = {}", input);
        return new ThoughtOutput(thoughtService.create(input));
    }

    @GetMapping("/{thoughtId}")
    @ResponseStatus(OK)
    public ThoughtOutput get(@PathVariable("thoughtId") String id) {
        log.info("get >> id = {}", id);
        return new ThoughtOutput(thoughtService.get(id));
    }

    @GetMapping
    @ResponseStatus(OK)
    public ListOutput<ThoughtOutput> list() {
        log.info("list >>");
        List<ThoughtOutput> thoughts = thoughtService.list().stream()
                .map(ThoughtOutput::new)
                .collect(toList());
        return new ListOutput<>(thoughts, thoughts.size());
    }
}
