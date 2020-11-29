package org.xiyoulinux.qqbot.handler.online;

import net.mamoe.mirai.message.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import org.springframework.stereotype.Component;
import org.xiyoulinux.qqbot.handle.mirai.message.GroupMessageEventHandle;
import org.xiyoulinux.qqbot.handle.mirai.EventHandleResult;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/9/18 下午4:17
 */
@Component
public class OnlineInfoGroupHandle implements GroupMessageEventHandle {

    private final OnlineService onlineService;

    public OnlineInfoGroupHandle(OnlineService onlineService) {
        this.onlineService = onlineService;
    }

    @Override
    public EventHandleResult handle(GroupMessageEvent event) {
        String msg = chainString(event);
        onlineService.onlineHandle(msg, replyMsg -> event.getGroup().sendMessage(new At(event.getSender()).plus(replyMsg)));
        return EventHandleResult.DEFAULT_RESULT;
    }

}
