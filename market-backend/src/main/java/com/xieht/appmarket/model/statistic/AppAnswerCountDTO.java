package com.xieht.appmarket.model.statistic;

import lombok.Data;

/**
 * @Author：xht
 */
@Data
public class AppAnswerCountDTO {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 用户提交答案数
     */
    private Long answerCount;


}
