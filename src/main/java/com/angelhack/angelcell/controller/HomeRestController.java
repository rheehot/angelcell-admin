package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.dto.MessageSaveDto;
import com.angelhack.angelcell.dto.MessageSendDto;
import com.angelhack.angelcell.dto.UserSaveDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author seha
 * @date 2019-06-01
 */
@RestController
@AllArgsConstructor
@Log4j2
public class HomeRestController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/users")
    public int regUserData(@RequestBody UserSaveDto dto){
        return homeService.regOrModUserData(dto);
    }


    @PostMapping("/users/")
    public Long regMessageByNum(@RequestBody MessageSaveDto dto) {
        return homeService.regMessageByNum(dto);
    }

    @PostMapping("/users/{hpno}/delete")
    public Long delUserData(@PathVariable("hpno") String hpno){
        return homeService.delUserData(hpno);

    }

    @PostMapping("/users/{hpno}/state")
    public int modUserDataCheckAlive(@PathVariable("hpno") String hpno, @RequestBody UserSaveDto dto){
        dto.setHpno(hpno);
        return homeService.modUserDataCheckAlive(dto);
    }

    @PostMapping("/users/{num}/send")
    public int sendMessage(@PathVariable("num")Long num) throws IOException {
        int groupCount = homeService.getUserCountByGroupId(num);

        // request POST
        URL url = new URL("http://localhost:4000/users/1/send");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        try (OutputStream out = conn.getOutputStream()) {
//            out.write("id=javaking".getBytes());
//            out.write("&".getBytes());
//            out.write(("name=" + URLEncoder.encode("자바킹", "UTF-8")).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = conn.getInputStream();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024 * 8];
            int length = 0;
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            System.out.println(new String(out.toByteArray(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.disconnect();

        return 0;
    }
}
