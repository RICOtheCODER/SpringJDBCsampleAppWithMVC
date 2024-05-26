package com.wiley.traineesapp.dto;


//this trasfers data within layers--needed  by service
public record TraineeDto(int id,String name,String email,String location) {

    //public TraineeDto saveTrainee(TraineeDto traineeDto);
}
