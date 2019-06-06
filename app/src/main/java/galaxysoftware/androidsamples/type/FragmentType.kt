package galaxysoftware.androidsamples.type

import androidx.navigation.NavDirections
import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.fragment.RecyclerViewSampleFragmentDirections

enum class FragmentType(val directions: NavDirections, val title: String, val menu: Int) {
    RECYCLER_VIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToBottomNavigationFragment(), "Recycler View　Sample", R.menu.main),
    COUNTER_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToCountSampleFragment(), "Counter Sample", R.menu.empty),
    EDITOR_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToEditorSampleFragment(), "Editor Sample", R.menu.empty),
    BOTTOM_NAVIGATION_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToBottomNavigationFragment(), "BottomNavigation Sample", R.menu.empty),
    IMAGE_VIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToImageViewSampleFragment(), "ImageViewSample", R.menu.empty),
    WEBVIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToWebViewSampleFragment(), "WebView Sample", R.menu.search)
}