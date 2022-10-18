package co.usa.reto3.reto3.repository;

import co.usa.reto3.reto3.model.Messagge;
import co.usa.reto3.reto3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Messagge> getAll(){
        return (List<Messagge>) messageCrudRepository.findAll();
    }

    public Optional<Messagge> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Messagge save(Messagge m){
        return messageCrudRepository.save(m);
    }

    public void delete (Messagge message){
        messageCrudRepository.delete(message);
    }
}
