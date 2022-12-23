package domain.services

import domain.model.hotel.Hotel
import domain.model.room.Room
import domain.model.util.Id
import domain.ports.repositories.HotelRepository

class HotelService(private val hotelRepository: HotelRepository) {
    fun addHotel(hotel: Hotel) {
        hotelRepository.add(hotel)
    }

    fun setRoom(hotelId: Id, room: Room) {
        val hotel: Hotel = hotelRepository.get(hotelId)
        hotel.addRoom(room)

        hotelRepository.update(hotelId, hotel)
    }

    fun findHotelBy(hotelId: Id): Hotel = hotelRepository.get(hotelId)
}
