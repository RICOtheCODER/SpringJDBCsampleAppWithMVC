package com.wiley.traineesapp.repository;

import com.wiley.traineesapp.exception.RecordNotFoundException;
import com.wiley.traineesapp.model.Trainee;
import com.wiley.traineesapp.util.TraineeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository //sme as component
public class TraineeRepositoryImpl implements  TraineeRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TraineeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Trainee saveTrainee(Trainee trainee) {
       int rowCount=jdbcTemplate.update("insert into backuptrainees(trainee_name,email,location)" +
               " values(?,?,?)",trainee.getName(),trainee.getEmail(),trainee.getLocation());
//       return getTraineeByName(trainee.getEmail()).orElse(null);
        if(rowCount > 0){
            return getTraineeByName(trainee.getName()).get();
        }
        return null;
    }

    @Override
    public Optional<Trainee> getTraineeById(int id) {
        Trainee trainee= jdbcTemplate.queryForObject("select id,trainee_name,email,location from backuptrainees where id ="+id,
        new TraineeRowMapper());
        if (trainee == null) {
            throw new RecordNotFoundException("Trainee Not Found : "+id+" Not Found");
        }
        return Optional.of(trainee);
    }

    @Override
    public Optional<Trainee> getTraineeByName(String name) {  //new line manatory
        try {
            Trainee trainee =jdbcTemplate.queryForObject("select * from backuptrainees where trainee_name='"+name+"'", new TraineeRowMapper());
        if (trainee == null) {
            throw new RecordNotFoundException("Trainee Not Found : "+name+" Not Found");
        }
        return Optional.of(trainee);
    }catch (DataAccessException runtimeException){
            throw new RecordNotFoundException("Trainee with name : "+name+" not found");

        }
    }


    @Override
    public List<Trainee> getAllTrainees() {
        return jdbcTemplate.query("select * from backuptrainees",new TraineeRowMapper());
    }

    @Override
    public void deleteTrainee(int id) {

        getTraineeById(id).ifPresent((t)->jdbcTemplate.update("delete from backuptrainees where id= ?",id));
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
         int rowCount= jdbcTemplate.update("update backuptrainees set trainee_name=? ,email=?,location=? where" +
                 "id =?",trainee.getName(),trainee.getEmail(),trainee.getLocation(),id);
         if(rowCount==0){
             throw new RecordNotFoundException("Trainee with id + "+id+" not present");
         }
         Trainee upDatedTrainee=getTraineeById(id).get();
         return upDatedTrainee;

    }


}
