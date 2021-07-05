package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.JobDTO;
import one.digitalinnovation.personapi.exception.JobNotFoundException;
import one.digitalinnovation.personapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.OnMessage;
import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobController {
    private JobService jobService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJob(@RequestBody @Valid JobDTO jobDTO){
        return jobService.createJob(jobDTO);
    }

    @GetMapping("/{id}")
    public JobDTO findById(@PathVariable Long id) throws JobNotFoundException {
        return jobService.findById(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody JobDTO jobDTO) throws JobNotFoundException {
        return jobService.updateById(id,jobDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws JobNotFoundException {
            jobService.delete(id);
    }

    @GetMapping
    public List<JobDTO> listAll(){ return jobService.listAll(); }




}
