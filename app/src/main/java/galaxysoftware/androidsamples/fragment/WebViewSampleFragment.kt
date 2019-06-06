package galaxysoftware.androidsamples.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.application.App
import galaxysoftware.androidsamples.viewModel.WebViewSampleViewModel
import kotlinx.android.synthetic.main.webview_layout.*

class WebViewSampleFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = WebViewSampleFragment()
    }

    private lateinit var sampleViewModel: WebViewSampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.webview_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sampleViewModel = ViewModelProviders.of(this).get(WebViewSampleViewModel::class.java)
        // TODO: Use the ViewModel
        webView.apply {
            settings.apply {
                javaScriptEnabled = true
                setSupportZoom(true)
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
            }
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    view?.loadUrl(request?.url.toString())
                    updateURL()
                    return false
                }
            }
        }
        reloadWebView.setOnRefreshListener {
            webView.reload()
            reloadWebView.isRefreshing = false
        }
        go_back.setOnClickListener {
            goBack()
        }
        go_forward.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
                updateURL()
            }
        }
        search.setOnClickListener { search(search_bar.text.toString()) }
        search("https://google.com")
    }

    private fun search(url: String) = webView.loadUrl(url)

    fun updateURL() = (activity?.application as App).mainActivity?.setURL(webView.url)

    fun canGoBack() = webView.canGoBack()

    fun goBack() {
        if (webView.canGoBack()) {
            webView.goBack()
            updateURL()
        }
    }
}
