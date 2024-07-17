package com.xieht.appmarket.manager;

import com.xieht.appmarket.common.ErrorCode;
import com.xieht.appmarket.exception.BusinessException;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.ChatCompletionRequest;
import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.ChatMessageRole;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：xht
 */
@Component
public class AiManager {

    @Resource
    private ClientV4 clientV4;

    // 输入给Ai的参数--希望得到稳定/不稳定的答案
    public static final float STABLE_TEMPERATURE = 0.05f;
    public static final float UNSTABLE_TEMPERATURE = 0.99f;


    /***
     * 同步请求（稳定）
     * @param systemMessage
     * @param userMessage
     * @return
     */
    public String doSyncStableRequest(String systemMessage, String userMessage){
        return doRequest(systemMessage, userMessage, Boolean.FALSE, STABLE_TEMPERATURE); //传入参数调用通用api
    }


    /***
     * 同步请求（不稳定）
     * @param systemMessage
     * @param userMessage
     * @return
     */
    public String doSyncUnStableRequest(String systemMessage, String userMessage){
        return doRequest(systemMessage, userMessage, Boolean.FALSE, UNSTABLE_TEMPERATURE); //传入参数调用通用api
    }

    /**
     * 同步请求
     *
     * @param systemMessage
     * @param userMessage
     * @param temperature
     * @return
     */
    public String doSyncRequest(String systemMessage, String userMessage, Float temperature) {
        return doRequest(systemMessage, userMessage, Boolean.FALSE, temperature);
    }

    /***
     * 通用请求（简化消息传递），允许用户定义系统消息和用户消息
     * @param systemMessage
     * @param userMessage
     * @param stream
     * @param temperature
     * @return
     */
    public String doRequest(String systemMessage, String userMessage, Boolean stream, Float temperature){
        List<ChatMessage> charMessageList = new ArrayList<>();
        ChatMessage systemCM = new ChatMessage(ChatMessageRole.SYSTEM.value(), systemMessage);
        charMessageList.add(systemCM);
        ChatMessage userCM = new ChatMessage(ChatMessageRole.USER.value(), userMessage);
        charMessageList.add(userCM);

        return doRequest(charMessageList, stream, temperature); //传入参数调用通用api
    }


    /***
     * 通用请求
     * @param messages
     * @param stream
     * @param temperature
     * @return
     */
    public String doRequest(List<ChatMessage> messages, Boolean stream, Float temperature){
        // 构建请求
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(stream)
                .temperature(temperature)
                .invokeMethod(Constants.invokeMethod)
                .messages(messages)
                .build();
        try {
            ModelApiResponse invokeModelApiResp = clientV4.invokeModelApi(chatCompletionRequest);
            return invokeModelApiResp.getData().getChoices().get(0).toString();
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,e.getMessage());
        }

    }
}
