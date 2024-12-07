package com.dev.bernardoslailati.sorteadordenumeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.dev.bernardoslailati.sorteadordenumeros.databinding.FragmentConfiguracaoDeSorteioBinding
import com.dev.bernardoslailati.sorteadordenumeros.databinding.FragmentResultadoSorteioBinding
import kotlin.random.Random

class ConfiguracaoDeSorteioFragment : Fragment() {

    private val viewModel: SorteioViewModel by activityViewModels()

    private var _binding: FragmentConfiguracaoDeSorteioBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
                viewModel.setShouldRepeatNumbers(shouldRepeatNumbers = !isChecked)
            }

            etAmountNumbers.addTextChangedListener { text ->
                viewModel.setDrawAmountNumber(drawAmountNumber = text.toString().toIntOrNull() ?: 0)
            }

            etInitialLimit.addTextChangedListener { text ->
                viewModel.setInitialLimit(initialLimit = text.toString().toIntOrNull() ?: 0)
            }

            etFinalLimit.addTextChangedListener { text ->
                viewModel.setFinalLimit(finalLimit = text.toString().toIntOrNull() ?: 0)
            }
        }
    }

    fun FragmentResultadoSorteioBinding.gerarTextoDeNumeroSorteado() {
        val textView = TextView(requireContext()).apply {
            id = View.generateViewId()
            text = "${Random.nextInt(100)}"
            setTextAppearance(R.style.TextAppearance_Sora_DisplayMedium)
            setTextColor(ContextCompat.getColor(requireContext(), R.color.content_brand))
        }
        root.addView(textView)
        flowResultNumbersHelper.referencedIds = flowResultNumbersHelper.referencedIds.plus(textView.id)
    }

}