package com.kotlin.mall.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.mall.R
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg",
            "https://img.zcool.cn/community/013112554c656c0000009e32d21083.jpg@1280w_1l_2o_100sh.jpg",
            "https://image.uisdc.com/wp-content/uploads/2016/03/ttt20160309-13.png"))
        mHomeBanner.setBannerAnimation(Transformer.Default)
        mHomeBanner.isAutoPlay(true)
        mHomeBanner.start()

        mHomeBanner.setOnBannerListener {
            Log.d("TAG", it.toString())
        }
    }
}