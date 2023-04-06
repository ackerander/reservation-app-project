package com.revature.Repository;

import com.revature.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Modifying
    @Query(value = "insert into \"user_reservations\" values (:restaurant_id, :reservation_id, :customer_id)", nativeQuery = true)
    void insertReservation(@Param("customer_id") long customer_id, @Param("restaurant_id") long restaurant_id, @Param("reservation_id") long reservation_id);
}
