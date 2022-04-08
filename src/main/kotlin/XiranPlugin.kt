package org.xiranp

import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageRecallEvent
import net.mamoe.mirai.utils.info

object XiranPlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "org.xiranans.plugin",
        version = "1.0-SNAPSHOT",
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }

        MySimpleCommand.register()
        MyData.reload()
        //创建一个只有group的通道
        val channel = GlobalEventChannel.filter { it is GroupMessageEvent || it is MessageRecallEvent}

        //传入消息监听的表达式给通道
        channel.subscribeAlways<GroupMessageEvent> { event ->
            Core.groupMessageHandle(event)
        }

        //撤回消息监听
        channel.subscribeAlways<MessageRecallEvent> { event ->
            Core.recallMessageHandle(event)
        }
    }
}