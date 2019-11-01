package test

import main.Shopopoly.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class ShopopolyTest {

    @Test
    fun moneyIsReturnedZeroOrPositiveFromGBPTest() {
        val ten = GBP(10)
        val zero = GBP(0)
        val minusOne = GBP(-1)
        assertEquals(ten.toString(), "£10")
        assertEquals(zero.toString(), "£0")
        assertEquals(minusOne.toString(), "£0")
    }

    @Test
    fun freeParkingIsALocationTest() {
        val freeParking = Location.FreeParking
        assertTrue(freeParking is Location.FreeParking)
    }

    @Test
    fun goIsALocationTest() {
        val go = Location.Go
        assertTrue(go is Location.Go)
    }

    @Test
    fun go100RewardTest() {
        val go = Location.Go
        assertEquals(100, go.reward)
    }

    @Test
    fun factoryOrWarehouseTests() {
        val warehouse = Location.FactoryOrWarehouse("Magna Park")
        assertTrue(warehouse is Location)
        assertTrue(warehouse is Location.FactoryOrWarehouse)
        assertTrue(warehouse is Rentable)
        assertTrue(warehouse is Purchaseable)
        assertEquals(100, warehouse.cost)
        assertEquals(20, warehouse.rent)
        assertEquals("Magna Park", warehouse.name)
    }

    @Test
    fun retailSiteTests() {
        val retailSite = Location.RetailSite(
            name = "Oxford Street",
            group = Group.Blue,
            cost = 999,
            retailRentalValues = RetailRentalValues(
                rentUndeveloped = 50,
                rentMinistore = 100,
                rentSupermarket = 150,
                rentMegastore = 200),
            retailBuildingCosts = RetailBuildingCosts(
                costMinistore = 300,
                costSupermarket = 400,
                costMegastore = 500)
        )
        assertTrue(retailSite is Location)
        assertTrue(retailSite is Location.RetailSite)
        assertTrue(retailSite is Rentable)
        assertTrue(retailSite is Purchaseable)
        assertTrue(retailSite is Developable)
        assertEquals("Oxford Street", retailSite.name)
        assertEquals(Group.Blue, retailSite.group)
        assertEquals(999, retailSite.cost)
        assertEquals(50, retailSite.retailRentalValues.rentUndeveloped)
        assertEquals(100, retailSite.retailRentalValues.rentMinistore)
        assertEquals(150, retailSite.retailRentalValues.rentSupermarket)
        assertEquals(200, retailSite.retailRentalValues.rentMegastore)
        assertEquals(300, retailSite.retailBuildingCosts.costMinistore)
        assertEquals(400, retailSite.retailBuildingCosts.costSupermarket)
        assertEquals(500, retailSite.retailBuildingCosts.costMegastore)
    }



}