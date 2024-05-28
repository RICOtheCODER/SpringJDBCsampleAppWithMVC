package com.wiley.traineesapp.controller;

import com.wiley.traineesapp.dto.TraineeDto;
import com.wiley.traineesapp.model.Trainee;
import com.wiley.traineesapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")  //base url for all the locations-->more adding done after this url by adding /
public class TraineeRestController {

    @Autowired
    TraineeService traineeService;

    @GetMapping
    public List<TraineeDto> getAllTrainees(){
        return traineeService.getAllTrainees();

    }

    @PostMapping
  //  @ResponseStatus(HttpStatus.CREATED) //returning a status code
    public ResponseEntity<TraineeDto> saveTrainee(@RequestBody TraineeDto traineeDto){
        TraineeDto savetrainee=traineeService.saveTrainee(traineeDto);
        HttpStatus status;
        if (savetrainee!=null){
            status=HttpStatus.CREATED;
        }
        else {
            status=HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(status).body(savetrainee); //same as response status
    }

    //pathvariable uses the value from the specified path
    //requestparam =?paramname
    @GetMapping("/{id}")  //{} dynamic parameter
    public TraineeDto getTraineeById(@PathVariable("id") int id){  //say id mapped with the argument id
        return traineeService.getTrainee(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  //request no content
    public void deleteTraineeById(@PathVariable int id){
         traineeService.deleteTrainee(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto updateTrainee(@PathVariable int id,@RequestBody TraineeDto traineeDto){
          return traineeService.updateTrainee(id,traineeDto);
    }
}
