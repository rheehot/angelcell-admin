package com.angelhack.angelcell.dto.user;

import com.angelhack.angelcell.domain.home.Message;
import com.angelhack.angelcell.domain.home.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageSaveDto {

    private Users num;
    private String uuid;
    private String msg;
    private String host;

    @Builder
    public MessageSaveDto(Users num, String uuid, String msg, String host) {
        this.num = num;
        this.uuid = uuid;
        this.msg = msg;
        this.host = host;
    }

    public Message toEntity() {
        return Message.builder()
                .num(num)
                .uuid(uuid)
                .msg(msg)
                .host(host)
                .build();
    }
}
