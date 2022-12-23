package features

import domain.model.hotel.Hotel
import domain.model.hotel.HotelInformation
import domain.model.room.Room
import domain.model.room.RoomType
import domain.model.util.Id
import domain.ports.repositories.HotelRepository
import domain.services.HotelService
import io.github.serpro69.kfaker.faker
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class HotelServiceFeatureTest {
    private val hotel = getRandomHotel()
    private val room = Room(
        roomNumber = 1,
        roomType = RoomType.Single
    )

    private val hotelRepository: HotelRepository = FakeHotelRepository()
    private val hotelService = HotelService(hotelRepository)

    @Test
    fun `find hotel by id shows information about the hotel's room`() {
        hotelService.addHotel(hotel)
        hotelService.setRoom(hotel.id, room)
        val hotelRoomsInformation = hotelService.findHotelBy(hotel.id)

        expectThat(hotelRoomsInformation).isEqualTo(hotel)
    }

    private fun getRandomHotel(): Hotel {
        val fakeData = faker { }
        val hotelId: Id = 1
        val hotelInformation = HotelInformation(fakeData.company.name())
        return Hotel(hotelId, hotelInformation)
    }
}