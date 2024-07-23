package com.xieht.appmarket.controller;

import com.xieht.appmarket.common.BaseResponse;
import com.xieht.appmarket.common.ErrorCode;
import com.xieht.appmarket.common.ResultUtils;
import com.xieht.appmarket.exception.ThrowUtils;
import com.xieht.appmarket.mapper.UserAnswerMapper;
import com.xieht.appmarket.model.statistic.AppAnswerCountDTO;
import com.xieht.appmarket.model.statistic.AppAnswerResultCountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * App 统计分析
 * @Author：xht
 */
@RestController
@RequestMapping("/app/statistic")
@Slf4j
public class AppStatisticController {
    @Resource
    private UserAnswerMapper userAnswerMapper;

    @GetMapping("/answer_count")
    public BaseResponse<List<AppAnswerCountDTO>> getAppAnswerCount() {
        return ResultUtils.success(userAnswerMapper.doAppAnswerCount());
    }

    @GetMapping("/answer_result_count")
    public BaseResponse<List<AppAnswerResultCountDTO>> getAppAnswerResultCount(Long appId) {
        ThrowUtils.throwIf(appId == null || appId <= 0, ErrorCode.PARAMS_ERROR);
        return ResultUtils.success(userAnswerMapper.doAppAnswerResultCount(appId));
    }
}
