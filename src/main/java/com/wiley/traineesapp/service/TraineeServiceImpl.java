package com.wiley.traineesapp.service;

import com.wiley.traineesapp.dto.TraineeDto;
import com.wiley.traineesapp.model.Trainee;
import com.wiley.traineesapp.repository.TraineeRepository;
import com.wiley.traineesapp.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{
    @Autowired
    private final TraineeRepository repository;

    public TraineeServiceImpl(TraineeRepository repository) {
        this.repository = repository;
    }

    @Override
    public TraineeDto saveTrainee(TraineeDto traineeDto) {
        Trainee trainee=repository.saveTrainee(EntityDtoUtil.convertToTraineeEntity(traineeDto));
        return EntityDtoUtil.convertToTraineeDto(trainee);
    }

    @Override
    public TraineeDto getTrainee(int id) {
        return repository.getTraineeById(id).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }

    @Override
    public TraineeDto getTraineeByName(String name) {
        return repository.getTraineeByName(name).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }

    @Override
    public void deleteTrainee(int id) {
        repository.deleteTrainee(id);
    }

    @Override
    public List<TraineeDto> getAllTrainees() {
        return repository.getAllTrainees().parallelStream().map(EntityDtoUtil::convertToTraineeDto).toList();
    }

    @Override
    public TraineeDto updateTrainee(int id, TraineeDto traineeDto) {
        Trainee trainee=repository.updateTrainee(id,EntityDtoUtil.convertToTraineeEntity(traineeDto));
        return EntityDtoUtil.convertToTraineeDto(trainee);
    }
}
