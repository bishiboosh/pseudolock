package eu.sweetlygeek.pseudopowerbutton

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.core.content.systemService

class LockScreenActivity : AppCompatActivity() {

    private val adminComponentName: ComponentName
        get() = ComponentName(this, DeviceAdminReceiver::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(systemService<DevicePolicyManager>()) {
            if (isAdminActive(adminComponentName)) {
                lockNow()
                finish()
            } else {
                startActivity(
                    Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
                        .putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminComponentName)
                        .putExtra(
                            DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                            "Cette application doit avoir les droits admin pour pouvoir verrouiller l'écran"
                        )
                )
                finish()
            }
        }
    }
}