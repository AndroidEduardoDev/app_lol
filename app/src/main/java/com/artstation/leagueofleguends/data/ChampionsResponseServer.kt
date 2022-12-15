package com.artstation.leagueofleguends.data
data class ChampionsResponseServer (
    val game: Game,
    val players: List<Player>
){

    data class Game (
        val activePlayer: ActivePlayer,
        val allPlayers: List<Player>,
        val events: Events,
        val gameData: GameData
    )

    data class ActivePlayer (
        val abilities: Abilities,
        val championStats: ChampionStats,
        val currentGold: Double,
        val fullRunes: FullRunes,
        val level: Any,
        val summonerName: SummonerName,
        val teamRelativeColors: Boolean
    )

    data class Abilities (
        val e: E,
        val passive: E,
        val q: E,
        val r: E,
        val w: E
    )

    data class E (
        val abilityLevel: Any? = null,
        val displayName: String,
        val id: String? = null,
        val rawDescription: String,
        val rawDisplayName: String
    )

    data class ChampionStats (
        val abilityHaste: Any,
        val abilityPower: Any,
        val armor: Double,
        val armorPenetrationFlat: Any,
        val armorPenetrationPercent: Double,
        val attackDamage: Double,
        val attackRange: Any,
        val attackSpeed: Double,
        val bonusArmorPenetrationPercent: Any,
        val bonusMagicPenetrationPercent: Any,
        val critChance: Any,
        val critDamage: Any,
        val currentHealth: Any,
        val healShieldPower: Any,
        val healthRegenRate: Double,
        val lifeSteal: Double,
        val magicLethality: Any,
        val magicPenetrationFlat: Any,
        val magicPenetrationPercent: Any,
        val magicResist: Double,
        val maxHealth: Double,
        val moveSpeed: Double,
        val omnivamp: Any,
        val physicalLethality: Any,
        val physicalVamp: Any,
        val resourceMax: Double,
        val resourceRegenRate: Double,
        val resourceType: String,
        val resourceValue: Double,
        val spellVamp: Any,
        val tenacity: Any
    )

    data class FullRunes (
        val generalRunes: List<Keystone>,
        val keystone: Keystone,
        val primaryRuneTree: Keystone,
        val secondaryRuneTree: Keystone,
        val statRunes: List<StatRune>
    )

    data class Keystone (
        val displayName: String,
        val id: Any? = null,
        val rawDescription: String,
        val rawDisplayName: String
    )

    data class StatRune (
        val id: Any,
        val rawDescription: String
    )

    enum class SummonerName {
        BotTristana,
        Brayanrobabancos
    }

    data class Player (
        val championName: String,
        val isBot: Boolean,
        val isDead: Boolean,
        val items: List<Item>,
        val level: Any,
        val position: String,
        val rawChampionName: String,
        val rawSkinName: String? = null,
        val respawnTimer: Double,
        val runes: Runes,
        val scores: Scores,
        val skinID: Any,
        val skinName: String? = null,
        val summonerName: String,
        val summonerSpells: SummonerSpells,
        val team: Team
    )

    data class Item (
        val canUse: Boolean,
        val consumable: Boolean,
        val count: Any,
        val displayName: String,
        val itemID: Any,
        val price: Any,
        val rawDescription: String,
        val rawDisplayName: String,
        val slot: Any
    )

    data class Runes (
        val keystone: Keystone,
        val primaryRuneTree: Keystone,
        val secondaryRuneTree: Keystone
    )

    data class Scores (
        val assists: Long,
        val creepScore: Long,
        val deaths: Long,
        val kills: Long,
        val wardScore: Double
    )

    data class SummonerSpells (
        val summonerSpellOne: SummonerSpell,
        val summonerSpellTwo: SummonerSpell
    )

    data class SummonerSpell (
        val displayName: String,
        val rawDescription: String,
        val rawDisplayName: String
    )

    enum class Team {
        Chaos,
        Order
    }

    data class Events (
        val events: List<Event>
    )

    data class Event (
        val eventID: Any,
        val eventName: String,
        val eventTime: Double,
        val assisters: List<Any?>? = null,
        val killerName: String? = null,
        val victimName: SummonerName? = null,
        val recipient: SummonerName? = null,
        val acer: SummonerName? = null,
        val acingTeam: Team? = null,
        val turretKilled: String? = null,
        val dragonType: String? = null,
        val stolen: String? = null,
        val inhibKilled: String? = null,
        val inhibRespawningSoon: String? = null,
        val inhibRespawned: String? = null
    )

    data class GameData (
        val gameMode: String,
        val gameTime: Double,
        val mapName: String,
        val mapNumber: Any,
        val mapTerrain: String
    )

}
