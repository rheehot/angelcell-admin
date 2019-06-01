package com.angelhack.angelcell.domain.home;

import com.angelhack.angelcell.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String uuid;

    private Long groups;

    private Long latitude;

    private Long logitude;

    @Builder
    public Users(String uuid, Long groups, Long latitude, Long logitude) {
        this.uuid = uuid;
        this.groups = groups;
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public Users toEntity() {
        return Users.builder()
                .uuid(uuid)
                .groups(groups)
                .latitude(latitude)
                .logitude(logitude)
                .build();
    }

}
