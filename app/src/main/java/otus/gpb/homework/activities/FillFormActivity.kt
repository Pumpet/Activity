package otus.gpb.homework.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.activities.databinding.ActivityFillFormBinding


class FillFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFillFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFillFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.run {
            binding.textName.setText(getString(KEY_NAME))
            binding.textSurname.setText(getString(KEY_SURNAME))
            binding.textAge.setText(getString(KEY_AGE))
        }

        binding.buttonOk.setOnClickListener {
            setResult(RESULT_OK, Intent().apply {
                putExtra(KEY_NAME, binding.textName.text.toString())
                putExtra(KEY_SURNAME, binding.textSurname.text.toString())
                putExtra(KEY_AGE, binding.textAge.text.toString())
            })
            finish()
        }
    }
}