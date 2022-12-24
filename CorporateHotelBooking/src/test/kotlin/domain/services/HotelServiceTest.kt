package domain.services

import domain.exceptions.MissingHotelException
import domain.exceptions.DuplicateHotelException
import domain.model.hotel.Hotel
import domain.model.hotel.HotelInformation
import domain.model.room.Room
import domain.model.room.RoomType
import domain.ports.repositories.HotelRepository
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import strikt.api.expectThrows

class HotelServiceTest {
    private val hotel = Hotel(1, HotelInformation("Random name"))
    private val room = Room(1, RoomType.Single)

    private val hotelRepository = spyk<HotelRepository>()
    private val hotelService = HotelService(hotelRepository)

    @Test
    fun `sends a new hotel to be saved in the hotel repository`() {
        hotelService.addHotel(hotel)

        verify { hotelRepository.add(hotel) }
    }

    @Test
    fun `sends a hotel to be updated with a new room`() {
        every { hotelRepository.get(hotel.id) } returns hotel

        hotelService.setRoom(hotel.id, room)
        hotel.addRoom(room)

        verify { hotelRepository.update(hotel.id, hotel) }
    }

    @Test
    fun `returns a hotel if it exists in the system`() {
        every { hotelRepository.get(hotel.id) } returns hotel

        hotelService.findHotelBy(hotel.id)

        verify { hotelRepository.get(hotel.id) }
    }

    @Test
    fun `throws duplicated hotel if trying to add an existing hotel`() {
        every { hotelRepository.get(hotel.id) } returns hotel

        expectThrows<DuplicateHotelException> { hotelService.addHotel(hotel) }
    }

    @Test
    fun `throws missing hotel if trying to add a room to a non existent hotel`() {
        every { hotelRepository.get(hotel.id) } returns null

        expectThrows<MissingHotelException> { hotelService.setRoom(hotel.id, room) }
    }
}
