package com.lqd.androidpractice

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import androidx.core.content.FileProvider
import com.lqd.androidpractice.activity.JetpackActivity
import com.lqd.androidpractice.kotlin.Example1
import com.lqd.androidpractice.kotlin.LoginFragment
import com.lqd.base.activity.BaseActivity
import java.io.File

/**
 *
 *
 * @author alone
 * @Date 4/6/21
 * @version 1.0
 *
 */

class KotlinTestActivity : BaseActivity() {


    private lateinit var btn: Button
    private lateinit var btn2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_kotlin_test1)


        btn = findViewById(R.id.btn1)
        btn.setOnClickListener {
            startActivity(Intent(this@KotlinTestActivity, JetpackActivity::class.java))
        }

        btn2 = findViewById(R.id.btn2)
        btn2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            var uri: Any? = null
            val saveFolder = Environment.getDataDirectory()
            val updateSaveName = ""
            val file = File(saveFolder, updateSaveName)
            if (Build.VERSION.SDK_INT >= 24) {//android 7.0以上
                uri = FileProvider.getUriForFile(KotlinTestActivity@ this, BuildConfig.APPLICATION_ID + ".provider", file)
            } else {
                uri = Uri.fromFile(file)
            }
            val type = "application/vnd.android.package-archive"
            intent.setDataAndType(uri, type);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            startActivityForResult(intent, 10);
        }

        findViewById<Button>(R.id.btnKotlin3).setOnClickListener {
            Example1.test1()

        }

//        val data = HunterPrivacyResponse(ProtocolContent(), ProtocolContent())
//        val list = data.hunterProtocolContent?.replaceTextList?.map { ReplaceStrEntity(it.replaceText, it.url) }
//        (application as LQDApplication).test(list)
//        GlobalScope.async {
//            delay(1000)
//            btn.setText("123123")
//        }


        val cameraBlackList: MutableList<String>? = mutableListOf()
        cameraBlackList?.add("haha")
        cameraBlackList?.add("aaa")
        cameraBlackList?.add("bbb")
        cameraBlackList?.add("ccc")
        cameraBlackList?.add("ccc")
        Log.d("#########", cameraBlackList.toString())
        cameraBlackList?.set(2, "ccc")
        Log.d("#########", cameraBlackList.toString())


    }


}

data class HunterPrivacyResponse(val hunterProtocolContent: ProtocolContent? = null,
                                 val hunterOtherProtocolContent: ProtocolContent? = null //拒绝样式文案
)

data class ProtocolContent(val title: String? = null, //标题
                           val content: String? = null,//内容
                           val textVersionCode: String? = null,//当前版本号
                           val replaceTextList: List<ReplaceTextEntiy>? = null //要替换的文本
)

data class ReplaceTextEntiy(val replaceText: String,//替换的文本
                            val url: String
)

data class ReplaceStrEntity(val replaceText: String, val url: String)