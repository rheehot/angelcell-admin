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
public class Location extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long num;

    @Column(length = 500)
    private String title;

    @Builder
    public Location(String title) {
        this.title = title;
    }

    public Location toEntity() {
        return Location.builder()
                .title(title)
                .build();
    }

}
