package com.xieht.appmarket.model.dto.userAnswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建用户答案请求
 *
 * @author xht
 * 
 */
@Data
public class UserAnswerAddRequest implements Serializable {

    /**
     * 应用 id
     */
    private Long appId;

    /**
     * 用户答案（JSON 数组）
     */
    private List<String> choices;

    /**
     * 用户答案 id，用于保证幂等性
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}