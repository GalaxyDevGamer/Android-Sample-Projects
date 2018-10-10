package galaxysoftware.androidsamples.callback

import galaxysoftware.androidsamples.type.FragmentType

interface ItemClickListener {
    fun onItemSelected(fragmentType: FragmentType)
}