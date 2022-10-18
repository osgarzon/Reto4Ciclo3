package co.usa.reto3.reto3.repository;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.model.dto.CClient;
import co.usa.reto3.reto3.repository.crud.BookingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    public List<Booking> getAll(){
        return (List<Booking>) bookingCrudRepository.findAll();
    }

    public Optional<Booking> getBooking(int id){
        return bookingCrudRepository.findById(id);
    }

    public Booking save(Booking boo){
        return bookingCrudRepository.save(boo);
    }

    public void delete (Booking reservation){
        bookingCrudRepository.delete(reservation);
    }
    public List<CClient> getClientesTop(){
        List<CClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = bookingCrudRepository.countTotalReservationByClient();
        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new CClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Booking> getReservationBetweenDays(Date a, Date b){
        return bookingCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Booking> getReservationByStatus(String status){
        return bookingCrudRepository.findAllByStatus(status);
    }

}
