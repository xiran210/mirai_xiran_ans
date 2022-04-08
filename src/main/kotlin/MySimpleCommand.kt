package org.xiranp

import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.message.data.messageChainOf

object MySimpleCommand : CompositeCommand(
    owner = XiranPlugin , "ans", "添加回复",
    description = "添加回复，支持正则表达式"
) {
    @SubCommand  // 标记这是指令处理器  // 函数名随意
    @Description("添加一个回复规则")
    suspend fun CommandSender.add(problem : String,answer : String) {
        if( MyData.problem.get(problem)!=null ){
            sendMessage("此问题已存在，若需修改，请先删除此问题")
            return
        }
        MyData.problem+=Pair(problem,answer)
        sendMessage("添加成功")
    }

    @SubCommand
    @Description("删除一个回复规则")
    suspend fun CommandSender.del(problem : String) {
        if( MyData.problem.get(problem)==null ){
            sendMessage("此问题不存在,无法删除")
            return
        }
        MyData.problem-=problem
        sendMessage("删除成功")
    }

    @SubCommand
    @Description("删除一个回复规则,若一个指令能提供正则表达式匹配输入的字符串则删除次规则")
    suspend fun CommandSender.re(problem : String) {
        var tot:Int =0
        for( (pro,ans) in MyData.problem ){
            val r1=Regex(pro)
            if( r1.matches(problem) ){
                tot+=1
                MyData.problem-=problem
            }
        }
        sendMessage("删除成功,共计删除规则"+tot+"条")
    }
}