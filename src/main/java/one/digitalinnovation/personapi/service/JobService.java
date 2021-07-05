package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.JobDTO;
import one.digitalinnovation.personapi.entity.Job;
import one.digitalinnovation.personapi.exception.JobNotFoundException;
import one.digitalinnovation.personapi.mapear.JobMapper;
import one.digitalinnovation.personapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobService {
    private JobRepository jobRepository;

    private final JobMapper jobMapper = JobMapper.INSTANCE;

    public MessageResponseDTO createJob(JobDTO jobDTO){
        Job jobToSave = jobMapper.toModel(jobDTO);

        Job savedJob = jobRepository.save(jobToSave);

        return getMessageResponseDTO(savedJob.getId(), "Job created ID ");
    }



    public MessageResponseDTO updateById(Long id, JobDTO jobDTO) throws JobNotFoundException {
        verifyIfExits(id);
        Job jobToUpdate = jobMapper.toModel((jobDTO));

        Job updateJob = jobRepository.save(jobToUpdate);

        return getMessageResponseDTO(updateJob.getId(), "Job updated ID ");

    }
    
    
    public List<JobDTO> listAll() {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream()
                .map(jobMapper::toDTO)
                .collect(Collectors.toList())
                ;

    }



    public JobDTO findById(Long id) throws JobNotFoundException {
         Job job = verifyIfExits(id);
         return jobMapper.toDTO(job);

    }

    public void delete(Long id) throws JobNotFoundException {
        verifyIfExits(id);
        jobRepository.deleteById(id);
    }

    private MessageResponseDTO getMessageResponseDTO(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
    private Job verifyIfExits(Long id) throws JobNotFoundException {
        return jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException(id));

    }
}
