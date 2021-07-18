package galaxysoftware.androidTraining.type

import androidx.navigation.NavDirections
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.fragment.RecyclerViewSampleFragmentDirections

enum class FragmentType(val directions: NavDirections, val title: String) {
    RECYCLER_VIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToBottomNavigationFragment("RecyclerView　Sample", R.menu.main), "RecyclerView　Sample"),
    COUNTER_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToCountSampleFragment("Button & Label Sample", R.menu.empty), "Button & Label Sample"),
    EDITOR_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToEditorSampleFragment("Editor Sample", R.menu.empty), "Editor Sample"),
    BOTTOM_NAVIGATION_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToBottomNavigationFragment("BottomNavigation Sample", R.menu.empty), "BottomNavigation Sample"),
    IMAGE_VIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToImageViewSampleFragment("ImageViewSample", R.menu.empty), "ImageViewSample"),
    WEB_VIEW_SAMPLE(RecyclerViewSampleFragmentDirections.actionRecyclerViewSampleFragmentToWebViewSampleFragment("WebView Sample", R.menu.search), "WebView Sample")
}