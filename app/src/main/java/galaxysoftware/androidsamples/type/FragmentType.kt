package galaxysoftware.androidsamples.type

import galaxysoftware.androidsamples.R

enum class FragmentType(val navigation: NavigationType, val title: String, val menu: Int, val haveToAdd: Boolean) {
    RECYCLER_VIEW_SAMPLE(NavigationType.NONE, "Recycler View　Sample", R.menu.main, true),
    COUNTER_SAMPLE(NavigationType.BACK, "Counter Sample", R.menu.empty, true),
    EDITOR_SAMPLE(NavigationType.BACK, "Editor Sample", R.menu.empty, true),
    BOTTOM_NAVIGATION_SAMPLE(NavigationType.BACK, "BottomNavigation Sample", R.menu.empty, true),
    IMAGE_VIEW_SAMPLE(NavigationType.BACK, "ImageViewSample", R.menu.empty, true),
    WEBVIEW_SAMPLE(NavigationType.BACK, "WebView Sample", R.menu.search, true)
}