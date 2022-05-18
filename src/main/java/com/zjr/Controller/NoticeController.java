package com.zjr.Controller;

import com.zjr.Mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoticeController {

    @Autowired
    NoticeMapper noticeMapper;
}
