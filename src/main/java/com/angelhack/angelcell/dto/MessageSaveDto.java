package com.angelhack.angelcell.dto;

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
    private String hpno;
    private String msg;
    private String host;

    @Builder
    public MessageSaveDto(Users num, String hpno, String msg, String host) {
        this.num = num;
        this.hpno = hpno;
        this.msg = msg;
        this.host = host;
    }

    public Message toEntity() {
        return Message.builder()
                .num(num)
                .hpno(hpno)
                .msg(msg)
                .host(host)
                .build();
    }
}
