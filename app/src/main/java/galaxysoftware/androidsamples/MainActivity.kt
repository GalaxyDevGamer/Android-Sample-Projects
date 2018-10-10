package galaxysoftware.androidsamples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import galaxysoftware.androidsamples.application.App
import galaxysoftware.androidsamples.helper.FragmentMakeHelper
import galaxysoftware.androidsamples.type.FragmentType
import galaxysoftware.androidsamples.type.NavigationType
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ほとんどのサンプルは各々のFragmentに分散してあるが、Toolbarだけは仕様上Activityでしか設定できんので、ここにはToolbarも含む
 */
class MainActivity : AppCompatActivity() {

    //Fragmentを入れとく用
    private var fragmentHistory = ArrayList<Fragment>()
    private var fragmentTypeHistory = ArrayList<FragmentType>()

    /**
     * 本当はToolbarもFragmentに移したいのだが、ToolbarをActionBarとして扱う設定はここ以外でするべきじゃ無いのだ。(というかできん
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        (application as App).mainActivity = this
        /**まだRecyclerViewについては教えてないけど、こっちの方が見やすいから。後から教える**/
        addFragment(FragmentType.RECYCLER_VIEW_SAMPLE)
    }

    /**
     * Add Fragment. Choose the fragment you want to add from FragmentType
     */
    fun addFragment(fragmentType: FragmentType) {
        fragmentHistory.add(FragmentMakeHelper.make(fragmentType))
        fragmentTypeHistory.add(fragmentType)
        if (fragmentType.haveToAdd)
            supportFragmentManager.beginTransaction().add(R.id.main_container, fragmentHistory[fragmentHistory.size - 1]).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.main_container, fragmentHistory[fragmentHistory.size - 1]).commit()
        updateToolbar()
    }

    /**
     * Remove Fragment
     */
    private fun backFragment() {
        if (fragmentHistory.size == 1) {
            finish()
            return
        }
        supportFragmentManager.beginTransaction().remove(fragmentHistory[fragmentHistory.size - 1]).commit()
        fragmentHistory.removeAt(fragmentHistory.size - 1)
        fragmentTypeHistory.removeAt(fragmentTypeHistory.size - 1)
        updateToolbar()
    }

    /**
     * Get current fragment type from history list
     */
    private fun getCurrentFragmentType() = fragmentTypeHistory[fragmentTypeHistory.size-1]

    /**
     * Update Toolbar
     */
    private fun updateToolbar() {
        toolbar.apply {
            if (fragmentTypeHistory.size == 0) {
                navigationIcon = null
                setNavigationOnClickListener(null)
                return
            }
            when (fragmentTypeHistory[fragmentTypeHistory.size - 1].navigation) {
                NavigationType.BACK -> {
                    navigationIcon = getDrawable(R.mipmap.baseline_keyboard_arrow_left_black_24)
                    setNavigationOnClickListener { backFragment() }
                }
                NavigationType.NONE -> {
                    navigationIcon = null
                    setNavigationOnClickListener(null)
                }
            }
            title = fragmentTypeHistory[fragmentTypeHistory.size - 1].title
        }
        invalidateOptionsMenu()
    }

    /**
     * Updating menu
     */
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        if (getCurrentFragmentType() != FragmentType.RECYCLER_VIEW_SAMPLE)
            menuInflater.inflate(fragmentTypeHistory[fragmentTypeHistory.size - 1].menu, menu)
        else {
            menuInflater.inflate(R.menu.main, menu)
            (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
                isIconified = true /**ここをfalseにすると検索バーみたいに出しておける**/
                queryHint = getString(R.string.search)
                clearFocus()
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextChange(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }
                })
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    /**
     * On MenuItem clicked
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Backキーが押された時のコールバック乗っ取り
     */
    override fun onBackPressed() = backFragment()
}