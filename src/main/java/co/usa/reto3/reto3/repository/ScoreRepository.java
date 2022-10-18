package co.usa.reto3.reto3.repository;

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.crud.ScoreCrudRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRespository scoreCrudRepository;

    public List<Score> getAll(){

        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete (Score score){
        scoreCrudRepository.delete(score);
    }
}
