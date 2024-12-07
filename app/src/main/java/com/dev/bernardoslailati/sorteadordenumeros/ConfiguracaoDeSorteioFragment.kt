package com.dev.bernardoslailati.sorteadordenumeros

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.dev.bernardoslailati.sorteadordenumeros.databinding.FragmentConfiguracaoDeSorteioBinding
import com.dev.bernardoslailati.sorteadordenumeros.databinding.FragmentResultadoSorteioBinding
import kotlin.random.Random


class ConfiguracaoDeSorteioFragment : Fragment() {

    private var _binding: FragmentConfiguracaoDeSorteioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfiguracaoDeSorteioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            swtNotRepeatNumbers.setOnCheckedChangeListener { _, isChecked ->
                swtNotRepeatNumbers.trackTintList = getColorStateList(
                    requireContext(),
                    if (isChecked) R.color.background_brand else R.color.content_tertiary
                )
            }

            etAmountNumbers.addTextChangedListener { text ->

            }

            etInitialLimit.addTextChangedListener { text ->

            }

            etFinalLimit.addTextChangedListener { text ->

            }
        }
    }
}