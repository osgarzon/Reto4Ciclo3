package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save (Score s){
        if(s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> saux = getScore(s.getId());
            if(saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }

    public Score update (Score s){
        if(s.getId()!=null){
            Optional<Score> saux = getScore(s.getId());
            if(!saux.isEmpty()){
                if(s.getMessageT()!=null){
                    saux.get().setMessageT(s.getMessageT());
                }
                if(s.getStars()!=null){
                    saux.get().setStars(s.getStars());
                }
                return scoreRepository.save(saux.get());
            }
        }
        return s;
    }
    public boolean delete(int id){
        Boolean result = getScore(id).map(elemento ->{
            scoreRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }
}
