package com.angelhack.angelcell.domain.home;

import com.angelhack.angelcell.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long num;

    @Column(name = "uuid")
    private String uuid;

    @OneToMany(mappedBy = "uuid", cascade = {CascadeType.ALL})
    private Set<Message> message = new HashSet<>();

    private Long group;

    private Long latitude;

    private Long logitude;

    @Builder
    public Users(String uuid, Set<Message> message, Long group, Long latitude, Long logitude) {
        this.uuid = uuid;
        this.message = message;
        this.group = group;
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public Users toEntity() {
        return Users.builder()
                .uuid(uuid)
                .message(message)
                .group(group)
                .latitude(latitude)
                .logitude(logitude)
                .build();
    }

}
