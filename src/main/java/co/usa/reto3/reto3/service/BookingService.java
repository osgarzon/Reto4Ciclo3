package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.model.dto.CClient;
import co.usa.reto3.reto3.model.dto.Status;
import co.usa.reto3.reto3.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.getAll();
    }

    public Optional<Booking> getBooking(int id){
        return bookingRepository.getBooking(id);
    }

    public Booking save(Booking boo){
        if (boo.getId()==null){
            return bookingRepository.save(boo);
        }else {
            Optional<Booking> boaux= bookingRepository.getBooking(boo.getId());
            if (boaux.isEmpty()){
                return bookingRepository.save(boo);
            }else {
                return boo;
            }
        }
    }

    public Booking update (Booking b){
        if(b.getId()!=null){
            Optional<Booking> baux = getBooking(b.getId());
            if(!baux.isEmpty()){
                if(b.getStartDate()!=null){
                    baux.get().setStartDate(b.getStartDate());
                }
                if(b.getDevolutionDate()!=null){
                    baux.get().setDevolutionDate(b.getDevolutionDate());
                }
                if(b.getStatus()!=null){
                    baux.get().setStatus(b.getStatus());
                }
                return bookingRepository.save(baux.get());
            }
        }
        return b;

    }

    public boolean delete(int id){
        Boolean result = getBooking(id).map(elemento ->{
            bookingRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }

    //Reto 5
    public List<CClient> getClientesTop(){
        return bookingRepository.getClientesTop();
    }


    public List<Booking> getReservationsBetweenDays(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException error) {
            error.printStackTrace();
        }
        if (a.before(b)) {
            return bookingRepository.getReservationBetweenDays(a, b);
        } else {
            return new ArrayList<>();
        }
    }
    public Status getReservationsStatus(){
        List<Booking> reservasCompletadas =bookingRepository.getReservationByStatus("completed");
        List<Booking> reservasCanceladas =bookingRepository.getReservationByStatus("cancelled");
        return new Status((long) reservasCompletadas.size(), (long) reservasCanceladas.size());
    }
}
