package org.xiranp

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value
import java.util.Vector

object MyData : AutoSavePluginConfig("MyData") { // 文件名为 MyData, 会被保存为 MyData.yml
    var problem: Map<String,String> by value()
}
