package com.angelhack.angelcell.dto;

import com.angelhack.angelcell.domain.home.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveDto {

    private String hpno;

    private Long groupId;

    private Long battery;

    private String myHost;

    private String connectedHost;

    private boolean isOnline;

    private String latitude;

    private String logitude;

    @Builder
    public UserSaveDto(String hpno, Long groupId, Long battery,
                       String myHost, String connectedHost, boolean isOnline,
                       String latitude, String logitude) {
        this.hpno = hpno;
        this.groupId = groupId;
        this.battery = battery;
        this.myHost = myHost;
        this.connectedHost = connectedHost;
        this.isOnline = isOnline;
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public Users toEntity() {
        return Users.builder()
                .hpno(hpno)
                .groupId(groupId)
                .battery(battery)
                .myHost(myHost)
                .connectedHost(connectedHost)
                .isOnline(isOnline)
                .latitude(latitude)
                .logitude(logitude)
                .build();
    }

}
