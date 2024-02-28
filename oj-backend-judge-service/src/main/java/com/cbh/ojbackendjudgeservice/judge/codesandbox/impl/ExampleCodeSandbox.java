package com.cbh.ojbackendjudgeservice.judge.codesandbox.impl;


import com.cbh.ojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.cbh.ojbackendmodel.model.codesandbox.JudgeInfo;
import com.cbh.ojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.cbh.ojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（仅为跑通流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();


        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);

        
        return executeCodeResponse;
    }
}
