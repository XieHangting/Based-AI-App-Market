package com.xieht.appmarket.scoring;

import com.xieht.appmarket.model.entity.App;
import com.xieht.appmarket.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
 * @author xht
 * 
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}