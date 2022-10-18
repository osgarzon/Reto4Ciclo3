package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Admin;
import co.usa.reto3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if (a.getIdAdmin() == null){
            return adminRepository.save(a);
        } else {
            Optional<Admin> adaux = adminRepository.getAdmin(a.getIdAdmin());
            if (adaux.isEmpty()){
                return adminRepository.save(a);
            }else {
                return a;
            }
        }

    }

    public Admin update (Admin a){
        if(a.getIdAdmin() != null){
            Optional<Admin> adaux = adminRepository.getAdmin(a.getIdAdmin());
            if(!adaux.isEmpty()){
                if(a.getPassword() != null){
                    adaux.get().setPassword(a.getPassword());
                }
                if(a.getName() !=  null){
                    adaux.get().setName(a.getName());
                }
                return adminRepository.save(adaux.get());
            }
        }
        return a;
    }
    public boolean delete(int id){
        Boolean result = getAdmin(id).map(elemento ->{
            adminRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }
}
