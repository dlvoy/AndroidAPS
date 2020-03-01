package info.nightscout.androidaps.plugins.pump.danaRS.comm

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest()
class DanaRS_Packet_General_Delivery_StatusTest : DanaRSTestBase() {

    @Test fun runTest() {
        val packet = DanaRS_Packet_General_Delivery_Status(aapsLogger)
        // test params
        val testparams = packet.requestParams
        Assert.assertEquals(null, packet.requestParams)
        // test message decoding
// everything ok :)
        packet.handleMessage(createArray(15, 0.toByte()))
        Assert.assertEquals(false, packet.failed)
        packet.handleMessage(createArray(15, 161.toByte()))
        Assert.assertEquals(true, packet.failed)
        Assert.assertEquals("REVIEW__DELIVERY_STATUS", packet.friendlyName)
    }
}