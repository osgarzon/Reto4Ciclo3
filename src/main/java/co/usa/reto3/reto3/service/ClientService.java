package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if (c.getId()==null){
            return clientRepository.save(c);
        }else {
            Optional<Client> caux= clientRepository.getClient(c.getId());
            if (caux.isEmpty()){
                return clientRepository.save(c);
            }else {
                return c;
            }
        }
    }

    public Client update(Client c){
        if(c.getId() !=null){
            Optional<Client> caux = getClient(c.getId());
            if(!caux.isEmpty()){
                if(c.getName() !=null){
                    caux.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    caux.get().setAge(c.getAge());
                }
                if(c.getPassword()!=null){
                    caux.get().setPassword(c.getPassword());
                }
                return clientRepository.save(caux.get());
            }
        }
        return c;
    }
    public boolean delete(int id){
        Boolean result = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }
}
