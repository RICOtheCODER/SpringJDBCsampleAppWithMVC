package com.wiley.traineesapp.controller;

import com.wiley.traineesapp.dto.TraineeDto;
import com.wiley.traineesapp.model.Trainee;
import com.wiley.traineesapp.service.TraineeService;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private TraineeService service;

    @GetMapping("/trainee")
    public String WelcomePage(){
        return "welcome.jsp";
    }

@GetMapping("/gettrainee")
public String getTrainees(Model model){
    List<TraineeDto> trainees=service.getAllTrainees();
    model.addAttribute("trainees",trainees);
    return "gettraineesFrontHeavy.jsp";
}

//public String postTraineeByName(Model model,@ModelAttribute Trainee trainee){
//
//}

@GetMapping("/gettraineebyname")
public String getTraineeByName(@RequestParam("name") String name, Model model) {
        TraineeDto traineeDtos=service.getTraineeByName(name);
        model.addAttribute("traineeDtos",traineeDtos);
        return "getTraineeByName.jsp";
}
@PostMapping("/showtraineebyname/getTraineeByName")
public String postTraineeNameTree(Model model,@ModelAttribute Trainee trainee){
        return "/getTraineeByName.jsp";
}

@PostMapping("/showTraineeByName")
public String postTraineeByName(Model model,@ModelAttribute Trainee trainee){
        return "/ShowTraineeByName.jsp";
}

@GetMapping("/showTraineeByName")
    public String showTraineeByName(){
        return "ShowTraineeByName.jsp";
    }
    @PostMapping("/mainpage/gettrainee")
    public String addUser(@ModelAttribute Trainee trainee,Model model){
        List<TraineeDto> traineeDtos=service.getAllTrainees();
        model.addAttribute("traineeDtos",traineeDtos);
        //add all doesnot work here
        return "/gettraineesFrontHeavy.jsp";
    }


//    @PostMapping("/traineebyname")
//    public String addUsers(@ModelAttribute Trainee trainee){
//        return "gettraineesFrontHeavy.jsp";
//    }

    @GetMapping("/traineebyid")
    public String getTraineeById(Model model){
        TraineeDto dto=service.getTrainee(5);
        model.addAttribute("trainees",dto);
        return "getTraineeByName.jsp";
    }

    @PostMapping("/mainpage/register")
    public String postMappingRegistrationForm(@ModelAttribute Trainee trainee,Model model){
          return "/RegistrationForm.jsp";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
       TraineeDto dto=new TraineeDto(1,"Saurajit Sarkar","rico189@gmail.com","Howrah");
       model.addAttribute("dto",dto);
       return "RegistrationForm.jsp";
    }

    //@RequestMapping(value = "/register/save",method =RequestMethod.GET)
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("dto") TraineeDto traineeDto, BindingResult result,
                               Model model){
//        TraineeDto existingTrainee=service.getTraineeByName(traineeDto.name()); //searchesfro the trainee already presentor or not
//        if(existingTrainee !=null && existingTrainee.email()!=null
//                && existingTrainee.email().isEmpty()){
//            result.rejectValue("email",null,"There is already account registered with same name");
//        }
//        if(result.hasErrors()){
//            model.addAttribute("dto",traineeDto);
//            return "/register";
//        }

        model.addAttribute("dto",traineeDto);
        service.saveTrainee(traineeDto);
        return "redirect:/register?success";
    }

    @GetMapping("/delete-trainee")
    public String deleteTrainee(@RequestParam("id") int id){
        service.deleteTrainee(id);
        return "redirect:/gettrainee";
    }

    @GetMapping("/mainpage")
    public String mainPage(Model model){
          return "mainpage.jsp";
    }

//    @GetMapping("/mainpage/gettrainee")
//    public String mainpageToView(Model model){
//        List<TraineeDto> trainees=service.getAllTrainees();
//        model.addAttribute("trainees",trainees);
//        return "/gettraineesFrontHeavy.jsp"; ///giving / before the name works if the error getrainees.jsp not found is encountered
//    }
//
//    @PostMapping("/mainpage/gettrainee")
//    public String addUsers(@ModelAttribute Trainee trainee){
//        return "/gettraineesFrontHeavy.jsp";
//    }


}
