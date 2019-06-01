package com.angelhack.angelcell.domain.home;

import com.angelhack.angelcell.domain.BaseTimeEntity;
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
@ToString
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long num;

    private String uuid;

    private Long groups;

    private String latitude;

    private String logitude;

    @OneToMany(mappedBy = "num", cascade = {CascadeType.ALL})
    private Set<Message> message = new HashSet<>();

    @Builder
    public Users(String uuid, Long groups, String latitude, String logitude) {
        this.uuid = uuid;
        this.groups = groups;
        this.latitude = latitude;
        this.logitude = logitude;
    }

}
