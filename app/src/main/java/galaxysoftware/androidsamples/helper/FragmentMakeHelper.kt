package galaxysoftware.androidsamples.helper

import galaxysoftware.androidsamples.fragment.*
import galaxysoftware.androidsamples.type.FragmentType

class FragmentMakeHelper {
    companion object {
        fun make(fragmentType: FragmentType) = when (fragmentType) {
            FragmentType.RECYCLER_VIEW_SAMPLE -> RecyclerViewSampleFragment.newInstance()
            FragmentType.COUNTER_SAMPLE -> CountSampleFragment.newInstance()
            FragmentType.EDITOR_SAMPLE -> EditorSampleFragment.newInstance()
            FragmentType.BOTTOM_NAVIGATION_SAMPLE -> BottomNavigationFragment.newInstance()
            FragmentType.IMAGE_VIEW_SAMPLE -> ImageViewSampleFragment.newInstance()
            FragmentType.WEBVIEW_SAMPLE -> WebViewSampleFragment.newInstance()
        }
    }
}