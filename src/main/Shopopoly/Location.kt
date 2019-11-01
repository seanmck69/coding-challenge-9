package main.Shopopoly


//rent / cost to Int - until GBP implemented
interface Rentable {
    val rent: Int
}

interface Purchaseable {
    val cost: Int
}

interface Rewardable {
    val reward: Int
}

interface Developable {
    val developmentStatus: DevelopmentStatus
    val locationCosts: Map<DevelopmentStatus, Purchaseable>
}

data class RetailRentalValues(
    val rentUndeveloped: Int,
    val rentMinistore: Int,
    val rentSupermarket: Int,
    val rentMegastore: Int
)

data class RetailBuildingCosts(
    val costMinistore: Int,
    val costSupermarket: Int,
    val costMegastore: Int
)


sealed class Location {
    object FreeParking : Location() {
    }

    object Go : Rewardable, Location() {
        override val reward = 100
    }

    class FactoryOrWarehouse(val name: String) : Rentable, Purchaseable, Location() {
        override val cost: Int = 100
        override val rent: Int = 20
    }

    class RetailSite(
        val name: String,
        val group: Group,
        override val cost: Int,
        val retailRentalValues: RetailRentalValues,
        val retailBuildingCosts: RetailBuildingCosts
    ) : Developable, Rentable, Purchaseable, Location() {
        override val locationCosts: Map<DevelopmentStatus, Purchaseable>
            get() = TODO("not implemented")
        override val rent
            get() = TODO("not implemented")
        override val developmentStatus: DevelopmentStatus
            get() = TODO("not implemented")
    }
}

enum class Group {
    Red, Green, Blue, Brown, Orange, Purple
}

