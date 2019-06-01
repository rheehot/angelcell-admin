package com.angelhack.angelcell.dto.user;

import com.angelhack.angelcell.domain.home.Message;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.util.CommonUtil;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author seha
 * @date 2019-06-01
 */

@Getter
public class UsersResponseDto {
    private String uuid;

    private Set<Message> message = new HashSet<>();

    private Long group;

    private Long latitude;

    private Long longitude;

    private String moddate;

    public UsersResponseDto(Users entity) {
        uuid = entity.getUuid();
        group = entity.getGroups();
        latitude = entity.getLatitude();
        longitude = entity.getLogitude();
        moddate = CommonUtil.toStringDateTime(entity.getModdate());
    }
}

