package com.angelhack.angelcell.dto.location;

import com.angelhack.angelcell.domain.home.Location;
import lombok.Getter;

/**
 * @author seha
 * @date 2019-06-01
 */

@Getter
public class LocationResponseDto {
    private Long num;
    private String title;

    public LocationResponseDto(Location entity) {
        num = entity.getNum();
        title = entity.getTitle();
    }
}

