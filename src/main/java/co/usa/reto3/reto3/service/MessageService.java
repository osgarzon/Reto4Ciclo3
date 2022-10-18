package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Messagge;
import co.usa.reto3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Messagge> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Messagge> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Messagge save(Messagge m){
        if (m.getId()==null){
            return messageRepository.save(m);
        }else {
            Optional<Messagge> maux= messageRepository.getMessage(m.getId());
            if (maux.isEmpty()){
                return messageRepository.save(m);
            }else {
                return m;
            }
        }
    }

    public Messagge update (Messagge m){
        if(m.getId()!=null){
            Optional<Messagge> maux = getMessage(m.getId());
            if(!maux.isEmpty()){
                if(m.getMessage()!=null){
                    maux.get().setMessage(m.getMessage());
                }
                return messageRepository.save(maux.get());
            }

        }
        return m;
    }
    public boolean delete(int id){
        Boolean result = getMessage(id).map(elemento ->{
            messageRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }
}
