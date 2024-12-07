package com.dev.bernardoslailati.sorteadordenumeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dev.bernardoslailati.sorteadordenumeros.databinding.FragmentResultadoSorteioBinding
import kotlin.random.Random

class ResultadoSorteioFragment : Fragment() {

    private var _binding: FragmentResultadoSorteioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultadoSorteioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            tbDrawNumber.text = getString(R.string.numero_do_sorteio, "35")


            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
            generateDrawNumberTextView()
        }
    }

    private fun FragmentResultadoSorteioBinding.generateDrawNumberTextView() {
        val drawNumberTextView = TextView(requireContext()).apply {
            id = View.generateViewId()
            text = Random.nextInt(100).toString()
            setTextAppearance(R.style.TextAppearance_RobotoMono_Overline)
            textSize = 48f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.content_brand))
        }

        root.addView(drawNumberTextView)
        flowResultNumbersHelper.referencedIds =
            flowResultNumbersHelper.referencedIds.plus(drawNumberTextView.id)
    }
}