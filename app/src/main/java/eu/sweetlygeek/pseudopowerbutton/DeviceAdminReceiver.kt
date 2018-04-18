package eu.sweetlygeek.pseudopowerbutton

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import androidx.core.content.systemService

class DeviceAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context?, intent: Intent?) {
        context?.systemService<DevicePolicyManager>()?.lockNow()
    }
}