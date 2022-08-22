package media.uqab.cartera.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import media.uqab.cartera.BuildConfig
import media.uqab.libAuth.ui.AuthActivity
import media.uqab.libCartera.presentation.CostActivity

class StartActivity: ComponentActivity() {
    private val authLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == AuthActivity.RESULT_OK) {
            startActivity(Intent(this, CostActivity::class.java))
        }
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authLauncher.launch(Intent(this, AuthActivity::class.java))
    }
}