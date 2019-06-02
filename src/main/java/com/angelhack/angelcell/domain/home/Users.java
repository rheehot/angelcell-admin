package com.angelhack.angelcell.domain.home;

import com.angelhack.angelcell.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author seha
 * @date 2019-06-01
 */

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = "message", callSuper = false)
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long num;

    private String hpno;

    private Long groupId;

    private Long battery;

    private String myHost;

    private String connectedHost;

    private boolean isOnline;

    private String latitude;

    private String logitude;

    @OneToMany(mappedBy = "num", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("num")
    private Set<Message> message = new HashSet<>();

    @Builder
    public Users(String hpno, Long groupId, Long battery, String myHost, String connectedHost,
                 boolean isOnline, String latitude, String logitude) {
        this.hpno = hpno;
        this.groupId = groupId;
        this.battery = battery;
        this.myHost = myHost;
        this.connectedHost = connectedHost;
        this.isOnline = isOnline;
        this.latitude = latitude;
        this.logitude = logitude;
    }
}
