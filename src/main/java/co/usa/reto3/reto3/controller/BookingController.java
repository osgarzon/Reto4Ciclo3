package co.usa.reto3.reto3.controller;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.model.dto.CClient;
import co.usa.reto3.reto3.model.dto.Status;
import co.usa.reto3.reto3.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<Booking> getBookings(){
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBooking(@PathVariable("id") int id){
        return bookingService.getBooking(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking save(@RequestBody Booking bo){
        return bookingService.save(bo);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking update(@RequestBody Booking reservation) {return bookingService.update(reservation);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return bookingService.delete(id);}

    @GetMapping("/report-clients")
    public List<CClient> getReportClientesTop(){
        return bookingService.getClientesTop();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public List<Booking> getReportReservationBetweenDays(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return bookingService.getReservationsBetweenDays(dateOne, dateTwo);
    }

    @GetMapping("report-status")
    public Status getReportSatatus(){
        return bookingService.getReservationsStatus();
    }
}
