/*
 * This file is part of LiquidBounce (https://github.com/CCBlueX/LiquidBounce)
 *
 * Copyright (c) 2015 - 2024 CCBlueX
 *
 * LiquidBounce is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LiquidBounce is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LiquidBounce. If not, see <https://www.gnu.org/licenses/>.
 *
 */

package net.ccbluex.liquidbounce.event.events

import net.ccbluex.liquidbounce.event.Event
import net.ccbluex.liquidbounce.utils.client.Nameable
import net.ccbluex.liquidbounce.web.socket.protocol.event.WebSocketEvent
import net.ccbluex.liquidbounce.web.socket.protocol.rest.game.PlayerStatistics

@Nameable("fps")
@WebSocketEvent
class FpsChangeEvent(val fps: Int) : Event()

@Nameable("playerStats")
@WebSocketEvent
class PlayerStatsChangeEvent(
    val health: Float,
    val maxHealth: Float,
    val absorption: Float,
    var armor: Int,
    val food: Int,
    val experienceLevel: Int,
    val experienceProgress: Float
) : Event() {
    companion object {
        fun fromPlayerStatistics(stats: PlayerStatistics) = PlayerStatsChangeEvent(
            stats.health,
            stats.maxHealth,
            stats.absorption,
            stats.armor,
            stats.food,
            stats.experienceLevel,
            stats.experienceProgress
        )
    }
}
