package domain.model.hotel

import domain.model.room.Room
import domain.model.util.Id

data class Hotel(val id: Id, val information: HotelInformation, val rooms: ArrayList<Room> = ArrayList()) {
    fun addRoom(room: Room) {
        rooms.add(room)
    }
}
