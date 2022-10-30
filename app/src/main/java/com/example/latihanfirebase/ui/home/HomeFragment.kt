package com.example.latihanfirebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.latihanfirebase.databinding.FragmentHomeBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        binding.btnAnalytics.setOnClickListener { analytics() }
        binding.btnCrashlytics.setOnClickListener { crashlytics() }
    }

    private fun analytics() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {

        }
    }

    private fun crashlytics() {
        throw RuntimeException("Test Crash")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}