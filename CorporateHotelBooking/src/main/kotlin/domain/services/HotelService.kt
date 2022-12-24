package domain.services

import domain.exceptions.MissingHotelException
import domain.exceptions.DuplicateHotelException
import domain.model.hotel.Hotel
import domain.model.room.Room
import domain.model.util.Id
import domain.ports.repositories.HotelRepository

class HotelService(private val hotelRepository: HotelRepository) {
    fun addHotel(hotel: Hotel) {
        if (hotelAlreadyExists(hotel))
            throw DuplicateHotelException()
        hotelRepository.add(hotel)
    }

    fun setRoom(hotelId: Id, room: Room) {
        val hotel = hotelRepository.get(hotelId) ?: throw MissingHotelException()
        hotel.addRoom(room)
        hotelRepository.update(hotelId, hotel)
    }

    fun findHotelBy(hotelId: Id): Hotel = hotelRepository.get(hotelId)!!

    private fun hotelAlreadyExists(hotel: Hotel) = hotelRepository.get(hotel.id) != null
}
