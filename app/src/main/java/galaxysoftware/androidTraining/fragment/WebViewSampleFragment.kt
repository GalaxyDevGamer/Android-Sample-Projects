package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.*
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.databinding.WebviewLayoutBinding
import galaxysoftware.androidTraining.viewModel.WebViewSampleViewModel

class WebViewSampleFragment : BaseFragment() {

    private lateinit var sampleViewModel: WebViewSampleViewModel

    private lateinit var binding: WebviewLayoutBinding

    private lateinit var searchBar: SearchView

    private val args: WebViewSampleFragmentArgs by navArgs()

    override fun menuId(): Int = args.menu

    override fun title(): String = args.title

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WebviewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sampleViewModel = ViewModelProvider(this).get(WebViewSampleViewModel::class.java)
        // TODO: Use the ViewModel
        binding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                setSupportZoom(true)
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
            }
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(request?.url.toString())
                    return false
                }
            }
        }
        binding.reloadWebView.setOnRefreshListener {
            binding.webView.reload()
            binding.reloadWebView.isRefreshing = false
        }
        binding.goBack.setOnClickListener {
            goBack()
        }
        binding.goForward.setOnClickListener {
            if (binding.webView.canGoForward()) {
                binding.webView.goForward()
            }
        }
        search("https://google.com")
    }

    override fun extraMenuSetup(menu: Menu) {
        super.extraMenuSetup(menu)
        searchBar = (menu.findItem(R.id.search)?.actionView as SearchView).apply {
            /**ここをfalseにすると検索バーみたいに出しておける**/
            isIconified = false
            queryHint = getString(R.string.search)
            clearFocus()
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    search(query!!)
                    return false
                }
            })
            setQuery("https://google.com", true)
        }
    }

    private fun search(url: String) = binding.webView.loadUrl(url)

    fun canGoBack() = binding.webView.canGoBack()

    fun goBack() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        }
    }
}
