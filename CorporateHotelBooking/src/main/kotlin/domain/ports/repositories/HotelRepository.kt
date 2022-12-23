package domain.ports.repositories

import domain.model.hotel.Hotel
import domain.model.util.Id

interface HotelRepository {
    fun add(hotel: Hotel)
    fun update(hotelId: Id, hotel: Hotel)
    fun get(hotelId: Id): Hotel
}
