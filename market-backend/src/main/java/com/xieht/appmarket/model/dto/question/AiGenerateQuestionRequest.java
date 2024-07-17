package com.xieht.appmarket.model.dto.question;

import lombok.Data;

/**
 * @Author：xht
 */
@Data
public class AiGenerateQuestionRequest {
    /**
     * 应用id
     */
    private Long appId;
    /**
     * 题目数
     */
    int questionNumber;
    /**
     * 选项数
     */
    int optionNumber;

    public static final long serialVersionUID = 1L;
}
