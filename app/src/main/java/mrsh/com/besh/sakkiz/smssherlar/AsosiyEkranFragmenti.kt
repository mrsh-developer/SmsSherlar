package mrsh.com.besh.sakkiz.smssherlar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_asosiy_ekran_fragmenti.*
import kotlinx.android.synthetic.main.fragment_asosiy_ekran_fragmenti.view.*
import mrsh.com.besh.sakkiz.smssherlar.chatch.MySharePreference
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val TAG = "AsosiyEkranFragmenti"

/**
 * A simple [Fragment] subclass.
 * Use the [AsosiyEkranFragmenti.newInstance] factory method to
 * create an instance of this fragment.
 */
class AsosiyEkranFragmenti : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var root:View
    lateinit var arrayList: ArrayList<DataClassIkki>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_asosiy_ekran_fragmenti, container, false)

        root.sevgi_sherlar.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "sevgi_sherlar"))


        }
        root.soginch_armon.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "soginch_armon"))


        }
        root.tabrik_sherlar.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "tabrik_sherlar"))


        }
        root.ota_ona.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "ota_ona"))


        }
        root.dostlik_sherlar.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "dostlik_sherlar"))


        }
        root.hazil.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "hazil"))


        }
        root.yangilar.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "yangilar"))


        }
        root.saqlanganlar.setOnClickListener {

            root.findNavController().navigate(R.id.sherlar, bundleOf("key" to "saqlanganlar"))


        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        MySharePreference.init(root.context)

        arrayList = ArrayList()
        arrayList.addAll(MySharePreference.contactList)

        root.saqlanganlar_soni.text = arrayList.size.toString()
        root.yangilar_soni.text = "13".toString()

        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AsosiyEkranFragmenti.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AsosiyEkranFragmenti().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}