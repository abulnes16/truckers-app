package com.abulnes.trucker_app.data.entities

data class Event(
    val name: String,
    val description: String,
    val category: String,
    val businessName: String,
    val eventPhoto: String = "",
    val status: String = "Available",
    val globalRating: Int = 0,
    val assistants: Int = 0,
    val comments: List<Comment> = listOf(),
    val location: Location,
    val date: String,
    val hour: String,
)

val popularMockEvents = listOf(
    Event(
        name = "National Music Festival",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
    Event(
        name = "Art Workshop",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
)

val mockEvents = listOf(
    Event(
        name = "National Music Festival",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
    Event(
        name = "Art Workshop",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
    Event(
        name = "Music Concert",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
    Event(
        name = "Tech Seminar",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    ),
    Event(
        name = "Mural Painting",
        date = "Mon, Dec 24",
        hour = "18:00 - 23:00 PM",
        location = Location(0.0, 0.0),
        businessName = "",
        description = "",
        category = "Music"
    )
)

