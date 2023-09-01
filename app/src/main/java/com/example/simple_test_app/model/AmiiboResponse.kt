package com.example.simple_test_app.model

data class AmiiboResponse (
    val amiiboSeries: String,
    val character: Character,
    val gameSeries: GameSeries,
    val head: String,
    val image: String,
    val name: String,
    val release: Release,
    val tail: String,
    val type: Type
)

enum class Character(val value: String) {
    BabyMario("Baby Mario"),
    Mario("Mario"),
    MarioCereal("Mario Cereal"),
    MetalMario("Metal Mario");

    companion object {
        public fun fromValue(value: String): Character = when (value) {
            "Baby Mario"   -> BabyMario
            "Mario"        -> Mario
            "Mario Cereal" -> MarioCereal
            "Metal Mario"  -> MetalMario
            else           -> throw IllegalArgumentException()
        }
    }
}

enum class GameSeries(val value: String) {
    Kellogs("Kellogs"),
    MarioSportsSuperstars("Mario Sports Superstars"),
    SuperMario("Super Mario");

    companion object {
        public fun fromValue(value: String): GameSeries = when (value) {
            "Kellogs"                 -> Kellogs
            "Mario Sports Superstars" -> MarioSportsSuperstars
            "Super Mario"             -> SuperMario
            else                      -> throw IllegalArgumentException()
        }
    }
}

data class Release (
    val au: String? = null,
    val eu: String? = null,
    val jp: String? = null,
    val na: String? = null
)

enum class Type(val value: String) {
    Band("Band"),
    Card("Card"),
    Figure("Figure");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "Band"   -> Band
            "Card"   -> Card
            "Figure" -> Figure
            else     -> throw IllegalArgumentException()
        }
    }
}

