package matsumana.com.omikujiapp

import android.os.Bundle
import android.content.Intent
import android.app.Activity
import android.app.IntentService
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent


class GeofenceTransitionsIntentService : IntentService, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    constructor(name: String) : super(name) {}

    constructor() : super("GeofenceTransitionsIntentService") {}

    override fun onHandleIntent(intent: Intent?) {
        sendNotification("onHandleIntent() called")
        val geofencingEvent = GeofencingEvent.fromIntent(intent)
        if (geofencingEvent.hasError()) {
            sendNotification("geofencingEvent.hasError()")
            return
        }

        // Get the transition type.
        val geofenceTransition = geofencingEvent.getGeofenceTransition()


        // Test that the reported transition was of interest.
        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER || geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT) {

            val triggeringGeofences = geofencingEvent.getTriggeringGeofences()

            val message = getMessage(geofenceTransition, triggeringGeofences)
            sendNotification(message)
        } else {
            sendNotification("onHandleIntent error")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onConnected(p0: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getMessage(geofenceTransition: Int, geofenceList: List<Geofence>): String {
        var message = ""

        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER) {
            message += "enter"
            sendNotification("")
        } else if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT) {
            message += "exit"
        } else {
            message += "else"
        }
        message += " , count : " + geofenceList.size + " ( "

        for (geofence in geofenceList) {
            message += geofence.getRequestId() + " "
        }
        message += ")"

        return message
    }

    companion object {

        var activity: Activity? = null

        fun sendNotification(text: String) {
            GeofenceTransitionsIntentService.activity?.let {
                val myNotification = MyNotification(
                        it
                )
                myNotification.title = "ジオフェンステスト"
                myNotification.text = text
                myNotification.run()
            }
        }
    }
}