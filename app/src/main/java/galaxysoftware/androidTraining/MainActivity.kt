package galaxysoftware.androidTraining

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import galaxysoftware.androidTraining.databinding.ActivityMainBinding

/**
 * ほとんどのサンプルは各々のFragmentに分散してあるが、Toolbarだけは仕様上Activityでしか設定できんので、ここにはToolbarも含む
 */
class MainActivity : AppCompatActivity() {

    //Fragmentを入れとく用
//    private var fragmentHistory = ArrayList<Fragment>()
//    private var fragmentTypeHistory = ArrayList<FragmentType>()

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    /**
     * 本当はToolbarもFragmentに移したいのだが、ToolbarをActionBarとして扱う設定はここ以外でするべきじゃ無いのだ。(というかできん
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        NavigationUI.setupWithNavController(binding.toolbar, navController)
        /**まだRecyclerViewについては教えてないけど、こっちの方が見やすいから。後から教える**/
//        addFragment(FragmentType.RECYCLER_VIEW_SAMPLE)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

    /**
     * Add Fragment. Choose the fragment you want to add from FragmentType
     */
//    fun addFragment(fragmentType: FragmentType) {
//        fragmentHistory.add(FragmentMakeHelper.make(fragmentType))
//        fragmentTypeHistory.add(fragmentType)
//        if (fragmentType.haveToAdd)
//            supportFragmentManager.beginTransaction().add(R.id.main_container, fragmentHistory[fragmentHistory.size - 1]).commit()
//        else
//            supportFragmentManager.beginTransaction().replace(R.id.main_container, fragmentHistory[fragmentHistory.size - 1]).commit()
//        updateToolbar()
//    }

    /**
     * Remove Fragment
     */
//    private fun backFragment() {
//        if (getCurrentFragmentType() == FragmentType.WEB_VIEW_SAMPLE) {
//            val fragment = fragmentHistory[fragmentHistory.size - 1] as WebViewSampleFragment
//            if (fragment.canGoBack()) {
//                fragment.goBack()
//                return
//            }
//        }
//        if (fragmentHistory.size == 1) {
//            finish()
//            return
//        }
//        supportFragmentManager.beginTransaction().remove(fragmentHistory[fragmentHistory.size - 1])
//            .commit()
//        fragmentHistory.removeAt(fragmentHistory.size - 1)
//        fragmentTypeHistory.removeAt(fragmentTypeHistory.size - 1)
//    }

    /**
     * Get current fragment type from history list
     */
//    private fun getCurrentFragmentType() = fragmentTypeHistory[fragmentTypeHistory.size - 1]

    /**
     * Updating menu
     */
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menu?.clear()
//        menuInflater.inflate(fragmentTypeHistory[fragmentTypeHistory.size - 1].menu, menu)
//        if (getCurrentFragmentType() == FragmentType.RECYCLER_VIEW_SAMPLE || getCurrentFragmentType() == FragmentType.WEBVIEW_SAMPLE)
//            searchBar = (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
//                isIconified = getCurrentFragmentType() != FragmentType.WEB_VIEW_SAMPLE
//                /**ここをfalseにすると検索バーみたいに出しておける**/
//                queryHint = getString(R.string.search)
//                clearFocus()
//                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                    override fun onQueryTextChange(query: String?): Boolean {
//                        return false
//                    }
//
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//                        if (getCurrentFragmentType() == FragmentType.WEB_VIEW_SAMPLE)
//                            (fragmentHistory[fragmentHistory.size-1] as WebViewSampleFragment).search(query!!)
//                        return false
//                    }
//                })
//                if (getCurrentFragmentType() == FragmentType.WEB_VIEW_SAMPLE)
//                    setQuery("https://google.com", true)
//            }
//        return super.onPrepareOptionsMenu(menu)
//    }
}