package jp.nephy.penicillin.endpoints

import jp.nephy.penicillin.core.emulation.EmulationMode

annotation class PrivateEndpoint(
    vararg val mode: EmulationMode
)
