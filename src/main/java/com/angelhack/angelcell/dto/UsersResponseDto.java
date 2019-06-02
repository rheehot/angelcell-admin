package com.angelhack.angelcell.dto;

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
    private String hpno;

    private Long groupId;

    private String latitude;

    private String longitude;

    private String moddate;

    public UsersResponseDto(Users entity) {
        hpno = entity.getHpno();
        groupId = entity.getGroupId();
        latitude = entity.getLatitude();
        longitude = entity.getLogitude();
        moddate = CommonUtil.toStringDateTime(entity.getModdate());
    }
}

