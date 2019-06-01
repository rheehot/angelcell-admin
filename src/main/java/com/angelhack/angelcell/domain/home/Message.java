package com.angelhack.angelcell.domain.home;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String uuid;

    private String msg;

    private String host;

    @Builder
    public Message(String uuid, String host, String msg) {
        this.uuid = uuid;
        this.host = host;
        this.msg = msg;
    }
}
