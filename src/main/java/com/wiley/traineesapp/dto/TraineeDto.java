package com.wiley.traineesapp.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//this trasfers data within layers--needed  by service
public record TraineeDto(int id, String name, @JsonProperty("email_id") String email, @JsonIgnore String location) {

    //public TraineeDto saveTrainee(TraineeDto traineeDto);
}
