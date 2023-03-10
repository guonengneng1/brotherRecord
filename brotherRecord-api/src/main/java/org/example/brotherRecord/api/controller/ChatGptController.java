package org.example.brotherRecord.api.controller;

import org.example.brotherRecord.api.ApiConstant;
import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.vo.ChatGPTVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = ApiConstant.URL_PREFIX)
@RestController
public interface ChatGptController {
    @PostMapping("/chatGPTGetModel")
    public BrotherRecordResponse chatGPTGetModel();

    @PostMapping("/chatGPT")
    public BrotherRecordResponse chatGPT(@RequestBody ChatGPTVo request);
}
