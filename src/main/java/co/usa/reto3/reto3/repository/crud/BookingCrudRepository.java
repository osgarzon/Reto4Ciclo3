package co.usa.reto3.reto3.repository.crud;

import co.usa.reto3.reto3.model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BookingCrudRepository extends CrudRepository<Booking, Integer> {

    @Query("SELECT c.client, count(c.client) FROM Booking AS c GROUP BY c.client ORDER BY count (c.client) DESC")
    public List<Object[]> countTotalReservationByClient();


    public List<Booking> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    public List<Booking> findAllByStatus(String status);
}
