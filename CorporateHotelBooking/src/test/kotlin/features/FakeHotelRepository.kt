package features

import domain.model.hotel.Hotel
import domain.model.util.Id
import domain.ports.repositories.HotelRepository

class FakeHotelRepository : HotelRepository {
    private val store: HashMap<Id, Hotel> = HashMap()

    override fun add(hotel: Hotel) {
        store[hotel.id] = hotel
    }

    override fun update(hotelId: Id, hotel: Hotel) {
        store[hotelId] = hotel
    }

    override fun get(hotelId: Id): Hotel? = store[hotelId]
}
