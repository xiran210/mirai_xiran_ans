package org.xiranp

import net.mamoe.mirai.contact.Friend
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageRecallEvent
import javax.swing.plaf.metal.MetalFileChooserUI.FilterComboBoxRenderer

object Core {

    suspend fun groupMessageHandle(groupMessage : GroupMessageEvent){
        //随机复读
        /*
        if( (0..10).random()==1 )
            groupMessage.group.sendMessage(groupMessage.message)
         */

        val text=groupMessage.message[groupMessage.message.size-1].toString()

        for( (pro,ans) in MyData.problem ){
            val r1=Regex(pro)
            if( r1.matches(text) )
                groupMessage.group.sendMessage(ans)
        }

    }

    suspend fun recallMessageHandle(recallMessage : MessageRecallEvent){
        when(recallMessage){
            is MessageRecallEvent.GroupRecall -> groupRecallMessageHandle(recallMessage)
            is MessageRecallEvent.FriendRecall -> friendRecallMessageHandle(recallMessage)
        }
    }

    //群撤回消息
    private suspend fun groupRecallMessageHandle(event : MessageRecallEvent.GroupRecall){

    }

    //好友撤回消息
    private suspend fun friendRecallMessageHandle(event : MessageRecallEvent.FriendRecall){

    }


}